package JHProject;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**작성자 : 김지희
 * 작성일 : 2023-09-21
 * 버 전 : 1.1
 * drink패널의 음료 각각의 개수를 더하고 빼기, 수량을 정한 음료를 하단 bottom 패널의 장바구니테이블에 담을 수 있는 액션리스너
 * 수량을 더하지 않은 상태(0)에서 -버튼 클릭시 경고메시지 출력
 * +버튼으로 수량 선택 후 담기버튼 클릭하면 하단 bottom패널의 table에 담은 메뉴 리스트 확인가능
 * 
 * */
public class DrinkListener implements ActionListener {	
	private CafeKiosk cafe;

    /** 메인클래스(CafeKiosk)의 정보를 얻어옴 */
    public DrinkListener(CafeKiosk cafe) {	
        this.cafe = cafe;
    }
    
    /** drink패널의 음료 각각의 개수를 더하고 빼기, 수량을 정한 음료를 하단 bottom 패널의 장바구니테이블에 담을 수 있는 액션리스너
     * */
    public void actionPerformed(ActionEvent e) {
    	Component f = null;
    	
    	//1번 아메리카노
    	if ("plus1".equals(e.getActionCommand())) {
    		cafe.tf1+=1;
			cafe.textField1.setText(Integer.toString(cafe.tf1));
		}else if ("minus1".equals(e.getActionCommand())) {
			if(cafe.tf1==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf1-=1;
				cafe.textField1.setText(Integer.toString(cafe.tf1));
			}
        }else if ("addc1".equals(e.getActionCommand())) {
			int num=cafe.tf1;				
			int menutotal=num*3000;		//아메리카노 수량 * 가격
			if (cafe.tf1!=0) {
				cafe.model.addRow(new Object[] {"아메리카노", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//2번 카페라떼
    	if ("plus2".equals(e.getActionCommand())) {
    		cafe.tf2+=1;
			cafe.textField2.setText(Integer.toString(cafe.tf2));
		}else if ("minus2".equals(e.getActionCommand())) {
			if(cafe.tf2==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf2-=1;
				cafe.textField2.setText(Integer.toString(cafe.tf2));
			}
        }else if ("addc2".equals(e.getActionCommand())) {
			int num=cafe.tf2;				
			int menutotal=num*3500;		//아메리카노 수량 * 가격
			if (cafe.tf2!=0) {
				cafe.model.addRow(new Object[] {"카페라떼", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//3번 카라멜마끼아또
    	if ("plus3".equals(e.getActionCommand())) {
    		cafe.tf3+=1;
			cafe.textField3.setText(Integer.toString(cafe.tf3));
		}else if ("minus3".equals(e.getActionCommand())) {
			if(cafe.tf3==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf3-=1;
				cafe.textField3.setText(Integer.toString(cafe.tf3));
			}
        }else if ("addc3".equals(e.getActionCommand())) {
			int num=cafe.tf3;				
			int menutotal=num*4000;		//카라멜마끼아또 수량 * 가격
			if (cafe.tf3!=0) {
				cafe.model.addRow(new Object[] {"카라멜마끼아또", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//4번 녹차라떼
    	if ("plus4".equals(e.getActionCommand())) {
    		cafe.tf4+=1;
			cafe.textField4.setText(Integer.toString(cafe.tf4));
		}else if ("minus4".equals(e.getActionCommand())) {
			if(cafe.tf4==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf4-=1;
				cafe.textField4.setText(Integer.toString(cafe.tf4));
			}
        }else if ("addc4".equals(e.getActionCommand())) {
			int num=cafe.tf4;				
			int menutotal=num*4500;		//녹차라떼 수량 * 가격
			if (cafe.tf4!=0) {
				cafe.model.addRow(new Object[] {"녹차라떼", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//5번 라임티
    	if ("plus5".equals(e.getActionCommand())) {
    		cafe.tf5+=1;
			cafe.textField5.setText(Integer.toString(cafe.tf5));
		}else if ("minus5".equals(e.getActionCommand())) {
			if(cafe.tf5==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf5-=1;
				cafe.textField5.setText(Integer.toString(cafe.tf5));
			}
        }else if ("addc5".equals(e.getActionCommand())) {
			int num=cafe.tf5;				
			int menutotal=num*4500;		//라임티 수량 * 가격
			if (cafe.tf5!=0) {
				cafe.model.addRow(new Object[] {"라임티", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//6번 레몬티
    	if ("plus6".equals(e.getActionCommand())) {
    		cafe.tf6+=1;
			cafe.textField6.setText(Integer.toString(cafe.tf6));
		}else if ("minus6".equals(e.getActionCommand())) {
			if(cafe.tf6==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf6-=1;
				cafe.textField6.setText(Integer.toString(cafe.tf6));
			}
        }else if ("addc6".equals(e.getActionCommand())) {
			int num=cafe.tf6;				
			int menutotal=num*4500;		//레몬티 수량 * 가격
			if (cafe.tf6!=0) {
				cafe.model.addRow(new Object[] {"레몬티", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//7번 딸기스무디
    	if ("plus7".equals(e.getActionCommand())) {
    		cafe.tf7+=1;
			cafe.textField7.setText(Integer.toString(cafe.tf7));
		}else if ("minus7".equals(e.getActionCommand())) {
			if(cafe.tf7==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf7-=1;
				cafe.textField7.setText(Integer.toString(cafe.tf7));
			}
        }else if ("addc7".equals(e.getActionCommand())) {
			int num=cafe.tf7;				
			int menutotal=num*5000;		//딸기스무디 수량 * 가격
			if (cafe.tf7!=0) {
				cafe.model.addRow(new Object[] {"딸기스무디", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//8번 초코스무디
    	if ("plus8".equals(e.getActionCommand())) {
    		cafe.tf8+=1;
			cafe.textField8.setText(Integer.toString(cafe.tf8));
		}else if ("minus8".equals(e.getActionCommand())) {
			if(cafe.tf8==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf8-=1;
				cafe.textField8.setText(Integer.toString(cafe.tf8));
			}
        }else if ("addc8".equals(e.getActionCommand())) {
			int num=cafe.tf8;				
			int menutotal=num*5000;		//초코스무디 수량 * 가격
			if (cafe.tf8!=0) {
				cafe.model.addRow(new Object[] {"초코스무디", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
				}
            }

        	
      }
}
