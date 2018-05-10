# Käyttöohje

Lataa [TimeApp.jar](https://github.com/olegTervo/otm-harjoitustyo/releases/tag/v1.1) ja [list.db](https://github.com/olegTervo/otm-harjoitustyo/releases/tag/v1.1)

## Konfigurointi

Ohjelma käyttää list.db tietokantaa tietojen tallentamiseen. Tietokanta pitäisi olla samassa kansiossa, jossa TimeApp.jar on.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar TimeApp.jar
```

## Uuden käyttäjän luominen

Käyttäjän luominen tapahtu painamalla _New user_.
Syötä käyttäjätunnus tekstikentään ja paina _done_.

## Kirjautuminen

Järjestelmään voi kirjautua kirjoittamalla olemassaoleva käyttäjätunnus syötekenttään ja painamalla _Log in_.

## Aikataulun käyttäminen

Kirjautumisen jalkeen nakee aikalista. Jokainen rivi on yhden tunnin aika.

- Aika on vapaa jos se on musta ja sen vieressä on _varaa_ nappi.
- Aika on varattu nykyiselta käyttäjältä jos se on punainen ja sen vieressä on _poista_ nappi.
- Aika on varattu mualta käyttäjältä jos se on punainen ja ei ole _poista_ nappia.

Aika voi varata painamalla _varaa_ ja poista varauksen ajalta painamalla _poista_.

## Lopussa

Klikkaamalla näkymän vasemman ylänurkan nappia _logout_, käyttäjä kirjautuu ulos sovelluksesta ja sovellus palaa takaisin kirjaantumisnäkymään.
