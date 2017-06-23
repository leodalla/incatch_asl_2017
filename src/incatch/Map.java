package incatch;

import java.awt.geom.Point2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class Map extends JPanel {
    private Point2D ul,br;
    private BufferedImage mapImage;
    
    public Map(){
        mapImage= null;
        this.ul=null;
        this.br=null;  
    }
    
    public Map(BufferedImage img, Point2D ul, Point2D br){
        mapImage= img;
        this.ul=ul;
        this.br=br;  
    }
    
    public void setMapImage(BufferedImage img){
        mapImage= img;
    }
    
    public void setUl(Point2D ul){  
        this.ul=ul;
    }
    
    public void setBr(Point2D br){
        this.br=br;
    }
    
    public Point2D getUl(){
        return ul;
    }
    
    public Point2D getBr(){
        return br;
    }
    
    public BufferedImage getMapImage(){
        return mapImage;
    }
    
    public String toString(){ 
        String description="";
        description+="map: (" + mapImage.getWidth() +","+mapImage.getHeight()+") ";
        description+="ul: (" + ul.getX() +","+ul.getY()+") ";
        description+="br: (" + br.getX() +","+br.getY()+") ";
        return description;
    }
    
    public Point2D convert(Pose p){
        Point2D t = p.getP();
        Point2D z=new Point2D.Double(-1,-1);
        int width = mapImage.getWidth ();
        int height = mapImage.getHeight ();
        double t_x=t.getX();
        System.out.println("tx: "+t_x);
        double ul_x=ul.getX();
        //System.out.println("ulX: "+ul_x);
        double br_x=br.getX();
        //System.out.println("brX: "+br_x);
        double x = ((t_x-ul_x)*width)/(br_x-ul_x);
        double t_y=t.getY();
        System.out.println("ty: "+t_y);
        double ul_y=ul.getY();
        double br_y=br.getY();
        double y=((t_y-ul_y)*height)/(br_y-ul_y);
        //System.out.println("y: "+y);
        z.setLocation(x,y);
        if((z.getX()<0)||(z.getY()<0)){
            //System.out.println("Errore, coordinate negative");
            //System.out.println("puntoX: "+z.getX());
            //System.out.println("puntoY: "+z.getY());
        }
        
        return z;
    }
}
