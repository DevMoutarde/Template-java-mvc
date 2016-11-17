/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Gabin
 */
public class Model extends Observable{
    
    FileReader fr;
    BufferedReader br;
    String sujet;
    String message;
    public int noMessage = 0;
    List<String> lines;
    
    public Model() throws IOException{
        
        
    }
    
    public void read() throws FileNotFoundException, IOException{
        
        fr = new FileReader(new File("..\\messages.txt"));
        br = new BufferedReader(fr);
        br.mark(1);
        
    }
    
    public void lire() throws IOException{
        String text = br.readLine();
        if(text == "null"){
            br.reset();
            text = br.readLine();
        }
        System.out.println(br.readLine());
    }
    
    
    public void lireSuivant(){
        
        Path helloPath = Paths.get("src/main/java/messages.txt");
        Charset charset = Charset.forName("UTF-8");
        
        try
        {
            lines = Files.readAllLines(helloPath, charset);
            
            sujet = lines.get(this.noMessage);
            message = lines.get(this.noMessage +1);
            this.noMessage+= 3;
            
            //reinitialisation si au bout
            if(this.noMessage >= lines.size()){
                this.noMessage = 0;
            }
        }catch (IOException e){
            
            System.out.println(e);
         }
        this.changementMessage(sujet, message);
    }
    
    public void lirePrecedent(){
        
        Path helloPath = Paths.get("src/main/java/messages.txt");
        Charset charset = Charset.forName("UTF-8");
        //reinitialisation si au bout
        
        try
        {
            lines = Files.readAllLines(helloPath, charset);
            if(this.noMessage <= lines.size()){
                this.noMessage = lines.size()-2;
            }
            sujet = lines.get(this.noMessage);
            message = lines.get(this.noMessage +1);
            this.noMessage-= 3;
            
            
        }catch (IOException e){
            
            System.out.println(e);
         }
        this.changementMessage(sujet, message);
    }
    

    
    
    
    public String getLigne() throws IOException{
        
        return br.readLine();
        
    }
    
    public void close() throws IOException{
        br.close();
        fr.close();
    }
    
    public String lireLigneX(int x) throws IOException {
        
        String mot= "";
        try {
            
            System.out.println("no de ligne a atteindre: "+x);
            br.reset();
            for(int i = 0; i< x ; i++){
                
                mot = br.readLine();
                //si on arrive en fin de messages
                if(mot == "null"){
                    br.reset();
                    mot = br.readLine();
                }
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mot;
    }
    
    public void changementMessage(){
        
        this.sujet = "test";
        this.message = "test";
        
        setChanged();
        notifyObservers();
        
    }
    
    public void changementMessage(String sujet, String message){
        
        this.sujet = sujet;
        this.message = message;
        setChanged();
        notifyObservers();
        
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

   
    
}
