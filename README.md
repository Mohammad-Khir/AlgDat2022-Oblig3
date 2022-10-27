# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Navn Navnesen, S123456, s123456@oslomet.no


# Oppgavebeskrivelse

### Oppgave 1:
Løste ved å implementere kode fra kilde Programkode 5.2.3 a som det står i oppgaveteksten.
Vi starter med å opprette en node som blir en teller og en node som blir foreldre-noden til telleren.
Verdien vi får inn i metoden blir sammenliknet med node-verdien vi
er på og er den mindre flyttes noden til venstre barn. Er den større,
flyttes telleren til høyre barn. Når det ikke er flere barn,
er teller null og vi går ut av while-løkken. Her blir det avgjort om
rot (foreldrenode) er null, da settes rot lik telleren. Har vi en
rotnode med verdi, skal den nye noden settes lik enten høyre eller venstre barn i treet.

### Oppgave 2:
