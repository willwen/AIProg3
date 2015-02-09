import static org.junit.Assert.*;

import org.junit.Test;


public class testFeatures {

	@Test
	public void testFirstMove() {

	}

	@Test
	public void testCountTopMost() {
		Features f = new Features();
		f.board = new Integer[] [] {
				{2, 1 , 1 , 1 , 2 ,2 , 1},
				{1 ,0 ,0 ,0 ,0 ,0,0},
				{2 ,2 ,0 ,0 ,0 ,0,0},
				{1 ,0 ,0 ,0 ,0 ,0,0},
				{0 ,0 ,2 ,0 ,0 ,0,0},
				{1 , 2 ,1  ,0 ,0 ,0,0},
		};
		
		assertEquals(f.countTopMost(), 1);
		//6 , 7
	}
	@Test
	public void testAdjacentMoreThanThree(){
		Features f = new Features();
		f.board = new Integer[] [] {
				{2, 1 , 1 , 1 , 2 ,2 , 1},
				{1 ,0 ,0 ,0 ,0 ,0,0},
				{2 ,2 ,0 ,0 ,0 ,0,0},
				{1 ,0 ,0 ,0 ,0 ,0,0},
				{0 ,0 ,2 ,0 ,0 ,0,0},
				{1 , 2 ,1  ,0 ,0 ,0,0},
		};
		assertEquals(f.adjacentMoreThanThree() , 0);
	}
	
	@Test
	public void testAdjacentMoreThanThree2(){
		Features f = new Features();
		f.board = new Integer[] [] {
				{2, 1 , 1 , 1 , 2 ,2 , 1},
				{1 ,1 , 1 , 0 , 0 ,0 ,0},
				{2 ,2 ,0 ,0 ,0 ,0,0},
				{1 ,0 ,0 ,0 ,0 ,0,0},
				{0 ,0 ,2 ,0 ,0 ,0,0},
				{1 , 2 ,1  ,0 ,0 ,0,0},
		};
		assertEquals(f.adjacentMoreThanThree() , 1);
	}

	@Test
	public void testAdjacentMoreThanThree3(){
		Features f = new Features();
		f.board = new Integer[] [] {
				{2, 1 , 1 , 1 , 2 ,2 , 1},
				{1 ,1 , 1 ,0 ,0 ,0,0},
				{2 ,2 , 1 ,0 ,0 ,0,0},
				{1 ,0 ,0 ,2 ,0 ,0,0},
				{2 ,2  ,2 ,2 ,0 ,0,0},
				{1 , 2 ,1  ,2  ,0 ,0,0},
		};
		assertEquals(f.adjacentMoreThanThree() , 0);
	}
}
