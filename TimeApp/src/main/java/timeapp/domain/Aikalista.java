package timeapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author oleg
 * luokka hallintaa kaikki varauksia
 * käyttäjä vaihtaa kun joku kiraudu sisään
 * 
 */
public class Aikalista {
    private Map<Kayttaja, ArrayList<Integer>> list;
    private Kayttaja user;
    
    public Aikalista() {
        this.list = new HashMap();
        this.list.putIfAbsent(user, new ArrayList());
    }
    
    public Aikalista(HashMap<Kayttaja, ArrayList<Integer>> list) {
        this.list = list;
    }
    
    public void vaihtaKayttaja(Kayttaja user) {
        this.user = user;
        this.list.putIfAbsent(user, new ArrayList());
    }
    
    public void varaa(int time) {
        if (!this.list.get(user).contains(time)) {
            this.list.get(user).add(time);
        }
    }
    
    public void poistaVaraus(int time) {
        if (this.list.containsKey(user)) {
            if (this.list.get(user).contains(time)) {
                this.list.get(user).remove(this.list.get(user).indexOf(time));
            }
        }
    }
    /**
     * 
     * @return yhden käyttäjän varauksia
     */
    public ArrayList<Integer> varauksia() {
        return this.list.get(user);
    }
    /**
     * 
     * @return kaikki varaukset
     */
    public ArrayList<Integer> kaikki() {
        ArrayList<Integer> kaikki = new ArrayList();
        this.list.keySet().stream().forEach(k -> {
            for (int j = 0; j < this.list.get(k).size(); j++) {
                kaikki.add(this.list.get(k).get(j));
            }
        });
        return kaikki;
    }
    
    public Kayttaja getUser() {
        return this.user;
    }
}
