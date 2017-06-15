package incatch;

import java.util.Vector;
import java.util.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Incatch {
    
    private static void createAndShowGUI() {
        //Use the Java look and feel.
        try {
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }
        Framework framework = new Framework();
        framework.addButton();
        int code = framework.run();
        while(code<0){
            framework.run();
<<<<<<< Updated upstream
            }  
     }
     
=======

        }
        
        //framework.addMap();
    }
     
    public static void main(String[] args){
        //javax.swing.SwingUtilities.invokeLater(new Runnable() {
          //  public void run() {
                createAndShowGUI();
            //}
        //});
      
        
        
       /* String nomefile= new String("dati/log1.txt");
        System.out.println(nomefile);
        LogReader lr= new LogReader(nomefile);
        if(lr.read())
        {
            System.out.println("OK");
            
            
        }
        else{
           System.out.println("Errore chiudo"); 
           return;
        }
        
        Vector<Pose> v= lr.getVector();
        System.out.println("v:" +v.size());
        Iterator<Pose> it= v.iterator();
        
        while(it.hasNext())
        {
           Pose p= it.next();
           System.out.println(p.toString());
        }
        */
    }

>>>>>>> Stashed changes
    public static void main(String[] args) {
     //class lookk and feel
        createAndShowGUI();
    }
}

