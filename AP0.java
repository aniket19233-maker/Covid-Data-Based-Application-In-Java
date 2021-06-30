import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;


public class AP0 {

	
	class Patient
	{
		String Name;
		int Age;
		char Tower;
		String DateofReporting;
		String RecoveryDate;
		
		public Patient()
		{
			this.Name=null;
			this.Age=0;
			this.Tower='$';
			this.DateofReporting = null;
			this.RecoveryDate=null;
		}
		
		public Patient(String Name,int Age,char Tower,String DateofReporting,String RecoveryDate)
		{
			this.Name=Name;
			this.Age=Age;
			this.Tower=Tower;
			this.DateofReporting=DateofReporting;
			this.RecoveryDate=RecoveryDate;
		}
		
		char getTower()
		{
			return this.Tower;
		}
		
		int getAge()
		{
			return this.Age;
		}
		
		String getName()
		{
			return this.Name;
		}
		
		String getReportingDate()
		{
			return this.DateofReporting;
		}
		
		String getRecoveryDate()
		{
			return this.RecoveryDate;
		}
		String InfoString()
		{
			return Name+" "+String.valueOf(Age)+" "+getReportingDate()+" "+getRecoveryDate()+"\n";
		}
		
	}
	
	class PatientData
	{
		ArrayList<Patient> patientInfo;
		HashMap<String,ArrayList<Patient>> reporting;
		HashMap<String,Integer> recovered;
		int total_active_cases;
		int total_recovered_cases;
		
		public PatientData()
		{
			 this.patientInfo= new ArrayList<Patient>();
			 this.reporting = new HashMap<String, ArrayList<Patient>>();
			 this.recovered= new HashMap<String, Integer>();
			 initializeData();
			 OrderData();
			 this.total_active_cases=patientInfo.size();
			 this.total_recovered_cases=0;
		}
		
		void setData(String Name,int Age, char Tower, String DateofReporting,String RecoveryDate)
		{
			patientInfo.add(new Patient(Name,Age,Tower,DateofReporting,RecoveryDate));
		}
		
		void addNewPatient(String Name,int Age, char Tower, String DateofReporting,String RecoveryDate)
		{
			setData(Name, Age, Tower, DateofReporting, RecoveryDate);
		}
		
		void OrderData()
		{
			for(Patient p:patientInfo)
			{
				if(!reporting.containsKey(p.DateofReporting))
				{
					ArrayList<Patient> list= new ArrayList<Patient>();
					list.add(p);
					reporting.put(p.DateofReporting, list);
				}
				else
				{
					reporting.get(p.DateofReporting).add(p);
				}
				
				if(!recovered.containsKey(p.RecoveryDate))
				{
					recovered.put(p.RecoveryDate, 1);
				}
				else
				{
					int count=recovered.get(p.RecoveryDate);
					recovered.replace(p.RecoveryDate,count ,count+1);
				}
			}
		}
		
		void initializeData()
		{
			addNewPatient("Flora",   6,  'A', "01/04/2020", "21/04/2020");
			addNewPatient("Denys",   24, 'B', "01/04/2020", "21/04/2020");
			addNewPatient("Jim",     42, 'C', "18/05/2020", "07/06/2020");
			addNewPatient("Hazel",   87, 'D', "23/06/2020", "13/07/2020");
			addNewPatient("Caery",   72, 'A', "01/06/2020", "21/06/2020");
			addNewPatient("David",   7,  'B', "14/06/2020", "4/07/20200");
			addNewPatient("Kevim",   37, 'D', "05/06/2020", "25/04/2020");
			addNewPatient("Tom",     67, 'D', "20/06/2020", "10/07/2020");
			addNewPatient("Bob",     74, 'A', "04/07/2020", "24/07/2020");
			addNewPatient("Rachel",  48, 'C', "24/07/2020", "13/08/2020");
			addNewPatient("Thomas",  21, 'C', "11/06/2020", "01/07/2020");
			addNewPatient("Mary",    17, 'D', "21/06/2020", "11/07/2020");
			addNewPatient("Smith",   89, 'A', "07/08/2020", "27/08/2020");
			addNewPatient("Pearson",  6, 'B', "04/06/2020", "24/06/2020");
			addNewPatient("Anderson",62, 'B', "27/07/2020", "16/08/2020");
			addNewPatient("Johnson", 10, 'D', "01/08/2020", "21/08/2020");
			addNewPatient("Robertz", 50, 'A', "09/08/2020", "29/08/2020");
			addNewPatient("Julie",   86, 'B', "02/05/2020", "22/05/2020");
			addNewPatient("Edith",   42, 'D', "07/06/2020", "27/06/2020");
			addNewPatient("John",    95, 'D', "01/06/2020", "21/06/2020");
		}
		
