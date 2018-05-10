package timeapp.domain;

/**
 *
 * @author oleg
 * luokka edustaa käyttäjää
 */
public class Kayttaja {
    private String nimi;
    
    public Kayttaja(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int hashCode() {
        return this.nimi.hashCode();
    }
    
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        try {
            Kayttaja k = (Kayttaja) o;
        } catch (Exception e) {
            return false;
        }
        Kayttaja k = (Kayttaja) o;
        if (this.hashCode() == k.hashCode()) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return this.nimi;
    }
}
