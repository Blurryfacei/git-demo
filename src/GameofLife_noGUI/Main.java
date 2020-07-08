package GameofLife_noGUI;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Chessboard test=new Chessboard();
		test.Init();
		System.out.println("输入1继续,0退出");
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		while(n!=0) {
			if(n==1) test.getNext();
			n=scan.nextInt();
		}
	}

}