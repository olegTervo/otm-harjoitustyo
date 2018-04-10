/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.timeapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oleg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Kayttaja user = new Kayttaja("Usver");
        Aikalista l = new Aikalista();
        while(true){
            System.out.println("Select time (1-24) :");
            int time = Integer.parseInt(lukija.nextLine());
            l.varaa(user, time);
            ArrayList<Integer> varauksia = l.varauksia(user);
            System.out.println("Sinun varauksia ovat nyt:");
            for(int i = 0; i < varauksia.size(); i++){
                System.out.println((varauksia.get(i) - 1) + "-" + varauksia.get(i));
            }
            System.out.println("Haluatko varaa vielä? (Y/N)");
            if(!lukija.nextLine().equals("Y")){
                break;
            }
        }
    }
    
}
