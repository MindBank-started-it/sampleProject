package sampleProject;


import java.util.LinkedList;

public class MyMainClass {

	public static void main(String[] args) {
		
		String mainClass = "MyMainClass: ";
		
		//CREATING DAG#1 - PROPER DAG:
		Vertex vertex1From = new Vertex();		
		vertex1From.setId(1);	
		
		Vertex vertex1To = new Vertex();
		vertex1To.setId(2);
		
		Edge edge1 = new Edge();		
		edge1.setFrom(vertex1From);
		edge1.setTo(vertex1To);
		
		Vertex vertex2From = new Vertex();
		vertex2From.setId(2);	
		Vertex vertex2To = new Vertex();
		vertex2To.setId(3);
		
		Edge edge2 = new Edge();
		edge2.setFrom(vertex2From);
		edge2.setTo(vertex2To);
		
		Vertex vertex3From = new Vertex();
		vertex3From.setId(3);	
		
		Vertex vertex3To = new Vertex();
		vertex3To.setId(4);
		
		Edge edge3 = new Edge();				
		edge3.setFrom(vertex3From);
		edge3.setTo(vertex3To);
		
		LinkedList<Edge> edgesA = new LinkedList<Edge>();
		edgesA.add(edge1);								//CHANGE HERE TO CHANGE DAG LENGTH.
		edgesA.add(edge2);
		edgesA.add(edge3);
		
		Vertex vertexStart1 = new Vertex();
		vertexStart1.setId(vertex1From.getId());		//CHANGE HERE TO CHANGE DAG LENGTH.
		
		Dag dag1 = new Dag(vertexStart1, edgesA);
				
		DagProcessor dagProcessor1 = new DagProcessor(dag1);		
		
		if (dagProcessor1.verifyDag()) {
			int dagLength = dagProcessor1.getLongestDirectedPath();
			System.out.println("\n"+ mainClass + " DAG Length: " + dagLength);
		} else {
			System.out.println("\n"+ mainClass + " It is not a proper DAG");
		}				
		
		//CREATING DAG#2 - BAD DAG:
		Vertex vertex5From = new Vertex();		
		vertex5From.setId(5);	
		
		Vertex vertex5To = new Vertex();
		vertex5To.setId(6);
		
		Edge edge5 = new Edge();		
		edge5.setFrom(vertex5From);
		edge5.setTo(vertex5To);
		
		Vertex vertex6From = new Vertex();
		vertex6From.setId(6);	
		Vertex vertex6To = new Vertex();
		vertex6To.setId(8);			//8 INSTEAD OF 7
		
		Edge edge6 = new Edge();
		edge6.setFrom(vertex6From);
		edge6.setTo(vertex6To);
		
		Vertex vertex7From = new Vertex();
		vertex7From.setId(7);	
		
		Vertex vertex7To = new Vertex();
		vertex7To.setId(8);
		
		Edge edge7 = new Edge();				
		edge7.setFrom(vertex7From);
		edge7.setTo(vertex7To);
		
		LinkedList<Edge> edgesB = new LinkedList<Edge>();
		edgesB.add(edge5);
		edgesB.add(edge6);
		edgesB.add(edge7);
		
		Vertex vertexStart2 = new Vertex();
		vertexStart2.setId(vertex5From.getId());
		
		Dag dag2 = new Dag(vertexStart2, edgesB);
				
		DagProcessor dagProcessor2 = new DagProcessor(dag2);		
		
		if (dagProcessor2.verifyDag()) {
			int dagLength2 = dagProcessor2.getLongestDirectedPath();
			System.out.println("\n"+ mainClass + " Longest Directed Path Length: " + dagLength2);
		} else {
			System.out.println("\n"+ mainClass + " It is not a proper DAG. ");
		}	
	}
}

/*
QUESTIONS to be answered WITH the CODING EXERCISE: 

Does the solution work for larger graphs? 
	Yes.
	i) This solution works with any proper DAG.
	ii) This solution also works with any proper DAG where you can specify any starting point Vertex.

Can you think of any optimizations? 
	I can create another method within DagProcessor class that can be called to create a new DAG anytime based on passing just a list of vertices and starting vertex.
	
What’s the computational complexity of your solution? 
	The longest directed path must be a continuous uninterrupted, directed, acyclic path start from a specified starting vertex. 
	For this reason, I've created a method to explicitly check that these criteria are met, else the program stops and points out the error in the DAG.
	
Are there any unusual cases that aren't handled? 
	Do DAGs ever fork/split and go in 2 or more directions - intentionally or in error? If yes, this is not yet handled by my codes. 
 */
