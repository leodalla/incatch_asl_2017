package incatch;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphDraw extends JPanel {
    int width;
    int height;

    ArrayList<Node> nodes;
    ArrayList<Edge> edges;

    public GraphDraw() { //Constructor
        
        
	nodes = new ArrayList<Node>();
	edges = new ArrayList<Edge>();
	width = 30;
	height = 30;
    }
    
    public void addNode(double utm_x, double utm_y,
                        int x, int y)
    { 
	//add a node at pixel (x,y)
	nodes.add(new Node(nodes.size(), utm_x, utm_y, x, y));
	this.repaint();
    }
    
    public void addNode(Node n)
    { 
	//add a node at pixel (x,y)
	nodes.add(new Node(nodes.size(),
                           n.getUtmX(),
                           n.getUtmY(),
                           n.getX(),
                           n.getY()));
	this.repaint();
    }
    
    public void addEdge(int i, int j) {
	//add an edge between nodes i and j
	edges.add(new Edge(i,j));
	this.repaint();
    }
    
    public void paint(Graphics g) { // draw the nodes and edges
	
        double OFFSET = 20;
        
	g.setColor(Color.red);
	for (Edge e : edges) {
            
            int xi = (int)(nodes.get(e.getI()).x*OFFSET);
            int yi = (int)(nodes.get(e.getI()).y*OFFSET);
            int xj = (int)(nodes.get(e.getJ()).x*OFFSET);
            int yj = (int)(nodes.get(e.getJ()).y*OFFSET);
            
            
            System.out.println("sono nel GraphDraw");
            //System.out.println("yi: " + yi);
            //System.out.println("xj: " + xj);
            //System.out.println("yj: " + yj);
            
            
            
            //double theta = Math.PI/2;    
        
            int xip = xi; 
                    //(int)(Math.cos(theta) * xi - Math.sin(theta) * yi);
            int yip = yi;
                    //(int)(Math.sin(theta) * xi + Math.cos(theta) * yi);
            
            xip -= 8000;
            yip -= 6700;
            
            
            System.out.println("xip: " + xip);
            System.out.println("yip: " + yip);
            
            
            int xjp = xj;
                    //(int)(Math.cos(theta) * xj - Math.sin(theta) * yj);
            int yjp = yj;
                    //(int)(Math.sin(theta) * xj + Math.cos(theta) * yj);
            
            xjp -= 8000;
            yjp -= 6700;
            
            
            //System.out.println("xjp: " + xjp);
            //System.out.println("yjp: " + yjp);
            
            
	    g.drawLine(xip, yip, xjp, yjp);
	}
        g.setColor(Color.black);
	for (Node n : nodes) {	    
	    
            
            
            int x = (int)(n.x*OFFSET);
            int y = (int)(n.y*OFFSET);
            
            //double theta = Math.PI/2;    
        
            int xp = x;
                    //(int)(Math.cos(theta) * x - Math.sin(theta) * y);
            int yp = y;
                    //(int)(Math.sin(theta) * x + Math.cos(theta) * y);
            
            xp -= 8000;
            yp -= 6700;
            
            g.fillOval(xp, yp, 6, 6);
	    
	}
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
    
    public static double distanceBetweenUTM(double i_x, double i_y,
                                            double j_x, double j_y)
    {
        return Math.sqrt(Math.pow(i_x - j_x, 2) +
                         Math.pow(i_y - j_y, 2));
    }
}
