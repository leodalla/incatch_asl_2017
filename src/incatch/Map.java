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
import java.awt.image.BufferedImage;

/**
 *
 * @author CCIAA
 */
public class Map extends JPanel {
    
    private Point2D ul,br;
    private BufferedImage mapImage;

    public Map()
    {
        mapImage= null;
        this.ul=null;
        this.br=null;  
    }
    
    public Map(BufferedImage img, Point2D ul, Point2D br)
    {
        mapImage= img;
        this.ul=ul;
        this.br=br;  
    }
    
    public void setMapImage(BufferedImage img){
        
        mapImage= img;
    }
    
    public void setUl(Point2D ul){
        
        this.ul=ul;
         System.out.println("OK: ");
    }
    
    public void setBr(Point2D br){
        
        this.br=br;
    }
    
    public Point2D getUl()
    {
        return ul;
    }
    
    public Point2D getBr()
    {
        return br;
    }
    
    public BufferedImage getMapImage()
    {
        return mapImage;
    }
    
    public String toString(){
            
            
        System.out.println("dentrotoString");
        
        String description="";
        
        description+="map: (" + mapImage.getWidth() +","+mapImage.getHeight()+") ";
        description+="ul: (" + ul.getX() +","+ul.getY()+") ";
        description+="br: (" + br.getX() +","+br.getY()+") ";
        
        return description;
    }
}
