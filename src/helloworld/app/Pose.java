package helloworld.app;

import java.awt.geom.Point2D;

public class Pose {
     
    private long timestamp;
    private String q;
    private String zone;
    private Point2D p;
    
    public Pose(long timestamp, Point2D p, String q, String zone)
    {
        this.timestamp=timestamp;
        this.p=p;
        this.q=q;
        this.zone=zone;
    }
    
    public long getTimestamp()
    {
        return timestamp;
    }
    
    public String toString()
    {
        String s= "Pose(";
        s = s + (timestamp+",");
        s += (p.getX()+"," + p.getY()+",");
        s += (q+"," + zone +")");
        return s;
    }
    
}
   
   
