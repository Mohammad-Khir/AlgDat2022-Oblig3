# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Navn Navnesen, S123456, s123456@oslomet.no


# Oppgavebeskrivelse

### Oppgave 1
Løste ved å implementere kode fra kilde Programkode 5.2.3 a som det står i oppgaveteksten.
Vi starter med å opprette en node som blir en teller og en node som blir foreldre-noden til telleren.
Verdien vi får inn i metoden blir sammenliknet med node-verdien vi
er på og er den mindre flyttes noden til venstre barn. Er den større,
flyttes telleren til høyre barn. Når det ikke er flere barn,
er teller null og vi går ut av while-løkken. Her blir det avgjort om
rot (foreldrenode) er null, da settes rot lik telleren. Har vi en
rotnode med verdi, skal den nye noden settes lik enten høyre eller venstre barn i treet.

### Oppgave 2
Jeg brukte samme ide som er i Avsnitt 5.2.6 oppgave2 i kompendiet.
Oppretter node som starter i roten som blir en teller
"nodeViErPå" og en teller for antall forekomster. Lager en while-løkke
som itererer så lenge nodeViErPå ikke lik null. For hver iterasjon
flytter vi oss binært i treet, ved å bruke compare()-metoden.
Hvis compare() returnerer -1 er verdien vi sammenlikner med nodenViErPå mindre, og går vi videre til venstre. 
Er den 0 har vi funnet verdien i treet og øker antall-telleren(count) med 1 også går videre til høyre i treet. 
Er returverdien 1 går vi videre til høyre i treet.
Når vi er ute av while-løkken returnerer den antallet forekomster (count).

### Oppgave 3
Jeg hentet inspirasjon fra kompendiet "seksjon “5.1.7 Preorden, inorden og postorden”"
hvor det var snakk om hvilke kriterier som gjelder ved PostOrden.
I "FørstepostOrden" bruker jeg en while løkke som kjører til p
ikke lenger er lik null. I while løkken, sjekkes det om p.venstre
ikke er lik, så oppdateres p til p.venstre. Når det ikke er mulig å gå
mer til venstre, sjekker jeg om det er går ann å gå til høyre.
Når det ikke lenger er mulig å gå til høyre eller venstre,
returneres p. Og dermed får jeg første node post orden, med p som rot.

I "NestePostOrden" starter jeg med å se om p.forelder er lik null.
Dersom positiv så retunerer jeg null, ettersom rot er den siste i
postorden. Deretter sjekkes det om p er barn venstre eller høyre.
Hvis p er et venstre barn, returnerer jeg p.forelder ettersom den er
neste i postorden. Hvis p er et høyre barn, blir p.forelder neste verdi
i postorden.
Deretter sjekker jeg om p har, høyre søsken,
og dersom positiv så kjøres førstePostOrden(p.forelder.høyre)
for å finne første node.I "NestePostOrden" starter jeg med å se om p.forelder er lik null.
Dersom positiv så retunerer jeg null, ettersom rot er den siste i
postorden. Deretter sjekkes det om p er barn venstre eller høyre.
Hvis p er et venstre barn, returnerer jeg p.forelder ettersom den er
neste i postorden. Hvis p er et høyre barn, blir p.forelder neste verdi
i postorden.
Deretter sjekker jeg om p har, høyre søsken,
og dersom positiv så kjøres førstePostOrden(p.forelder.høyre)
for å finne første node.