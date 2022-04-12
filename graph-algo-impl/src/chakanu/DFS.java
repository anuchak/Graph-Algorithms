package chakanu;

import java.util.*;
import java.util.logging.Logger;

class DFS {
    public static final Logger LOGGER = Logger.getLogger(DFS.class.getName());

    public static void main(String[] args) {
        Map<String, List<String>> inputGraph = new HashMap<>();
        inputGraph.put("A", Arrays.asList("B", "C", "H"));
        inputGraph.put("B", Arrays.asList("A", "C", "G"));
        inputGraph.put("C", Arrays.asList("A", "D", "G", "H"));
        inputGraph.put("D", Arrays.asList("C", "G"));
        inputGraph.put("G", Arrays.asList("C", "B"));
        inputGraph.put("H", Arrays.asList("A", "C"));
        new DFS().dfsImpl(inputGraph);
    }

    private void dfsImpl(Map<String, List<String>> inputGraph) {
        Set <String> listOfTraversedNodes = new HashSet<>();

        for(Map.Entry<String, List<String>> listEntry : inputGraph.entrySet()) {
            if(!listOfTraversedNodes.contains(listEntry.getKey())) {
                LOGGER.info(listEntry.getKey() + " -> ");
                listOfTraversedNodes.add(listEntry.getKey());
                listEntry.getValue().forEach(val -> iterateDfs(inputGraph, listOfTraversedNodes, val));
                LOGGER.info("Finished traversing neighbours of " + listEntry.getKey());
            }
        }

    }

    private void iterateDfs(Map<String, List<String>> inputGraph, Set <String> listOfTraversedNodes, String node) {
        if(listOfTraversedNodes.contains(node)) {
            LOGGER.info(node + " already traversed");
            return;
        }

        LOGGER.info(node + " -> ");
        listOfTraversedNodes.add(node);
        inputGraph.get(node).forEach(val -> iterateDfs(inputGraph, listOfTraversedNodes, val));
        LOGGER.info("Finished traversing neighbours of " + node);
    }

}