package Model.Objects;

public class Edge {
    private String name;
    private float length;

    private String sourceID;
    private String  targetID;

    public Edge(String name, float length){
        this.name = name;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", source=" + sourceID +
                ", target=" + targetID +
                '}';
    }

    public void setSource(String sourceID) {
        this.sourceID = sourceID;
    }

    public void setTarget(String targetID) {
        this.targetID = targetID;
    }

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }

    public String getSource() {
        return sourceID;
    }

    public String getTarget() {
        return targetID;
    }
}
