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
 * dessert패널의 디저트 각각의 개수를 더하고 빼기, 수량을 정한 디저트를 하단 bottom 패널의 장바구니테이블에 담을 수 있는 액션리스너
 * 수량을 더하지 않은 상태(0)에서 -버튼 클릭시 경고메시지 출력
 * +버튼으로 수량 선택 후 담기버튼 클릭하면 하단 bottom패널의 table에 담은 메뉴 리스트 확인가능
 * */
public class DessertListener implements ActionListener {	
	private CafeKiosk cafe;

    /** 메인클래스(CafeKiosk)의 정보를 얻어옴 */
    public DessertListener(CafeKiosk cafe) {	
        this.cafe = cafe;
    }
    
    
    /** dessert패널의 디저트 각각의 개수를 더하고 빼기, 수량을 정한 디저트를 하단 bottom 패널의 장바구니테이블에 담을 수 있는 액션리스너 
     * */
    public void actionPerformed(ActionEvent e) {
    	Component f = null;
    	
    	//11번 초코칩쿠키
    	if ("plus11".equals(e.getActionCommand())) {
    		cafe.tf11+=1;
			cafe.textField11.setText(Integer.toString(cafe.tf11));
		}else if ("minus11".equals(e.getActionCommand())) {
			if(cafe.tf11==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf11-=1;
				cafe.textField11.setText(Integer.toString(cafe.tf11));
			}
        }else if ("addc11".equals(e.getActionCommand())) {
			int num=cafe.tf11;				
			int menutotal=num*3000;		//초코칩쿠키 수량 * 가격
			if (cafe.tf11!=0) {
				cafe.model.addRow(new Object[] {"초코칩쿠키", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//2번 휘낭시에
    	if ("plus12".equals(e.getActionCommand())) {
    		cafe.tf12+=1;
			cafe.textField12.setText(Integer.toString(cafe.tf12));
		}else if ("minus12".equals(e.getActionCommand())) {
			if(cafe.tf12==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf12-=1;
				cafe.textField12.setText(Integer.toString(cafe.tf12));
			}
        }else if ("addc12".equals(e.getActionCommand())) {
			int num=cafe.tf12;				
			int menutotal=num*3500;		//휘낭시에 수량 * 가격
			if (cafe.tf12!=0) {
				cafe.model.addRow(new Object[] {"휘낭시에", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//3번 스콘
    	if ("plus13".equals(e.getActionCommand())) {
    		cafe.tf13+=1;
			cafe.textField13.setText(Integer.toString(cafe.tf13));
		}else if ("minus13".equals(e.getActionCommand())) {
			if(cafe.tf13==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf13-=1;
				cafe.textField13.setText(Integer.toString(cafe.tf13));
			}
        }else if ("addc13".equals(e.getActionCommand())) {
			int num=cafe.tf13;				
			int menutotal=num*4000;		//스콘 수량 * 가격
			if (cafe.tf13!=0) {
				cafe.model.addRow(new Object[] {"스콘", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }
    	//4번 갈레트브루통
    	if ("plus14".equals(e.getActionCommand())) {
    		cafe.tf14+=1;
			cafe.textField14.setText(Integer.toString(cafe.tf14));
		}else if ("minus14".equals(e.getActionCommand())) {
			if(cafe.tf14==0) {
				JOptionPane.showMessageDialog(f, "잘못된 입력입니다");
			} else {
				cafe.tf14-=1;
				cafe.textField14.setText(Integer.toString(cafe.tf14));
			}
        }else if ("addc14".equals(e.getActionCommand())) {
			int num=cafe.tf14;				
			int menutotal=num*4500;		//갈레트브루통 수량 * 가격
			if (cafe.tf14!=0) {
				cafe.model.addRow(new Object[] {"갈레트브루통", num, menutotal});
				cafe.alltotal+=menutotal;
				cafe.tfalltotal.setText("합계 "+cafe.alltotal);
			}
        }


      }
}
