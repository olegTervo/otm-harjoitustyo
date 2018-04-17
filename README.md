# TimeApp

Sovellus on järjestelmä, joka hoitaa ajanvarauksia. Siellä voi rikestroida, varaa itselle aikaa ja tarkistaa, jos aika on vapaa.

## Dokumentaatio

[Vaatimusmaarittely]( https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md )

[Työaikakirjanpito]( https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md )

[Arkkitehtuurikuvaus] ( https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md )

## Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

## Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/olegTervo/otm-harjoitustyo/blob/master/TimeApp/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
