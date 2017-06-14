/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incatch;

import java.awt.geom.Point2D;
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
    public Point2D convert(Pose p){
        Point2D t = p.getP();
        Point2D z=new Point2D.Double(-1,-1);
        t.getX();
        int width = mapImage.getWidth ();
        int height = mapImage.getHeight ();
        double ulX=ul.getX();
        double ulY=ul.getY();
        double brX=br.getX();
        double brY=br.getY();
        double diffX=ulX-brX;
        double diffY=brY-ulY;
        double tY=t.getY();
        double tX=t.getX();
        double difftX=tX-ulX;
        double difftY=tY-ulY;
        double zX=(tX*width)/diffX;
        double zY=(tY*height)/diffY;
        z.setLocation(zX,zY);
        System.out.println("puntoX: "+z.getX());
        System.out.println("puntoY: "+z.getY());
        System.out.println("X: "+diffX);
        System.out.println("Y: "+diffY);
        System.out.println("X: "+ulX);
        System.out.println("Y: "+ulY);
        System.out.println("X: "+brX);
        System.out.println("Y: "+brY);
    return z;
    }
}
