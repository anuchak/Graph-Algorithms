package chakanu;

import java.util.*;
import java.util.logging.Logger;

public class ConnectedComponents {
    public static final Logger LOGGER = Logger.getLogger(ConnectedComponents.class.getName());

    public static void main(String[] args) {
        new ConnectedComponents().dfsImpl(AdjList.getAdjListUndirectedGraph());
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