		int findActiveCases(String date)
		{
			return (reporting.containsKey(date)?reporting.get(date).size():0);
		}
		
		int findRecoveredCases(String Date)
		{
			return recovered.get(Date);
		}
		
		ArrayList<Patient> getPatientsInTower(String tower)
		{
			ArrayList<Patient> list= new ArrayList<Patient>();
			for(Patient p:patientInfo)
			{
				if(p.getTower()==tower.charAt(0))
					list.add(p);
			}
			return list;
		}
		ArrayList<Patient> getPatientsReported(String Date)
		{
			ArrayList<Patient> list= new ArrayList<Patient>();
			for(Patient p:patientInfo)
			{
				if(p.getReportingDate().equals(Date))
					list.add(p);
			}
			return list;
		}
		ArrayList<Patient> getPatientsRecovered(String Date)
		{
			ArrayList<Patient> list= new ArrayList<Patient>();
			for(Patient p:patientInfo)
			{
				if(p.getRecoveryDate().equals(Date))
					list.add(p);
			}
			return list;
		}
		ArrayList<Patient> getAgedPatients(int age)
		{
			ArrayList<Patient> list= new ArrayList<Patient>();
			for(Patient p:patientInfo)
			{
				if(p.getAge()==age)
					list.add(p);
			}
			return list;
		}
	}
	
	PatientData patInfo;
	JFrame frame;
	JButton tower_btn;
	JButton date_report_btn;
	JButton date_recover_btn;
	JButton age_button;
	JButton Report_Submit_btn;
	JButton Recover_Submit_btn;
	JButton Age_Submit_btn;
	JTextArea area;
	Font font;
	Color color;
	JTextArea active_cases;
	JTextArea recovered_cases;
	JFrame tower_frame;
	JFrame date_report_frame;
	JFrame date_recover_frame;
	JFrame age_frame;
	String column_headers[]= {" NAME ","AGE ","REPORTING DATE ","RECOVERING DATE "};
	String data[][]= new String[100][4];
	
	public AP0()
	{
		this.patInfo = new PatientData();
		this.getMainWindow();
		this.getTowerWindow();
		this.getDateReportedWindow();
		this.getDateRecoveredWindow();
		this.getAgeWindow();
		this.getFromTower();
		this.getCasesDateReported();
		this.getCasesRecovered();
		this.getFromAge();
	}
	
	void getMainWindow()
	{
		this.frame= new JFrame();
		this.setMainWindowText();
		this.createTowerBtn();
		this.createDateReportBtn();
		this.createDateRecoverBtn();
		this.createAgeBtn();
		this.frame.setBounds(20, 155, 600, 400);
		this.addComponents(this.frame, new Component[]{active_cases,recovered_cases,area});
		this.WindowSetup(this.frame, 400, 500, true,null);
	}
	
	void getTowerWindow()
	{
		this.tower_frame=new JFrame();
		this.tower_frame.setBounds(20, 155, 600, 400);
		this.tower_frame.getContentPane().setBackground(color);
	}
	
	void getDateReportedWindow()
	{
		this.date_report_frame= new JFrame();
		this.date_report_frame.setBounds(20, 155, 600, 400);
		this.date_report_frame.getContentPane().setBackground(color);
		this.createReportSubmitBtn();
	}
	
	void getDateRecoveredWindow()
	{
		this.date_recover_frame= new JFrame();
		this.date_recover_frame.setBounds(20, 155, 600, 400);
		this.date_recover_frame.getContentPane().setBackground(color);
		this.createRecoverSubmitBtn();
	}
	
	void getAgeWindow()
	{
		this.age_frame= new JFrame();
		this.age_frame.setBounds(20, 155, 600, 400);
		this.age_frame.getContentPane().setBackground(color);
		this.createAgeSubmitBtn();
	}
	
	void createTowerBtn()
	{
		this.tower_btn= new JButton("Tower");
		this.tower_btn.setBounds(20, 155, 80, 20);
		this.frame.add(tower_btn);
	}
	
	void createDateReportBtn()
	{
		this.date_report_btn= new JButton("Reporting Date");
		this.date_report_btn.setBounds(120, 155, 160, 20);
		this.frame.add(date_report_btn);
	}
	
	void createDateRecoverBtn()
	{
		this.date_recover_btn= new JButton("Recovery Date");
		this.date_recover_btn.setBounds(290, 155, 160, 20);
		this.frame.add(date_recover_btn);
	}
	
	void createAgeBtn()
	{
		this.age_button= new JButton("Age");
		this.age_button.setBounds(460, 155, 160, 20);
		this.frame.add(age_button);
	}
	
