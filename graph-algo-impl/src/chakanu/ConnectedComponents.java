package chakanu;

import java.util.*;
import java.util.logging.Logger;

public class ConnectedComponents {
    public static final Logger LOGGER = Logger.getLogger(ConnectedComponents.class.getName());

    public static void main(String[] args) {
        Map<String, List<String>> adjList = new HashMap<>();
        adjList.put("0", Arrays.asList("4", "8", "13", "14"));
        adjList.put("1", Arrays.asList("5"));
        adjList.put("2", Arrays.asList("9", "15"));
        adjList.put("3", Arrays.asList("9"));
        adjList.put("4", Arrays.asList("0", "8"));
        adjList.put("5", Arrays.asList("1", "16", "17"));
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
        new ConnectedComponents().dfsImpl(adjList);
    }

    private void dfsImpl(Map<String, List<String>> inputGraph) {
        Set<String> listOfTraversedNodes = new HashSet<>();
        int totalConnComps = 0;

        for(Map.Entry<String, List<String>> listEntry : inputGraph.entrySet()) {
            if(!listOfTraversedNodes.contains(listEntry.getKey())) {
                LOGGER.info(listEntry.getKey() + " -> ");
                totalConnComps++;
                listOfTraversedNodes.add(listEntry.getKey());
                if(Objects.nonNull(listEntry.getValue()))
                    listEntry.getValue().forEach(val -> iterateDfs(inputGraph, listOfTraversedNodes, val));
            }
        }

        LOGGER.info("Total no. of connected components is: " + totalConnComps);
    }

    private void iterateDfs(Map<String, List<String>> inputGraph, Set <String> listOfTraversedNodes, String node) {
        if(listOfTraversedNodes.contains(node)) {
            return;
        }

        LOGGER.info(node + " -> ");
        listOfTraversedNodes.add(node);

        if(Objects.nonNull(inputGraph.get(node)))
            inputGraph.get(node).forEach(val -> iterateDfs(inputGraph, listOfTraversedNodes, val));
    }

}
