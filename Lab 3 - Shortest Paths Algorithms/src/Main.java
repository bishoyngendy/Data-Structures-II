package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 3 : Shortest Paths Algorithms
 * Created by Bishoy N. Gendy (programajor) on Saturday 17/06/2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner s = new Scanner(System.in);
        String fileName = "";
        IGraph graph = new IGraphImpl();
        while (true) {
            System.out.println("Enter File Name");
            fileName = s.nextLine();
            File file = new File(System.getProperty("user.dir")
                    + File.separator + fileName + ".txt");
            try {
                graph.readGraph(file);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        while (true) {
            System.out.println("Enter required algorithm name either 'Dijkstra' or 'Bellman-Ford'");
            String algorithmName = s.next();
            if (algorithmName.equalsIgnoreCase("Dijkstra")) {
                String output = getDijkstraOutput(graph);
                PrintWriter writer = new PrintWriter(fileName + "_output.txt", "UTF-8");
                writer.print(output);
                writer.close();
                break;
            } else if (algorithmName.equalsIgnoreCase("Bellman-Ford")) {
                String output = getBellmanOutput(graph);
                PrintWriter writer = new PrintWriter(System.getProperty("user.dir")
                        + File.separator + fileName + "_output.txt", "UTF-8");
                writer.print(output);
                writer.close();
                break;
            } else {
                System.out.println("Invalid Algorithm Name");
            }
        }
        s.close();
    }

    private static String getBellmanOutput(IGraph graph) {
        StringBuilder builder = new StringBuilder();
        int[] distances = new int[graph.size()];
        builder.append(graph.runBellmanFord(0, distances)).append('\n');
        for(int i = 0; i < distances.length; i++) {
            builder.append(distances[i]).append(" ");
        }
        return builder.toString();
    }

    private static String getDijkstraOutput(IGraph graph) {
        StringBuilder builder = new StringBuilder();
        int[] distances = new int[graph.size()];
        graph.runDijkstra(0, distances);
        for(int i = 0; i < distances.length; i++) {
            builder.append(distances[i]).append(" ");
        }
        builder.append('\n');
        List<Integer> prev = graph.getDijkstraProcessedOrder();
        for(int i = 0; i < prev.size(); i++) {
            builder.append(prev.get(i)).append(" ");
        }
        return builder.toString();
    }

}
