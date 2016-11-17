/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.Model;

/**
 *
 * @author Gabin
 */
public class VueLecteur extends JFrame implements Observer{
    
    public JPanel rootPanel;
    public JButton suivant;
    public JButton precedent;
    public JLabel labelSujet;
    public JLabel labelMessage;
    public JTextArea sujet;
    public JTextArea message;
    
    private Model model;
    
    public VueLecteur(Model model){
        
        this.model = model;
        init();
    }
    
    public void init(){
        
        this.setSize(200,500);
        this.setContentPane(mainContent());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        
    }
    
    public JPanel mainContent(){
        
        
        JPanel panel = new JPanel();
        
        suivant = new JButton("Suivant");
        precedent = new JButton("Precedent");
        labelSujet = new JLabel("Sujet");
        labelMessage = new JLabel("Message");
        sujet = new JTextArea();
        sujet.setPreferredSize(new Dimension(250, 30));
        message = new JTextArea();
        message.setPreferredSize(new Dimension(250, 120));
        
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        //label sujet
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 2;
        gbc.ipady = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(labelSujet, gbc);
        
        //zone sujet
        gbc.gridx = 1;
        gbc.ipady = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(sujet, gbc);
        
        
        //label message
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 2;
        gbc.ipady = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(labelMessage, gbc);
        
        //zone message
        gbc.gridx = 1;
        gbc.ipady = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(message, gbc);
        
        //boutons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 2;
        gbc.ipady = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(precedent, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(suivant, gbc);
        
        return panel;
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
        if(o == getModel()){
            this.sujet.setText(getModel().getSujet());
            this.message.setText(getModel().getMessage());
        }
        
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    
    
}
