# OOPprojekt
Õppeaine Objektorienteeritud programmeerimine projektirepo


## Projekti II etapp:

Projekti teises etappis saime tööle kasutaja loomise ja sql andmebaasi andmete salvestamise.


Kuidas praegu programmi käivitada:

1. Lähtesta programmi teegid kasutades Mavenit.
2. Käivita arvutis postgres andmebaas ning ütle programmile kus andmebaas jookseb. Selleks:
   a) Ava rakenduse seadistus src/main/resources kaustas "application.properties"
   b) Real "spring.datasource.url=jdbc:postgresql://localhost:<port_nr>/<Andmebaasi_nimi>" sisesta pordi number ja andmebaas mida programm saab kasutada.
3. Kasutaja registreeringu kinnitamiseks kasutame emailiserverit MailDev. 

Selleks, et jooksutada MailDev-i dockeris [Docker](https://www.docker.com/), saab kasutada
[**maildev/maildev** image-it Docker Hubis](https://hub.docker.com/r/maildev/maildev).
Täpsemate juhiste jaoks dokumentatsiooni leiab siit, kuigi ablikatsiooni saab jooksutada jooksutades järgnevat commandi,
[Loe dokumentatsiooni](https://github.com/maildev/maildev/blob/master/docs/docker.md).

    $ docker run -p 1080:1080 -p 1025:1025 --name Maildev maildev/maildev
    
  Emailid on saadaval:
  
    http://0.0.0.0:1080


5. Pane programm tööle.
6. Tutvu praegu toimivate requestidega näiteks meie Postmani töölaual, millele pääsed ligi siit: https://lingid.ee/unsmm
7. Kasutaja kinnitamiseks 
8. Lisame täiendavaid funktsionaalsuseid töö edenedes ;)

## Projekti I etapp:

Projekti esimeses etappis saime tööle algelise veebiserveri, millel läbi oli võimalik implementeeritud Ride andmetüübi objekte in memory andmebaasi
lisada, samuti saime tööle Ride objektide loomise näidisfailist lugedes. Edasi hakkasime tööle eesmärgiga kasutada andmebaasi ja luua võimalus kasutaja
loomiseks.


Kuidas praegu programmi käivitada:

1. Lähtesta programmi teegid kasutades Mavenit.
2. Käivita arvutis postgres andmebaas ning ütle programmile kus andmebaas jookseb. Selleks:
   a) Ava rakenduse seadistus src/main/resources kaustas "application.properties"
   b) Real "spring.datasource.url=jdbc:postgresql://localhost:<port_nr>/<Andmebaasi_nimi>" sisesta pordi number ja andmebaas mida programm saab kasutada.
4. Pane programm tööle.
5. Tutvu praegu toimivate requestidega näiteks meie Postmani töölaual, millele pääsed ligi siit: https://lingid.ee/unsmm
6. Kasutaja kinnitamiseks 
7. Lisame täiendavaid funktsionaalsuseid töö edenedes ;)
