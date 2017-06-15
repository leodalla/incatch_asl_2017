package incatch;

class Node {
    int x, y; //coordinate immagine
    double utm_x, utm_y; //coordinate UTM
    int idx; //indice del nodo

    public Node(int _idx,
                double _utm_x,
                double _utm_y,
                int _x,
                int _y)
    {
        idx = _idx;
        utm_x = _utm_x;
        utm_y = _utm_y;
        x = _x;
        y = _y;
    }

    public String toString() {
        return "utm: " + utm_x + " " +
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
