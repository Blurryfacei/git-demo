package GameofLife_noGUI;

import java.util.Scanner;

public class Chessboard {
	public int l,w;
	public int Cell[][];
	public void Init() {//初始化格子
		System.out.println("请输入格子的长宽：");
		Scanner scan = new Scanner(System.in);
		l=scan.nextInt();
		w=scan.nextInt();
		Cell=new int[l][w];
	//随机各个格子中细胞的状态，1代表生，0代表死
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				if (Math.random()>0.2)
					Cell[i][j]=1;
				else
					Cell[i][j]=0;
			}
		}
		PrintOut();
	}
	public void getNext() {//获取下一时刻的状态
		int Cell1[][]=new int[l][w];//创建Cell的副本
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				if(Cell[i][j]==1) {
					if(getNeighbors(i,j)==2||getNeighbors(i,j)==3) Cell1[i][j]=1;
					else Cell1[i][j]=0;
				}else {
					if(getNeighbors(i,j)==3) Cell1[i][j]=1;
					else Cell1[i][j]=0;
				}
			}
		}
		Cell=Cell1;
		PrintOut();
	}
	public int getNeighbors(int i,int j) {//获得Cell[i][j]周围存活细胞总数
        int n=0;
        n+=cellState(i-1,j-1);
        n+=cellState(i-1,j);
        n+=cellState(i-1,j+1);
        n+=cellState(i,j-1);
        n+=cellState(i,j+1);
        n+=cellState(i+1,j-1);
        n+=cellState(i+1,j);
        n+=cellState(i+1,j+1);
        return n;
	}
	public int cellState(int i,int j) {//获取Cell[i][j]细胞状态
        boolean State=!(i<0||i>=l||j<0||j>=w||Cell[i][j]==0);
        return State?1:0;
    }
	public void PrintOut() {//打印所有格子
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				System.out.print(Cell[i][j]);
			}
			System.out.println();
		}
	}
}
