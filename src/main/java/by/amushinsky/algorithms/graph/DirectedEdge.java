package by.amushinsky.algorithms.graph;

/**
 * Created by Andrei_Mushinsky on 27/09/2016.
 */
public class DirectedEdge {
    private final int source;
    private final int target;
    private final double weight;

    public DirectedEdge(int source, int target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                '}';
    }
}
