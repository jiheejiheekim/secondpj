package JHProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DropMode;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EmptyBorder;

public class Cafedrink extends JFrame{
	
	JFrame f=new JFrame();
	
	private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8;

	int tf1=0;
	int tf2=0;
	int tf3=0;
	int tf4=0;
	int tf5=0;
	int tf6=0;
	int tf7=0;
	int tf8=0;


	private JTextField textField11, textField12, textField13, textField14;
	
	int tf11=0;
	int tf12=0;
	int tf13=0;
	int tf14=0;
	
	int num;

	
	private JTextArea tfalltotal;
	
	int alltotal=0;		//합계 초기화
	
	private JButton btnNewButton;
	
	JPanel toppn, bottompn, drinkpn, dessertpn, paypn;

	String[] heading =new String[] {"메뉴", "수량", "금액"};		//1열
	
	DefaultTableModel model=new DefaultTableModel(heading,0);	//열은 header, 행은 0 
	JTable table = new JTable(model);
	
	public Cafedrink() {
		super("Cafe Order");
		getContentPane().setLayout(null);
		
		dessertpn = new JPanel();
		dessertpn.setVisible(false);
		
		
		paypn = new JPanel();
		paypn.setVisible(false);
		paypn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		paypn.setBackground(new Color(255, 255, 255));
		paypn.setBounds(0, 83, 686, 537);
		getContentPane().add(paypn);
		paypn.setLayout(null);
		
		btnNewButton = new JButton("현금");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(alltotal>0) {
					try {
						int select=JOptionPane.showConfirmDialog(f, "현금을 넣어주세요", "현금결제", JOptionPane.YES_NO_OPTION);
						if(select==JOptionPane.YES_OPTION) {
							String input=JOptionPane.showInputDialog(f, "키오스크에 넣을 금액을 입력하세요 예) 10000");
							
							if(input==null) {
								JOptionPane.showMessageDialog(f, "취소하겠습니다");
								return;
							};
							int ainput=Integer.parseInt(input);
							if(ainput==alltotal) {
								JOptionPane.showMessageDialog(f, "현금결제가 완료되었습니다");
								alltotal=0;
								tfalltotal.setText("합계 "+alltotal);		//결제 후 합계 창 비우기!!!!!1
								model.setRowCount(0);					//결제 후 테이블 비우기
							}else if(ainput<alltotal) {
								JOptionPane.showMessageDialog(f, "현금을 더 넣어주세요");
								return;
							}else if(ainput>alltotal) {
								JOptionPane.showMessageDialog(f, (ainput-alltotal)+"원 받으세요. 현금결제가 완료되었습니다");
								alltotal=0;
								tfalltotal.setText("합계 "+alltotal);
								model.setRowCount(0);
							}//ainput==alltotal
						}//select==JOptionPane.YES_OPTION
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(f, "잘못된 입력입니다. 다시 시도하세요");
						return;
					}
				}else {
					JOptionPane.showMessageDialog(f, "메뉴를 담아주세요");
				}//alltotal>0
		
			}//actionPerformed
		}); //ActionListener()
		btnNewButton.setBackground(new Color(244, 244, 244));
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 33));
		btnNewButton.setBounds(104, 118, 175, 122);
		paypn.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("카드");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(alltotal>0) {
					int select=JOptionPane.showConfirmDialog(f, "카드를 넣어주세요", "카드결제", JOptionPane.YES_NO_OPTION);
					if(select==JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(f, "카드결제가 완료되었습니다");
						alltotal=0;
						tfalltotal.setText("합계 "+alltotal);
						model.setRowCount(0);
					}
				}else {
					JOptionPane.showMessageDialog(f, "메뉴를 담아주세요");
				}
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 33));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton_1.setBackground(new Color(244, 244, 244));
		btnNewButton_1.setBounds(404, 118, 175, 122);
		paypn.add(btnNewButton_1);
		dessertpn.setLayout(null);
		dessertpn.setBackground(Color.WHITE);
		dessertpn.setBounds(0, 83, 686, 537);
		getContentPane().add(dessertpn);
		
		JLabel lblNewLabel_1_6 = new JLabel("");
		lblNewLabel_1_6.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c11.png")));
		lblNewLabel_1_6.setBounds(12, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c12.png")));
		lblNewLabel_1_1_1.setBounds(174, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c13.png")));
		lblNewLabel_1_2_1.setBounds(339, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c14.png")));
		lblNewLabel_1_3_1.setBounds(504, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("");
		lblNewLabel_1_4_2.setBounds(339, 292, 148, 148);
		dessertpn.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("");
		lblNewLabel_1_5_1.setBounds(504, 292, 148, 148);
		dessertpn.add(lblNewLabel_1_5_1);
		
		textField11 = new JTextField();
		textField11.setText("0");
		textField11.setHorizontalAlignment(SwingConstants.CENTER);
		textField11.setColumns(10);
		textField11.setBounds(66, 220, 38, 25);
		dessertpn.add(textField11);
		
		JButton plus11 = new JButton("+");
		plus11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf11+=1;
				textField11.setText(Integer.toString(tf11));
			}
		});
		plus11.setFont(new Font("굴림", Font.PLAIN, 9));
		plus11.setBackground(SystemColor.control);
		plus11.setBounds(116, 220, 40, 25);
		dessertpn.add(plus11);
		
		JButton addc11 = new JButton("담기");
		addc11.setFont(new Font("굴림", Font.PLAIN, 13));
		addc11.setBackground(new Color(244, 244, 244));
		addc11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=tf11;					//수량
				int menutotal=tf11*3000;		//초코칩쿠키의 총 가격
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf11!=0) {
					model.addRow(new Object[] {"초코칩쿠키", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		
		addc11.setBounds(50, 252, 67, 30);
		dessertpn.add(addc11);
		
		JButton minus11 = new JButton("-");
		minus11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf11==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf11-=1;
					textField1.setText(Integer.toString(tf11));
				}
			}
		});
		minus11.setBackground(SystemColor.control);
		minus11.setBounds(19, 220, 40, 25);
		dessertpn.add(minus11);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("");
		lblNewLabel_1_4_1_1_1.setBounds(174, 292, 148, 148);
		dessertpn.add(lblNewLabel_1_4_1_1_1);
		
		JLabel lblNewLabel_2_8 = new JLabel("초코칩쿠키 3000원");
		lblNewLabel_2_8.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_8.setBounds(36, 191, 110, 30);
		dessertpn.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("휘낭시에 3500원");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(204, 191, 100, 30);
		dessertpn.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("스콘 4000원");
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(372, 191, 120, 30);
		dessertpn.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("갈레트브루통 4500원");
		lblNewLabel_2_3_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(514, 191, 138, 30);
		dessertpn.add(lblNewLabel_2_3_1);
		
		JButton minus12 = new JButton("-");
		minus12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf12==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf12-=1;
					textField12.setText(Integer.toString(tf12));
				}
			}
		});
		minus12.setBackground(SystemColor.control);
		minus12.setBounds(187, 220, 40, 25);
		dessertpn.add(minus12);
		
		textField12 = new JTextField();
		textField12.setText("0");
		textField12.setHorizontalAlignment(SwingConstants.CENTER);
		textField12.setColumns(10);
		textField12.setBounds(232, 220, 38, 25);
		dessertpn.add(textField12);
		
		JButton plus12 = new JButton("+");
		plus12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf12+=1;
				textField12.setText(Integer.toString(tf12));
			}
		});
		plus12.setFont(new Font("굴림", Font.PLAIN, 9));
		plus12.setBackground(SystemColor.control);
		plus12.setBounds(277, 220, 40, 25);
		dessertpn.add(plus12);
		
		JButton addc12 = new JButton("담기");
		addc12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=tf12;						//수량
				int menutotal=tf12*3500;		//휘낭시에 총 가격
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf12!=0) {
					model.addRow(new Object[] {"휘낭시에", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc12.setFont(new Font("굴림", Font.PLAIN, 13));
		addc12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc12.setBackground(new Color(244, 244, 244));
		addc12.setBounds(218, 252, 67, 30);
		dessertpn.add(addc12);
		
		JButton minus13 = new JButton("-");
		minus13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf13==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf13-=1;
					textField12.setText(Integer.toString(tf13));
				}
			}
		});
		minus13.setBackground(SystemColor.control);
		minus13.setBounds(348, 220, 40, 25);
		dessertpn.add(minus13);
		
		textField13 = new JTextField();
		textField13.setText("0");
		textField13.setHorizontalAlignment(SwingConstants.CENTER);
		textField13.setColumns(10);
		textField13.setBounds(395, 220, 38, 25);
		dessertpn.add(textField13);
		
		JButton plus13 = new JButton("+");
		plus13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf13+=1;
				textField13.setText(Integer.toString(tf13));
			}
		});
		plus13.setFont(new Font("굴림", Font.PLAIN, 9));
		plus13.setBackground(SystemColor.control);
		plus13.setBounds(439, 220, 40, 25);
		dessertpn.add(plus13);
		
		JButton addc13 = new JButton("담기");
		addc13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=tf13;						//수량
				int menutotal=tf13*4000;		//스콘 총 가격
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf13!=0) {
					model.addRow(new Object[] {"스콘", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc13.setBackground(new Color(244, 244, 244));
		addc13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc13.setFont(new Font("굴림", Font.PLAIN, 13));
		addc13.setBounds(383, 252, 67, 30);
		dessertpn.add(addc13);
		
		JButton minus14 = new JButton("-");
		minus14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf14==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf14-=1;
					textField12.setText(Integer.toString(tf14));
				}
			}
		});
		minus14.setBackground(SystemColor.control);
		minus14.setBounds(511, 220, 40, 25);
		dessertpn.add(minus14);
		
		textField14 = new JTextField();
		textField14.setText("0");
		textField14.setHorizontalAlignment(SwingConstants.CENTER);
		textField14.setColumns(10);
		textField14.setBounds(558, 220, 38, 25);
		dessertpn.add(textField14);
		
		JButton plus14 = new JButton("+");
		plus14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf14+=1;
				textField14.setText(Integer.toString(tf14));
			}
		});
		plus14.setFont(new Font("굴림", Font.PLAIN, 9));
		plus14.setBackground(SystemColor.control);
		plus14.setBounds(604, 220, 40, 25);
		dessertpn.add(plus14);
		
		JButton addc14 = new JButton("담기");
		addc14.setBackground(new Color(244, 244, 244));
		addc14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=tf14;						//수량
				int menutotal=tf14*4500;		//갈레트브루통 총 가격
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf14!=0) {
					model.addRow(new Object[] {"갈레트브루통", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc14.setFont(new Font("굴림", Font.PLAIN, 13));
		addc14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc14.setBounds(542, 252, 67, 30);
		dessertpn.add(addc14);
		
		
		//음료패널영역
		drinkpn = new JPanel();
		drinkpn.setBounds(0, 83, 686, 537);
		drinkpn.setBackground(Color.WHITE);
		getContentPane().add(drinkpn);
		drinkpn.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 38, 148, 148);
		lblNewLabel_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/11c1.png")));
		drinkpn.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(174, 38, 148, 148);
		lblNewLabel_1_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c2.png")));
		drinkpn.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(339, 38, 148, 148);
		lblNewLabel_1_2.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c3.png")));
		drinkpn.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setBounds(504, 38, 148, 148);
		lblNewLabel_1_3.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c4.png")));
		drinkpn.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setBounds(339, 292, 148, 148);
		lblNewLabel_1_4.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c5.png")));
		drinkpn.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setBounds(504, 292, 148, 148);
		lblNewLabel_1_5.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c6.png")));
		drinkpn.add(lblNewLabel_1_5);
		
		textField1 = new JTextField();
		textField1.setBounds(66, 220, 38, 25);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setText("0");
		drinkpn.add(textField1);
		textField1.setColumns(10);
		
		JButton plus1 = new JButton("+");
		plus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					tf1+=1;
					textField1.setText(Integer.toString(tf1));
			}
		});
		plus1.setBounds(115, 220, 40, 25);
		plus1.setFont(new Font("굴림", Font.PLAIN, 9));
		plus1.setBackground(SystemColor.control);
		drinkpn.add(plus1);
		
		
		
		JButton minus1 = new JButton("-");
		minus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf1-=1;
					textField1.setText(Integer.toString(tf1));
				}
			}
		});
		
		JButton addc1 = new JButton("담기");
		addc1.setFont(new Font("굴림", Font.PLAIN, 13));
		addc1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc1.setBackground(new Color(240, 240, 240));
		addc1.setBounds(50, 252, 67, 30);
		addc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//아메리카노의 수량(textField1), 총 가격을 담아 bottompn의 테이블에 표시하기
				
				int num=tf1;				//수량
				int menutotal=num*3000;		//아메리카노의 총 가격
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf1!=0) {
					model.addRow(new Object[] {"아메리카노", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
				
			}
		});
		drinkpn.add(addc1);
		minus1.setBounds(19, 220, 40, 25);
		minus1.setBackground(SystemColor.control);
		drinkpn.add(minus1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("");
		lblNewLabel_1_4_1.setBounds(12, 292, 148, 148);
		lblNewLabel_1_4_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c7.png")));
		drinkpn.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("");
		lblNewLabel_1_4_1_1.setBounds(174, 292, 148, 148);
		lblNewLabel_1_4_1_1.setIcon(new ImageIcon(Cafedrink.class.getResource("/JHProject/1c8.png")));
		drinkpn.add(lblNewLabel_1_4_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("아메리카노 3000원");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(24, 192, 120, 30);
		drinkpn.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("카페라떼 3500원");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(198, 192, 135, 30);
		drinkpn.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("카라멜마끼아또 4000원");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(341, 192, 148, 30);
		drinkpn.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("녹차라떼 4500원");
		lblNewLabel_2_3.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(526, 192, 120, 30);
		drinkpn.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("라임티 4500원");
		lblNewLabel_2_4.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(43, 445, 130, 25);
		drinkpn.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("레몬티 4500원");
		lblNewLabel_2_5.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(206, 445, 130, 25);
		drinkpn.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("딸기스무디 5000원");
		lblNewLabel_2_6.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_6.setBounds(364, 445, 130, 25);
		drinkpn.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("초코스무디 5000원");
		lblNewLabel_2_7.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_7.setBounds(526, 445, 130, 25);
		drinkpn.add(lblNewLabel_2_7);
		
		JButton minus2 = new JButton("-");
		minus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf2==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf2-=1;
					textField2.setText(Integer.toString(tf2));
				}
			}
		});
		minus2.setBackground(SystemColor.control);
		minus2.setBounds(187, 220, 40, 25);
		drinkpn.add(minus2);
		
		textField2 = new JTextField();
		textField2.setText("0");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setColumns(10);
		textField2.setBounds(234, 220, 38, 25);
		drinkpn.add(textField2);
		
		JButton plus2 = new JButton("+");
		plus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2+=1;
				textField2.setText(Integer.toString(tf2));
			}
		});
		plus2.setFont(new Font("굴림", Font.PLAIN, 9));
		plus2.setBackground(SystemColor.control);
		plus2.setBounds(277, 220, 40, 25);
		drinkpn.add(plus2);
		
		JButton addc2 = new JButton("담기");
		addc2.setFont(new Font("굴림", Font.PLAIN, 13));
		addc2.setBackground(new Color(240, 240, 240));
		addc2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf2;				
				int menutotal=num*3500;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf2!=0) {
					model.addRow(new Object[] {"카페라떼", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc2.setBounds(218, 252, 67, 30);
		drinkpn.add(addc2);
		
		JButton minus3 = new JButton("-");
		minus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf3==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf3-=1;
					textField3.setText(Integer.toString(tf3));
				}
			}
		});
		minus3.setBackground(SystemColor.control);
		minus3.setBounds(349, 220, 40, 25);
		drinkpn.add(minus3);
		
		textField3 = new JTextField();
		textField3.setText("0");
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setColumns(10);
		textField3.setBounds(395, 220, 38, 25);
		drinkpn.add(textField3);
		
		JButton plus3 = new JButton("+");
		plus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf3+=1;
				textField3.setText(Integer.toString(tf3));
			}
		});
		plus3.setFont(new Font("굴림", Font.PLAIN, 9));
		plus3.setBackground(SystemColor.control);
		plus3.setBounds(440, 220, 40, 25);
		drinkpn.add(plus3);
		
		JButton addc3 = new JButton("담기");
		addc3.setFont(new Font("굴림", Font.PLAIN, 13));
		addc3.setBackground(new Color(240, 240, 240));
		addc3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf3;				
				int menutotal=num*4000;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf3!=0) {
					model.addRow(new Object[] {"카라멜마끼아또", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc3.setBounds(383, 252, 67, 30);
		drinkpn.add(addc3);
		
		JButton minus4 = new JButton("-");
		minus4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf4==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf4-=1;
					textField4.setText(Integer.toString(tf4));
				}
			}
		});
		minus4.setBackground(SystemColor.control);
		minus4.setBounds(511, 220, 40, 25);
		drinkpn.add(minus4);
		
		textField4 = new JTextField();
		textField4.setText("0");
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setColumns(10);
		textField4.setBounds(558, 220, 38, 25);
		drinkpn.add(textField4);
		
		JButton plus4 = new JButton("+");
		plus4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf4+=1;
				textField4.setText(Integer.toString(tf4));
			}
		});
		plus4.setFont(new Font("굴림", Font.PLAIN, 9));
		plus4.setBackground(SystemColor.control);
		plus4.setBounds(603, 220, 40, 25);
		drinkpn.add(plus4);
		
		JButton addc4 = new JButton("담기");
		addc4.setFont(new Font("굴림", Font.PLAIN, 13));
		addc4.setBackground(new Color(240, 240, 240));
		addc4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf4;				
				int menutotal=num*4500;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf4!=0) {
					model.addRow(new Object[] {"녹차라떼", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc4.setBounds(542, 252, 67, 30);
		drinkpn.add(addc4);
		
		JButton minus5 = new JButton("-");
		minus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf5==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf5-=1;
					textField5.setText(Integer.toString(tf5));
				}
			}
		});
		minus5.setBackground(SystemColor.control);
		minus5.setBounds(25, 469, 40, 25);
		drinkpn.add(minus5);
		
		textField5 = new JTextField();
		textField5.setText("0");
		textField5.setHorizontalAlignment(SwingConstants.CENTER);
		textField5.setColumns(10);
		textField5.setBounds(72, 469, 38, 25);
		drinkpn.add(textField5);
		
		JButton plus5 = new JButton("+");
		plus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf5+=1;
				textField5.setText(Integer.toString(tf5));
			}
		});
		plus5.setFont(new Font("굴림", Font.PLAIN, 9));
		plus5.setBackground(SystemColor.control);
		plus5.setBounds(115, 469, 40, 25);
		drinkpn.add(plus5);
		
		JButton addc5 = new JButton("담기");
		addc5.setFont(new Font("굴림", Font.PLAIN, 13));
		addc5.setBackground(new Color(240, 240, 240));
		addc5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf5;				
				int menutotal=num*4500;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf5!=0) {
					model.addRow(new Object[] {"라임티", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc5.setBounds(56, 501, 67, 30);
		drinkpn.add(addc5);
		
		JButton minus6 = new JButton("-");
		minus6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf6==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf6-=1;
					textField6.setText(Integer.toString(tf6));
				}
			}
		});
		minus6.setBackground(SystemColor.control);
		minus6.setBounds(187, 469, 40, 25);
		drinkpn.add(minus6);
		
		textField6 = new JTextField();
		textField6.setText("0");
		textField6.setHorizontalAlignment(SwingConstants.CENTER);
		textField6.setColumns(10);
		textField6.setBounds(234, 469, 38, 25);
		drinkpn.add(textField6);
		
		JButton plus6 = new JButton("+");
		plus6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf6+=1;
				textField6.setText(Integer.toString(tf6));
			}
		});
		plus6.setFont(new Font("굴림", Font.PLAIN, 9));
		plus6.setBackground(SystemColor.control);
		plus6.setBounds(277, 469, 40, 25);
		drinkpn.add(plus6);
		
		JButton addc6 = new JButton("담기");
		addc6.setFont(new Font("굴림", Font.PLAIN, 13));
		addc6.setBackground(new Color(240, 240, 240));
		addc6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf6;				
				int menutotal=num*4500;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf6!=0) {
					model.addRow(new Object[] {"레몬티", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc6.setBounds(218, 501, 67, 30);
		drinkpn.add(addc6);
		
		JButton minus7 = new JButton("-");
		minus7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf7==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf7-=1;
					textField7.setText(Integer.toString(tf7));
				}
			}
		});
		minus7.setBackground(SystemColor.control);
		minus7.setBounds(349, 469, 40, 25);
		drinkpn.add(minus7);
		
		textField7 = new JTextField();
		textField7.setText("0");
		textField7.setHorizontalAlignment(SwingConstants.CENTER);
		textField7.setColumns(10);
		textField7.setBounds(395, 469, 38, 25);
		drinkpn.add(textField7);
		
		JButton plus7 = new JButton("+");
		plus7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf7+=1;
				textField7.setText(Integer.toString(tf7));
			}
		});
		plus7.setFont(new Font("굴림", Font.PLAIN, 9));
		plus7.setBackground(SystemColor.control);
		plus7.setBounds(440, 469, 40, 25);
		drinkpn.add(plus7);
		
		JButton addc7 = new JButton("담기");
		addc7.setFont(new Font("굴림", Font.PLAIN, 13));
		addc7.setBackground(new Color(240, 240, 240));
		addc7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf7;				
				int menutotal=num*5000;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf7!=0) {
					model.addRow(new Object[] {"딸기스무디", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc7.setBounds(383, 501, 67, 30);
		drinkpn.add(addc7);
		
		JButton minus8 = new JButton("-");
		minus8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf8==0) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
				} else {
					tf8-=1;
					textField8.setText(Integer.toString(tf8));
				}
			}
		});
		minus8.setBackground(SystemColor.control);
		minus8.setBounds(511, 469, 40, 25);
		drinkpn.add(minus8);
		
		textField8 = new JTextField();
		textField8.setText("0");
		textField8.setHorizontalAlignment(SwingConstants.CENTER);
		textField8.setColumns(10);
		textField8.setBounds(558, 469, 38, 25);
		drinkpn.add(textField8);
		
		JButton plus8 = new JButton("+");
		plus8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf8+=1;
				textField8.setText(Integer.toString(tf8));
			}
		});
		plus8.setFont(new Font("굴림", Font.PLAIN, 9));
		plus8.setBackground(SystemColor.control);
		plus8.setBounds(603, 469, 40, 25);
		drinkpn.add(plus8);
		
		JButton addc8 = new JButton("담기");
		addc8.setFont(new Font("굴림", Font.PLAIN, 13));
		addc8.setBackground(new Color(240, 240, 240));
		addc8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=tf8;				
				int menutotal=num*5000;		
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				if (tf8!=0) {
					model.addRow(new Object[] {"초코스무디", num, menutotal});
					alltotal+=menutotal;
					tfalltotal.setText("합계 "+alltotal);
				}
			}
		});
		addc8.setBounds(542, 501, 67, 30);
		drinkpn.add(addc8);
		
		
		// 상단 toppn 영역
		JPanel toppn = new JPanel();
		toppn.setBackground(SystemColor.control);
		toppn.setBounds(0, 0, 686, 87);
		getContentPane().add(toppn);
		toppn.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAFE");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 38));
		lblNewLabel.setBounds(15, 13, 125, 53);
		toppn.add(lblNewLabel);
		
		JButton drinkbt = new JButton("drink");
		drinkbt.setBackground(new Color(255, 255, 255));
		drinkbt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		drinkbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toppn.setVisible(true);
				bottompn.setVisible(true);
				drinkpn.setVisible(true);
				dessertpn.setVisible(false);
				paypn.setVisible(false);
			}
		});
		drinkbt.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		drinkbt.setBounds(160, 10, 157, 67);
		toppn.add(drinkbt);
		
		JButton dessertbt = new JButton("dessert");
		dessertbt.setBackground(new Color(255, 255, 255));
		dessertbt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dessertbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toppn.setVisible(true);
				bottompn.setVisible(true);
				drinkpn.setVisible(false);
				dessertpn.setVisible(true);
				paypn.setVisible(false);
			}
		});
		dessertbt.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		dessertbt.setBounds(330, 10, 157, 67);
		toppn.add(dessertbt);
		
		JButton paybt = new JButton("pay");
		paybt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		paybt.setBackground(new Color(255, 255, 255));
		paybt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toppn.setVisible(true);
				bottompn.setVisible(true);
				drinkpn.setVisible(false);
				dessertpn.setVisible(false);
				paypn.setVisible(true);
			}
		});
		paybt.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		paybt.setBounds(502, 10, 157, 67);
		toppn.add(paybt);
		
		
		//하단 bottompn 영역
		bottompn = new JPanel();
		bottompn.setBackground(UIManager.getColor("CheckBox.background"));
		bottompn.setBounds(0, 620, 686, 200);
		getContentPane().add(bottompn);
		bottompn.setLayout(null);
		
	
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane=new JScrollPane(table);
		
		scrollPane.setBackground(UIManager.getColor("Button.disabledShadow"));
		scrollPane.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setBounds(12, 10, 511, 167);
		bottompn.add(scrollPane);
		
		
		tfalltotal = new JTextArea();
		tfalltotal.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		tfalltotal.setText("합계\r\n\r\n");
		tfalltotal.setBounds(535, 86, 139, 91);
		bottompn.add(tfalltotal);
		
		// 장바구니 리스트 삭제 버튼
		JButton delbt = new JButton("삭제");
		delbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectrow=table.getSelectedRow();
				if(selectrow>=0) {
					int removeprice=(int)table.getValueAt(selectrow, 2); //가격얻어옴
					model.removeRow(selectrow);
					alltotal-=removeprice;
					tfalltotal.setText("합계 "+alltotal);
				}else {
					JOptionPane.showMessageDialog(f, "삭제할 항목이 없습니다");
				}
				
			}
		});
		delbt.setBackground(new Color(255, 255, 255));
		delbt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		delbt.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		delbt.setBounds(535, 13, 139, 30);
		bottompn.add(delbt);

		setBounds(500, 10, 700, 850);
		setVisible(true);
		

	}
	
	public static void main(String[] args) {
		new Cafedrink();


	}
}
