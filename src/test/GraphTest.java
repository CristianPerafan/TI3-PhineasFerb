package test;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import generics.Graph;
import generics.Node;

public class GraphTest {
	
	private Graph<Integer> g; 

	
	
	public void setUpStage1() {
		g = new Graph<Integer>();
	
		g.insertANode(1);
		
		
	}
	
	public void setUpStage2() {
		g = new Graph<Integer>();
		
		for(int i = 0;i<1000;i++) {
			g.insertANode(i+1);
		}
	}
	
	@Test
	public void testSearchANode() {
		setUpStage1();
		
		assertSame(1,g.searchANode(1).getElement());
		
		
	}
	
	@Test
	public void testInsertANode() {
		
		setUpStage1();
		
		
		Node<Integer> expected = new Node<Integer>(1);
		
		assertSame(expected.getElement(),g.searchANode(1).getElement());
	}
	
	@Test
	public void testDeleteANode() {
		
		setUpStage2();
		
		g.deleteANode(5);
		
		assertNull(g.searchANode(5));
	}
	
	@Test
	public void testInsertAEdge() {
		
		setUpStage2();

		g.insertANode(5);
		g.insertANode(6);
		g.insertANode(7);
		g.insertANode(8);
		g.insertANode(9);
		
		
		assertTrue(g.insertAEdge(20,5,500));
		
		
	}
}
