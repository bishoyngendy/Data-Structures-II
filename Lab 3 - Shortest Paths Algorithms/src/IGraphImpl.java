package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 3 : Shortest Paths Algorithms
 * Created by Bishoy N. Gendy (programajor) on Saturday 06/05/2017.
 */
public class IGraphImpl implements IGraph {

    private int numberOfNodes;
    private int numberOfEdges;

    private List<List<Edge>> adjList;
    private ArrayList<Integer> prev;

    public IGraphImpl() {
        this.numberOfNodes = 0;
        this.numberOfEdges = 0;
        initializeGraph(0);
    }

    @Override
    public void readGraph(File file) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        InputReader reader = new InputReader(inputStream);
        numberOfNodes = reader.nextInt();
        numberOfEdges = reader.nextInt();
        initializeGraph(numberOfNodes);
        for (int i = 0; i < numberOfEdges; i++) {
            Edge edge = new Edge();
            edge.setSource(reader.nextInt());
            edge.setDestination(reader.nextInt());
            edge.setWeight(reader.nextInt());
            adjList.get(edge.getSource()).add(edge);
        }
    }

    private void initializeGraph(int numberOfNodes) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            List<Edge> edges = new ArrayList<>();
            adjList.add(edges);
        }
        prev = new ArrayList<>();
    }

    @Override
    public int size() {
        return numberOfNodes;
    }

    @Override
    public ArrayList<Integer> getVertices() {
        ArrayList<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public ArrayList<Integer> getNeighbors(int v) {
        ArrayList<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < adjList.get(v).size(); i++) {
            neighbours.add(adjList.get(v).get(i).getDestination());
        }
        return neighbours;
    }

    @Override
    public void runDijkstra(int src, int[] distances) {
        for(int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i = 0; i < numberOfNodes; i++) {
            queue.add(new Edge(-1, i, Integer.MAX_VALUE));
        }
        queue.remove(new Edge(-1, src, Integer.MAX_VALUE));
        queue.add(new Edge(-1, src, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int u = edge.getDestination();
            prev.add(u);

            for (int i = 0; i < adjList.get(u).size(); i++) {
                int v = adjList.get(u).get(i).getDestination();
                int w = adjList.get(u).get(i).getWeight();
                if(u != v && (long) distances[v] > (long) distances[u] + w) {
                    distances[v] = distances[u] + w;
                    queue.remove(new Edge(-1, v, Integer.MAX_VALUE));
                    queue.add(new Edge(-1, v, distances[v]));
                }
            }
        }

    }

    @Override
    public ArrayList<Integer> getDijkstraProcessedOrder() {
        return prev;
    }

    @Override
    public boolean runBellmanFord(int src, int[] distances) {
        for(int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;

        for(int i = 0; i < (distances.length-1); i++) {
            for(int j = 0; j < adjList.size(); j++) {
                List<Edge> edges = adjList.get(j);
                for(Edge edge : edges) {
                    if ((long) distances[edge.getSource()] + edge.getWeight() < (long)distances[edge.getDestination()]) {
                        distances[edge.getDestination()] = distances[edge.getSource()] + edge.getWeight();
                    }
                }
            }

        }

        for(int j = 0; j < adjList.size(); j++) {
            List<Edge> edges = adjList.get(j);
            for(Edge edge : edges) {
                if ((long) distances[edge.getSource()] + edge.getWeight() < (long) distances[edge.getDestination()]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * class to represent the directed edges of the graph.
     */
    class Edge implements Comparator<Edge>, Comparable<Edge> {

        /**
         * The source node of the edge.
         */
        private int source;

        /**
         * The destination node of the edge.
         */
        private int destination;

        /**
         * The weight of the edge.
         */
        private int weight;

        /**
         *
         * @param source the source node of the edge.
         * @param destination the destination node of the edge.
         * @param weight the weight of the edge.
         */
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Edge() {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            return getDestination() == edge.getDestination();
        }

        @Override
        public int hashCode() {
            return getDestination();
        }

        /**
         * Getter for property 'source'.
         * @return Value for property 'source'.
         */
        public int getSource() {
            return source;
        }

        /**
         * Setter for property 'source'.
         * @param source Value to set for property 'source'.
         */
        public void setSource(int source) {
            this.source = source;
        }

        /**
         * Getter for property 'destination'.
         * @return Value for property 'destination'.
         */
        public int getDestination() {
            return destination;
        }

        /**
         * Setter for property 'destination'.
         * @param destination Value to set for property 'destination'.
         */
        public void setDestination(int destination) {
            this.destination = destination;
        }

        /**
         * Getter for property 'weight'.
         * @return Value for property 'weight'.
         */
        public int getWeight() {
            return weight;
        }

        /**
         * Setter for property 'weight'.
         * @param weight Value to set for property 'weight'.
         */
        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.getWeight() - e.getWeight();
        }

        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.getWeight() - e2.getWeight();
        }

        @Override
        public Comparator<Edge> reversed() {
            return null;
        }

        @Override
        public Comparator<Edge> thenComparing(Comparator<? super Edge> other) {
            return null;
        }

        @Override
        public <U> Comparator<Edge> thenComparing(Function<? super Edge, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
            return null;
        }

        @Override
        public <U extends Comparable<? super U>> Comparator<Edge> thenComparing(Function<? super Edge, ? extends U> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<Edge> thenComparingInt(ToIntFunction<? super Edge> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<Edge> thenComparingLong(ToLongFunction<? super Edge> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<Edge> thenComparingDouble(ToDoubleFunction<? super Edge> keyExtractor) {
            return null;
        }
    }

}
