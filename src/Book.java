class Book {
	
	public String title;//å����
	public Author author;//���ڸ�
	public Patron patron = null;//å�뿩��
	
	public Book() {
	
	}
	
	//���� å������ �ִ°�
	//���� Ȯ�忩�� : ���� å�����̴��� ���ڰ� �ٸ��� �Է¹��� �� �ְ� ����
	public boolean equals(Object node) {
		return title.equals(((Book) node).title);
	}
	
	public String toString() {
		return " * " + title + (patron != null ? " - checked out to " + patron.name : "") + "\n";
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	public Author getAuthor() {
		return this.author;
	}
	public Patron getPatron() {
		return this.patron;
	}
	
	public void setAuthor(Object o) {
		this.author = (Author) o;
	}
	
	public void setPatron(Object o) {
		this.patron = (Patron) o;
	}
	
}