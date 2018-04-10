/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.timeapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oleg
 */
public class Kayttaja {
    private String nimi;
    private List<Integer> varaukset;
    
    public Kayttaja(String nimi){
        this.nimi = nimi;
        this.varaukset = new ArrayList();
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public int hashCode(){
        return this.nimi.hashCode();
    }
}
