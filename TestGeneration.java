import java.util.*;

public class TestGeneration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data file name: ");
        String fileName = sc.nextLine();

        Generation g = new Generation(500, 3, fileName);
        g.evalAll();

        g.printBestTree();
        g.printBestFitness();

        System.out.print("Top Ten Fitness Values:\n");
        ArrayList<GPTree> topTen = g.getTopTen();
        for (int i = 0; i < topTen.size(); i++) {
            System.out.printf("%.2f", topTen.get(i).getFitness());
            if (i < topTen.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