	void createReportSubmitBtn()
	{
		this.Report_Submit_btn= new JButton(" Submit ");
		this.Report_Submit_btn.setBounds(200, 300, 140, 30);
		this.date_report_frame.add(Report_Submit_btn);
	}
	
	void createRecoverSubmitBtn()
	{
		this.Recover_Submit_btn= new JButton(" Submit ");
		this.Recover_Submit_btn.setBounds(200, 300, 140, 30);
		this.date_recover_frame.add(Recover_Submit_btn);
	}
	
	void createAgeSubmitBtn()
	{
		this.Age_Submit_btn= new JButton(" Submit ");
		this.Age_Submit_btn.setBounds(200, 300, 140, 30);
		this.age_frame.add(Age_Submit_btn);
	}

	void setMainWindowText()
	{
		this.color=new Color(150,255,200); 
		this.frame.getContentPane().setBackground(color);
		this.area=this.CreateTextArea("  WELCOME TO COVID-19 DATA MANAGER  ",140,255,450,50);
		this.font = new Font("Segoe Script", Font.BOLD, 20);
		this.area.setFont(font);
		this.active_cases=this.CreateTextArea("  Active Cases: "+" "+String.valueOf(patInfo.total_active_cases),140, 355, 150, 50);
		this.recovered_cases=this.CreateTextArea("  Recovered Cases: "+" "+String.valueOf(patInfo.total_recovered_cases),340, 355, 150, 50);
		this.area.setEditable(false);
	}
	
	void getFromTower()
	{
		JCheckBox cb1=new JCheckBox("A"),cb2= new JCheckBox("B"),cb3=new JCheckBox("C"),cb4=new JCheckBox("D");
		JLabel I=createLabel("Choose a Tower",50,50,300,20);
		Component chbxes[]= {cb1, cb2, cb3, cb4,I,active_cases,recovered_cases};
		this.setTowerButtontoControl(tower_btn, chbxes, tower_frame, frame);
	}
	
	void getCasesDateReported()
	{
		JTextField[] tf= {createTextField(200, 200, 30, 30),createTextField(240, 200, 30, 30),createTextField(280, 200, 50, 30)};
		this.date_report_btn.addActionListener(e->{this.frame.dispose();
		this.addComponents(this.date_report_frame, tf);
		this.addComponents(this.date_report_frame, new Component[]{createLabel(" ENTER THE DATE IN DD/MM/YYYY FORMAT: ",150,150,300,20)});
		this.setDateReportButtontoControl(date_report_btn, tf, date_report_frame, frame);
		this.WindowSetup(this.date_report_frame, 400, 500, true,null);});
	}
	
	void getCasesRecovered()
	{
		JTextField[] tf= {createTextField(200, 200, 30, 30),createTextField(240, 200, 30, 30),createTextField(280, 200, 50, 30)};
		this.date_recover_btn.addActionListener(e->{this.frame.dispose();
		this.addComponents(this.date_recover_frame, tf);
		this.addComponents(this.date_recover_frame, new Component[]{createLabel(" ENTER THE DATE IN DD/MM/YYYY FORMAT: ",150,150,300,20)});
		this.setDateRecoverButtontoControl(date_recover_btn, tf, date_recover_frame, frame);
		this.WindowSetup(this.date_recover_frame, 400, 500, true,null);});
	}
	
	void getFromAge()
	{
		JTextField []tf= {createTextField(200, 200, 35, 30)};
		this.age_button.addActionListener(e->{this.frame.dispose();
		this.addComponents(this.age_frame, tf);
		this.addComponents(this.age_frame, new Component[]{createLabel(" ENTER THE AGE : ",150,150,300,20)});
		this.setAgeButtontoControl(age_button,tf , age_frame, frame);
		this.WindowSetup(this.age_frame, 400, 500, true,null);});
	}
	
	void openDetailsofTower(JCheckBox cb1,JCheckBox cb2,JCheckBox cb3,JCheckBox cb4)
	{
		this.openFrameFromCheckBox(cb1);this.openFrameFromCheckBox(cb2);
		this.openFrameFromCheckBox(cb3);this.openFrameFromCheckBox(cb4);
	}
	
