package JHProject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**작성자 : 김지희
 * 작성일 : 2023-09-20
 * 버 전 : 1.1
 * pay버튼을 클릭 후 결제탭으로 가서 현금결제 또는 카드결제를 선택하면 실행되는 결제관리 액션리스너
 * 현금버튼 또는 카드버튼 클릭 시 실행되는 액션이벤트
 * 현금결제 시 InputDialog를 통해 건넬 금액을 입력하고 거스름돈이 있다면 그 금액까지 출력/
 * 만약 처음 입력한 금액이 결제금액보다 적은 경우 MessageDialog를 통해 알림 메시지출력/
 * InputDialog 예외 생성(try~catch) ex)숫자가 아닌 문자입력 등의 예외 발생 시 예외메시지 출력/
 * 결제 완료 시 완료메시지 출력과 합계금액 0으로 리셋, 장바구니 테이블 초기화 
 * */

public class PayBtListener implements ActionListener { 
    private CafeKiosk cafe;

    /** 메인클래스(CafeKiosk)의 정보를 얻어옴 */
    public PayBtListener(CafeKiosk cafe) {	
        this.cafe = cafe;
    }

    /** pay버튼을 클릭 후 결제탭으로 가서 현금결제 또는 카드결제를 선택하면 실행되는 결제관리 액션리스너 */
	public void actionPerformed(ActionEvent e) {	
		int alltotal=cafe.alltotal;
		Component f = null;
		if (e.getActionCommand().equals("현금")) {
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
							cafe.tfalltotal.setText("합계 "+alltotal);		
							cafe.model.setRowCount(0);					
						}else if(ainput<alltotal) {
							JOptionPane.showMessageDialog(f, "현금을 더 넣어주세요");
							return;
						}else if(ainput>alltotal) {
							JOptionPane.showMessageDialog(f, (ainput-alltotal)+"원 받으세요. 현금결제가 완료되었습니다");
							alltotal=0;
							cafe.tfalltotal.setText("합계 "+alltotal);
							cafe.model.setRowCount(0);
						}//ainput==alltotal
					}//select==JOptionPane.YES_OPTION
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(f, "잘못된 입력입니다. 다시 시도하세요");
					return;
				}
			}else {
				JOptionPane.showMessageDialog(f, "메뉴를 담아주세요");
			}//alltotal>0
	    }else if (e.getActionCommand().equals("카드")) {
	    	if(alltotal>0) {
				int select=JOptionPane.showConfirmDialog(f, "카드를 넣어주세요", "카드결제", JOptionPane.YES_NO_OPTION);
				if(select==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(f, "카드결제가 완료되었습니다");
					alltotal=0;
					cafe.tfalltotal.setText("합계 "+alltotal);
					cafe.model.setRowCount(0);
				}
			}else {
				JOptionPane.showMessageDialog(f, "메뉴를 담아주세요");
			}
	    } 
	    
	}
}
