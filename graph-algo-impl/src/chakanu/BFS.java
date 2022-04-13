package chakanu;

import java.util.*;
import java.util.logging.Logger;

public class BFS {
    public static final Logger LOGGER = Logger.getLogger(BFS.class.getName());

    public static void main(String[] args) {
        // the graph is actually disconnected, so only a sub graph is being traversed
        // not adding the iterative approach that goes through whole graph again
        new BFS().bfsImpl(AdjList.getAdjListUndirectedGraph());
    }

    private void bfsImpl(Map<String, List<String>> adjList) {
        LinkedList <String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("1");

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if(!visited.contains(node)) {
                LOGGER.info(node + " -> ");
                visited.add(node);
                List<String> vals = adjList.get(node);
                queue.addAll(vals);
            }

        }

    }

}
