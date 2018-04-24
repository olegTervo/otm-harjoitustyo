# Arkkitehtuurikuvaus

## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä näkymää

- kirjautuminen
- uuden käyttäjän luominen
- varauslista

## Sovelluslogiikka

<img src="https://github.com/olegTervo/otm-harjoitustyo/blob/master/dokumentaatio/65fd4cd5.png" width="400">

Tästä näkee, että luokka Aikalista sisältää kaikki käyttäjät. Siellä on HashMap<Kayttaja, ArrayList<Integer>> olio, jossa on kaikki varauksia. Myös luokka Aikalista sisältä seuravia metodeja:
  - vaihtaKayttaja(Kayttaja user) - vaihtaa luokan nykyisen käyttäjän
  - varaa(int time) - varaa aika
  - poistaVaraus(int time) - poista ajanvaraus
  - varauksia() - palauttaa ArrayList<Integer> eli kaikki nykyisen käyttäjän varattu ajat
  - kaikki() - palauttaa kaikki varaukset ( ArrayList<Integer> )
