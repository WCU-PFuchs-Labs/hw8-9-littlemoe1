

public class GPTree implements Comparable<GPTree>, Cloneable {
    private Node root;        // root node of expression tree
    private double fitness;   // computed fitness

    public void evalFitness(DataSet dataSet) {
        double sumSqError = 0;
        for (DataRow row : dataSet) {
            double predicted = eval(row.getX()); // existing eval(double[]) or eval(double)
            double actual = row.getY();
            double diff = predicted - actual;
            sumSqError += diff * diff;
        }
        fitness = sumSqError;
    }

    public double getFitness() {
        return fitness;
    }

    @Override
    public int compareTo(GPTree t) {
        return Double.compare(this.fitness, t.fitness);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof GPTree)) return false;
        return this.compareTo((GPTree)o) == 0;
    }

    @Override
    public Object clone() {
        try {
            GPTree copy = (GPTree) super.clone();
            copy.root = (Node) root.clone(); // or new Node(root) if you have a copy constructor
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
