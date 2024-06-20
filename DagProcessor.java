package sampleProject;

import java.util.LinkedList;

public class DagProcessor {
	
	private Vertex vertexStart = new Vertex();
	private LinkedList<Edge> dag = new LinkedList<>();
	private Vertex vertexFrom = new Vertex();
	
	//No argument constructor
	public DagProcessor() {		
	}
	
	//Constructor
	public DagProcessor(Dag dag) {
		this.vertexStart = dag.getVertexStart();
		this.dag = dag.getDag();	
	}
	
	//To verified if it is a DAG
	public boolean verifyDag() {
		String verifyDagMethod = "VerifyDag(): ";
		
		System.out.println("\n" + verifyDagMethod + "Start... ");
		boolean verified = false;
		vertexFrom.setId(vertexStart.getId());
		
		for (int i = 0; i < dag.size(); i++) {			
			Edge edge = (Edge) dag.get(i);			
			//System.out.println(verifyDagMethod + "Loop#" + i + "- vertexStart.getId: " + vertexStart.getId() + "; vertexFrom: " + vertexFrom.getId() + "; Edge.getFrom: " + edge.getFrom().getId()+ "; Edge.getTo: " + edge.getTo().getId() + "; ");
			
			if (vertexFrom.getId() == (edge.getFrom().getId())) {
				vertexFrom.setId(edge.getTo().getId());		
				verified = true;
			} else if (vertexFrom.getId() != (edge.getFrom().getId())) {
				System.out.println(verifyDagMethod + "This is NOT a proper DAG. ");
				System.out.println(verifyDagMethod + "Edge VertexTo '" + edge.getTo().getId() + "' does not match next Edge VertexFrom '" + edge.getFrom().getId() + "'. ");
				verified = false;
				break;
			}
		}
		if (verified)	System.out.println(verifyDagMethod + "This is a proper DAG. ");
		return verified; 
	}
	
	//To check length of DAG
	public int getLongestDirectedPath() {
		
		String getLongestDirectedPath = "getLongestDirectedPath(): ";
		int longestDirectedPath = 0;
		vertexFrom.setId(vertexStart.getId());
		
		System.out.println("\n" + getLongestDirectedPath + "Start... ");
		
		for (int i = 0; i < dag.size(); i++) {
			Edge edge = (Edge) dag.get(i);
			//System.out.println(getLongestDirectedPath + "Loop#" + i + "- vertexStart.getId: " + vertexStart.getId() + "; vertexFrom: " + vertexFrom.getId() + "; Edge.getFrom: " + edge.getFrom().getId()+ "; Edge.getTo: " + edge.getTo().getId() + "; ");
			
			if (vertexFrom.getId() == (edge.getFrom().getId())) {
				vertexFrom.setId(edge.getTo().getId());
				longestDirectedPath++;
			}			
		}		
		System.out.println("Longest Directed Path: " + longestDirectedPath);
		return longestDirectedPath;
	}
}


