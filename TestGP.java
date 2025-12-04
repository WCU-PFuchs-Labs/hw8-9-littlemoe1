import java.util.Scanner;
import binary.Generation;
import binary.GPTree;
import java.util.ArrayList;

public class TestGP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data file name: ");
        String fileName = sc.nextLine();

        Generation gen = new Generation(500, 3, fileName);
        gen.evalAll();

        for (int i = 1; i <= 50; i++) {
            System.out.println("\nGeneration " + i + ":");
            gen.printBestTree();
            gen.printBestFitness();
            gen.evolve();
            gen.evalAll();
        }
    }
}
