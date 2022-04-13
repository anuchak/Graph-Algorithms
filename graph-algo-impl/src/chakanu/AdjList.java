package chakanu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjList {
    private static final Map<String, List<String>> adjList = new HashMap<>();

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

}
