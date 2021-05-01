package questions.Graph;

public class EdgeUndirectedGraphWithWeight {
    public int source;
    public int neighbor;
    public int weight;

    public EdgeUndirectedGraphWithWeight(int source, int destination, int weight) {
        this.source = source;
        this.neighbor = destination;
        this.weight = weight;
    }
}

