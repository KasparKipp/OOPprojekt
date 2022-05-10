# OOPprojekt
Õppeaine Objektorienteeritud programmeerimine projektirepo


Projekti I etapp:

Projekti esimeses etappis saime tööle algelise veebiserveri, millel läbi oli võimalik implementeeritud Ride andmetüübi objekte in memory andmebaasi
lisada, samuti saime tööle Ride objektide loomise näidisfailist lugedes. Edasi hakkasime tööle eesmärgiga kasutada andmebaasi ja luua võimalus kasutaja
loomiseks.


Kuidas praegu programmi käivitada:

1. Lähtesta programmi teegid kasutades Mavenit.
2. Käivita arvutis postgres andmebaas ning ütle programmile kus andmebaas jookseb. Selleks:
   a) Ava rakenduse seadistus src/main/resources kaustas "application.properties"
   b) Real "spring.datasource.url=jdbc:postgresql://localhost:<port_nr>/<Andmebaasi_nimi>" sisesta pordi number ja andmebaas mida programm saab kasutada.
3. Kasutaja loomiseks ja kinnitamiseks kasutame emailiserverit. Selle käivitamiseks käivitada dockeri konteineris jooksva veebiserveri järgneva commandiga:

   $ docker run -p 1080:1080 -p 1025:1025 maildev/maildev

5. Pane programm tööle.
6. Tutvu praegu toimivate requestidega näiteks meie Postmani töölaual, millele pääsed ligi siit: https://lingid.ee/unsmm
7. Lisame täiendavaid funktsionaalsuseid töö edenedes ;)
