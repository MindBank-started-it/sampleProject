package sampleProject;

import java.util.LinkedList;

public class Dag {
	private Vertex vertexStart;
	private LinkedList<Edge> dag;
	
	public Dag() {
		
	}
	
	public Dag(Vertex vertexStart, LinkedList<Edge> dag) {
		this.vertexStart = vertexStart;
		this.dag = dag;
	}
	
	
	public Vertex getVertexStart() {
		return vertexStart;
	}
	public void setVertexStart(Vertex vertexStart) {
		this.vertexStart = vertexStart;
	}
	public LinkedList<Edge> getDag() {
		return dag;
	}
	public void setDag(LinkedList<Edge> dag) {
		this.dag = dag;
	}
}
