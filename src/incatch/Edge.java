package incatch;

class Edge {
    private int i, j;
    private final String id;
    private final Node source;
    private final Node destination;
    private final double weight;
	
    public Edge(int ii, int jj) {
	i = ii;
	j = jj;	    
        //System.out.println("Sono nell'Edge");
        id = null;
        source = null;
        weight = 0;
        destination = null;
    }
    
    public Edge(String id, Node source, Node destination, double weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
     
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
    public String toString() {
        return "Edge(" + source.getId() + ", " + destination.getId() + ")";
        
        
    }
    
    public String getId() {
        return id;
    }
    
    public Node getDestination() {
        return destination;
    }

    public Node getSource() {
        return source;
    }
    
    public double getWeight() {
        return weight;
    }
}
