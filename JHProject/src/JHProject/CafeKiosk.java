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

/**작성자 : 김지희
 * 작성일 : 2023-09-21
 * 버 전 : 1.1
 * 
 * CafeKiosk프로그램의 메인클래스
 * 음료메뉴, 디저트메뉴 수량 지정해서 하단 장바구니 테이블에 담기, 합계로 메뉴와 총 금액 확인 가능
 * 결제 전 메뉴나 수량 변경을 원할 시 장바구니의 해당 메뉴 삭제 가능
 * 현금결제와 카드결제 중 하나를 선택
 * 현금결제 선택 시 사용자가 처음 지불할 금액 입력과 거스름돈 출력
 * 지불금액이 결제금액보다 적을 경우, 결제 완료 시 메시지출력
 * 결제 완료 후 합계창과 장바구니 리셋
 * */
public class CafeKiosk extends JFrame{
	
	JFrame f=new JFrame();
	
	JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8;
	// 디저트의 수량을 나타내는 텍스트필드 / 주석 기준 위는 음료, 아래는 디저트
	JTextField textField11, textField12, textField13, textField14;
	
	//음료 개수 초기화 텍스트필드
	int tf1=0;
	int tf2=0;
	int tf3=0;
	int tf4=0;
	int tf5=0;
	int tf6=0;
	int tf7=0;
	int tf8=0;
	//디저트 개수 초기화 / 주석 기준 위는 음료, 아래는 디저트
	int tf11=0;
	int tf12=0;
	int tf13=0;
	int tf14=0;

	int num;
	JTextArea tfalltotal;
	int alltotal=0;		//합계 초기화
	
	JButton btnNewButton;
	JPanel toppn, bottompn, drinkpn, dessertpn, paypn;

