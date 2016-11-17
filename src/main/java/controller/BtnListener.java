/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import model.Model;
import view.VueLecteur;

/**
 *
 * @author Gabin
 */
public class BtnListener implements MouseListener{
    
    protected Model model;
    protected VueLecteur vueLecteur;
    
    public int noMessage = 0;
    
    public BtnListener(){
        
    }
    
    public BtnListener(Model model, VueLecteur vueLecteur){
        
        this.model = model;
        this.vueLecteur = vueLecteur;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e){
        
        JButton btn = (JButton)e.getSource();
        switch(btn.getText()){
            case "Suivant":
        
                getModel().lireSuivant();
                //getModel().changementMessage();
                //getModel().lireSuivant();
                break;
                
            case "Precedent":
                getModel().lirePrecedent();
                break;
                
            default:
                System.out.println("bouton inconnu");
                break;
        }

        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        

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
