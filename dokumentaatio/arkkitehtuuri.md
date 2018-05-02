# Arkkitehtuurikuvaus

## Rakenne

Rakennessa on kolme kerrosta. Pakkausrakenne on seuraava:

<img src="https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/pic/rakenne.png">

## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä näkymää

- kirjautuminen
- uuden käyttäjän luominen
- varauslista

## Sovelluslogiikka

<img src="https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/pic/logiikka.png" width="400">

Tästä näkee, että luokka Aikalista sisältää kaikki käyttäjät. Siellä on HashMap<Kayttaja, ArrayList<Integer>> olio, jossa on kaikki varauksia. Myös luokka Aikalista sisältä seuravia metodeja:
  - vaihtaKayttaja(Kayttaja user) - vaihtaa luokan nykyisen käyttäjän
  - varaa(int time) - varaa aika
  - poistaVaraus(int time) - poista ajanvaraus
  - varauksia() - palauttaa ArrayList<Integer> eli kaikki nykyisen käyttäjän varattu ajat
  - kaikki() - palauttaa kaikki varaukset ( ArrayList<Integer> )
  
## Päätoiminnallisuudet

### käyttäjän kirjaantuminen

<img src="https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/pic/sek1.png" width="600">

### uuden käyttäjän luominen

<img src="https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/pic/sek2.png" width="600">

### varaus

<img src="https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/pic/sek3.png" width="600">
