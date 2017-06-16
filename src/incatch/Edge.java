package incatch;

class Edge {
    private int i, j;
	
    public Edge(int ii, int jj) {
	i = ii;
	j = jj;	    
        //System.out.println("Sono nell'Edge");
    }
    
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
