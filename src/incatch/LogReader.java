package incatch;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.Vector;
import java.awt.geom.Point2D;
import java.lang.*;
import java.lang.Double;

public class LogReader {
    private String nomefile;
    private Vector<Pose> v;
    
    public LogReader(String nf){
        nomefile=nf;
        v= new Vector();
    }
    
    public boolean read(){
        FileReader f;
        try{
            f=new FileReader(nomefile);
            //System.out.println("file: " +nomefile);
        }
        catch (FileNotFoundException e) {
            System.err.println("non trovo il file " +nomefile);
            return false;
        }
        BufferedReader b;
        b=new BufferedReader(f);
        try{
            String riga=b.readLine();
                while(riga!=null){
                    
                    
                    parse(riga);
                    riga=b.readLine();
                }
            }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        
        
        return true;
    }
    public void parse(String riga){
        int index=riga.indexOf("I");
        if(index<0){
            System.err.println("Errore logfile non trovo I");
            System.exit(-1);
        }
        String ss= riga.substring(0,index);
        long timestamp=Long.valueOf(ss.trim()).longValue();
        int index2=riga.indexOf("pose");
        if(index2>0)
        {
            String sp= riga.substring(index2+6);
            //System.out.println("sp: "+sp);
            String x= sp.substring(sp.indexOf("p")+4, sp.indexOf(","));
            //System.out.println("x: "+x);
            String temp=sp.substring(sp.indexOf(",")+1);
            String y= temp.substring(0, temp.indexOf(","));
            //System.out.println("y: "+y);
            double xd=Double.valueOf(x);
            //System.out.println("xd: "+xd);
            double yd=Double.valueOf(y);
            //System.out.println("yd: "+yd);
            Point2D p= new Point2D.Double(xd,yd);
            String q= temp.substring(temp.indexOf("q")+4, temp.indexOf("z")-3);
            //System.out.println("q: "+q);
            String z= temp.substring(temp.indexOf("z")+7,temp.indexOf("\"}"));
            //System.out.println("z: "+z);
            if(z.equals("32North")){
                Pose pose= new Pose(timestamp,p, q, z);
                v.add(pose);
            }       
        }
    }
   
    public Vector<Pose> getVector() {
        return v;
    }   
}