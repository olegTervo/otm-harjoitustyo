/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import timeapp.domain.Aikalista;
import timeapp.domain.Kayttaja;
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
public class TimeAppTest {
    
    Kayttaja user;
    Aikalista list;
    
    public TimeAppTest() {
    }
    
    @Before
    public void setUp() {
        user = new Kayttaja("User");
        list = new Aikalista(user);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void nameTest(){
        assertEquals(user.getNimi(), "User");
    }
    
    @Test
    public void varaustest(){
        list.varaa(6);
        assertTrue(list.varauksia().get(0) == 6);
    }
    
    @Test
    public void poistaminenTest(){
        list.varaa(1);
        list.varaa(5);
        list.poistaVaraus(5);
        assertEquals(list.varauksia().size(), 1);
        assertTrue(list.varauksia().get(0) == 1);
    }
}
