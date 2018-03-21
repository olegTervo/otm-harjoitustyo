/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oleg
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa != null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiOikein() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiOikein() {
        kassa.syoMaukkaasti(600);
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiOikeinMaksukortilla() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
//        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiVaarin() {
        kassa.syoEdullisesti(100);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100, kassa.syoEdullisesti(100));
    }
    
    @Test
    public void syoMaukkaastiVaarin() {
        kassa.syoMaukkaasti(100);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100, kassa.syoMaukkaasti(100));
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
        assertEquals(101000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKortilla() {
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKortilla() {
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiMaksamallaVahan() {
        kortti.otaRahaa(900);
        assertFalse(kassa.syoEdullisesti(kortti));
        assertEquals(100, kortti.saldo());        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void palauttaaOkeinMaaraRahaa() {
        assertEquals(760, kassa.syoEdullisesti(1000));
    }
}
