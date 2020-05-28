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

    @Override
    public String toString() {
        return "Edge{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", source=" + source +
                ", target=" + target +
                '}';
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public void setTarget(Node target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }
}
