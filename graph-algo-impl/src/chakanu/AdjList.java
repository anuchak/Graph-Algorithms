package chakanu;

import javafx.util.Pair;
import java.util.*;

public class AdjList {
    private static final Map<String, List<String>> adjList = new HashMap<>();
    private static final Map<String, List <Pair<String, Integer>>> directedAdjList = new HashMap<>();

    public static Map<String, List<String>> getAdjListUndirectedGraph() {
        adjList.put("0", Arrays.asList("4", "8", "13", "14"));
        adjList.put("1", Arrays.asList("5"));
        adjList.put("2", Arrays.asList("9", "15"));
        adjList.put("3", Arrays.asList("9"));
        adjList.put("4", Arrays.asList("0", "8"));
        adjList.put("5", Arrays.asList("1", "16"));
        adjList.put("6", Arrays.asList("7", "11"));
        adjList.put("7", Arrays.asList("6", "11"));
        adjList.put("8", Arrays.asList("0", "4", "14"));
        adjList.put("9", Arrays.asList("2", "3", "15"));
        adjList.put("10", Arrays.asList("15"));
        adjList.put("11", Arrays.asList("6", "7"));
        adjList.put("12", null);
        adjList.put("13", Arrays.asList("0", "14"));
        adjList.put("14", Arrays.asList("0", "8", "13"));
        adjList.put("15", Arrays.asList("2", "9", "10"));
        adjList.put("16", Arrays.asList("5"));
        return adjList;
    }

    public static Map<String, List <Pair<String, Integer>>> getDirectedGraphAdjList() {
        List <Pair<String, Integer>> zerolist = Collections.singletonList(new Pair<>("1", 2));
        List <Pair<String, Integer>> onelist = Arrays.asList(new Pair<>("2", 1), new Pair<>("3", 1));
        List <Pair<String, Integer>> twolist = Arrays.asList(new Pair<>("0", 1), new Pair<>("3", 3));
        List <Pair<String, Integer>> threelist = Collections.singletonList(new Pair<>("4", 2));
        directedAdjList.put("0", zerolist);
        directedAdjList.put("1", onelist);
        directedAdjList.put("2", twolist);
        directedAdjList.put("3", threelist);
        directedAdjList.put("4", null);
        return directedAdjList;
    }

}
