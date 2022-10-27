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