	//담기 한 데이터를 하단 table에 출력
	String[] heading =new String[] {"메뉴", "수량", "금액"};			//bottompn의 table 1열 제목
	DefaultTableModel model=new DefaultTableModel(heading,0);	//열은 heading, 행은 0으로 초기값 비움
	JTable table = new JTable(model);
	
	
	/**카페키오스크 프로그램의 GUI*/
	private CafeKiosk() {
		setTitle("Cafe Kiosk");
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
		
		//현금결제
		btnNewButton = new JButton("현금");
		btnNewButton.addActionListener(new PayBtListener(this)); //외부클래스로 뺌
		btnNewButton.setBackground(new Color(244, 244, 244));
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 33));
		btnNewButton.setBounds(104, 118, 175, 122);
		paypn.add(btnNewButton);
		
		//카드결제
		JButton btnNewButton_1 = new JButton("카드");
		btnNewButton_1.addActionListener(new PayBtListener(this));
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 33));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton_1.setBackground(new Color(244, 244, 244));
		btnNewButton_1.setBounds(404, 118, 175, 122);
		paypn.add(btnNewButton_1);
		
		
		//디저트패널영역-------------------------------------
		dessertpn.setLayout(null);
		dessertpn.setBackground(Color.WHITE);
		dessertpn.setBounds(0, 83, 686, 537);
		getContentPane().add(dessertpn);
		
		JLabel lblNewLabel_1_6 = new JLabel("");
		lblNewLabel_1_6.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c11.png")));
		lblNewLabel_1_6.setBounds(12, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c12.png")));
		lblNewLabel_1_1_1.setBounds(174, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c13.png")));
		lblNewLabel_1_2_1.setBounds(339, 38, 148, 148);
		dessertpn.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c14.png")));
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
		plus11.setActionCommand("plus11");
		plus11.addActionListener(new DessertListener(this));
		plus11.setFont(new Font("굴림", Font.PLAIN, 9));
		plus11.setBackground(SystemColor.control);
		plus11.setBounds(116, 220, 40, 25);
		dessertpn.add(plus11);
		
		JButton addc11 = new JButton("담기");
		addc11.setFont(new Font("굴림", Font.PLAIN, 13));
		addc11.setBackground(new Color(244, 244, 244));
		addc11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc11.setActionCommand("addc11");
		addc11.addActionListener(new DessertListener(this));
		
		addc11.setBounds(50, 252, 67, 30);
		dessertpn.add(addc11);
		
		JButton minus11 = new JButton("-");
		minus11.setActionCommand("minus11");
		minus11.addActionListener(new DessertListener(this));
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
		minus12.setActionCommand("minus12");
		minus12.addActionListener(new DessertListener(this));
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
		plus12.setActionCommand("plus12");
		plus12.addActionListener(new DessertListener(this));
		plus12.setFont(new Font("굴림", Font.PLAIN, 9));
		plus12.setBackground(SystemColor.control);
		plus12.setBounds(277, 220, 40, 25);
		dessertpn.add(plus12);
		
		JButton addc12 = new JButton("담기");
		addc12.setActionCommand("addc12");
		addc12.addActionListener(new DessertListener(this));
		addc12.setFont(new Font("굴림", Font.PLAIN, 13));
		addc12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc12.setBackground(new Color(244, 244, 244));
		addc12.setBounds(218, 252, 67, 30);
		dessertpn.add(addc12);
		
		JButton minus13 = new JButton("-");
		minus13.setActionCommand("minus13");
		minus13.addActionListener(new DessertListener(this));
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
		plus13.setActionCommand("plus13");
		plus13.addActionListener(new DessertListener(this));
		plus13.setFont(new Font("굴림", Font.PLAIN, 9));
		plus13.setBackground(SystemColor.control);
		plus13.setBounds(439, 220, 40, 25);
		dessertpn.add(plus13);
		
		JButton addc13 = new JButton("담기");
		addc13.setActionCommand("addc13");
		addc13.addActionListener(new DessertListener(this));
		addc13.setBackground(new Color(244, 244, 244));
		addc13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc13.setFont(new Font("굴림", Font.PLAIN, 13));
		addc13.setBounds(383, 252, 67, 30);
		dessertpn.add(addc13);
		
		JButton minus14 = new JButton("-");
		minus14.setActionCommand("minus14");
		minus14.addActionListener(new DessertListener(this));
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
		plus14.setActionCommand("plus14");
		plus14.addActionListener(new DessertListener(this));
		plus14.setFont(new Font("굴림", Font.PLAIN, 9));
		plus14.setBackground(SystemColor.control);
		plus14.setBounds(604, 220, 40, 25);
		dessertpn.add(plus14);
		
		JButton addc14 = new JButton("담기");
		addc14.setBackground(new Color(244, 244, 244));
		addc14.setActionCommand("addc14");
		addc14.addActionListener(new DessertListener(this));
		addc14.setFont(new Font("굴림", Font.PLAIN, 13));
		addc14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc14.setBounds(542, 252, 67, 30);
		dessertpn.add(addc14);
		
		
		//음료패널영역-------------------------------------
		drinkpn = new JPanel();
		drinkpn.setBounds(0, 83, 686, 537);
		drinkpn.setBackground(Color.WHITE);
		getContentPane().add(drinkpn);
		drinkpn.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 38, 148, 148);
		lblNewLabel_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/11c1.png")));
		drinkpn.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(174, 38, 148, 148);
		lblNewLabel_1_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c2.png")));
		drinkpn.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(339, 38, 148, 148);
		lblNewLabel_1_2.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c3.png")));
		drinkpn.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setBounds(504, 38, 148, 148);
		lblNewLabel_1_3.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c4.png")));
		drinkpn.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setBounds(339, 292, 148, 148);
		lblNewLabel_1_4.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c5.png")));
		drinkpn.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setBounds(504, 292, 148, 148);
		lblNewLabel_1_5.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c6.png")));
		drinkpn.add(lblNewLabel_1_5);
		
		textField1 = new JTextField();
		textField1.setBounds(66, 220, 38, 25);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setText("0");
		drinkpn.add(textField1);
		textField1.setColumns(10);
		
		JButton plus1 = new JButton("+");
		plus1.setActionCommand("plus1");
		plus1.addActionListener(new DrinkListener(this));
		plus1.setBounds(115, 220, 40, 25);
		plus1.setFont(new Font("굴림", Font.PLAIN, 9));
		plus1.setBackground(SystemColor.control);
		drinkpn.add(plus1);
		
		JButton minus1 = new JButton("-");
		minus1.setActionCommand("minus1");
		minus1.addActionListener(new DrinkListener(this));
		minus1.setBounds(19, 220, 40, 25);
		minus1.setBackground(SystemColor.control);
		drinkpn.add(minus1);
		
		JButton addc1 = new JButton("담기");
		addc1.setFont(new Font("굴림", Font.PLAIN, 13));
		addc1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc1.setBackground(new Color(240, 240, 240));
		addc1.setBounds(50, 252, 67, 30);
		addc1.setActionCommand("addc1");
		addc1.addActionListener(new DrinkListener(this));
		drinkpn.add(addc1);

		
		JLabel lblNewLabel_1_4_1 = new JLabel("");
		lblNewLabel_1_4_1.setBounds(12, 292, 148, 148);
		lblNewLabel_1_4_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c7.png")));
		drinkpn.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("");
		lblNewLabel_1_4_1_1.setBounds(174, 292, 148, 148);
		lblNewLabel_1_4_1_1.setIcon(new ImageIcon(CafeKiosk.class.getResource("/JHProject/1c8.png")));
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
		minus2.setActionCommand("minus2");
		minus2.addActionListener(new DrinkListener(this));
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
		plus2.setActionCommand("plus2");
		plus2.addActionListener(new DrinkListener(this));
		plus2.setFont(new Font("굴림", Font.PLAIN, 9));
		plus2.setBackground(SystemColor.control);
		plus2.setBounds(277, 220, 40, 25);
		drinkpn.add(plus2);
		
		JButton addc2 = new JButton("담기");
		addc2.setFont(new Font("굴림", Font.PLAIN, 13));
		addc2.setBackground(new Color(240, 240, 240));
		addc2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc2.setActionCommand("addc2");
		addc2.addActionListener(new DrinkListener(this));
		addc2.setBounds(218, 252, 67, 30);
		drinkpn.add(addc2);
		
		JButton minus3 = new JButton("-");
		minus3.setActionCommand("minus3");
		minus3.addActionListener(new DrinkListener(this));
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
		plus3.setActionCommand("plus3");
		plus3.addActionListener(new DrinkListener(this));
		plus3.setFont(new Font("굴림", Font.PLAIN, 9));
		plus3.setBackground(SystemColor.control);
		plus3.setBounds(440, 220, 40, 25);
		drinkpn.add(plus3);
		
		JButton addc3 = new JButton("담기");
		addc3.setFont(new Font("굴림", Font.PLAIN, 13));
		addc3.setBackground(new Color(240, 240, 240));
		addc3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc3.setActionCommand("addc3");
		addc3.addActionListener(new DrinkListener(this));
		addc3.setBounds(383, 252, 67, 30);
		drinkpn.add(addc3);
		
		JButton minus4 = new JButton("-");
		minus4.setActionCommand("minus4");
		minus4.addActionListener(new DrinkListener(this));
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
		plus4.setActionCommand("plus4");
		plus4.addActionListener(new DrinkListener(this));
		plus4.setFont(new Font("굴림", Font.PLAIN, 9));
		plus4.setBackground(SystemColor.control);
		plus4.setBounds(603, 220, 40, 25);
		drinkpn.add(plus4);
		
		JButton addc4 = new JButton("담기");
		addc4.setFont(new Font("굴림", Font.PLAIN, 13));
		addc4.setBackground(new Color(240, 240, 240));
		addc4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc4.setActionCommand("addc4");
		addc4.addActionListener(new DrinkListener(this));
		addc4.setBounds(542, 252, 67, 30);
		drinkpn.add(addc4);
		
		JButton minus5 = new JButton("-");
		minus5.setActionCommand("minus5");
		minus5.addActionListener(new DrinkListener(this));
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
		plus5.setActionCommand("plus5");
		plus5.addActionListener(new DrinkListener(this));
		plus5.setFont(new Font("굴림", Font.PLAIN, 9));
		plus5.setBackground(SystemColor.control);
		plus5.setBounds(115, 469, 40, 25);
		drinkpn.add(plus5);
		
		JButton addc5 = new JButton("담기");
		addc5.setFont(new Font("굴림", Font.PLAIN, 13));
		addc5.setBackground(new Color(240, 240, 240));
		addc5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc5.setActionCommand("addc5");
		addc5.addActionListener(new DrinkListener(this));
		addc5.setBounds(56, 501, 67, 30);
		drinkpn.add(addc5);
		
		JButton minus6 = new JButton("-");
		minus6.setActionCommand("minus6");
		minus6.addActionListener(new DrinkListener(this));
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
		plus6.setActionCommand("plus6");
		plus6.addActionListener(new DrinkListener(this));
		plus6.setFont(new Font("굴림", Font.PLAIN, 9));
		plus6.setBackground(SystemColor.control);
		plus6.setBounds(277, 469, 40, 25);
		drinkpn.add(plus6);
		
		JButton addc6 = new JButton("담기");
		addc6.setFont(new Font("굴림", Font.PLAIN, 13));
		addc6.setBackground(new Color(240, 240, 240));
		addc6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc6.setActionCommand("addc6");
		addc6.addActionListener(new DrinkListener(this));
		addc6.setBounds(218, 501, 67, 30);
		drinkpn.add(addc6);
		
		JButton minus7 = new JButton("-");
		minus7.setActionCommand("minus7");
		minus7.addActionListener(new DrinkListener(this));
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
		plus7.setActionCommand("plus7");
		plus7.addActionListener(new DrinkListener(this));
		plus7.setFont(new Font("굴림", Font.PLAIN, 9));
		plus7.setBackground(SystemColor.control);
		plus7.setBounds(440, 469, 40, 25);
		drinkpn.add(plus7);
		
		JButton addc7 = new JButton("담기");
		addc7.setFont(new Font("굴림", Font.PLAIN, 13));
		addc7.setBackground(new Color(240, 240, 240));
		addc7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc7.setActionCommand("addc7");
		addc7.addActionListener(new DrinkListener(this));
		addc7.setBounds(383, 501, 67, 30);
		drinkpn.add(addc7);
		
		JButton minus8 = new JButton("-");
		minus8.setActionCommand("minus8");
		minus8.addActionListener(new DrinkListener(this));
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
		plus8.setActionCommand("plus8");
		plus8.addActionListener(new DrinkListener(this));
		plus8.setFont(new Font("굴림", Font.PLAIN, 9));
		plus8.setBackground(SystemColor.control);
		plus8.setBounds(603, 469, 40, 25);
		drinkpn.add(plus8);
		
		JButton addc8 = new JButton("담기");
		addc8.setFont(new Font("굴림", Font.PLAIN, 13));
		addc8.setBackground(new Color(240, 240, 240));
		addc8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addc8.setActionCommand("addc8");
		addc8.addActionListener(new DrinkListener(this));
		addc8.setBounds(542, 501, 67, 30);
		drinkpn.add(addc8);
		
		
		// 상단 toppn 영역--------------------------------
		toppn = new JPanel();
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
		drinkbt.addActionListener(new TopBtListener(this));
		drinkbt.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		drinkbt.setBounds(160, 10, 157, 67);
		toppn.add(drinkbt);
		
		JButton dessertbt = new JButton("dessert");
		dessertbt.setBackground(new Color(255, 255, 255));
		dessertbt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dessertbt.addActionListener(new TopBtListener(this));
		dessertbt.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		dessertbt.setBounds(330, 10, 157, 67);
		toppn.add(dessertbt);
		
		JButton paybt = new JButton("pay");
		paybt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		paybt.setBackground(new Color(255, 255, 255));
		paybt.addActionListener(new TopBtListener(this));
		paybt.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		paybt.setBounds(502, 10, 157, 67);
		toppn.add(paybt);
		
		
		//하단 bottompn 장바구니 영역--------------------------------
		bottompn = new JPanel();
		bottompn.setBackground(UIManager.getColor("CheckBox.background"));
		bottompn.setBounds(0, 620, 686, 200);
		getContentPane().add(bottompn);
		bottompn.setLayout(null);
		
	
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane=new JScrollPane(table);	//담은 데이터가 많을 시 스크롤 생성
		
		scrollPane.setBackground(UIManager.getColor("Button.disabledShadow"));
		scrollPane.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setBounds(12, 10, 511, 167);
		bottompn.add(scrollPane);
		
		
		tfalltotal = new JTextArea();
		tfalltotal.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		tfalltotal.setText("합계\r\n\r\n");
		tfalltotal.setBounds(535, 86, 139, 91);
		bottompn.add(tfalltotal);
		
		// 장바구니 리스트 삭제 
		Delete();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 10, 700, 850);
		setVisible(true);
	}
	
	/** 테이블에서 삭제하고자 하는 행을 선택 후 버튼 클릭 시 해당 행을 삭제
	 * 삭제 후 합계영역에 삭제한 데이터의 금액(수량*가격)을 얻어와 제함
	 * 삭제 할 데이터가 없는데('담기'한 데이터가 없을때 or 삭제할 행을 선택하지 않았을 때) 삭제버튼을 클릭했을 경우 경고메시지 출력
	 * */
	public void Delete() {
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

		
	}
	
	public static void main(String[] args) {
		new CafeKiosk();


	}
}
