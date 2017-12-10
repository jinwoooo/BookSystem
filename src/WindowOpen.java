/* 변수 선언규칙
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

	
	
/* 수정내용 : 동적인 테이블 행 추가/삭제를 위해 DefaultTableModel을 이용. 해당 변수는
 * 			이곳에서 new 선언문으로 생성이 불가능한 문제점이 있어 생성자에 InitVariables()
 * 			함수를 통해 생성. 그와 연동되는 JTable, JScrollPane 도 어쩔수 없이 위의 함수에서
 * 			초기화.
 * 
 */
	
	private JPanel P_Menu = new JPanel(); // 상단 메뉴 프레임차
		private JPanel P_Menu_Add = new JPanel();
		private JButton B_Menu_Add = new JButton("책 추가하기"); // 추가버튼
		private JPanel P_Menu_Patron = new JPanel();
		private JButton B_Menu_Patron = new JButton("책 대출하기"); // 대출버튼
		private JPanel P_Menu_Return = new JPanel();
		private JButton B_Menu_Return = new JButton("책 반납하기"); // 반납버튼
		private JPanel P_Menu_Search = new JPanel();
		private JButton B_Menu_Search = new JButton("책 검색하기"); // 검색버튼
		private JPanel P_Menu_Exit = new JPanel();
		private JButton B_Menu_Exit = new JButton("프로그램종료"); // 프로그램 종료버튼
		private JPanel P_Menu_Save = new JPanel();
		private JButton B_Menu_Save = new JButton("자료저장하기"); // 자료 저장하기
		
	private JPanel P_Main = new JPanel(); // 하단 내용 프레임
		private JPanel P_Main_Table = new JPanel(); // 하단 데이터가 표시될 부분
			private DefaultTableModel DTB_Common;
			private String[] Table_Column = {"책 제 목",
	                "저 자 명",
	                "대 출 자"};
			private JTable Table_Common;
			private JScrollPane SP_Table_Common;
		
		private JPanel P_Main_Buttons = new JPanel(); // 하단 입력필드와 버튼이 나타날 곳
	
			private JPanel P_Addbook = new JPanel(); // "추가"클릭시 나타날 패널 (하단 내용 프레임에 들어갈 Sub 패널)
				private JPanel P_Addbook_1 = new JPanel();
					//private JLabel L_Addbook_bookTitle = new JLabel(); // 책제목 라벨
					private JTextField T_Addbook_bookTitle = new JTextField(12); // 책제목 입력필드
				private JPanel P_Addbook_2 = new JPanel();	
					//private JLabel L_Addbook_bookAuthor = new JLabel(); // 저자명 라벨
					private JTextField T_Addbook_bookAuthor = new JTextField(12); // 저자명 입력필드
				private JPanel P_Addbook_3 = new JPanel();
					private JButton B_Addbook_Add = new JButton("추          가"); // 실행 버튼
	
		
	
	//List<String[]> Table_Data = new ArrayList<String[]>();
	//String[][] Table_Data_Str;
	//private String[][] Data_Patron =
	//private String[][] Data_Return =
	//private String[][] Data_Search =
		
			
	private JPanel P_Patron = new JPanel(); // "대출"클릭시 나타날 패널 (하단 내용 프레임에 들어갈 Sub 패널)
		private JPanel P_Patron_1 = new JPanel();
			private JTextField T_Patron_bookPatroner = new JTextField(12); // 대출자 입력필드
		private JPanel P_Patron_2 = new JPanel();
			private JTextField T_Patron_bookAuthor = new JTextField(12); // 저자명 입력필드
		private JPanel P_Patron_3 = new JPanel();
			private JTextField T_Patron_bookTitle = new JTextField(12); // 책제목 입력필드
		private JPanel P_Patron_4 = new JPanel();
			private JButton B_Patron_Add = new JButton("대          출");
		
	private JPanel P_Return = new JPanel(); // "반납"클릭시 나타날 패널 (하단 내용 프레임에 들어갈 Sub 패널)
		private JPanel P_Return_1 = new JPanel();
			private JTextField T_Return_bookPatroner = new JTextField(12); // 대출자 입력필드
		private JPanel P_Return_2 = new JPanel();
			private JTextField T_Return_bookAuthor = new JTextField(12); // 저자명 입력필드
		private JPanel P_Return_3 = new JPanel();
			private JTextField T_Return_bookTitle = new JTextField(12); // 책제목 입력필드
		private JPanel P_Return_4 = new JPanel();
			private JButton B_Return_Add = new JButton("반          납");
		
	private JPanel P_Search = new JPanel(); // "검색"클릭시 나타날 패널 (하단 내용 프레임에 들어갈 Sub 패널)
			private JPanel P_Search_1 = new JPanel();
				private JTextField T_Search_bookPatroner = new JTextField(12); // 대출자 입력필드
			private JPanel P_Search_2 = new JPanel();
				private JTextField T_Search_bookAuthor = new JTextField(12); // 저자명 입력필드
			private JPanel P_Search_3 = new JPanel();
				private JTextField T_Search_bookTitle = new JTextField(12); // 책제목 입력필드
			private JPanel P_Search_4 = new JPanel();
				private JButton B_Search_byTitle = new JButton("제목으로 검색");
			private JPanel P_Search_5 = new JPanel();
				private JButton B_Search_byAuthor = new JButton("저자명으로 검색");
			private JPanel P_Search_6 = new JPanel();
				private JButton B_Search_byPatron = new JButton("대출자명으로 검색");
			private JPanel P_Search_7 = new JPanel();
				private JButton B_Search_Checkedoutbook = new JButton("대출된책 조회");
			private JPanel P_Search_8 = new JPanel();
				private JButton B_Search_All = new JButton("모든책 조회");

	
	
	
	
	
	
	
	/* 내용 : 윈도우 생성크기, 배치, 무슨 내용이 그려질지 생성장에 선언. 
	 *			실제 구현내용은 InitDesign()함수참고
	 */				
	public WindowOpen(String title){
		
		super(title);//상단화면의 타이틀 설정
		InitVariables();//변수초기화
		InitDesign();//화면그리기
		InitFunction();//화면구현내용 불러오기
	}
	
	
	/* 내용 : 화면 그리는데 필요한 함수 정리 부분
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
		

		this.setSize(800,600);//프레임 사이즈
        this.setVisible(true);//프레임 창 표시
	}
	
	
	/* 내용 : 필요한 함수 초기화 부분
	
	 */
	private void InitFunction(){
		
		LoadData();//화면에 뿌릴 데이터값을 읽어온다.
		LoadData_Table();
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창종료
		
		//메뉴항목
		B_Menu_Add.addActionListener(this);
		B_Menu_Patron.addActionListener(this);
		B_Menu_Return.addActionListener(this);
		B_Menu_Search.addActionListener(this);
		B_Menu_Exit.addActionListener(this);
		
		//책추가하기
		B_Addbook_Add.addActionListener(this);
		
		//책대출하기
		B_Patron_Add.addActionListener(this);
		
		
		//책반납하기
		B_Return_Add.addActionListener(this);
		
		
		//책검색하기
		B_Search_byTitle.addActionListener(this);
		B_Search_byAuthor.addActionListener(this);
		B_Search_byPatron.addActionListener(this);
		B_Search_Checkedoutbook.addActionListener(this);
		B_Search_All.addActionListener(this);
		
		//책저장하기
		B_Menu_Save.addActionListener(this);
		
	}
	
	
	/* 내용 : 사용하는 모든 변수 초기화 부분, 카탈로그 인덱스 초기화
	
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
	
	
	/* 내용: 메뉴화면을 그린다.
	 *  
	
	 */	
	private void DrawMenu(){
		
		P_Menu.setLayout(new GridLayout(1,6)); // 버튼 5개가 들어가도록 레이아웃을 5개로 쪼갠다.
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
	
	
	/* 수정내용: 레이아웃을 설정하지않으면 텍스트필드가 아주 작게 나오는 현상이 있었는데, 처음 텍스트필드
	 * 			를 생성할때, 크기를 선언하지 않아서 생긴 문제였음. 크기 선언하고 고쳐짐.
	
	 * 수정내용: 라벨을 미리 만들어서 텍스트를 입력하면 글씨가 깨져서 바로 생성
	 * 수정일자: 2010년 12월 13일 월요일 19:43
	 * 내용: 메인화면을 그린다.
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
	
	
	/* 내용 : 책 추가하기 버튼 클릭시 메인 프레임에 화면 그리기
	
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
		P_Addbook_1.add(new Label("책  제  목  :  "));
		P_Addbook_1.add(T_Addbook_bookTitle);
		P_Addbook_1.setBackground(new Color(215,225,235));
		//P_Addbook_2.setLayout(new GridLayout(1,1));
		//P_Addbook_2.add(L_Addbook_bookAuthor);
		P_Addbook_2.add(new Label("저  자  명  :  "));
		P_Addbook_2.add(T_Addbook_bookAuthor);
		P_Addbook_2.setBackground(new Color(215,225,235));
		P_Addbook_3.setLayout(new GridLayout(1,1));
		P_Addbook_3.add(B_Addbook_Add);
		P_Addbook_3.setBackground(new Color(215,225,235));
		//L_Addbook_bookTitle.setText("책제목:");
		//L_Addbook_bookTitle.setFont(new Font("돋움",Font.PLAIN,20));
		//L_Addbook_bookAuthor.setText("저자명:");
		//L_Addbook_bookAuthor.setFont(new Font("돋움",Font.PLAIN,20));
		
	}
	
	
	/* 내용 : 책 대출하기 버튼 클릭시 메인 프레임에 해당 화면 그리기
	 * 
	
	 */
	private void DrawPatron(){
		
		//메뉴부분
		P_Patron.setBounds(0,0,170,450);
		P_Patron.setBackground(new Color(215,225,235));
		P_Patron.setBorder(BorderFactory.createEtchedBorder());
		P_Patron.setLayout(new GridLayout(8,1));
		P_Patron.add(P_Patron_1);
		P_Patron.add(P_Patron_2);
		P_Patron.add(P_Patron_3);
		P_Patron.add(P_Patron_4);
		
		//P_Patron_2_1.setLayout(new GridLayout(1,1));
		P_Patron_1.add(new Label("대  출  자  :  "));
		P_Patron_1.add(T_Patron_bookPatroner);
		P_Patron_1.setBackground(new Color(215,225,235));
		//P_Patron_2_2.setLayout(new GridLayout(1,1));
		P_Patron_2.add(new Label("저  자  명  :  "));
		P_Patron_2.add(T_Patron_bookAuthor);
		P_Patron_2.setBackground(new Color(215,225,235));
		//P_Patron_2_3.setLayout(new GridLayout(1,1));
		P_Patron_3.add(new Label("책  제  목  :  "));
		P_Patron_3.add(T_Patron_bookTitle);
		P_Patron_3.setBackground(new Color(215,225,235));
		P_Patron_4.setLayout(new GridLayout(1,1));
		P_Patron_4.add(B_Patron_Add);
		P_Patron_4.setBackground(new Color(215,225,235));
		
	}
	
	
	/* 내용 : 책 반납하기  버튼 클릭시 메인 프레임에 해당 화면 그리기
	
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
		P_Return_1.add(new Label("대  출  자  :  "));
		P_Return_1.add(T_Return_bookPatroner);
		P_Return_1.setBackground(new Color(215,225,235));
		//P_Return_2_2.setLayout(new GridLayout(1,1));
		P_Return_2.add(new Label("저  자  명  :  "));
		P_Return_2.add(T_Return_bookAuthor);
		P_Return_2.setBackground(new Color(215,225,235));
		//P_Return_2_3.setLayout(new GridLayout(1,1));
		P_Return_3.add(new Label("책  제  목  :  "));
		P_Return_3.add(T_Return_bookTitle);
		P_Return_3.setBackground(new Color(215,225,235));
		P_Return_4.setLayout(new GridLayout(1,1));
		P_Return_4.add(B_Return_Add);
		P_Return_4.setBackground(new Color(215,225,235));
	}
	
	
	/* 내용 : 책 검색하기 버튼 클릭시 메인 프레임에 해당 화면 그리기
	
	 */
	private void DrawSearch(){

		//메뉴부분
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
		P_Search_1.add(new Label("대  출  자  :  "));
		P_Search_1.add(T_Search_bookPatroner);
		P_Search_1.setBackground(new Color(215,225,235));
		//P_Search_2_2.setLayout(new GridLayout(1,1));
		P_Search_2.add(new Label("저  자  명  :  "));
		P_Search_2.add(T_Search_bookAuthor);
		P_Search_2.setBackground(new Color(215,225,235));
		//P_Searh_2_3.setLayout(new GridLayout(1,1));
		P_Search_3.add(new Label("책  제  목  :  "));
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
	
	
	/* 내용 : 텍스트파일로부터 자료를 읽어온다.
	 * 			데이터 형식은 아래에 위치.
	
	 */
	private void LoadData(){
		//1번째줄 저자명
		//2번째줄 책제목
		//(3번째줄 대출자명) 그전에 #을 만나면 다음책목록으로 넘어간다.
		try{
			
			BufferedReader File_Pointer = new BufferedReader(new FileReader("data.txt"));
			String FP_Title = null;
			String FP_Author = null;
			String FP_Patron = null;
			String temp=null;
	
			while( (temp = File_Pointer.readLine()) != null){
				if(temp.substring(0,1).equals("#"))
				{
					continue;//해당 라인을 넘어간다.
				}
				
				//해당하는 라인에 구분자 "#" 이 없다면 데이터를 읽어들인다.
				FP_Author = temp;
				temp = File_Pointer.readLine();
				FP_Title = temp;
				
				temp = File_Pointer.readLine();
				
				//대출자가 없을 때는 바로 책을 추가
				if(temp.substring(0,1).equals("#")){
					includeBook(FP_Title,FP_Author);
				}
				
				//대출자가 있는경우 대출자를 추가.
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
	
	
	/*내용 : 대출탭에서 테이블에 나열할 데이터를 불러오는 함수
	
	 */
	private void LoadData_Table() {
		// TODO Auto-generated method stub
		String[] Data_Printed = { "", "", "" }; // 책제목, 저자명, 대출자
	
		
		//표에 내용을 초기화
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		//카탈로그를 다 돌때까지 반복하여 추가한다.
		for(int i = (int) 'A'; i <= (int) 'Z' ; i++){
			
			//해당인덱스에 책이 존재한다면 아래의 for문이 동작한다.		
			for(int j = 0; j < titlecatalog[i].size();j ++){
				
				Data_Printed[0] = ((Book)titlecatalog[i].get(j)).getTitle();//책제목
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

	/* 내용 : 제목으로만 검색

	 * 차후 개선사항 : 단어만으로도 책이 검색되도록 개선 가능
	 */
	private void LoadData_Table_Title(String bookTitle) {
		// TODO Auto-generated method stub
		
		String[] Data_Printed = { "", "", "" }; // 책제목, 저자명, 대출자
		//표에 내용을 초기화
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		// 입력받은 String이 단어별인지 총 단어인지 모르는 상태...
		// Catalog의 책목록의 책제목을 꺼내서 해당 책제목을 스페이스바를 기준으로 구분할필요가 있음.
		// 1. 완전히 일치하는 책제목이 있는가
		// 2. 단어별로 쪼갰을 때 일치하는 것이 있는가
		
		//책제목으로 무언가 입력을 받았다면
		if (bookTitle.length() != 0){
			
			
		
				
			//해당인덱스에 책이 존재한다면 아래의 for문이 동작한다.		
			for(int i = 0; i < titlecatalog[(int) bookTitle.charAt(0)].size();i ++){
				
				String tempTitle = ((Book) titlecatalog[(int) bookTitle.charAt(0)].get(i)).getTitle();
				int tempSpliter = tempTitle.indexOf((int) ' ');
				String tempWord = tempTitle.substring(0,tempSpliter);
				
				if(	bookTitle.equals( 
						tempTitle)
					){	//책제목이 일치
					
					Data_Printed[0] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getTitle();//책제목
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
				
				//첫단어만 일치
				else if( bookTitle.equals( tempWord ) ){
					
					Data_Printed[0] = ((Book)titlecatalog[(int)bookTitle.charAt(0)].get(i)).getTitle();//책제목
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
				

			//입력된값은 있지만 일치하는 정보가 없다.
			if( Data_Printed[0].equals("") && Data_Printed[1].equals("") && Data_Printed[2].equals("")){
				JOptionPane.showMessageDialog(B_Search_byPatron, "해당하는 책제목의 책은 도서관에 없습니다.");
			}
	
		}
		else{//책제목이 입력된 것이 없을 때.
			JOptionPane.showMessageDialog(B_Search_byTitle, "책제목을 입력하고 검색하십시오.");
		}
		
	}


	private void LoadData_Table_Author(String bookAuthor) {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		
		String[] Data_Printed = { "", "", "" }; // 책제목, 저자명, 대출자
		//표에 내용을 초기화
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		// 입력받은 String이 단어별인지 총 단어인지 모르는 상태...
		// Catalog의 책목록의 책제목을 꺼내서 해당 책제목을 스페이스바를 기준으로 구분할필요가 있음.
		// 1. 완전히 일치하는 책제목이 있는가
		// 2. 단어별로 쪼갰을 때 일치하는 것이 있는가
		
		//책제목으로 무언가 입력을 받았다면
		if (bookAuthor.length() != 0){
			
			
		
				
			//해당인덱스에 책이 존재한다면 아래의 for문이 동작한다.		
			for(int i = 0; i < authorcatalog[(int) bookAuthor.charAt(0)].size();i ++){
				
				String tempAuthor = ((Author) authorcatalog[(int) bookAuthor.charAt(0)].get(i)).getName();
				
				if(	bookAuthor.equals(tempAuthor)){	//저자명이 일치
					
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
			
			

			//입력된값은 있지만 일치하는 정보가 없다.
			if( Data_Printed[0].equals("") && Data_Printed[1].equals("") && Data_Printed[2].equals("")){
				JOptionPane.showMessageDialog(B_Search_byAuthor, "해당하는 저자명으로 저술된 책은 없습니다.");
			}	
				
		}
		else{//책제목이 입력된 것이 없을 때.
			JOptionPane.showMessageDialog(B_Search_byTitle, "저자명을 입력하고 검색하십시오.");
		}
	}

	/* 내용 : 대출자명으로 검색해서 해당 대출자가 어떤 책을 빌렸는지 나열한다.
	
	 */

	private void LoadData_Table_Patron(String bookPatroner) {
		// TODO Auto-generated method stub

		String[] Data_Printed = { "", "", "" }; // 책제목, 저자명, 대출자
		//표에 내용을 초기화
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
			
			//입력된값은 있지만 일치하는 정보가 없다.
			if( Data_Printed[0].equals("") && Data_Printed[1].equals("") && Data_Printed[2].equals("")){
				JOptionPane.showMessageDialog(B_Search_byPatron, "해당하는 이름으로 대출하신 분은 없습니다.");
			}
		}
		else
			JOptionPane.showMessageDialog(B_Search_byPatron, "대출자명을 입력하세요.");
	}


	/* 내용 : 대출된 책들을 나열한다.
	 * 		
	 */
	private void LoadData_Table_Checkedoutbook() {
	// TODO Auto-generated method stub
		
		String[] Data_Printed = { "", "", "" }; // 책제목, 저자명, 대출자
		//표에 내용을 초기화
		int rowcount = DTB_Common.getRowCount();
		for(int i = 0;i < rowcount; i++)
			DTB_Common.removeRow(0);
		
		
		for(int i= 'A'; i <= 'Z' ; i++){
			
			for(int j = 0; j < titlecatalog[i].size(); j++){
			
				
				//해당책은 대출되었다.
				if( ((Book)titlecatalog[i].get(j)).getPatron() != null ){
					
					Data_Printed[0] = ((Book)titlecatalog[i].get(j)).getTitle();
					Data_Printed[1] = ((Book)titlecatalog[i].get(j)).getAuthor().getName();
					Data_Printed[2] = ((Book)titlecatalog[i].get(j)).getPatron().getName();
					DTB_Common.addRow(Data_Printed);
				}
				
				
			}
		}
		
		
		
	}


	/* 내용 : 리스트로 정리되있는 자료들을 파일형태로 저장한다. authorcatalog, titlecatalog
	 * 		둘중어느것을 사용해도 상관없지만 여기서 편의상 titlecatalog를 썼다. 저장시 책제목순서로 저장된다.
	
	 */
	private void SaveData(BookList[] catalog){
		
		try{
			// BufferedWriter 의 write(Object o) 에서 String을 제외한 
			// 객체는 입력이 안되는 문제가 발생...? 정수가 입력이 안되는...??? 쌍다옴표로 스트링만 처리됨.
			//BufferedWriter File_Pointer = new BufferedWriter(new FileWriter("data.txt"));
			PrintWriter File_Pointer = new PrintWriter(new FileWriter("data.txt"));
			String tempTitle;
			String tempAuthor;
			String tempPatron;
			
			for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
				
				//catalog[i].size(); // 해당 인덱스에 몇개의 책이 저장되있는가
				//인덱스안에 북리스트가 있는가
				if(catalog[i].isEmpty()){ //true 없다.
					//JOptionPane.showMessageDialog(B_Menu_Save, i + " 번째 인덱스는 비어있습니다.");
					continue;
				}
				else{//false 있다.
					//JOptionPane.showMessageDialog(B_Menu_Save, i + " 번째 인덱스는 현재 " + catalog[i].size() + "개의 데이터가 있습니다.");
					for(int j = 0; j < catalog[i].size() ; j++){
						
						//JOptionPane.showMessageDialog(B_Menu_Save, "For문안 " + j + ((Book) catalog[i].get(j)).getTitle() );
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
			JOptionPane.showMessageDialog(B_Menu_Save, "정상적으로 저장됐습니다.");
			File_Pointer.close();
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(B_Menu_Save, "오류가 발생했습니다.");
			return;
		}
	}
	
	/*
	 * 내용: 새로운 책을 추가하는 함수
	
	 * 추가 개선사항 : 같은 책제목이 들어왔을 때의 처리부분
	 */
	private void includeBook() {

		Author newAuthor = new Author();
		Book newBook = new Book();
		int oldAuthor, oldBook; // AuthorName, BookTitle을 Indexing한 정수값을 갖는다.

		if(T_Addbook_bookAuthor.getText().length() !=0 && T_Addbook_bookTitle.getText().length() != 0){
		
			//책을 추가할 때 생성되어야 하는 객체는 Author 와 Book
			// Author 에는 BookList, Author Name를 추가
			// Book 에는 BookTitle, Author Name, Patroner 를 추가
			
			newAuthor.name = T_Addbook_bookAuthor.getText();//Author 저자명 기입
						
			oldAuthor = authorcatalog[(int)
			                	newAuthor.name.charAt(0)].indexOf(newAuthor);//Index만들기
			
			
			//Author BookList에 newBook을 추가
			//authorcatalog목록에 존재하지  않는 새로운 작가
			if (oldAuthor == -1) {
				newAuthor.books.add(newBook);//작가의 책리스트에 책 추가
				authorcatalog[(int) newAuthor.name.charAt(0)].add(newAuthor);//카탈로그 인덱스항에 저자명추가
			}
			//목록에 동일한 이름의 작가가 있다. 책목록만 추가
			else ((Author)authorcatalog[(int) newAuthor.name.charAt(0)].
					get(oldAuthor)).books.add(newBook);
			
			
			//새로만든 책에 책 등록
			newBook.title = T_Addbook_bookTitle.getText();
			//책의 저자 연결
			newBook.author = newAuthor;
			
			oldBook = titlecatalog[(int)
			                       newBook.title.charAt(0)].indexOf(newBook);
			
			//titlecatalog목록에 존재하지 않는 책. 카테고리에 해당 책을 추가
			if (oldBook == -1) {
				titlecatalog[(int) newBook.title.charAt(0)].add(newBook);
				JOptionPane.showMessageDialog(B_Addbook_Add, "새 책이 데이터에 추가되었습니다.");	
			}
			else{
				JOptionPane.showMessageDialog(B_Addbook_Add, "동일한 책제목이 존재합니다. 추가불가능.");
			}			
			
		}
		
		//저자명이나 책제목 둘중 하나가 입력되지 않을 때 에러 발생
		else{
			JOptionPane.showMessageDialog(B_Addbook_Add, "저자명, 책제목을 모두 기입하세요");	
		}
	}
	
	private void includeBook(String Title, String Author){
		Author newAuthor = new Author();
		Book newBook = new Book();
				
		int oldAuthor, oldBook; // AuthorName, BookTitle을 Indexing한 정수값을 갖는다.

		if(Author.length() !=0 && Title.length() != 0){
		
			//책을 추가할 때 생성되어야 하는 객체는 Author 와 Book
			// Author 에는 BookList, Author Name를 추가
			// Book 에는 BookTitle, Author Name, Patroner 를 추가
			
			newAuthor.name = Author;//Author 저자명 기입
						
			oldAuthor = authorcatalog[(int)
			                	newAuthor.name.charAt(0)].indexOf(newAuthor);//Index만들기
			
			
			//Author BookList에 newBook을 추가
			//authorcatalog목록에 존재하지  않는 새로운 작가
			if (oldAuthor == -1) {
				newAuthor.books.add(newBook);//작가의 책리스트에 책 추가
				authorcatalog[(int) newAuthor.name.charAt(0)].add(newAuthor);//카탈로그 인덱스항에 저자명추가
			}
			//목록에 동일한 이름의 작가가 있다. 책목록만 추가
			else ((Author)authorcatalog[(int) newAuthor.name.charAt(0)].
					get(oldAuthor)).books.add(newBook);
			
			
			
			
			//새로만든 책에 책 등록
			newBook.title = Title;
			//책의 저자 연결
			newBook.author = newAuthor;
			
			oldBook = titlecatalog[(int)
			                       newBook.title.charAt(0)].indexOf(newBook);
			
			//titlecatalog목록에 존재하지 않는 책. 카테고리에 해당 책을 추가
			if (oldBook == -1) {
				titlecatalog[(int) newBook.title.charAt(0)].add(newBook);
				//JOptionPane.showMessageDialog(B_Addbook_Add, "새 책이 데이터에 추가되었습니다.");	
			}
			else{
				//JOptionPane.showMessageDialog(B_Addbook_Add, "동일한 책제목이 존재합니다. 추가불가능.");
			}			
			
		}
	}
	
	
	/* 내용 : 대출자가 있을 경우의 데이터 로드 함수

	 */
	private void includeBook(String Title, String Author, String Patron){
		Author newAuthor = new Author();
		Book newBook = new Book();
		Patron newPatron = new Patron();
		
		int oldAuthor, oldBook, oldPatron; // AuthorName, BookTitle을 Indexing한 정수값을 갖는다.

		if(Author.length() !=0 && Title.length() != 0){
		
			//책을 추가할 때 생성되어야 하는 객체는 Author 와 Book
			// Author 에는 BookList, Author Name를 추가
			// Book 에는 BookTitle, Author Name, Patroner 를 추가
			
			newAuthor.name = Author;//Author 저자명 기입
						
			oldAuthor = authorcatalog[(int)
			                	newAuthor.name.charAt(0)].indexOf(newAuthor);//Index만들기
			
			
			//Author BookList에 newBook을 추가
			//authorcatalog목록에 존재하지  않는 새로운 작가
			if (oldAuthor == -1) {
				newAuthor.books.add(newBook);//작가의 책리스트에 책 추가
				authorcatalog[(int) newAuthor.name.charAt(0)].add(newAuthor);//카탈로그 인덱스항에 저자명추가
			}
			//목록에 동일한 이름의 작가가 있다. 책목록만 추가
			else ((Author)authorcatalog[(int) newAuthor.name.charAt(0)].
					get(oldAuthor)).books.add(newBook);
			
			newPatron.name = Patron; //대출자명 기입
			
			oldPatron = people[(int)
			                   newPatron.name.charAt(0)].indexOf(newPatron);
			
			if (oldPatron == -1) {
				newPatron.books.add(newBook);
				people[(int) newPatron.name.charAt(0)].add(newPatron);
			}
			else ((Patron)people[(int) newPatron.name.charAt(0)].get(oldPatron)).books.add(newBook);
			
			//새로만든 책에 책 등록
			newBook.title = Title;
			//책의 저자 연결
			newBook.author = newAuthor;
			newBook.patron = newPatron;
			
			oldBook = titlecatalog[(int)
			                       newBook.title.charAt(0)].indexOf(newBook);
			
			//titlecatalog목록에 존재하지 않는 책. 카테고리에 해당 책을 추가
			if (oldBook == -1) {
				titlecatalog[(int) newBook.title.charAt(0)].add(newBook);
				//JOptionPane.showMessageDialog(B_Addbook_Add, "새 책이 데이터에 추가되었습니다.");	
			}
			else{
				//JOptionPane.showMessageDialog(B_Addbook_Add, "동일한 책제목이 존재합니다. 추가불가능.");
			}			
			
		}
		
		//저자명이나 책제목 둘중 하나가 입력되지 않을 때 에러 발생
		else{
			//JOptionPane.showMessageDialog(B_Addbook_Add, "저자명, 책제목을 모두 기입하세요");	
		}
		//JOptionPane.showMessageDialog(B_Addbook_Add, "데이터가 로드 됐습니다.");
	}
	
	
	
		
	
	private void PatronBook() {
		// TODO Auto-generated method stub
		//Object temp = new Object();
		
		
		if( T_Patron_bookTitle.getText().length() != 0 &&	//3개의 입력필드 모두에 값이 들어왔다.
			T_Patron_bookAuthor.getText().length() != 0 &&
			T_Patron_bookPatroner.getText().length() != 0 ){
			
			String tempTitle = T_Patron_bookTitle.getText();
			String tempAuthor = T_Patron_bookAuthor.getText();
			String tempPatroner = T_Patron_bookPatroner.getText();			
			int hasBook = 0;
			//책제목과 저자명으로 해당 책이 존재하는지에 대한 체크가 필요.
			hasBook = titlecatalog[(int) T_Patron_bookTitle.getText().charAt(0)].size();
			
			if(hasBook > 0)//책제목의 첫글자로 같은 것이 있는지 체크해서 찾아들어간다....
			{
				//JOptionPane.showMessageDialog(B_Patron_Add, "해당인덱스 존재");
				for(int i=0; i < hasBook ; i++)
				{
					Book tempBook = ((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i));
					//JOptionPane.showMessageDialog(B_Patron_Add, "입력값 : " + tempTitle + ", 출력값 : " + tempBook.getTitle() + ", 입력저자 : " + tempAuthor + " 출력값 : " + tempBook.getAuthor().getName());
					if(	tempTitle.equals( 
							tempBook.getTitle()) 
							&&
						tempAuthor.equals(
							tempBook.getAuthor().getName())
						){	//대출하려는 책과 똑같은 제목의 책이 존재한다.
						
						if(tempBook.getPatron() == null){//해당책이 대출된적이 있는가? 없다면
							
						
							Patron newPatroner = new Patron();
							newPatroner.name = tempPatroner;
							int oldPatroner;
							
							oldPatroner = people[(int)
							                       newPatroner.name.charAt(0)].indexOf(newPatroner);
							
							
							if(oldPatroner == -1){//기존에 명단에 없던 대출자
								newPatroner.books.add(	((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i))	);
								((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).patron = newPatroner;
								people[(int) newPatroner.name.charAt(0)].add(newPatroner);
								JOptionPane.showMessageDialog(B_Patron_Add, tempPatroner + "님, 처음 책을 빌리시네요.");
								//this.SaveData(titlecatalog);
								break;
							}
							else{//기존에 명단에 존재하는 대출자
								((Patron) people[(int) newPatroner.name.charAt(0)].get(oldPatroner)).books.add(	((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i))	);
								((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).patron = newPatroner;
								JOptionPane.showMessageDialog(B_Patron_Add, tempPatroner + "님, 책이 대출되었습니다.");
								//this.SaveData(titlecatalog);
								break;
							}	
						
						}
						else{
							JOptionPane.showMessageDialog(B_Patron_Add, tempPatroner + "님, 해당책은 대출중입니다.");
							break;
						}
					}
				}
			}
			else//
			{
				JOptionPane.showMessageDialog(B_Patron_Add, "해당 책은 Library가 가지고 있지 않습니다.");
			}
			
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(B_Patron_Add, "저자명, 책제목, 대출자명을 정확히 기입하시오.");
		}
		
		
	}


	private void ReturnBook() {
		// TODO Auto-generated method stub
		//Object temp = new Object();
		
		
		if( T_Return_bookTitle.getText().length() != 0 &&	//3개의 입력필드 모두에 값이 들어왔다.
			T_Return_bookAuthor.getText().length() != 0 &&
			T_Return_bookPatroner.getText().length() != 0 ){
			
			String tempTitle = T_Return_bookTitle.getText();
			String tempAuthor = T_Return_bookAuthor.getText();
			String tempPatroner = T_Return_bookPatroner.getText();
			
			int hasBook = 0;
			//책제목과 저자명으로 해당 책이 존재하는지에 대한 체크가 필요.
			hasBook = titlecatalog[(int) T_Return_bookTitle.getText().charAt(0)].size();
			
			if(hasBook > 0)//책제목의 첫글자로 같은 것이 있는지 체크해서 찾아들어간다....
			{
				//JOptionPane.showMessageDialog(B_Patron_Add, "해당인덱스 존재");
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
					){	//반납자 정보와 책, 저자명이 일치
						
						if(tempPatroner.equals(
							tempBook.getPatron().getName())){
							JOptionPane.showMessageDialog(B_Return_Add, tempBook.getPatron().getName() + "님께서 책을 반납하였습니다.");
							((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).getPatron().books.remove(((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)));
							((Book) titlecatalog[(int) tempTitle.charAt(0)].get(i)).patron = null;
							//this.SaveData(titlecatalog);
							break;
						}
						else{
							JOptionPane.showMessageDialog(B_Return_Add, "대출자명이 잘못 입력되었습니다.");
						}
						
						
					}
					else{
						if(i==hasBook-1)
						JOptionPane.showMessageDialog(B_Return_Add, "대출된 책과 반납정보가 일치하지 않습니다.");
					}
				}
			}
			else//
			{
				JOptionPane.showMessageDialog(B_Return_Add, "해당 책은 Library가 가지고 있지 않습니다.");
			}
			
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(B_Return_Add, "저자명, 책제목, 대출자명을 정확히 기입하시오.");
		}
	}



	/* 화면의 각종 버튼 클릭 시 구현되는 모든 이벤트 구현 부분
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
			LoadData_Table(); // 책제목순서로 나열된다.
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
		if(e.getSource() == B_Menu_Exit){//종료버튼 선택시
			System.exit(0);
		}
		
	}


}

