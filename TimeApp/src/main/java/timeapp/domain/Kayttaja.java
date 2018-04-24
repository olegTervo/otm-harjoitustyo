/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeapp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oleg
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
}
