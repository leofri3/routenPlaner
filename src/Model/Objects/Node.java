package Model.Objects;

import java.util.HashSet;

public class Node {
    private String id;

    private float lat;
    private float lon;

    private HashSet<Edge> edges = new HashSet<>(); //all edges from this node

    public Node(String id, float lat, float lon){
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }
}