	void openFrameFromCheckBox(JCheckBox cb)
	{
		cb.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
                  if(e.getStateChange()==1)
                  {
                	  JFrame f= new JFrame();
                	  String tow =cb.getText();
                	  JTable t= fillDataInTable(patInfo.getPatientsInTower(tow),f);
                	  t.setVisible(true);
                	  WindowSetup(f, 400, 500, true,t);
                	  tower_frame.dispose();
                  }
     }});}
	
	void setTowerButtontoControl(JButton b,Component comp[],JFrame work,JFrame toClose)
	{
		this.tower_btn.addActionListener(e->{this.frame.dispose();
		this.AllignCheckBoxes((JCheckBox)comp[0], (JCheckBox)comp[1], (JCheckBox)comp[2], (JCheckBox)comp[3]);
		this.openDetailsofTower((JCheckBox)comp[0], (JCheckBox)comp[1], (JCheckBox)comp[2],(JCheckBox)comp[3]);
		this.addComponents(this.tower_frame, comp);
		this.WindowSetup(this.tower_frame, 400, 500, true,null);});
	}
	
	void setDateReportButtontoControl(JButton b,JTextField comp[],JFrame work,JFrame toClose)
	{
			this.Report_Submit_btn.addActionListener(e->{this.date_report_frame.dispose();
			ArrayList<Patient> p= patInfo.getPatientsReported(this.formDate(comp));
			JFrame details= new JFrame(String.valueOf(p.size())+" Cases were Found on "+this.formDate(comp));
			JTable ta= this.fillDataInTable(patInfo.getPatientsReported(this.formDate(comp)), details);
			this.WindowSetup(details, 400, 500, true,ta);});
	}
	
	void setDateRecoverButtontoControl(JButton b,JTextField comp[],JFrame work,JFrame toClose)
	{
		this.Recover_Submit_btn.addActionListener(e->{this.date_recover_frame.dispose();
		ArrayList<Patient> p= patInfo.getPatientsRecovered(this.formDate(comp));
		JFrame details= new JFrame(String.valueOf(p.size())+" Cases were Found on "+this.formDate(comp));
		JTable ta= this.fillDataInTable(patInfo.getPatientsRecovered(this.formDate(comp)), details);
		this.WindowSetup(details, 400, 500, true,ta);});
	}
	
	void setAgeButtontoControl(JButton b,JTextField comp[],JFrame work,JFrame toClose)
	{
		this.Age_Submit_btn.addActionListener(e->{this.age_frame.dispose();
		ArrayList<Patient> p= patInfo.getAgedPatients(Integer.parseInt(comp[0].getText()));
		JFrame details= new JFrame(String.valueOf(p.size())+" Cases were Found of Age "+comp[0].getText());
		JTable ta= this.fillDataInTable(patInfo.getAgedPatients(Integer.parseInt(comp[0].getText())), details);
		this.WindowSetup(details, 400, 500, true,ta);
		});
	}
	
	void AllignCheckBoxes(JCheckBox cb1,JCheckBox cb2,JCheckBox cb3,JCheckBox cb4)
	{
		cb1.setBounds(100,100,150,20);
		cb2.setBounds(100,150,150,20); 
		cb3.setBounds(100,200,150,20);
		cb4.setBounds(100,250,150,20);
	}
	
	void addComponents(JFrame fr,Component l[])
	{
		for(int i=0;i<l.length;i++)
			fr.add((Component) l[i]);
	}
	
	void WindowSetup(JFrame fr,int width,int height,boolean visible,JTable ta)
	{
		fr.setSize(width, height);
		fr.setLayout(null);
		fr.setVisible(true);
		if(ta!=null)
			fr.add(ta);
	}
	
	JTextArea CreateTextArea(String s,int x,int y,int w,int h)
	{
		JTextArea ta= new JTextArea();
		ta = new JTextArea();
		ta.setBounds(x, y, w, h);
		ta.setText(s);
		ta.setEditable(false);
		return ta;
	}
	
	JLabel createLabel(String s,int x,int y,int w,int h)
	{
		JLabel I= new JLabel(s);
		I.setBounds(x,y,w,h);
		return I;
	}
	
	JTextField createTextField(int x,int y,int w,int h)
	{
		JTextField tf= new JTextField();
		tf.setBounds(x, y, w, h);
		return tf;
	}
	
	String formDate(JTextField[] tf)
	{
		return tf[0].getText()+"/"+tf[1].getText()+"/"+tf[2].getText();
	}
	
	JTable fillDataInTable(ArrayList<Patient> p,JFrame f)
	{
		this.clear_Data(); 
		for(int i=0;i<4;i++)
			this.data[0][i]=this.column_headers[i];
		for(int i=0;i<p.size();i++)
		{
			this.data[i+1][0]=p.get(i).getName();
			this.data[i+1][1]=String.valueOf(p.get(i).getAge());
			this.data[i+1][2]=p.get(i).getReportingDate();
			this.data[i+1][3]=p.get(i).getRecoveryDate();
		}
		JTable table= new JTable(this.data,this.column_headers);
		table.setSize(600, 400);
		JScrollPane sp=new JScrollPane(table);
		return table;
	}
	void clear_Data()
	{
		for(int i=1;i<this.data.length;i++)
			this.data[i][0]=this.data[i][1]=this.data[i][2]=this.data[i][3]="";
	}
	
	public static void main(String[] args) {
		
		AP0 obj= new AP0();
		
	}

}
