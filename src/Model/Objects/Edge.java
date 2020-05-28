package Model.Objects;

public class Edge {
    private String name;
    private float length;

    private Node source;
    private Node target;

    public Edge(String name, float length){
        this.name = name;
        this.length = length;
    }
}
