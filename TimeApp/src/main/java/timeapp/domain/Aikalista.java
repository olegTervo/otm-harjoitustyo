/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.timeapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author oleg
 */
public class Aikalista {
    private Map<Kayttaja, ArrayList<Integer>> list;
    
    public Aikalista() {
        this.list = new HashMap();
    }
    
    public void varaa(Kayttaja k, int time) {
        this.list.putIfAbsent(k, new ArrayList());
        this.list.get(k).add(time);
    }
    
    public void poistaVaraus(Kayttaja k, int time) {
        if (this.list.containsKey(k)) {
            if (this.list.get(k).contains(time)) {
                this.list.get(k).remove(this.list.get(k).indexOf(time));
            }
        }
    }
    
    public ArrayList<Integer> varauksia(Kayttaja k) {
        return this.list.get(k);
    }
}
