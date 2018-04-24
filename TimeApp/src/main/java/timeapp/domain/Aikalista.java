/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author oleg
 */
public class Aikalista {
    private Map<Kayttaja, ArrayList<Integer>> list;
    private Kayttaja user;
    
    public Aikalista() {
        this.list = new HashMap();
//        this.user = user;
        this.list.putIfAbsent(user, new ArrayList());
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
    
    public ArrayList<Integer> varauksia() {
        return this.list.get(user);
    }
    
    public ArrayList<Integer> kaikki() {
        ArrayList<Integer> kaikki = new ArrayList();
//        for(int i = 0; i < this.list.size(); i++) {
        this.list.keySet().stream().forEach(k -> {
            for (int j = 0; j < this.list.get(k).size(); j++) {
                kaikki.add(this.list.get(k).get(j));
            }
        });
        return kaikki;
    }
}
