package chakanu;

import javafx.util.Pair;
import java.util.*;

public class DijkstraSSSP {

    public static void main(String[] args) {
        Map<String, List<Pair<String, Integer>>> adjList = AdjList.getDirectedGraphAdjList();
        int[] distanceStore = new int[adjList.size()];
        int startingNode = 0;
        distanceStore[startingNode] = 0;
        for(int i = 0; i < distanceStore.length; i++) {
            if (i != startingNode) {
                distanceStore[i] = Integer.MAX_VALUE;
            }
        }
        DijkstraSSSP sssp = new DijkstraSSSP();
        sssp.runSSSP(distanceStore, adjList, startingNode);
        Arrays.stream(distanceStore).sequential().forEach(System.out::println);
    }

    private void runSSSP(int[] distanceStore, final Map<String, List<Pair<String, Integer>>> adjList, final int startingNode) {
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            Integer key1 = Integer.parseInt(o1.getKey());
            Integer key2 = Integer.parseInt(o2.getKey());
            return o1.getValue().equals(o2.getValue())
                    ? key1.compareTo(key2)
                    : ((o1.getValue() < o2.getValue()) ? -1 : 1);
        });

        pq.add(new Pair<>(String.valueOf(startingNode), 0));
        while(pq.size() > 0) {
            Pair<String, Integer> top = pq.poll();
            int value = top.getValue();
            List<Pair<String, Integer>> list = adjList.get(top.getKey());
            if(Objects.isNull(list))
                break;
            for(Pair<String, Integer> entry : list) {
                int temp = value + entry.getValue();
                if(temp < distanceStore[Integer.parseInt(entry.getKey())]) {
                    distanceStore[Integer.parseInt(entry.getKey())] = temp;
                    pq.add(new Pair<>(entry.getKey(), temp));
                }
            }
        }
    }

}
