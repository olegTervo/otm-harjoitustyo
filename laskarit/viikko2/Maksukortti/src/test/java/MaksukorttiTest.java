/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.maksukortti.Maksukortti;
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
public class MaksukorttiTest {
    
    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void hello() {}
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        Maksukortti kortti = new Maksukortti(10);

        String vastaus = kortti.toString(); 

        assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
    }
    
    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        Maksukortti kortti = new Maksukortti(10);

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        // nyt kortin saldo on 2
        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }  
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    @Test
    public void negatiivinenSummanLataaminen() {
        kortti.lataaRahaa(-10);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    @Test
    public void pystyyOstamaanEdullisen() {
        Maksukortti k1 = new Maksukortti(2.5);
        k1.syoEdullisesti();
        assertEquals("Kortilla on rahaa 0.0 euroa", k1.toString());
    }
    
    @Test
    public void pystyyOstamaanEMaukkaan() {
        Maksukortti k1 = new Maksukortti(4.0);
        k1.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 0.0 euroa", k1.toString());
    }
}
