package incatch;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graph {
    
    ArrayList<Node> nodes;
    ArrayList<Edge> edges;

    public Graph() {       
	nodes = new ArrayList<Node>();
	edges = new ArrayList<Edge>();
    }
    
    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {       
	this.nodes = nodes;
	this.edges = edges;
    }
    
    public void addNode(double utm_x, double utm_y,
                        int x, int y)
    {
	nodes.add(new Node(nodes.size(), utm_x, utm_y, x, y));
    }
    
    public void addNode(Node n)
    {
        nodes.add(new Node(nodes.size(),
                           n.getUtmX(),
                           n.getUtmY(),
                           n.getX(),
                           n.getY()));
    }
    
    public void addEdge(int i, int j) {
	edges.add(new Edge(i,j));
    }
    
    public void print() {
        System.out.println("Nodes:");
	for (Node n : nodes) {	    
	    System.out.println(n.toString());
	}
        System.out.println();
        System.out.println("Edges:");
	for (Edge e : edges) {
            System.out.println(e.toString());
	}
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
    
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
    public static double distanceBetweenUTM(double i_x, double i_y,
                                            double j_x, double j_y)
    {
        return Math.sqrt(Math.pow(i_x - j_x, 2) +
                         Math.pow(i_y - j_y, 2));
    }
    
}
