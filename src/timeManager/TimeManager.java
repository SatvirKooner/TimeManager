package timeManager;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("unused")
public class TimeManager extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1469369784860126401L;
	static JMenuBar MenuBar;
	static JMenu File ;
	static JMenuItem Exit ;
	static JMenu Tools;
	static JMenuItem ToolsCalc;
	JButton newTask ;
	JButton removeTask;
	JButton startTask;
	JButton stopTask;
	JButton Pause;
	JButton Resume;
	JButton StartCalculator;
	JTextField taskName;
	JTextField timeLeft;
	String[] Task = new String[20];
	String[] Time = new String[20];
	boolean listActivated = false;
	String[] Blank = new String[]{ "","","","","",""};
	int i =0 , x;
	JList<String> List = new JList<String>();
	ArrayList<String> Array = null; 
	String Serif = null;
	Timer timer = null;
	String durationString;
	int Duration;
	int count = 0;
	int hours= 0,minutes= 0,seconds= 0;
	String hoursString, minutesString,secondsString;
	Clip clip = null;
	
	TimeManager(){
		GridBagLayout l = new GridBagLayout();
		l.columnWidths = new int[] {90,90,80,90,90,90,90,80};
		l.rowHeights = new int[] {60 , 60,60,60,60,60,60, 60, 60,60};
		setLayout(l); 
		GridBagConstraints c = new GridBagConstraints();
		 c.insets= new Insets(10,10,10,10);
		newTask= new JButton("New Task"); 
		removeTask = new JButton("Remove Task");
		startTask = new JButton("Start Task");
		stopTask = new JButton("Stop Task");
		Pause = new JButton("Pause");
		StartCalculator = new JButton("Calculator");
		StartCalculator.setFont(new Font(Serif, Font.PLAIN, 30));
		StartCalculator.setForeground(Color.BLUE);
		Resume = new JButton("►");
		Resume.setFont(new Font(Serif,Font.PLAIN, 75));
		Resume.setForeground(Color.BLACK);
		Pause.setFont(new Font(Serif, Font.PLAIN, 40));
		Pause.setForeground(Color.BLACK);
		taskName = new JTextField("Task Name");
		taskName.setBackground(Color.LIGHT_GRAY);
		taskName.setHorizontalAlignment(SwingConstants.CENTER);
		taskName.setBorder(new EmptyBorder(10, 10, 10, 10));
		taskName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		taskName.setFont(new Font(Serif,Font.PLAIN, 30));
		taskName.setEditable(false);
		timeLeft = new JTextField("00:00:00");
		timeLeft.setBackground(Color.white);;
		timeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		timeLeft.setBorder(new EmptyBorder(10, 10, 10, 10));
		timeLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		timeLeft.setFont(new Font(Serif,Font.PLAIN, 50));
		timeLeft.setEditable(false);
				
		List.setVisibleRowCount(8);
		List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		List.setVisible(true);
		List.setFont(new Font("Arial",Font.PLAIN,18));
		List.setBackground(new Color(10,60,60));
		List.setForeground(Color.WHITE);

		
	
			timer = new Timer(1000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		seconds--;
		//minute to second converter
		if(seconds == 0 && minutes != 0){
			minutes--;
			seconds = 59;
		}
		//hour to minute converter
		if (seconds ==0 && minutes==0 && hours != 0){
			hours--;
			minutes=59;
			seconds=59;
		}
		if (seconds == 0 &&minutes ==0 && hours == 0)
		{
			timer.stop();
			try{
				URL url = this.getClass().getResource("Alien_AlarmDrum-KevanGC-893953959.wav");
		       AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		       clip = AudioSystem.getClip();
		       clip.open(audioIn);
		       clip.start();
				} 
				catch(Exception g){
					JOptionPane.showMessageDialog(null,"There was an error loading the sound!");
				}
			String timeover = "Time over";

			JOptionPane.showMessageDialog(null,"Time over!");
			clip.stop();
		}	
		if(seconds <10 && seconds >=0){
			secondsString =("0"+seconds);
		}
		else{
			secondsString=("" +seconds);
		}
		if(minutes <10 && seconds >=0){
			minutesString=("0"+minutes);
		}
		else{
			minutesString=("" +minutes);
		}
		if(hours <10 && seconds >=0){
			hoursString=("0"+hours);
		}
		else{
			hoursString=("" +hours);
		}
		timeLeft.setText(hoursString+":"+minutesString+":"+secondsString);
		} });
		

		
	

		setVisible(true);
		setOpaque(false);
	c.gridx = 0;
	c.gridy = 1;
	 c.fill = GridBagConstraints.BOTH;
	add(newTask, c);
	c.gridx = 1;
	c.gridy = 1;

	add(removeTask, c);
	c.gridx = 0;
	c.gridy = 9;
	add(startTask, c);
	c.gridx = 1;
	c.gridy = 9;
	add(stopTask, c);
	c.gridx = 2;
	c.gridy = 5;
	c.gridheight = 2;
	c.gridwidth =2;
	c.fill = GridBagConstraints.BOTH;
	add(Resume, c);
	c.gridx = 4;
	c.gridy= 5;
	add(Pause,c);
	c.gridx = 6;
	c.gridy= 5;
	add(StartCalculator,c);
	c.gridx = 2;
	c.gridy = 1;
	c.gridwidth = 6;
	c.gridheight = 2;
	c.fill = GridBagConstraints.BOTH;
	add(taskName, c);
	c.gridx = 2;
	c.gridy = 3;
	c.gridwidth = 6;
	c.gridheight = 2;
	c.fill = GridBagConstraints.BOTH;
	add(timeLeft, c);
	c.gridx = 0;
	c.gridy = 2;
	c.gridheight = 7;
	c.gridwidth = 2;
	c.anchor = GridBagConstraints.CENTER;
	   c.fill = GridBagConstraints.BOTH;
	add(new JScrollPane(List),c);
			removeTask.addActionListener(this);
			newTask.addActionListener(this);
			startTask.addActionListener(this);
			stopTask.addActionListener(this);
			Resume.addActionListener(this);
			Pause.addActionListener(this);
			StartCalculator.addActionListener(this);

			
	//if (listActivated == true);
	//	add(list);
	
	
	//	"http://i.imgur.com/BwyTam2.png"
		
	}
	public static void main(String[] args){
		startManager();
	}
	
	public static void startManager() {
		MenuBar = new JMenuBar();
		File = new JMenu("File");
		Tools = new JMenu("Tools");
		ToolsCalc = new JMenuItem("Calculator");
		Exit = new JMenuItem("Exit");
		JPanel p2 = new JPanel();
		JLabel jl = new JLabel();
		Dimension windowSize = new Dimension(600, 800);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//Icon tm = new ImageIcon("C:\\users\\purplecrayon\\workspace\\timeManager\\src\\timemanager.png");
		//jl.setIcon(tm);
		//bp.add(jl);
		JFrame f = new JFrame("Satvir's TimeManager ");
		f.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		jl.setLayout(new BorderLayout());
		URL url = null;
		try {
		//	url = new URL("http://i.imgur.com/BwyTam2.png");
			url = new TimeManager().getClass().getResource("timemanager1.1.png");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      //  System.out.println(url);
        try {
            BufferedImage image = ImageIO.read(url);
            jl.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();
        }

        p2.add(jl);
        f.add(p2);
		jl.add(new TimeManager());
	
		
		f.setJMenuBar(MenuBar);
		MenuBar.add(File);
		MenuBar.add(Tools);
		Tools.add(ToolsCalc);
		File.add(Exit);
		ToolsCalc.addActionListener(new TimeManager());
		Exit.addActionListener(new TimeManager());
		f.setSize(800,600);
		f.pack();
	//	f.add(bp);

		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);

		
	
		
 
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = List.getSelectedIndex();
	
		if (e.getSource().equals(Exit)){
			System.exit(0);
		}
		if(e.getSource().equals(ToolsCalc)){
			Calculator.startCalc();
		}
		if (e.getSource().equals(newTask)){
			if (i < 20){
			
			Task[i] = JOptionPane.showInputDialog("Enter a task. Maximium of 20." );
			i++;
			List.setListData(Task);
			}
			//Time[x] = JOptionPane.showInputDialog("How long would you like to work on this? (in minutes)" );
			//x++;
			
		}

		if (e.getSource().equals(removeTask)){		
		    if(index >= 0){ //Remove only if a particular item is selected
		    	if(List.getSelectedValue().equals(taskName.getText())){
			    	JOptionPane.showMessageDialog(this, "You must stop the task");	
			    	}
		    	else{
		    	Task[index] = null;
		    	List.setListData(Task);
		    	}
		    	}
		} 
		    
	
		if (e.getSource().equals(startTask)){
		//	if(!timer.isRunning() && !timeLeft.getText().equals("00:00:00")){
			//	startManager();
			//}
		
			if (!timer.isRunning()){
			if(index >= 0){
				hours = 0;
				minutes = 0;
				seconds = 0;
			durationString = JOptionPane.showInputDialog("How long would you like to work on this? (in minutes)");
			try {			
				int Duration = Integer.parseInt(durationString);
			
				if(Duration <1){
					JOptionPane.showMessageDialog(this, "A minimum time of 1 minute is required");
				}
				else{
				if (Duration > 1440){
					JOptionPane.showMessageDialog(this, "Please enter a value less than 1440!");
				}
				else{
					if(!Task[index].equals(taskName.getText())){
						taskName.setText(List.getSelectedValue());}
				if(Duration == 1){
					seconds= 59;
					minutes = 0;	
					//timer.start();
				}
				if(Duration <=60 && Duration > 1){
					seconds = 59;
					minutes= Duration -1;
					//timer.start();					
				}
				if(Duration < 1440 || Duration == 1440 && Duration >60){
				while (Duration > 60) {
						hours++; 
						Duration-=60;
					
				};
				minutes=Duration;
				minutes --;
				seconds = 59;

				}	
			if(seconds <10 && seconds >=0){
				secondsString =("0"+seconds);
			}
			else{
				secondsString=("" +seconds);
			}
			if(minutes <10 && seconds >=0){
				minutesString=("0"+minutes);
			}
			else{
				minutesString=("" +minutes);
			}
			if(hours <10 && seconds >=0){
				hoursString=("0"+hours);
			}
			else{
				hoursString=("" +hours);
			}
			timeLeft.setText(hoursString+":"+minutesString+":"+secondsString);
			
			timer.start();
			}}
			}
		
			
			
			catch (Exception f){
				JOptionPane.showMessageDialog(this, "Only numbers please(whole numbers greater than 0)!");
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "No tasks selected!");
			}
			}
			else {
				JOptionPane.showMessageDialog(this, "A task is already running, please stop it to continue!");
			}
			}
	if(e.getSource().equals(stopTask)){
		if(!timeLeft.getText().equals("00:00:00")){
		int yes = JOptionPane.showConfirmDialog(this, "This will reset the task! Do you want to continue?");
		if (yes ==0){
		//	if(timer.isRunning()){
				timer.stop();
			timeLeft.setText("00:00:00");
			taskName.setText("Task Name");
			seconds= 0;
			minutes= 0;
			hours = 0;
			JOptionPane.showMessageDialog(this,"Task Stopped");
			}}
		else{
			JOptionPane.showMessageDialog(this, "No task to stop!");
		}
			}
	if(e.getSource().equals(Pause)){
		if(!timeLeft.getText().equals("00:00:00")){
		timer.stop();
		JOptionPane.showMessageDialog(this, "Timer Paused!");
		}
		}
	if(e.getSource().equals(Resume)){
		if (!timeLeft.getText().equals("00:00:00")){
		timer.start();
		JOptionPane.showMessageDialog(this, "Timer started!");
	}
		}
	if(e.getSource().equals(StartCalculator)){
	Calculator.startCalc();
	}
	}
	}
