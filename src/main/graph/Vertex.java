package main.graph;

import main.dictionary.Word;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertex {
    private Word word;
    private boolean visited;
    private Set<Vertex> neighbours;
    private int distance;
    private Vertex parent;

    public Vertex(Word word) {
        this.word = word;
        this.visited = false;
        this.neighbours = new HashSet<>();
    }

    public void addNeighbour(Vertex v) {
        this.neighbours.add(v);
    }

    @Override
    public String toString() {
        return this.getWord().getContent();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Vertex)) return false;
        return this.getWord().equals(((Vertex) other).getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.word);
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Set<Vertex> getNeighbours() {
        return neighbours;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }
}
