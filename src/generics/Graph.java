package generics;

import java.util.ArrayList;

public class Graph<T> {
	
	//Attributes
	private ArrayList<Node<T>> nodesList;
	private ArrayList<Edge<T>> edgesList;

	
	public Graph() {
		//To initialize the arraylist of vertex
		nodesList = new ArrayList<Node<T>>();
		
		//To initialize the arraylist of vertex
		edgesList = new ArrayList<Edge<T>>();
		
	}
	
	
	public void insertANode(T element) {
		Node<T> node = new Node<T>(element);
		nodesList.add(node);
	}
	
	public int get4() {
		return 4;
	}
	
	public Node<T> searchANode(T element) {
		
		Node<T> out = null;
		
		boolean stop = false;
		
		for(int i = 0;i<nodesList.size() && !stop;i++) {
			if(element.equals(nodesList.get(i).getElement())) {
				stop = true;
				out = nodesList.get(i);
			}
		}
		
		return out;
	}
	
	
	public boolean insertAEdge(int weight,T element_1, T element_2) {
		
		
		boolean out = false;
		
		Node<T> temp_1 =  searchANode(element_1);
		
		Node<T> temp_2 =  searchANode(element_2);
	
		if(temp_1 == null && temp_2 == null) {
			out = false;;
		}
		else if(temp_1 == temp_2) {
			
			Edge<T> edge = new Edge<T>(weight,temp_1,temp_2);
			
			edgesList.add(edge);
			
			temp_1.insertAEdge(edge);
			
			out = true;
			
		}
		else {
			
			
			Edge<T> edge = new Edge<T>(weight,temp_1,temp_2);
			
			temp_1.insertAEdge(edge);
			temp_2.insertAEdge(edge);
			
			edgesList.add(edge);
			
			out = true;
			
		}
		
		return out;
		
		
	}
	
	
	
	public boolean deleteANode(T element) {
		boolean out = false;
		
		Node<T> node = searchANode(element);
		
		if(node != null) {
			 removeANodeFromList(node);
			 node.delete();
			 out = true;		
		}
		
		return out;
	}
	
	
	private void removeANodeFromList(Node<T> n) {
		nodesList.remove(n);
	}
	
	public String showNodes() {
		String out = "[";
		System.out.println("G: "+nodesList.size());
		for(int i = 0; i<nodesList.size();i++) {
			if(i != nodesList.size()-1) {
				out += nodesList.get(i).toString()+",";
			}
			else {
				out += nodesList.get(i).toString()+"]";
			}
		}
		
		return out;
	}
	
	public String showEdges() {
		String out = "";
		
		for(int i = 0;i<edgesList.size();i++) {
			out += edgesList.get(i).toString()+"\n";
		}
		
		return out;
	}

	


}
