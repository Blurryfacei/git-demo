package GameofLife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game_GUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_GUI frame = new Game_GUI(2,2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game_GUI(int l,int w) {
		setTitle("\u751F\u547D\u6E38\u620F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 10*l, 10*w+20);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(l,w));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Chessboard_GUI test=new Chessboard_GUI(l,w);//根据长宽创建数组
		test.Init();
		
		int Cell[][]=test.getCell();//取得初始化后的数组
		JButton[][] buttonArr=new JButton[l][w];//根据数组设置界面
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				buttonArr[i][j]=new JButton();
				panel.add(buttonArr[i][j]);
				if(Cell[i][j]==1) {
					buttonArr[i][j].setBackground(Color.GREEN);//活细胞设置绿色
					buttonArr[i][j].setOpaque(true); //foreground设置透明
				}else {
					buttonArr[i][j].setBackground(Color.WHITE);//死细胞设置白色
					buttonArr[i][j].setOpaque(false); //foreground设置透明
				}
			}
		}
		
		JButton nextButton=new JButton("下一个");//下一个按钮
		panel_1.add(nextButton, BorderLayout.CENTER);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				test.getNext();//产生下一个的数组
				int Cell[][]=test.getCell();//取得下一个的数组
				for(int i=0;i<l;i++) {
					for(int j=0;j<w;j++) {
						if(Cell[i][j]==1) {
							buttonArr[i][j].setBackground(Color.GREEN);//活细胞设置绿色
							buttonArr[i][j].setOpaque(true); //foreground设置透明
						}else {
							buttonArr[i][j].setBackground(Color.WHITE);//死细胞设置白色
							buttonArr[i][j].setOpaque(false); //foreground设置透明
						}
					}
				}
			}
		});
	}
}
