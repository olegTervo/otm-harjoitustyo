/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeapp.ui;

import java.sql.SQLException;
import timeapp.domain.Kayttaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
import javafx.stage.Stage;
import timeapp.dao.AikalistaDao;
import timeapp.dao.Database;
import timeapp.domain.Aikalista;

/**
 *
 * @author oleg
 */
public class Main extends Application {
    
    private Stage primary;
    
    private Scene loginScene;
    private Scene createUser;
    private Scene logged;
    private Scene welldone;
    
    private ScrollPane finaltime;
    private List<Kayttaja> users = new ArrayList();
    private Aikalista list;// = new Aikalista();
    
    Database db;
    AikalistaDao dao;
    public void renew(){
        VBox boksi = new VBox();
        VBox time1 = times();
        time1.setSpacing(2);
        Button logout = new Button("Log out");
        boksi.getChildren().add(logout);
        finaltime = new ScrollPane(time1);    
        boksi.getChildren().add(finaltime);
        logged = new Scene(boksi, 200, 300);
        primary.setScene(logged);
        
        logout.setOnAction(e -> {
            primary.setScene(loginScene);
        });
    }
    
    public HBox time(int time){
        Label l = new Label((time-1) + " - " + time);
        Region space = new Region();
        HBox.setHgrow(space, Priority.ALWAYS);
        Button b = new Button("varaa");
        
        b.setOnAction(e -> {
            l.setTextFill(RED);
            list.varaa(time);
            try {
                dao.saveOrUpdate(list.getUser().toString(), time);
            } catch (SQLException ex) {
                System.out.println("Can not get user");
            }
            System.out.println(list.varauksia().toString());
            renew();
        });
        
        HBox line = new HBox(35);
        line.setPadding(new Insets(0,5,0,5));
        line.getChildren().addAll(l, space, b);
        
        return line;
    }
    
    public HBox varTime(int time, boolean yours){
        Label l = new Label((time-1) + " - " + time);
        l.setTextFill(RED);
        Region space = new Region();
        HBox.setHgrow(space, Priority.ALWAYS);
        Button b = new Button("poista");
        
        b.setOnAction(e -> {
            try {
                dao.delete(time);
            } catch (SQLException ex) {
                System.out.println("Can not delete time");
            }
            l.setTextFill(BLACK);
            list.poistaVaraus(time);
            renew();
        });
        
        HBox line = new HBox(35);
        line.setPrefHeight(25);
        line.setPadding(new Insets(0,5,0,5));
        if(yours)
            line.getChildren().addAll(l, space, b);
        else line.getChildren().add(l);
        return line;
    }
    
    public VBox times(){
        VBox times = new VBox();
        
        ArrayList<Integer> varattu = this.list.varauksia();
        ArrayList<Integer> varattuAll = this.list.kaikki();
        if(varattuAll.size() == 0){
            for(int i = 1; i <= 24; i++)
                times.getChildren().add(time(i));
            return times;
        }else{
        for(int i = 1; i <= 24; i++){
            if(varattuAll.contains(i)){
                if(list.getUser() != null){
                    if(varattu.contains(i)){
                        times.getChildren().add(varTime(i, true));
                    }else times.getChildren().add(varTime(i, false));
                }
            }else{
                times.getChildren().add(time(i));
            }
        }
        }
        
        return times;
    }
    
    @Override
    public void start(Stage primary) throws Exception {
        db = new Database("jdbc:sqlite:list.db");
        dao = new AikalistaDao(db);
        List<String> usrs = dao.findAll();
        for(int i = 0; i < usrs.size(); i++){
            this.users.add(new Kayttaja(usrs.get(i)));
        }
        this.list = new Aikalista(dao.varaukset());
        this.primary = primary;
        
        Label vaarinLogin = new Label("");
        Label logintext = new Label("Username");
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
        loginall.getChildren().add(vaarinLogin);
        loginall.getChildren().add(loginbox);
        loginall.getChildren().add(loginbuttons);
        
        login.setOnAction(e -> {
            String s = loginfield.getText();
            if (!users.isEmpty()) {
                if (users.contains(new Kayttaja(s))) {
                    vaarinLogin.setText("");
                    loginfield.setText("");
                    this.list.vaihtaKayttaja(new Kayttaja(s));
                    renew();
                }else vaarinLogin.setText("Tarkista käyttäjatunnus");
            }else vaarinLogin.setText("Paina new user");
        });
        
        newuser.setOnAction(e-> {
            primary.setScene(createUser);
        });
        
        loginScene = new Scene(loginall);
        
        //      end of 1 scene
        
        TextField newuserfield = new TextField();
        newuserfield.setText("");
        Button done = new Button("done");
        Label vaarin = new Label("");
        
        HBox newuserhbox = new HBox();
        newuserhbox.setSpacing(10);
        newuserhbox.getChildren().addAll(new Label(" Username"), newuserfield);
        
        VBox newuserall = new VBox();
        newuserall.setSpacing(10);
        newuserall.getChildren().addAll(vaarin, newuserhbox, done);
        
        done.setOnAction(e -> {
            String s = newuserfield.getText();
            if(users.contains(new Kayttaja(s))) {
                vaarin.setText("Nimi pitäisi olla uniikki!");
            }else{
                try {
                    dao.souser(s);
                } catch (SQLException ex) {
                    System.out.println("Can not add user");
                }
                users.add(new Kayttaja(s));
                vaarin.setText("");
                primary.setScene(loginScene);
                loginfield.setText("");
                newuserfield.setText("");
            }
        });
        
        createUser = new Scene(newuserall);
        
        //      end of 2 scene
        
        renew();
        
        //      end of main scene
        
        primary.setTitle("TimeApp");
        primary.setScene(loginScene);
        primary.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
