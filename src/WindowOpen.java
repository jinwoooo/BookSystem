/* ���� �����Ģ
 *
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


//import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.io.*;


class WindowOpen extends JFrame implements ActionListener{


		
	private AuthorList[] authorcatalog = new AuthorList[(int)('Z'+1)];
	// |A|B|C|D|E|...|X|Y|Z| 
	private BookList[] titlecatalog =  new BookList[(int)('Z'+1)];
	// |A|B|C|D|E|...|X|Y|Z| 
	private PatronList[] people = new PatronList[(int)('Z'+1)];
	// |A|B|C|D|E|...|X|Y|Z| 

	
	
/* �������� : ������ ���̺� �� �߰�/������ ���� DefaultTableModel�� �̿�. �ش� ������
 * 			�̰����� new �������� ������ �Ұ����� �������� �־� �����ڿ� InitVariables()
 * 			�Լ��� ���� ����. �׿� �����Ǵ� JTable, JScrollPane �� ��¿�� ���� ���� �Լ�����
 * 			�ʱ�ȭ.
 * 
 */
	
	private JPanel P_Menu = new JPanel(); // ��� �޴� ��������
		private JPanel P_Menu_Add = new JPanel();
		private JButton B_Menu_Add = new JButton("å �߰��ϱ�"); // �߰���ư
		private JPanel P_Menu_Patron = new JPanel();
		private JButton B_Menu_Patron = new JButton("å �����ϱ�"); // �����ư
		private JPanel P_Menu_Return = new JPanel();
		private JButton B_Menu_Return = new JButton("å �ݳ��ϱ�"); // �ݳ���ư
		private JPanel P_Menu_Search = new JPanel();
		private JButton B_Menu_Search = new JButton("å �˻��ϱ�"); // �˻���ư
		private JPanel P_Menu_Exit = new JPanel();
		private JButton B_Menu_Exit = new JButton("���α׷�����"); // ���α׷� �����ư
		private JPanel P_Menu_Save = new JPanel();
		private JButton B_Menu_Save = new JButton("�ڷ������ϱ�"); // �ڷ� �����ϱ�
		
	private JPanel P_Main = new JPanel(); // �ϴ� ���� ������
		private JPanel P_Main_Table = new JPanel(); // �ϴ� �����Ͱ� ǥ�õ� �κ�
			private DefaultTableModel DTB_Common;
			private String[] Table_Column = {"å �� ��",
	                "�� �� ��",
	                "�� �� ��"};
			private JTable Table_Common;
			private JScrollPane SP_Table_Common;
		
		private JPanel P_Main_Buttons = new JPanel(); // �ϴ� �Է��ʵ�� ��ư�� ��Ÿ�� ��
	
			private JPanel P_Addbook = new JPanel(); // "�߰�"Ŭ���� ��Ÿ�� �г� (�ϴ� ���� �����ӿ� �� Sub �г�)
				private JPanel P_Addbook_1 = new JPanel();
					//private JLabel L_Addbook_bookTitle = new JLabel(); // å���� ��
					private JTextField T_Addbook_bookTitle = new JTextField(12); // å���� �Է��ʵ�
				private JPanel P_Addbook_2 = new JPanel();	
					//private JLabel L_Addbook_bookAuthor = new JLabel(); // ���ڸ� ��
					private JTextField T_Addbook_bookAuthor = new JTextField(12); // ���ڸ� �Է��ʵ�
				private JPanel P_Addbook_3 = new JPanel();
					private JButton B_Addbook_Add = new JButton("��          ��"); // ���� ��ư
	
		
	
	//List<String[]> Table_Data = new ArrayList<String[]>();
	//String[][] Table_Data_Str;
	//private String[][] Data_Patron =
	//private String[][] Data_Return =
	//private String[][] Data_Search =
		
			
	private JPanel P_Patron = new JPanel(); // "����"Ŭ���� ��Ÿ�� �г� (�ϴ� ���� �����ӿ� �� Sub �г�)
		private JPanel P_Patron_1 = new JPanel();
			private JTextField T_Patron_bookPatroner = new JTextField(12); // ������ �Է��ʵ�
		private JPanel P_Patron_2 = new JPanel();
			private JTextField T_Patron_bookAuthor = new JTextField(12); // ���ڸ� �Է��ʵ�
		private JPanel P_Patron_3 = new JPanel();
			private JTextField T_Patron_bookTitle = new JTextField(12); // å���� �Է��ʵ�
		private JPanel P_Patron_4 = new JPanel();
			private JButton B_Patron_Add = new JButton("��          ��");
		
	private JPanel P_Return = new JPanel(); // "�ݳ�"Ŭ���� ��Ÿ�� �г� (�ϴ� ���� �����ӿ� �� Sub �г�)
		private JPanel P_Return_1 = new JPanel();
			private JTextField T_Return_bookPatroner = new JTextField(12); // ������ �Է��ʵ�
		private JPanel P_Return_2 = new JPanel();
			private JTextField T_Return_bookAuthor = new JTextField(12); // ���ڸ� �Է��ʵ�
		private JPanel P_Return_3 = new JPanel();
			private JTextField T_Return_bookTitle = new JTextField(12); // å���� �Է��ʵ�
		private JPanel P_Return_4 = new JPanel();
			private JButton B_Return_Add = new JButton("��          ��");
		
	private JPanel P_Search = new JPanel(); // "�˻�"Ŭ���� ��Ÿ�� �г� (�ϴ� ���� �����ӿ� �� Sub �г�)
			private JPanel P_Search_1 = new JPanel();
				private JTextField T_Search_bookPatroner = new JTextField(12); // ������ �Է��ʵ�
			private JPanel P_Search_2 = new JPanel();
				private JTextField T_Search_bookAuthor = new JTextField(12); // ���ڸ� �Է��ʵ�
			private JPanel P_Search_3 = new JPanel();
				private JTextField T_Search_bookTitle = new JTextField(12); // å���� �Է��ʵ�
			private JPanel P_Search_4 = new JPanel();
				private JButton B_Search_byTitle = new JButton("�������� �˻�");
			private JPanel P_Search_5 = new JPanel();
				private JButton B_Search_byAuthor = new JButton("���ڸ����� �˻�");
			private JPanel P_Search_6 = new JPanel();
				private JButton B_Search_byPatron = new JButton("�����ڸ����� �˻�");
			private JPanel P_Search_7 = new JPanel();
				private JButton B_Search_Checkedoutbook = new JButton("�����å ��ȸ");
			private JPanel P_Search_8 = new JPanel();
				private JButton B_Search_All = new JButton("���å ��ȸ");

	
	
	
	
	
	
	
	/* ���� : ������ ����ũ��, ��ġ, ���� ������ �׷����� �����忡 ����. 
	 *			���� ���������� InitDesign()�Լ�����
	 */				
	public WindowOpen(String title){
		
		super(title);//���ȭ���� Ÿ��Ʋ ����
		InitVariables();//�����ʱ�ȭ
		InitDesign();//ȭ��׸���
		InitFunction();//ȭ�鱸������ �ҷ�����
	}
	
	
	/* ���� : ȭ�� �׸��µ� �ʿ��� �Լ� ���� �κ�
	 */
	private void InitDesign(){
		this.setLayout(null);
		this.add(P_Menu);
		this.add(P_Main);
		
		DrawMenu();
		DrawMain();
			DrawAddbook();
			DrawPatron();
			DrawReturn();
			DrawSearch();
		

		this.setSize(800,600);//������ ������
        this.setVisible(true);//������ â ǥ��
	}
	
	
	/* ���� : �ʿ��� �Լ� �ʱ�ȭ �κ�
	
	 */
	private void InitFunction(){
		
		LoadData();//ȭ�鿡 �Ѹ� �����Ͱ��� �о�´�.
		LoadData_Table();
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â����
		
		//�޴��׸�
		B_Menu_Add.addActionListener(this);
		B_Menu_Patron.addActionListener(this);
		B_Menu_Return.addActionListener(this);
		B_Menu_Search.addActionListener(this);
		B_Menu_Exit.addActionListener(this);
		
		//å�߰��ϱ�
		B_Addbook_Add.addActionListener(this);
		
		//å�����ϱ�
		B_Patron_Add.addActionListener(this);
		
		
		//å�ݳ��ϱ�
		B_Return_Add.addActionListener(this);
		
		
		//å�˻��ϱ�
		B_Search_byTitle.addActionListener(this);
		B_Search_byAuthor.addActionListener(this);
		B_Search_byPatron.addActionListener(this);
		B_Search_Checkedoutbook.addActionListener(this);
		B_Search_All.addActionListener(this);
		
		//å�����ϱ�
		B_Menu_Save.addActionListener(this);
		
	}
	
	
	/* ���� : ����ϴ� ��� ���� �ʱ�ȭ �κ�, īŻ�α� �ε��� �ʱ�ȭ
	
	 */
	private void InitVariables(){
		
		DTB_Common = new DefaultTableModel();
			DTB_Common.setColumnIdentifiers(Table_Column);
			//DTB_Patron.addColumn(Table_Patron_Column);
		Table_Common = new JTable(DTB_Common);
		SP_Table_Common = new JScrollPane(Table_Common);
		
		for (int i = 0; i <= (int) 'Z'; i++) {
			titlecatalog[i] = new BookList();
			authorcatalog[i] = new AuthorList();
			people[i] = new PatronList();
		}
	}
	
	
	/* ����: �޴�ȭ���� �׸���.
	 *  
	
	 */	
	private void DrawMenu(){
		
		P_Menu.setLayout(new GridLayout(1,6)); // ��ư 5���� ������ ���̾ƿ��� 5���� �ɰ���.
		P_Menu.setBounds(20, 20, 760, 40);
		P_Menu.setBackground(new Color(238,240,244));
		P_Menu.add(P_Menu_Add);
			P_Menu_Add.add(B_Menu_Add);
		P_Menu.add(P_Menu_Patron);
			P_Menu_Patron.add(B_Menu_Patron);
		P_Menu.add(P_Menu_Return);
			P_Menu_Return.add(B_Menu_Return);
		P_Menu.add(P_Menu_Search);
			P_Menu_Search.add(B_Menu_Search);
		P_Menu.add(P_Menu_Save);
			P_Menu_Save.add(B_Menu_Save);
		P_Menu.add(P_Menu_Exit);
			P_Menu_Exit.add(B_Menu_Exit);
			
	}
	
	
	/* ��������: ���̾ƿ��� �������������� �ؽ�Ʈ�ʵ尡 ���� �۰� ������ ������ �־��µ�, ó�� �ؽ�Ʈ�ʵ�
	 * 			�� �����Ҷ�, ũ�⸦ �������� �ʾƼ� ���� ��������. ũ�� �����ϰ� ������.
	
	 * ��������: ���� �̸� ���� �ؽ�Ʈ�� �Է��ϸ� �۾��� ������ �ٷ� ����
	 * ��������: 2010�� 12�� 13�� ������ 19:43
	 * ����: ����ȭ���� �׸���.
	 */
	private void DrawMain(){
		
		P_Main.setLayout(null);
		P_Main.setBounds(20, 80, 760, 470);
		P_Main.setBackground(new Color(238,240,244));
		P_Main.setBorder(BorderFactory.createEtchedBorder());
			P_Main.add(P_Main_Table);
				P_Main_Table.setLayout(new GridLayout(1,1));
				P_Main_Table.setBounds(10,10,550,450);
				P_Main_Table.setBorder(BorderFactory.createEtchedBorder());
				P_Main_Table.add(SP_Table_Common);
			P_Main.add(P_Main_Buttons);
				P_Main_Buttons.setLayout(null);
				P_Main_Buttons.setBounds(580,10,170,450);
				P_Main_Buttons.setBorder(BorderFactory.createEtchedBorder());
					P_Main_Buttons.add(P_Addbook);
					P_Main_Buttons.add(P_Patron);
					P_Main_Buttons.add(P_Return);
					P_Main_Buttons.add(P_Search);
					P_Addbook.setVisible(false);
					P_Patron.setVisible(false);
					P_Return.setVisible(false);
					P_Search.setVisible(false);
		
	}
	
	
	/* ���� : å �߰��ϱ� ��ư Ŭ���� ���� �����ӿ� ȭ�� �׸���
	
	 */
	private void DrawAddbook(){
		
		P_Addbook.setBounds(0,0,170,450);
		P_Addbook.setBackground(new Color(215,225,235));
		P_Addbook.setBorder(BorderFactory.createEtchedBorder());
		P_Addbook.setLayout(new GridLayout(8,1));
		P_Addbook.add(P_Addbook_1);
		P_Addbook.add(P_Addbook_2);
		P_Addbook.add(P_Addbook_3);
		
		
		//P_Addbook_1.setLayout(new GridLayout(1,1));
		//P_Addbook_1.add(L_Addbook_bookTitle);
		P_Addbook_1.add(new Label("å  ��  ��  :  "));
		P_Addbook_1.add(T_Addbook_bookTitle);
		P_Addbook_1.setBackground(new Color(215,225,235));
		//P_Addbook_2.setLayout(new GridLayout(1,1));
		//P_Addbook_2.add(L_Addbook_bookAuthor);
		P_Addbook_2.add(new Label("��  ��  ��  :  "));
		P_Addbook_2.add(T_Addbook_bookAuthor);
		P_Addbook_2.setBackground(new Color(215,225,235));
		P_Addbook_3.setLayout(new GridLayout(1,1));
		P_Addbook_3.add(B_Addbook_Add);
		P_Addbook_3.setBackground(new Color(215,225,235));
		//L_Addbook_bookTitle.setText("å����:");
		//L_Addbook_bookTitle.setFont(new Font("����",Font.PLAIN,20));
		//L_Addbook_bookAuthor.setText("���ڸ�:");
		//L_Addbook_bookAuthor.setFont(new Font("����",Font.PLAIN,20));
		
	}
	
	
	/* ���� : å �����ϱ� ��ư Ŭ���� ���� �����ӿ� �ش� ȭ�� �׸���
	 * 
	
	 */
	private void DrawPatron(){
		
		//�޴��κ�
		P_Patron.setBounds(0,0,170,450);
		P_Patron.setBackground(new Color(215,225,235));
		P_Patron.setBorder(BorderFactory.createEtchedBorder());
		P_Patron.setLayout(new GridLayout(8,1));
		P_Patron.add(P_Patron_1);
		P_Patron.add(P_Patron_2);
		P_Patron.add(P_Patron_3);
		P_Patron.add(P_Patron_4);
		
		//P_Patron_2_1.setLayout(new GridLayout(1,1));
		P_Patron_1.add(new Label("��  ��  ��  :  "));
		P_Patron_1.add(T_Patron_bookPatroner);
		P_Patron_1.setBackground(new Color(215,225,235));
		//P_Patron_2_2.setLayout(new GridLayout(1,1));
		P_Patron_2.add(new Label("��  ��  ��  :  "));
		P_Patron_2.add(T_Patron_bookAuthor);
		P_Patron_2.setBackground(new Color(215,225,235));
		//P_Patron_2_3.setLayout(new GridLayout(1,1));
		P_Patron_3.add(new Label("å  ��  ��  :  "));
		P_Patron_3.add(T_Patron_bookTitle);
		P_Patron_3.setBackground(new Color(215,225,235));
		P_Patron_4.setLayout(new GridLayout(1,1));
		P_Patron_4.add(B_Patron_Add);
		P_Patron_4.setBackground(new Color(215,225,235));
		
	}
	
	
	/* ���� : å �ݳ��ϱ�  ��ư Ŭ���� ���� �����ӿ� �ش� ȭ�� �׸���
	
	 */
	private void DrawReturn(){
		
		P_Return.setBounds(0,0,170,450);
		P_Return.setBackground(new Color(215,225,235));
		P_Return.setBorder(BorderFactory.createEtchedBorder());
		P_Return.setLayout(new GridLayout(8,1));
		P_Return.add(P_Return_1);
		P_Return.add(P_Return_2);
		P_Return.add(P_Return_3);
		P_Return.add(P_Return_4);
		
		//P_Return_2_1.setLayout(new GridLayout(1,1));
		P_Return_1.add(new Label("��  ��  ��  :  "));
		P_Return_1.add(T_Return_bookPatroner);
		P_Return_1.setBackground(new Color(215,225,235));
		//P_Return_2_2.setLayout(new GridLayout(1,1));
		P_Return_2.add(new Label("��  ��  ��  :  "));
		P_Return_2.add(T_Return_bookAuthor);
		P_Return_2.setBackground(new Color(215,225,235));
		//P_Return_2_3.setLayout(new GridLayout(1,1));
		P_Return_3.add(new Label("å  ��  ��  :  "));
		P_Return_3.add(T_Return_bookTitle);
		P_Return_3.setBackground(new Color(215,225,235));
		P_Return_4.setLayout(new GridLayout(1,1));
		P_Return_4.add(B_Return_Add);
		P_Return_4.setBackground(new Color(215,225,235));
	}
	
	
	/* ���� : å �˻��ϱ� ��ư Ŭ���� ���� �����ӿ� �ش� ȭ�� �׸���
	
	 */
	private void DrawSearch(){

		//�޴��κ�
		P_Search.setBounds(0,0,170,450);
		P_Search.setBackground(new Color(215,225,235));
		P_Search.setBorder(BorderFactory.createEtchedBorder());
		P_Search.setLayout(new GridLayout(8,1));
		P_Search.add(P_Search_1);
		P_Search.add(P_Search_2);
		P_Search.add(P_Search_3);
		P_Search.add(P_Search_4);
		P_Search.add(P_Search_5);
		P_Search.add(P_Search_6);
		P_Search.add(P_Search_7);
		P_Search.add(P_Search_8);
		
		//P_Search_2_1.setLayout(new GridLayout(1,1));
		P_Search_1.add(new Label("��  ��  ��  :  "));
		P_Search_1.add(T_Search_bookPatroner);
		P_Search_1.setBackground(new Color(215,225,235));
		//P_Search_2_2.setLayout(new GridLayout(1,1));
		P_Search_2.add(new Label("��  ��  ��  :  "));
		P_Search_2.add(T_Search_bookAuthor);
		P_Search_2.setBackground(new Color(215,225,235));
		//P_Searh_2_3.setLayout(new GridLayout(1,1));
		P_Search_3.add(new Label("å  ��  ��  :  "));
		P_Search_3.add(T_Search_bookTitle);
		P_Search_3.setBackground(new Color(215,225,235));
		P_Search_4.setLayout(new GridLayout(1,1));
		P_Search_4.add(B_Search_byTitle);
		P_Search_4.setBackground(new Color(215,225,235));
		P_Search_5.setLayout(new GridLayout(1,1));
		P_Search_5.add(B_Search_byAuthor);
		P_Search_5.setBackground(new Color(215,225,235));
		P_Search_6.setLayout(new GridLayout(1,1));
		P_Search_6.add(B_Search_byPatron);
		P_Search_6.setBackground(new Color(215,225,235));
		P_Search_7.setLayout(new GridLayout(1,1));
		P_Search_7.add(B_Search_Checkedoutbook);
		P_Search_7.setBackground(new Color(215,225,235));
		P_Search_8.setLayout(new GridLayout(1,1));
		P_Search_8.add(B_Search_All);
		P_Search_8.setBackground(new Color(215,225,235));
		
	}
	
	
	/* ���� : �ؽ�Ʈ���Ϸκ��� �ڷḦ �о�´�.
	 * 			������ ������ �Ʒ��� ��ġ.
	
	 */
	private void LoadData(){
		//1��°�� ���ڸ�
		//2��°�� å����
		//(3��°�� �����ڸ�) ������ #�� ������ ����å������� �Ѿ��.
		try{
			
			BufferedReader File_Pointer = new BufferedReader(new FileReader("data.txt"));
			String FP_Title = null;
			String FP_Author = null;
			String FP_Patron = null;
			String temp=null;
	
			while( (temp = File_Pointer.readLine()) != null){
				if(temp.substring(0,1).equals("#"))
				{
					continue;//�ش� ������ �Ѿ��.
				}
				
				//�ش��ϴ� ���ο� ������ "#" �� ���ٸ� �����͸� �о���δ�.
				FP_Author = temp;
				temp = File_Pointer.readLine();
				FP_Title = temp;
				
				temp = File_Pointer.readLine();
				
				//�����ڰ� ���� ���� �ٷ� å�� �߰�
				if(temp.substring(0,1).equals("#")){
					includeBook(FP_Title,FP_Author);
				}
				
				//�����ڰ� �ִ°�� �����ڸ� �߰�.
				else{
					FP_Patron = temp;
					includeBook(FP_Title,FP_Author,FP_Patron);
					//checkOutBook(FP_Title, FP_Author, FP_Patron);
				}	
			}
		}
		catch (IOException ex) {
			return;
		}	
	}
	
	
	/*���� : �����ǿ��� ���̺� ������ �����͸� �ҷ����� �Լ�
	
	 */
	private void LoadData_Table() {
		// TODO Auto-generated method stub
		String[] Data_Printed = { "", "", "" }; // å����, ���ڸ�, ������
	
		
		//ǥ�� ������ �ʱ�ȭ
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		//īŻ�α׸� �� �������� �ݺ��Ͽ� �߰��Ѵ�.
		for(int i = (int) 'A'; i <= (int) 'Z' ; i++){
			
			//�ش��ε����� å�� �����Ѵٸ� �Ʒ��� for���� �����Ѵ�.		
			for(int j = 0; j < titlecatalog[i].size();j ++){
				
				Data_Printed[0] = ((Book)titlecatalog[i].get(j)).getTitle();//å����
				Data_Printed[1] = ((Book)titlecatalog[i].get(j)).getAuthor().getName();
				if(((Book)titlecatalog[i].get(j)).getPatron() != null){
					Data_Printed[2] = ((Book)titlecatalog[i].get(j)).getPatron().getName();
				}
				else
				{
					Data_Printed[2] = "";
				}
				
				DTB_Common.addRow(Data_Printed);
			}
		}
	}

	/* ���� : �������θ� �˻�

	 * ���� �������� : �ܾ���ε� å�� �˻��ǵ��� ���� ����
	 */
	private void LoadData_Table_Title(String bookTitle) {
		// TODO Auto-generated method stub
		
		String[] Data_Printed = { "", "", "" }; // å����, ���ڸ�, ������
		//ǥ�� ������ �ʱ�ȭ
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		// �Է¹��� String�� �ܾ���� �� �ܾ����� �𸣴� ����...
		// Catalog�� å����� å������ ������ �ش� å������ �����̽��ٸ� �������� �������ʿ䰡 ����.
		// 1. ������ ��ġ�ϴ� å������ �ִ°�
		// 2. �ܾ�� �ɰ��� �� ��ġ�ϴ� ���� �ִ°�
		
		//å�������� ���� �Է��� �޾Ҵٸ�
		if (bookTitle.length() != 0){
			
			
		
				
			//�ش��ε����� å�� �����Ѵٸ� �Ʒ��� for���� �����Ѵ�.		
			for(int i = 0; i < titlecatalog[(int) bookTitle.charAt(0)].size();i ++){
				
				String tempTitle = ((Book) titlecatalog[(int) bookTitle.charAt(0)].get(i)).getTitle();
				int tempSpliter = tempTitle.indexOf((int) ' ');
				String tempWord = tempTitle.substring(0,tempSpliter);
				
				if(	bookTitle.equals( 
						tempTitle)
					){	//å������ ��ġ
					
					Data_Printed[0] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getTitle();//å����
					Data_Printed[1] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getAuthor().getName();
					if(((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getPatron() != null){
						Data_Printed[2] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getPatron().getName();
					}
					else
					{
						Data_Printed[2] = "";
					}
					
					DTB_Common.addRow(Data_Printed);
					
				}
				
				//ù�ܾ ��ġ
				else if( bookTitle.equals( tempWord ) ){
					
					Data_Printed[0] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getTitle();//å����
					Data_Printed[1] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getAuthor().getName();
					if(((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getPatron() != null){
						Data_Printed[2] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getPatron().getName();
					}
					else
					{
						Data_Printed[2] = "";
					}
					
					DTB_Common.addRow(Data_Printed);
					
				}
			
				
			}
				

			//�ԷµȰ��� ������ ��ġ�ϴ� ������ ����.
			if( Data_Printed[0].equals("") && Data_Printed[1].equals("") && Data_Printed[2].equals("")){
				JOptionPane.showMessageDialog(B_Search_byPatron, "�ش��ϴ� å������ å�� �������� �����ϴ�.");
			}
	
		}
		else{//å������ �Էµ� ���� ���� ��.
			JOptionPane.showMessageDialog(B_Search_byTitle, "å������ �Է��ϰ� �˻��Ͻʽÿ�.");
		}
		
	}


	private void LoadData_Table_Author(String bookAuthor) {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		
		String[] Data_Printed = { "", "", "" }; // å����, ���ڸ�, ������
		//ǥ�� ������ �ʱ�ȭ
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		// �Է¹��� String�� �ܾ���� �� �ܾ����� �𸣴� ����...
		// Catalog�� å����� å������ ������ �ش� å������ �����̽��ٸ� �������� �������ʿ䰡 ����.
		// 1. ������ ��ġ�ϴ� å������ �ִ°�
		// 2. �ܾ�� �ɰ��� �� ��ġ�ϴ� ���� �ִ°�
		
		//å�������� ���� �Է��� �޾Ҵٸ�
		if (bookAuthor.length() != 0){
			
			
		
				
			//�ش��ε����� å�� �����Ѵٸ� �Ʒ��� for���� �����Ѵ�.		
			for(int i = 0; i < authorcatalog[(int) bookAuthor.charAt(0)].size();i ++){
				
				String tempAuthor = ((Author) authorcatalog[(int) bookAuthor.charAt(0)].get(i)).getName();
				
				if(	bookAuthor.equals(tempAuthor)){	//���ڸ��� ��ġ
					
					for(int j = 0; j < ((Author) authorcatalog[(int) bookAuthor.charAt(0)].get(i)).books.size() ; j++)
					{
						Data_Printed[0] = ((Book) ((Author) authorcatalog[(int) bookAuthor.charAt(0)].get(i)).books.get(j)).getTitle();
						Data_Printed[1] = tempAuthor;
						if(((Book) ((Author) authorcatalog[(int) bookAuthor.charAt(0)].get(i)).books.get(j)).getPatron() != null){
							Data_Printed[2] = ((Book) ((Author) authorcatalog[(int) bookAuthor.charAt(0)].get(i)).books.get(j)).getPatron().getName();
						}
						else
						{
							Data_Printed[2] = "";
						}
						
						DTB_Common.addRow(Data_Printed);
					}
					
				}
				
			
				//DTB_Common.addRow(Data_Printed);
			}
			
			

			//�ԷµȰ��� ������ ��ġ�ϴ� ������ ����.
			if( Data_Printed[0].equals("") && Data_Printed[1].equals("") && Data_Printed[2].equals("")){
				JOptionPane.showMessageDialog(B_Search_byAuthor, "�ش��ϴ� ���ڸ����� ������ å�� �����ϴ�.");
			}	
				
		}
		else{//å������ �Էµ� ���� ���� ��.
			JOptionPane.showMessageDialog(B_Search_byTitle, "���ڸ��� �Է��ϰ� �˻��Ͻʽÿ�.");
		}
	}

	/* ���� : �����ڸ����� �˻��ؼ� �ش� �����ڰ� � å�� ���ȴ��� �����Ѵ�.
	
	 */

	private void LoadData_Table_Patron(String bookPatroner) {
		// TODO Auto-generated method stub

		String[] Data_Printed = { "", "", "" }; // å����, ���ڸ�, ������
		//ǥ�� ������ �ʱ�ȭ
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		if(bookPatroner.length() != 0){
			
			for(int i=0; i < people[(int) bookPatroner.charAt(0)].size(); i++)
			{
				String tempPatroner = ((Patron) people[(int) bookPatroner.charAt(0)].get(i)).getName();
				
				if( bookPatroner.equals( tempPatroner )){
					
					for(int j = 0; j < ((Patron) people[(int) bookPatroner.charAt(0)].get(i)).books.size() ; j++)
					{
						
						Data_Printed[0] = ((Book) ((Patron) people[(int) bookPatroner.charAt(0)].get(i)).books.get(j)).getTitle();
						Data_Printed[1] = ((Book) ((Patron) people[(int) bookPatroner.charAt(0)].get(i)).books.get(j)).getAuthor().getName();
						Data_Printed[2] = bookPatroner;
						//JOptionPane.showMessageDialog(B_Search_byPatron, j + " ," + Data_Printed);		
						DTB_Common.addRow(Data_Printed);
					}
				}
			}
			
			//�ԷµȰ��� ������ ��ġ�ϴ� ������ ����.
			if( Data_Printed[0].equals("") && Data_Printed[1].equals("") && Data_Printed[2].equals("")){
				JOptionPane.showMessageDialog(B_Search_byPatron, "�ش��ϴ� �̸����� �����Ͻ� ���� �����ϴ�.");
			}
		}
		else
			JOptionPane.showMessageDialog(B_Search_byPatron, "�����ڸ��� �Է��ϼ���.");
	}


	/* ���� : ����� å���� �����Ѵ�.
	 * 		
	 */
	private void LoadData_Table_Checkedoutbook() {
	// TODO Auto-generated method stub
		
		String[] Data_Printed = { "", "", "" }; // å����, ���ڸ�, ������
		//ǥ�� ������ �ʱ�ȭ
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		for(int i= 'A'; i <= 'Z' ; i++){
			
			for(int j = 0; j < titlecatalog[i].size(); j++){
			
				
				//�ش�å�� ����Ǿ���.
				if( ((Book)titlecatalog[i].get(j)).getPatron() != null ){
					
					Data_Printed[0] = ((Book)titlecatalog[i].get(j)).getTitle();
					Data_Printed[1] = ((Book)titlecatalog[i].get(j)).getAuthor().getName();
					Data_Printed[2] = ((Book)titlecatalog[i].get(j)).getPatron().getName();
					DTB_Common.addRow(Data_Printed);
				}
				
				
			}
		}
		
		
		
	}


	/* ���� : ����Ʈ�� �������ִ� �ڷ���� �������·� �����Ѵ�. authorcatalog, titlecatalog
	 * 		���߾������ ����ص� ��������� ���⼭ ���ǻ� titlecatalog�� ���. ����� å��������� ����ȴ�.
	
	 */
	private void SaveData(BookList[] catalog){
		
		try{
			// BufferedWriter �� write(Object o) ���� String�� ������ 
			// ��ü�� �Է��� �ȵǴ� ������ �߻�...? ������ �Է��� �ȵǴ�...??? �ִٿ�ǥ�� ��Ʈ���� ó����.
			//BufferedWriter File_Pointer = new BufferedWriter(new FileWriter("data.txt"));
			PrintWriter File_Pointer = new PrintWriter(new FileWriter("data.txt"));
			String tempTitle;
			String tempAuthor;
			String tempPatron;
			
			for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
				
				//catalog[i].size(); // �ش� �ε����� ��� å�� ������ִ°�
				//�ε����ȿ� �ϸ���Ʈ�� �ִ°�
				if(catalog[i].isEmpty()){ //true ����.
					//JOptionPane.showMessageDialog(B_Menu_Save, i + " ��° �ε����� ����ֽ��ϴ�.");
					continue;
				}
				else{//false �ִ�.
					//JOptionPane.showMessageDialog(B_Menu_Save, i + " ��° �ε����� ���� " + catalog[i].size() + "���� �����Ͱ� �ֽ��ϴ�.");
					for(int j = 0; j < catalog[i].size() ; j++){
						
						//JOptionPane.showMessageDialog(B_Menu_Save, "For���� " + j + ((Book) catalog[i].get(j)).getTitle() );
						//File_Pointer.println( ((Book) catalog[i].get(j)).getAuthor().getName() );
						//File_Pointer.println(catalog[i].get(j));
						tempTitle = ((Book) catalog[i].get(j)).getTitle();
						tempAuthor = ((Book) catalog[i].get(j)).getAuthor().getName();
						
						File_Pointer.println(tempAuthor);
						File_Pointer.println(tempTitle);
					
						if( ((Book) catalog[i].get(j)).getPatron() != null)
						{
							tempPatron = ((Book) catalog[i].get(j)).getPatron().getName();
							//JOptionPane.showMessageDialog(B_Menu_Save, "Patron Check");
							File_Pointer.println( ((Book) catalog[i].get(j)).getPatron().getName() );
						}
						File_Pointer.println("#");
					}					
				}
			}
			JOptionPane.showMessageDialog(B_Menu_Save, "���������� ����ƽ��ϴ�.");
			File_Pointer.close();
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(B_Menu_Save, "������ �߻��߽��ϴ�.");
			return;
		}
	}
	
	/*
	 * ����: ���ο� å�� �߰��ϴ� �Լ�
	
	 * �߰� �������� : ���� å������ ������ ���� ó���κ�
	 */
	private void includeBook() {

		Author newAuthor = new Author();
		Book newBook = new Book();
		int oldAuthor, oldBook; // AuthorName, BookTitle�� Indexing�� �������� ���´�.

		if(T_Addbook_bookAuthor.getText().length() !=0 && T_Addbook_bookTitle.getText().length() != 0){
		
			//å�� �߰��� �� �����Ǿ�� �ϴ� ��ü�� Author �� Book
			// Author ���� BookList, Author Name�� �߰�
			// Book ���� BookTitle, Author Name, Patroner �� �߰�
			
			newAuthor.name = T_Addbook_bookAuthor.getText();//Author ���ڸ� ����
						
			oldAuthor = authorcatalog[(int)
			                	newAuthor.name.charAt(0)].indexOf(newAuthor);//Index�����
			
			
			//Author BookList�� newBook�� �߰�
			//authorcatalog��Ͽ� ��������  �ʴ� ���ο� �۰�
			if (oldAuthor == -1) {
				newAuthor.books.add(newBook);//�۰��� å����Ʈ�� å �߰�
				authorcatalog[(int) newAuthor.name.charAt(0)].add(newAuthor);//īŻ�α� �ε����׿� ���ڸ��߰�
			}
			//��Ͽ� ������ �̸��� �۰��� �ִ�. å��ϸ� �߰�
			else ((Author)authorcatalog[(int) newAuthor.name.charAt(0)].
					get(oldAuthor)).books.add(newBook);
			
			
			//���θ��� å�� å ���
			newBook.title = T_Addbook_bookTitle.getText();
			//å�� ���� ����
			newBook.author = newAuthor;
			
			oldBook = titlecatalog[(int)
			                       newBook.title.charAt(0)].indexOf(newBook);
			
			//titlecatalog��Ͽ� �������� �ʴ� å. ī�װ��� �ش� å�� �߰�
			if (oldBook == -1) {
				titlecatalog[(int) newBook.title.charAt(0)].add(newBook);
				JOptionPane.showMessageDialog(B_Addbook_Add, "�� å�� �����Ϳ� �߰��Ǿ����ϴ�.");	
			}
			else{
				JOptionPane.showMessageDialog(B_Addbook_Add, "������ å������ �����մϴ�. �߰��Ұ���.");
			}			
			
		}
		
		//���ڸ��̳� å���� ���� �ϳ��� �Էµ��� ���� �� ���� �߻�
		else{
			JOptionPane.showMessageDialog(B_Addbook_Add, "���ڸ�, å������ ��� �����ϼ���");	
		}
	}
	
	private void includeBook(String Title, String Author){
		Author newAuthor = new Author();
		Book newBook = new Book();
				
		int oldAuthor, oldBook; // AuthorName, BookTitle�� Indexing�� �������� ���´�.

		if(Author.length() !=0 && Title.length() != 0){
		
			//å�� �߰��� �� �����Ǿ�� �ϴ� ��ü�� Author �� Book
			// Author ���� BookList, Author Name�� �߰�
			// Book ���� BookTitle, Author Name, Patroner �� �߰�
			
			newAuthor.name = Author;//Author ���ڸ� ����
						
			oldAuthor = authorcatalog[(int)
			                	newAuthor.name.charAt(0)].indexOf(newAuthor);//Index�����
			
			
			//Author BookList�� newBook�� �߰�
			//authorcatalog��Ͽ� ��������  �ʴ� ���ο� �۰�
			if (oldAuthor == -1) {
				newAuthor.books.add(newBook);//�۰��� å����Ʈ�� å �߰�
				authorcatalog[(int) newAuthor.name.charAt(0)].add(newAuthor);//īŻ�α� �ε����׿� ���ڸ��߰�
			}
			//��Ͽ� ������ �̸��� �۰��� �ִ�. å��ϸ� �߰�
			else ((Author)authorcatalog[(int) newAuthor.name.charAt(0)].
					get(oldAuthor)).books.add(newBook);
			
			
			
			
			//���θ��� å�� å ���
			newBook.title = Title;
			//å�� ���� ����
			newBook.author = newAuthor;
			
			oldBook = titlecatalog[(int)
			                       newBook.title.charAt(0)].indexOf(newBook);
			
			//titlecatalog��Ͽ� �������� �ʴ� å. ī�װ��� �ش� å�� �߰�
			if (oldBook == -1) {
				titlecatalog[(int) newBook.title.charAt(0)].add(newBook);
				//JOptionPane.showMessageDialog(B_Addbook_Add, "�� å�� �����Ϳ� �߰��Ǿ����ϴ�.");	
			}
			else{
				//JOptionPane.showMessageDialog(B_Addbook_Add, "������ å������ �����մϴ�. �߰��Ұ���.");
			}			
			
		}
	}
	
	
	/* ���� : �����ڰ� ���� ����� ������ �ε� �Լ�

	 */
	private void includeBook(String Title, String Author, String Patron){
		Author newAuthor = new Author();
		Book newBook = new Book();
		Patron newPatron = new Patron();
		
		int oldAuthor, oldBook, oldPatron; // AuthorName, BookTitle�� Indexing�� �������� ���´�.

		if(Author.length() !=0 && Title.length() != 0){
		
			//å�� �߰��� �� �����Ǿ�� �ϴ� ��ü�� Author �� Book
			// Author ���� BookList, Author Name�� �߰�
			// Book ���� BookTitle, Author Name, Patroner �� �߰�
			
			newAuthor.name = Author;//Author ���ڸ� ����
						
			oldAuthor = authorcatalog[(int)
			                	newAuthor.name.charAt(0)].indexOf(newAuthor);//Index�����
			
			
			//Author BookList�� newBook�� �߰�
			//authorcatalog��Ͽ� ��������  �ʴ� ���ο� �۰�
			if (oldAuthor == -1) {
				newAuthor.books.add(newBook);//�۰��� å����Ʈ�� å �߰�
				authorcatalog[(int) newAuthor.name.charAt(0)].add(newAuthor);//īŻ�α� �ε����׿� ���ڸ��߰�
			}
			//��Ͽ� ������ �̸��� �۰��� �ִ�. å��ϸ� �߰�
			else ((Author)authorcatalog[(int) newAuthor.name.charAt(0)].
					get(oldAuthor)).books.add(newBook);
			
			newPatron.name = Patron; //�����ڸ� ����
			
			oldPatron = people[(int)
			                   newPatron.name.charAt(0)].indexOf(newPatron);
			
			if (oldPatron == -1) {
				newPatron.books.add(newBook);
				people[(int) newPatron.name.charAt(0)].add(newPatron);
			}
			else ((Patron)people[(int) newPatron.name.charAt(0)].get(oldPatron)).books.add(newBook);
			
			//���θ��� å�� å ���
			newBook.title = Title;
			//å�� ���� ����
			newBook.author = newAuthor;
			newBook.patron = newPatron;
			
			oldBook = titlecatalog[(int)
			                       newBook.title.charAt(0)].indexOf(newBook);
			
			//titlecatalog��Ͽ� �������� �ʴ� å. ī�װ��� �ش� å�� �߰�
			if (oldBook == -1) {
				titlecatalog[(int) newBook.title.charAt(0)].add(newBook);
				//JOptionPane.showMessageDialog(B_Addbook_Add, "�� å�� �����Ϳ� �߰��Ǿ����ϴ�.");	
			}
			else{
				//JOptionPane.showMessageDialog(B_Addbook_Add, "������ å������ �����մϴ�. �߰��Ұ���.");
			}			
			
		}
		
		//���ڸ��̳� å���� ���� �ϳ��� �Էµ��� ���� �� ���� �߻�
		else{
			//JOptionPane.showMessageDialog(B_Addbook_Add, "���ڸ�, å������ ��� �����ϼ���");	
		}
		//JOptionPane.showMessageDialog(B_Addbook_Add, "�����Ͱ� �ε� �ƽ��ϴ�.");
	}
	
	
	
		
	
	private void PatronBook() {
		// TODO Auto-generated method stub
		//Object temp = new Object();
		
		
		if( T_Patron_bookTitle.getText().length() != 0 &&	//3���� �Է��ʵ� ��ο� ���� ���Դ�.
			T_Patron_bookAuthor.getText().length() != 0 &&
			T_Patron_bookPatroner.getText().length() != 0 ){
			
			String tempTitle = T_Patron_bookTitle.getText();
			String tempAuthor = T_Patron_bookAuthor.getText();
			String tempPatroner = T_Patron_bookPatroner.getText();			
			int hasBook = 0;
			//å����� ���ڸ����� �ش� å�� �����ϴ����� ���� üũ�� �ʿ�.
			hasBook = titlecatalog[(int) T_Patron_bookTitle.getText().charAt(0)].size();
			
			if(hasBook > 0)//å������ ù���ڷ� ���� ���� �ִ��� üũ�ؼ� ã�Ƶ���....
			{
				//JOptionPane.showMessageDialog(B_Patron_Add, "�ش��ε��� ����");
				for(int i=0; i < hasBook ; i++)
				{
					Book tempBook = ((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i));
					//JOptionPane.showMessageDialog(B_Patron_Add, "�Է°� : " + tempTitle + ", ��°� : " + tempBook.getTitle() + ", �Է����� : " + tempAuthor + " ��°� : " + tempBook.getAuthor().getName());
					if(	tempTitle.equals( 
							tempBook.getTitle()) 
							&&
						tempAuthor.equals(
							tempBook.getAuthor().getName())
						){	//�����Ϸ��� å�� �Ȱ��� ������ å�� �����Ѵ�.
						
						if(tempBook.getPatron() == null){//�ش�å�� ��������� �ִ°�? ���ٸ�
							
						
							Patron newPatroner = new Patron();
							newPatroner.name = tempPatroner;
							int oldPatroner;
							
							oldPatroner = people[(int)
							                       newPatroner.name.charAt(0)].indexOf(newPatroner);
							
							
							if(oldPatroner == -1){//������ ��ܿ� ���� ������
								newPatroner.books.add(	((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i))	);
								((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).patron = newPatroner;
								people[(int) newPatroner.name.charAt(0)].add(newPatroner);
								JOptionPane.showMessageDialog(B_Patron_Add, tempPatroner + "��, ó�� å�� �����ó׿�.");
								//this.SaveData(titlecatalog);
								break;
							}
							else{//������ ��ܿ� �����ϴ� ������
								((Patron) people[(int) newPatroner.name.charAt(0)].get(oldPatroner)).books.add(	((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i))	);
								((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).patron = newPatroner;
								JOptionPane.showMessageDialog(B_Patron_Add, tempPatroner + "��, å�� ����Ǿ����ϴ�.");
								//this.SaveData(titlecatalog);
								break;
							}	
						
						}
						else{
							JOptionPane.showMessageDialog(B_Patron_Add, tempPatroner + "��, �ش�å�� �������Դϴ�.");
							break;
						}
					}
				}
			}
			else//
			{
				JOptionPane.showMessageDialog(B_Patron_Add, "�ش� å�� Library�� ������ ���� �ʽ��ϴ�.");
			}
			
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(B_Patron_Add, "���ڸ�, å����, �����ڸ��� ��Ȯ�� �����Ͻÿ�.");
		}
		
		
	}


	private void ReturnBook() {
		// TODO Auto-generated method stub
		//Object temp = new Object();
		
		
		if( T_Return_bookTitle.getText().length() != 0 &&	//3���� �Է��ʵ� ��ο� ���� ���Դ�.
			T_Return_bookAuthor.getText().length() != 0 &&
			T_Return_bookPatroner.getText().length() != 0 ){
			
			String tempTitle = T_Return_bookTitle.getText();
			String tempAuthor = T_Return_bookAuthor.getText();
			String tempPatroner = T_Return_bookPatroner.getText();
			
			int hasBook = 0;
			//å����� ���ڸ����� �ش� å�� �����ϴ����� ���� üũ�� �ʿ�.
			hasBook = titlecatalog[(int) T_Return_bookTitle.getText().charAt(0)].size();
			
			if(hasBook > 0)//å������ ù���ڷ� ���� ���� �ִ��� üũ�ؼ� ã�Ƶ���....
			{
				//JOptionPane.showMessageDialog(B_Patron_Add, "�ش��ε��� ����");
				for(int i=0; i < hasBook ; i++)
				{
					Book tempBook = ((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i));
					
					if(	tempTitle.equals( 
							tempBook.getTitle()) 
							&&
						tempAuthor.equals(
							tempBook.getAuthor().getName())
							&&
						tempBook.getPatron() != null
					){	//�ݳ��� ������ å, ���ڸ��� ��ġ
						
						if(tempPatroner.equals(
							tempBook.getPatron().getName())){
							JOptionPane.showMessageDialog(B_Return_Add, tempBook.getPatron().getName() + "�Բ��� å�� �ݳ��Ͽ����ϴ�.");
							((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).getPatron().books.remove(((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)));
							((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).patron = null;
							//this.SaveData(titlecatalog);
							break;
						}
						else{
							JOptionPane.showMessageDialog(B_Return_Add, "�����ڸ��� �߸� �ԷµǾ����ϴ�.");
						}
						
						
					}
					else{
						if(i==hasBook-1)
						JOptionPane.showMessageDialog(B_Return_Add, "����� å�� �ݳ������� ��ġ���� �ʽ��ϴ�.");
					}
				}
			}
			else//
			{
				JOptionPane.showMessageDialog(B_Return_Add, "�ش� å�� Library�� ������ ���� �ʽ��ϴ�.");
			}
			
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(B_Return_Add, "���ڸ�, å����, �����ڸ��� ��Ȯ�� �����Ͻÿ�.");
		}
	}



	/* ȭ���� ���� ��ư Ŭ�� �� �����Ǵ� ��� �̺�Ʈ ���� �κ�
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()== B_Addbook_Add){
			includeBook();
			LoadData_Table();
		}
		
		if(e.getSource() == B_Patron_Add){
			PatronBook();
			LoadData_Table();
		}
		
		if(e.getSource() == B_Return_Add){
			ReturnBook();
			LoadData_Table();
		}
		
		if(e.getSource() == B_Search_byTitle){
			LoadData_Table_Title(T_Search_bookTitle.getText());
			//LoadData_Table();
		}
		if(e.getSource() == B_Search_byAuthor){
			LoadData_Table_Author(T_Search_bookAuthor.getText());
		}
		if(e.getSource() == B_Search_byPatron){
			LoadData_Table_Patron(T_Search_bookPatroner.getText());
		}
		if(e.getSource() == B_Search_All){
			LoadData_Table(); // å��������� �����ȴ�.
		}
		if(e.getSource() == B_Search_Checkedoutbook){
			LoadData_Table_Checkedoutbook();
		}
			
		
		if(e.getSource() == B_Menu_Save){
			SaveData(this.titlecatalog);
		}
		
		if(e.getSource() == B_Menu_Add){
			P_Addbook.setVisible(true);
			P_Patron.setVisible(false);
			P_Return.setVisible(false);
			P_Search.setVisible(false);
			LoadData_Table();
		}
		if(e.getSource() == B_Menu_Patron){
			P_Addbook.setVisible(false);
			P_Patron.setVisible(true);
			P_Return.setVisible(false);
			P_Search.setVisible(false);
			LoadData_Table();
		}
		if(e.getSource() == B_Menu_Return){
			P_Addbook.setVisible(false);
			P_Patron.setVisible(false);
			P_Return.setVisible(true);
			P_Search.setVisible(false);
			LoadData_Table();
		}
		if(e.getSource() == B_Menu_Search){
			P_Addbook.setVisible(false);
			P_Patron.setVisible(false);
			P_Return.setVisible(false);
			P_Search.setVisible(true);
			LoadData_Table();
		}
		if(e.getSource() == B_Menu_Exit){//�����ư ���ý�
			System.exit(0);
		}
		
	}


}

