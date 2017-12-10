class Patron {
	
	public String name;//대출자명
	public BookList books = new BookList();//대출한 책 목록
	
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