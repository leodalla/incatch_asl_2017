
package helloworld.app;

import java.util.Vector;
import java.util.*;

public class HelloWorldApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, World");
        String nomefile= new String("dati/log1.txt");
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
        
     
    }
    
}
