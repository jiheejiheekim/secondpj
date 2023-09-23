package JHProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**작성자 : 김지희
 * 작성일 : 2023-09-20
 * 버 전 : 1.1
 * Top패널의 버튼을 클릭하면 음료탭, 디저트탭, 결제탭으로 이동할 수 있는 액션리스너
 * */
public class TopBtListener implements ActionListener { 
    private CafeKiosk cafe;

    /** 메인클래스(CafeKiosk)의 정보를 얻어옴 */
    public TopBtListener(CafeKiosk cafe) {	
        this.cafe = cafe;
    }
    
    /** 상단의 버튼 클릭 시 패널 이동 관련하여 실행됨 */
    public void actionPerformed(ActionEvent e) {	
    	if (e.getActionCommand().equals("drink")) {
    		cafe.toppn.setVisible(true);
    		cafe.bottompn.setVisible(true);
    		cafe.drinkpn.setVisible(true);
    		cafe.dessertpn.setVisible(false);
    		cafe.paypn.setVisible(false);
        }else if (e.getActionCommand().equals("dessert")) {
            cafe.toppn.setVisible(true);
            cafe.bottompn.setVisible(true);
            cafe.drinkpn.setVisible(false);
            cafe.dessertpn.setVisible(true);
            cafe.paypn.setVisible(false);
        } else if (e.getActionCommand().equals("pay")) {
            cafe.toppn.setVisible(true);
            cafe.bottompn.setVisible(true);
            cafe.drinkpn.setVisible(false);
            cafe.dessertpn.setVisible(false);
            cafe.paypn.setVisible(true);
        }
        
    }
}
