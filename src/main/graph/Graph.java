package main.graph;

import main.dictionary.Word;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private List<Vertex> vertices;

    public Graph(Set<Word> words) {
        initGraph(words);
    }

    private void initGraph(Set<Word> words) {
        vertices = words.parallelStream().map(word -> new Vertex(word)).collect(Collectors.toList());
        setNeighbours();
    }

    private void setNeighbours() {

        vertices.parallelStream()
                .forEach(v1 -> vertices.parallelStream()
                        .forEach(v2 -> {
                            if (v1.getWord().isNeighbourTo(v2.getWord()))
                                v1.addNeighbour(v2);
                        }));
    }

    public Optional<List<Vertex>> bfs(Vertex start, Vertex end) {

        List<Vertex> resultChain = new LinkedList<>();
        Queue<Vertex> queue = new LinkedList();

        for (Vertex v : vertices) {
            v.setVisited(false);
            v.setParent(null);
            v.setDistance(Integer.MAX_VALUE);
        }

        start.setVisited(true);
        start.setDistance(0);
        start.setParent(null);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Vertex next : current.getNeighbours()) {
                if (!next.isVisited()) {
                    next.setVisited(true);
                    next.setDistance(current.getDistance() + 1);
                    next.setParent(current);
                    queue.add(next);
                    if (next.equals(end)) {
                        Vertex chainElement = next;
                        while (chainElement != start) {
                            resultChain.add(chainElement);
                            chainElement = chainElement.getParent();
                        }
                        resultChain.add(start);
                        Collections.reverse(resultChain);
                        return Optional.of(resultChain);
                    }
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Vertex> vertexForString(String str) {
        return vertices.parallelStream().filter(vertex -> vertex.getWord().getContent().equals(str)).findAny();
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
}
