/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc;
import controller.Controller;
import java.io.IOException;
import model.Model;
import view.VueLecteur;
/**
 *
 * @author Gabin
 */
public class Mvc {
    
    public Model model;
    public Controller controller;
    public VueLecteur vueLecteur;
    
    
    public Mvc() throws IOException{
        
        init();
    }
    
    public void init() throws IOException{
        
        model = new Model();
        vueLecteur = new VueLecteur(model);
        controller = new Controller(model, vueLecteur);
        
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public VueLecteur getVueLecteur() {
        return vueLecteur;
    }

    public void setVueLecteur(VueLecteur vueLecteur) {
        this.vueLecteur = vueLecteur;
    }
    
    
}

