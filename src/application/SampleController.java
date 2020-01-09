package application;

import java.math.BigDecimal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class SampleController {
	class Item {
		final static int ADD = 1;
		final static int SUB = 2;
		final static int MUL = 3;
		final static int DIV = 4;
		final static int REM = 5;
		
		int sign;
		BigDecimal num;
	}
	Item[] items = new Item[2];
	int now = 1;
	boolean next = false;
	public SampleController() {
		items[0] = new Item();
		items[1] = new Item();
	}
	
	
	@FXML
	private TextField text;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button4;
	@FXML
	private Button button3;
	@FXML
	private Button button6;
	@FXML
	private Button button5;
	@FXML
	private Button button9;
	@FXML
	private Button button8;
	@FXML
	private Button button7;
	@FXML
	private Button buttonDiv;
	@FXML
	private Button buttonSub;
	@FXML
	private Button buttonMul;
	@FXML
	private Button buttonDot;
	@FXML
	private Button button0;
	@FXML
	private Button buttonC;
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonEql;
	@FXML
	private Button buttonRem;
	@FXML
	private Button buttonTurn;
	
	
	String str = "";
	boolean eqlFlag = false;
	boolean turnFlag = false;
	boolean tenFlag = false;
	BigDecimal result;
	
	
	// Event Listener on Button[#button1].onAction
	@FXML
	public void onClick(ActionEvent e) {
		
		//数値ボタン
		if(e.getSource().equals(button1)) {
			if(eqlFlag) {
				str = "";
			}
			str += "1"; eqlFlag = false;
		}else if(e.getSource().equals(button2)) {
			if(eqlFlag) {
				str = "";
			}
			str += "2"; eqlFlag = false;
		}else if(e.getSource().equals(button3)) {
			if(eqlFlag) {
				str = "";
			}
			str += "3";eqlFlag = false;
		}else if(e.getSource().equals(button4)) {
			if(eqlFlag) {
				str = "";
			}
			str += "4";eqlFlag = false;
		}else if(e.getSource().equals(button5)) {
			if(eqlFlag) {
				str = "";
			}
			str += "5";eqlFlag = false;
		}else if(e.getSource().equals(button6)) {
			if(eqlFlag) {
				str = "";
			}
			str += "6";eqlFlag = false;
		}else if(e.getSource().equals(button7)) {
			if(eqlFlag) {
				str = "";
			}
			str += "7";eqlFlag = false;
		}else if(e.getSource().equals(button8)) {
			if(eqlFlag) {
				str = "";
			}
			str += "8";eqlFlag = false;
		}else if(e.getSource().equals(button9)) {
			if(eqlFlag) {
				str = "";
			}
			str += "9";eqlFlag = false;
		}else if(e.getSource().equals(button0)) {
			if(eqlFlag) {
				str = "";eqlFlag = false;
			}
			str += 0;
		}else if(e.getSource().equals(buttonDot)) {
			if(eqlFlag) {
				str = "";
			}
			if(!tenFlag) {
				if(str.length()==0) {
					str += "0." ;eqlFlag = false;
				}else {
					str += ".";
				}
				tenFlag = true;
			}
			
		}
		//「＋」「－」反転ボタン
		if(e.getSource().equals(buttonTurn)) {
			if(!turnFlag) {
				str = "-" + str;
				turnFlag = true;
			}else {
				str = str.substring(1);
				turnFlag = false;
			}
		}
		//加算ボタン
		if(e.getSource().equals(buttonAdd)) {
			if(now == 1) {
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.ADD;
				now = 2;
				str = "";
				tenFlag = false;
				turnFlag = false;
			}else if(now == 2){
				items[1].num = new BigDecimal(str);
				cul();
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.ADD;
				str = "";
				now = 1;
				tenFlag = false;
				turnFlag = false;
			}
		}
		//減算ボタン
		if(e.getSource().equals(buttonSub)) {
			if(now == 1) {
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.SUB;
				now = 2;
				str = "";
				tenFlag = false;
				turnFlag = false;
			}else if(now == 2){
				items[1].num = new BigDecimal(str);
				cul();
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.SUB;
				str = "";
				now = 1;
				tenFlag = false;
				turnFlag = false;
			}
		}
		//乗算ボタン
		if(e.getSource().equals(buttonMul)) {
			if(now == 1) {
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.MUL;
				now = 2;
				str = "";
				tenFlag = false;
				turnFlag = false;
			}else if(now == 2){
				items[1].num = new BigDecimal(str);
				cul();
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.MUL;
				str = "";
				now = 1;
				tenFlag = false;
				turnFlag = false;
			}
		}
		//除算ボタン
		if(e.getSource().equals(buttonDiv)) {
			if(now == 1) {
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.DIV;
				now = 2;
				str = "";
				tenFlag = false;
				turnFlag = false;
			}else if(now == 2){
				items[1].num = new BigDecimal(str);
				cul();
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.DIV;
				str = "";
				now = 1;
				tenFlag = false;
				turnFlag = false;
			}
		}
		//剰余ボタン
		if(e.getSource().equals(buttonRem)) {
			if(now == 1) {
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.REM;
				now = 2;
				str = "";
				tenFlag = false;
				turnFlag = false;
			}else if(now == 2){
				items[1].num = new BigDecimal(str);
				cul();
				items[0].num = new BigDecimal(str);
				items[1].sign = Item.REM;
				str = "";
				now = 1;
				tenFlag = false;
				turnFlag = false;
			}
		}
		//「＝」ボタン
		if(!eqlFlag) {
			if(e.getSource().equals(buttonEql)) { 
			    if(now == 2 || now == 1) {
			        items[1].num = new BigDecimal(str);
			        cul();
			        items[0].num = new BigDecimal(str);
			        eqlFlag = true;
			        now = 1;
			        tenFlag = false;
			        turnFlag = false;
			    }
			}
		}
		//「C」ボタン
		if(e.getSource().equals(buttonC)) {
			str = "";
			items[0].num = new BigDecimal(0);
			items[1].num = new BigDecimal(0);
			now = 1;
			eqlFlag=false;
			turnFlag=false;
			tenFlag = false;
		}
		text.setText(str);
	}
	
	/**
	 * 計算します
	 */
	void cul() {
		switch(items[1].sign) {
			case Item.ADD: result = items[0].num.add(items[1].num); break;//加算演算
			case Item.SUB: result = items[0].num.subtract(items[1].num); break;//減算演算
			case Item.MUL: result = items[0].num.multiply(items[1].num); break;//乗算演算
			case Item.DIV: result = items[0].num.divide(items[1].num, 10, BigDecimal.ROUND_HALF_UP); break;//除算演算
			case Item.REM: result = items[0].num.remainder(items[1].num); break;//剰余演算
		}
		str = String.valueOf(result);
	}
}