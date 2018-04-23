/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.timeapp;

import com.mycompany.timeapp.Kayttaja;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author oleg
 */
public class Main extends Application {
    
    private Scene loginScene;
    private Scene createUser;
    private Scene logged;
    private Scene welldone;
    
    private Stage wdstage;
    private Kayttaja user;
    
    @Override
    public void start(Stage primary) {
        user = new Kayttaja("Admin");
        
        Label logintext = new Label("Username (use Admin for now)");
        TextField loginfield = new TextField();
        
        Button login = new Button("Log in");
        Button newuser = new Button("New user");
        
        HBox loginbox = new HBox();
        loginbox.setSpacing(10);
        loginbox.getChildren().add(logintext);
        loginbox.getChildren().add(loginfield);
        
        HBox loginbuttons = new HBox();
        loginbuttons.setSpacing(10);
        loginbuttons.getChildren().add(login);
        loginbuttons.getChildren().add(newuser);
        
        VBox loginall = new VBox();
        loginall.setSpacing(10);
        loginall.getChildren().add(loginbox);
        loginall.getChildren().add(loginbuttons);
        
        loginScene = new Scene(loginall);
        
        newuser.setOnAction(e-> {
            primary.setScene(createUser);
        });
        
        HBox newuserhbox = new HBox();
        newuserhbox.setSpacing(10);
        TextField newuserfield = new TextField();
        newuserfield.setText("");
        newuserhbox.getChildren().addAll(new Label(" Username"), newuserfield);
        VBox newuserall = new VBox();
        newuserall.setSpacing(10);
        Button done = new Button("done");
        newuserall.getChildren().addAll(newuserhbox, done);
        createUser = new Scene(newuserall);
        
        done.setOnAction(e -> {
            String s = newuserfield.getText();
            user = new Kayttaja(s);
            primary.setScene(loginScene);
        });
        
        login.setOnAction(e -> {
            String s = loginfield.getText();
            if (user != null) {
                if (user.getNimi().equals(s)) {
                    primary.setScene(logged);
                }
            }
        });
        
        VBox time = new VBox();
        time.setSpacing(2);
        ArrayList<Button> vaarabut = new ArrayList();
        for (int i = 0; i < 24; i++) {
            vaarabut.add(new Button("varaa"));
        }
        ArrayList<Label> times = new ArrayList();
        for (int i = 0; i < 24; i++) {
            times.add(new Label(i + " - " + (i + 1)));
        }
        for (int i = 0; i < 24; i++) {
            vaarabut.get(i).setOnAction(e -> {
                wdstage.show();
            });
            HBox onetime = new HBox();
            onetime.setSpacing(10);
            onetime.getChildren().addAll(times.get(i), vaarabut.get(i));
            time.getChildren().add(onetime);
        }
        
        BorderPane wd = new BorderPane();
        wd.setCenter(new Label("Done!"));
        welldone = new Scene(wd, 100, 100);
        wdstage = new Stage();
        wdstage.setScene(welldone);
        
        Button logout = new Button("Log out");
        time.getChildren().add(logout);
        logged = new Scene(time, 200, 700);
        
        logout.setOnAction(e -> {
            loginfield.setText("");
            primary.setScene(loginScene);
        });
        
        primary.setTitle("TimeApp");
        primary.setScene(loginScene);
        primary.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        /*Scanner lukija = new Scanner(System.in);
        
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
        }*/
    }
    
}
