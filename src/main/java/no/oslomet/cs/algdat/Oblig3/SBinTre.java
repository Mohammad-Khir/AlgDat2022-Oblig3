package no.oslomet.cs.algdat.Oblig3;

import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {   // Brukte programkode 5.2.3 fra kompendiet

        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        // Her skal vi finne ut hvor verdien skal legges
        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }
        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        // Her skal vi legge verdien
        p = new Node<>(verdi,q);                   // oppretter en ny node med refransen til sin forelder

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        endringer++;                             // en endring mer i treet
        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        if(!inneholder(verdi)) return 0;    //Hvis verdi ikke er treet (null er ikke i treet)
        Node<T> p = rot;                    // p starter i roten
        int count = 0;                      // verdi-antall
        while (p != null){
            int cmp = comp.compare(verdi,p.verdi);  // bruker komparatoren
            if(cmp < 0) p = p.venstre;              // flytte p til venstre
            else{
                if(cmp == 0) count++;              // hvis verdien er funnet
                p = p.høyre;                        // flytt p til høyre
            }
        }
        return count;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        // Kjører en while løkke så lenge p har en verdi.
        while (p != null) {
            // hvis p.venstre ikke er lik null, setter vi p.venstre til å være p.
            if (p.venstre != null) {
                p = p.venstre;
            }
            // hvis p.høyre ikke er lik null, setter vi p.høyre til å være p.
            else if (p.høyre != null) {
                p = p.høyre;
                // hvis ingen, returnerer p som første post orden.
            } else {
                return p;
            }
        }
        return null;
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        //sjekkes om p.forelder er lik null.
        if (p.forelder == null) {
            return null;
        }
        //sjekkes det om p er barn venstre eller høyre.
        if (p.forelder.høyre == p){
            return p.forelder;
        } else if (p.forelder.høyre != null){ //sjekker om p har høyre søsken
            return førstePostorden(p.forelder.høyre);
        } else {
            return p.forelder;
        }
    }

    public void postorden(Oppgave<? super T> oppgave) {
        // sjekker om treet er tom!
        if (tom()) return;
        // flytter p til den første i postorden.
        Node<T> p = rot;
        // Sjekker første postPosisjon, samme metode som førstPostorden.
        while (true)
        {
            if (p.venstre != null) p = p.venstre;      // sjekker venstre del.
            else if (p.høyre != null) p = p.høyre;     // sjekker høyre del.
            else break;
        }
        // utfører oppgave så lenge p ikke er null.
        while (p!=null){
            // bruker utføroppgave for å skrive ut verdi.
            oppgave.utførOppgave(p.verdi);
            // bruker neste postorden for å skrive verdiene i neste post osv.
            p=nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if(p == null) return;

        // sjekker venstre del for p. hvis ikke er null, lager rekursiv kall på metoden postordenRekrusiv.
        if (p.venstre != null){
            postordenRecursive(p.venstre,oppgave);
        }
        // sjekker høyre del for p. hvis ikke er null, lager rekursiv kall på metoden postordenRekrusiv.
        if (p.høyre != null){
            postordenRecursive(p.høyre,oppgave);
        }
        // skriver ut verdien til p.
        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
