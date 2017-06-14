/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incatch;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author CCIAA
 */
public class Map extends JPanel {
    
    private String nomeconfig;
    private File fileconfig;
    
    public Map(String n)
    {
        nomeconfig=n;
        nomeconfig=nomeconfig.concat("config.txt");
        System.out.println("fileconfig: "+ nomeconfig);
  
    }
   
        public boolean read()
    {
        System.out.println("sto per leggere il file "+nomeconfig);
        FileReader f;
        try  {
            
            f=new FileReader(nomeconfig);
        }
        
        catch (FileNotFoundException e) {
            System.err.println("non trovo il file " +nomeconfig);
            return false;
        }

        BufferedReader b;
        
        b=new BufferedReader(f);
        
            String riga="";

            while(true) {
            try{
              riga=b.readLine();
              
            }
            
            catch (IOException e){
            e.printStackTrace();
            return false;
            }
            
              if(riga==null)
                break;
              parse(riga);
              System.out.println("riga "+riga);
              //long ts= getTimestamp();
              //v.addElement(ts);     
        }
        
        return true;
        
    }
    
    public void parse(String riga)
    {
        int index=riga.indexOf("#");
        if(index==0)
        {
            System.out.println("Riga Commento");
        }
        else
        {
        String ss= riga.substring(0,index);
        //System.out.println("ss " +ss);
        long timestamp=Long.valueOf(ss.trim()).longValue();
        
        int index2=riga.indexOf("pose");
        if(index2>0)
        {
        
            String sp= riga.substring(index2+6);
            System.out.println("sp: "+sp);
            String x= sp.substring(sp.indexOf("p")+4, sp.indexOf(","));
                    System.out.println("x: "+x);
            String temp=sp.substring(sp.indexOf(",")+1);
            String y= temp.substring(0, temp.indexOf(","));
            System.out.println("y: "+y);

            double xd=Double.valueOf(x);
            System.out.println("xd: "+xd);
            double yd=Double.valueOf(y);
            System.out.println("yd: "+yd);
            Point2D p= new Point2D.Double(xd,yd);

            String q= temp.substring(temp.indexOf("q")+4, temp.indexOf("z")-3);

            System.out.println("q: "+q);

            String z= temp.substring(temp.indexOf("z")+7,temp.indexOf("\"}"));
            System.out.println("z: "+z);
        }
        }
    }
    
}
