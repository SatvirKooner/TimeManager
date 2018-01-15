package timeManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Calculator extends JPanel implements ActionListener, KeyListener{
	
	 JButton ADD;
	 JButton MINUS;
	 JButton MULTIPLY;
	 JButton DIVIDE;
	 JButton EQUALS;
	 JButton DECIMAL;
	 JButton PLUSMINUS;
	 JButton CLEAR;
	 double num2,ans;
	 int INTans;
	double num1 = 1337.133700000013370001337;
	 int number;
	 String STRINGnum1;
	 String STRINGnum2;
	 Boolean Point;
	 String testNum;
	 URL url = null;
	private static final long serialVersionUID = 6578519747084018994L;

    int num;
	JButton[] ClickButtons = new JButton[10];
	JTextField Field = new JTextField();
	String zero = "0.0";
	
Calculator(){

	 GridBagLayout l;
		
		
		 String Serif = null;
		 
		l = new GridBagLayout();
		l.columnWidths = new int[] {88, 88 ,88 ,88};
		l.rowHeights = new int [] {88,88,88,88,88,88};
		setLayout(l);
		
		int[][] ButtonConstraints = new int[][]{
				{0,5,2,1},
				{0,4,1,1},
				{1,4,1,1},
				{2,4,1,1},
				{0,3,1,1},
				{1,3,1,1},
				{2,3,1,1},
				{0,2,1,1},
				{1,2,1,1},
				{2,2,1,1},
			
		};
		
		
	EQUALS = new JButton("=");
	
		GridBagConstraints c = new GridBagConstraints();
				
		
		for (int i = 0; i < ClickButtons.length;i++){
			ClickButtons[i] = new JButton("" + i);
			ClickButtons[i].addActionListener(this);
			ClickButtons[i].addKeyListener(this);
			c.gridx = ButtonConstraints[i][0];
			c.gridy = ButtonConstraints[i][1];
			c.gridwidth = ButtonConstraints[i][2];
			c.gridheight = ButtonConstraints[i][3];
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(2,2,2,2);
			add(ClickButtons[i], c);
		}
		
	PLUSMINUS = new JButton("+/-");
	CLEAR = new JButton("C");
	ADD= new JButton("+");
	MINUS= new JButton("-");
	DIVIDE= new JButton("÷");
	EQUALS = new JButton("=");
	DECIMAL = new JButton(".");
	MULTIPLY = new JButton("x");
	c.gridx = 3;
	c.gridy = 3;
	add(ADD,c);
	c.gridx = 3;
	c.gridy = 2;
	add(MINUS, c);
	c.gridx= 3;
	c.gridy = 1;
	add(MULTIPLY, c);
	c.gridx = 2;
	c.gridy = 1;
	add(DIVIDE,c);
	c.gridx = 1;
	c.gridy = 1;
	add(PLUSMINUS, c);
	c.gridx = 0;
	c.gridy = 1;
	add(CLEAR,c);
	c.gridx= 2;
	c.gridy= 5;
	add(DECIMAL,c);
	c.gridx= 3;
	c.gridy =4;
	c.gridheight =2;
	add(EQUALS,c);
	//c.gridx=0;
	//c.gridy = 0;
	//c.gridwidth =4;
	//c.gridheight =1;
	//p.add(Field,c);
	
	//gridx = 3;
	//gridy= 4;
	//gridheight =2;
	//gridwidth = 1;
	//add(EQUALS,c);
	CLEAR.addActionListener(this);
	PLUSMINUS.addActionListener(this);
	DECIMAL.addActionListener(this);
	ADD.addActionListener(this);
	MINUS.addActionListener(this);
	MULTIPLY.addActionListener(this);
	DIVIDE.addActionListener(this);
	EQUALS.addActionListener(this);
	CLEAR.addKeyListener(this);
	PLUSMINUS.addKeyListener(this);
	DECIMAL.addKeyListener(this);
	ADD.addKeyListener(this);
	MINUS.addKeyListener(this);
	MULTIPLY.addKeyListener(this);
	DIVIDE.addKeyListener(this);
	EQUALS.addKeyListener(this);
	
	Field.setOpaque(true);
	Field.setBackground(Color.WHITE);
	Field.setHorizontalAlignment(SwingConstants.RIGHT);
	Field.setBorder(new EmptyBorder(10, 10, 10, 10));
	Field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	Field.setFont(new Font(Serif,Font.PLAIN, 30));
	Field.setEditable(false);
	Field.setText(zero);
	Field.addKeyListener(this);
	c.gridx=0;
	c.gridy=0;
	c.gridheight=1;
	c.gridwidth=4;
	add(Field,c);
	addKeyListener(this);

	setBackground(Color.cyan);
	


	}

	
	public static void startCalc(){

		JFrame f = new JFrame("Satvir's Calculator");
		f.setSize(360,540);
		f.add(new Calculator());
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.addKeyListener(new Calculator());

		
		
}

	
		
	public void getTimeManagerBackground(){
		url = this.getClass().getResource("timemanager.png");
	}
	public void clickbuttons(int num){
		ClickButtons[num].doClick();
	}
	public void clickplus(){
		ADD.doClick();
	}
	
	public void clickMINUS(){
		MINUS.doClick();
	}  
	
	public void clickMULTIPLY(){
		MULTIPLY.doClick();
	}  
		
	public void clickDIVIDE(){
		DIVIDE.doClick();
	}  
		
	public void clickDECIMAL(){
		DECIMAL.doClick();
	}  
		
	public void clickCLEAR(){
		CLEAR.doClick();
	}  
		
	public void clickEQUALS(){
		EQUALS.doClick();
	}  
		
	public void clickPLUSMINUS(){
		PLUSMINUS.doClick();
	}  
		
		
	


	
	public void actionPerformed(ActionEvent e){
		if (!Field.getText().contains("-") && !Field.getText().contains("x") && !Field.getText().contains("+") && !Field.getText().contains("÷")){

		if (e.getSource() == ADD){
			num1 = Double.parseDouble(Field.getText());
			number = 1; 
			Field.setText(""+ num1 +" + ");

		}
		if (e.getSource() == MINUS){
	
			num1 = Double.parseDouble(Field.getText());
			number = 2;
			Field.setText(""+ num1 + " - ");
		}
		if (e.getSource() == MULTIPLY){
			num1 = Double.parseDouble(Field.getText());
			number = 3;
			Field.setText(""+ num1 +" x ");
		}
		if (e.getSource() == DIVIDE){
			num1 = Double.parseDouble(Field.getText());
			number = 4;
			Field.setText(""+ num1 +" ÷ ");
		}} else if(Field.getText().contains("-")) {

			if (e.getSource() == ADD){
				num1 = Double.parseDouble(Field.getText());
				number = 1; 
				Field.setText(""+ num1 +" + ");

			}
			if (e.getSource() == MINUS){
		
				num1 = Double.parseDouble(Field.getText());
				number = 2;
				Field.setText(""+ num1 + " - ");
			}
			if (e.getSource() == MULTIPLY){
				num1 = Double.parseDouble(Field.getText());
				number = 3;
				Field.setText(""+ num1 +" x ");
			}
			if (e.getSource() == DIVIDE){
				num1 = Double.parseDouble(Field.getText());
				number = 4;
				Field.setText(""+ num1 +" ÷ ");
			}
			
		}
		if (e.getSource() == EQUALS ){
			if (Field.getText().equals(zero))
				return;
		if (num1 != 1337.133700000013370001337 )	{
			String FNUM=(""+num1);
			STRINGnum2 = Field.getText();
			STRINGnum2 = STRINGnum2.replace(" + ", "");
			STRINGnum2 = STRINGnum2.replace(" - ", "");
			STRINGnum2 = STRINGnum2.replace(" x ", "");
			STRINGnum2 = STRINGnum2.replace(" ÷ ", "");
			STRINGnum2 = STRINGnum2.replace(FNUM, "");
		num2 = Double.parseDouble(STRINGnum2);
		if (num2 == 0){
			try{
				System.out.println("num is 0");
			num1 = Double.parseDouble(Field.getText());
		} 
			catch(Exception g){
			
			}
			}
		if (number == 1){
			ans = num1 + num2;
		} else if (number == 2){
			ans = num1 - num2;
		}else if (number == 3){
			ans = num1 * num2;
		} else if (number == 4){
			ans = num1 / num2;
		}
		else if (number == 0){
		}
		STRINGnum1 =(""+ans);
		number = 0;
		num1 = 0; num2 = 0;
		if (STRINGnum1.contains(".")){
		number=0;
		Field.setText(""+ ans);
		num1 = 0; num2 = 0;
		}
		else{
			Field.setText(""+ Double.parseDouble(STRINGnum1));
		}
		}}
		if (e.getSource() == PLUSMINUS ) {
			if (Field.getText().equals(zero)){
				JOptionPane.showMessageDialog(null, "Cannot have negative 0 ");
			}
			else{
				if (Field.getText().contains(".")){
			Field.setText(""+ (-1 * Double.parseDouble(Field.getText())));
			}
				else if (!Field.getText().contains(".")){
					Field.setText(""+ (-1 * Integer.parseInt(Field.getText())));
					}
		}}
		for(int i =0;  i < ClickButtons.length;i++){
			if (e.getSource() == ClickButtons[i]){
				if(Field.getText().equals(zero)){
				Field.setText( i + "");			
			}
			else {
				Field.setText(Field.getText() + i );		
			}
			}
			if (e.getSource() == CLEAR ){
				Field.setText(zero);
	
			}
			String testNum = (""+num1);
			if (e.getSource() == DECIMAL && !Field.getText().contains(".") ){
				Field.setText(Field.getText() + ".");
			}  
			
			if ((e.getSource() == DECIMAL )){
				String FieldText = (Field.getText());
				FieldText = FieldText.replace(testNum, "");
		if (!FieldText.contains(".")){
			String CFieldText = (FieldText);
			CFieldText = CFieldText.replace("+", "");
			CFieldText = CFieldText.replace("-", "");
			CFieldText = CFieldText.replace("x", "");
			CFieldText = CFieldText.replace("÷", "");
					
			try{
				Double.parseDouble(CFieldText);
				Field.setText(Field.getText()+".");
				
			}
			catch(Exception f){
				if (!Field.getText().equals(zero)){
				Field.setText(Field.getText()+"0.");
			}}
		}
		String Zero1 = Field.getText();
		Zero1.replace(" + ","");
		Zero1.replace(" - ","");
		Zero1.replace(" x ","");
		Zero1.replace(" ÷ ","");
				
		if (Zero1.equals("0.0")){
			Field.setText("0.");
		}
			}

		}}


	@Override
	public void keyPressed(KeyEvent e) {
		int keyint = e.getKeyCode();
		char k = e.getKeyChar();
		
		//System.out.println(k);
		if (k == '0'){
			clickbuttons(0);
			}
		if (k == '1'){
			clickbuttons(1);
			}
		if (k == '2'){
			clickbuttons(2);
			}
		if (k == '3'){
			clickbuttons(3);
			}
		if (k == '4'){
			clickbuttons(4);
			}
		if (k == '5'){
			clickbuttons(5);
			}
		if (k == '6'){
			clickbuttons(6);
			}
		if (k == '7'){
			clickbuttons(7);
			}
		if (k == '8'){
			clickbuttons(8);
			}
		if (k == '9'){
			clickbuttons(9);
			}
		if (keyint == 106 || k == '*'){
			clickMULTIPLY();
		}
		if (keyint == 107 || k == '+'){
			clickplus();
		}
		if (keyint == 111 || k == '/'){
			clickDIVIDE();
		}
		if (keyint == 109 || k == '-'){
			clickMINUS();
		}
		if (keyint == 110|| k == '.'){
			clickDECIMAL();
		}
		if (keyint == 67){
			clickCLEAR();
		}
		if (keyint == 10 || k == '='){
			clickEQUALS();
		}
	

		}
		
		
				
	


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//char k = e.getKeyChar();
		//System.out.println(k);
	}

}




		
	

