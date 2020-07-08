package GameofLife;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Chessboard_GUITest {
	private static Chessboard_GUI Test=new Chessboard_GUI(100,100);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_Init() {
		this.Test.Init();
		int Cell[][];
		Cell=Test.getCell();
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				assertEquals(0.5,Cell[i][j],0.5);
			}
		}
	}
	@Test
	public void test_cellState() {
		int Cell[][];
		Cell=Test.getCell();
		for(int i=-10;i<150;i++) {
			for(int j=-10;j<150;j++) {
				if(i<0||j<0||i>=100||j>=100) assertEquals(0,this.Test.cellState(i,j));
				else assertEquals(Cell[i][j],this.Test.cellState(i,j));
			}
		}
	}
	@Test
	public void test_getNeighbors() {
		int Cell[][];
		Cell=Test.getCell();
		for(int i=1;i<99;i++) {
			for(int j=1;j<99;j++) {
				int n=Cell[i-1][j-1]+Cell[i-1][j]+Cell[i-1][j+1]+Cell[i][j-1]+Cell[i][j+1]+Cell[i+1][j-1]+Cell[i+1][j]+Cell[i+1][j+1];
				assertEquals(n,this.Test.getNeighbors(i, j));
			}
		}
	}
	@Test
	public void tset_getNext() {
		int Cell[][]=new int[100][100];
		int nextCell[][];
		nextCell=Test.getCell();
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				Cell[i][j]=nextCell[i][j];
			}
		}
		int Neighbors[][]=new int[100][100];
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				Neighbors[i][j]=this.Test.getNeighbors(i, j);
			}
		}
		this.Test.getNext();
		nextCell=Test.getCell();
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(Cell[i][j]==1) {
					if(Neighbors[i][j]==2||Neighbors[i][j]==3) assertEquals(1,nextCell[i][j]);
					else assertEquals(0,nextCell[i][j]);
				}else {
					if(Neighbors[i][j]==3) assertEquals(1,nextCell[i][j]);
					else assertEquals(0,nextCell[i][j]);
				}
			}
		}
	}
}
