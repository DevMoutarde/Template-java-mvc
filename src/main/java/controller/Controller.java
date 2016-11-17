/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Model;
import view.VueLecteur;

/**
 *
 * @author Gabin
 */
public final class Controller {
    
    private Model model;
    private VueLecteur vueLecteur;
    
    public Controller(Model model, VueLecteur vueLecteur){
        
        this.setModel(model);
        this.setVueLecteur(vueLecteur);
        getModel().addObserver(getVueLecteur());
        initListener();
    }
    
    public void initListener(){
        
        getVueLecteur().suivant.addMouseListener(new BtnListener(model, vueLecteur));
        getVueLecteur().precedent.addMouseListener(new BtnListener(model, vueLecteur));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public VueLecteur getVueLecteur() {
        return vueLecteur;
    }

    public void setVueLecteur(VueLecteur vueLecteur) {
        this.vueLecteur = vueLecteur;
    }
    
    
    
    
}
