# TimeApp

Sovellus on järjestelmä, joka hoitaa ajanvarauksia. Siellä voi rikestroida, varaa itselle aikaa ja tarkistaa, jos aika on vapaa.

## Dokumentaatio

[Vaatimusmaarittely]( https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md )

[Käyttöohje](https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Arkkitehtuurikuvaus]( https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md )

[Työaikakirjanpito]( https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md )

## Released

[release v1.2]( https://github.com/olegTervo/otm-harjoitustyo/releases/tag/v1.2 )

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _TimeApp-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/olegTervo/otm-harjoitustyo/blob/master/TimeApp/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
