class Patron {
	
	public String name;//�����ڸ�
	public BookList books = new BookList();//������ å ���
	
	public Patron() {
		
	}
	
	public boolean equals(Object node) {
		return name.equals(((Patron) node).name);
	}

	
	public String getName() {
		return this.name;
	}
	
	public BookList getBookList() {
		return this.books;
	}
}