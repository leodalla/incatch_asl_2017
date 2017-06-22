package incatch;

class Node {
    int x, y; //coordinate immagine
    double utm_x, utm_y; //coordinate UTM
    int idx; //indice del nodo
    final private String id;
    final private String name;


    public Node(int _idx,
                double _utm_x,
                double _utm_y,
                int _x,
                int _y)
    {
       // System.out.println("Sono nell node");
        idx = _idx;
        utm_x = _utm_x;
        utm_y = _utm_y;
        x = _x;
        y = _y;
        id = null;
        name = null;
    }
    
    public Node(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Node(String _id,
                String _name,
                int _idx,
                double _utm_x,
                double _utm_y,
                int _x,
                int _y)
    {
        id = _id;
        name = _name;
        idx = _idx;
        utm_x = _utm_x;
        utm_y = _utm_y;
        x = _x;
        y = _y;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }    

    public String toString() {
        return "id: " + id + " name: " + name + " utm: " + utm_x + " " +
                utm_y;
    }

    public int getIdx() {
        return idx;
    }

    public double getUtmX() {
        return utm_x;
    }

    public double getUtmY() {
        return utm_y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
