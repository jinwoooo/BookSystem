class Book {
	
	public String title;//책제목
	public Author author;//저자명
	public Patron patron = null;//책대여자
	
	public Book() {
	
	}
	
	//같은 책제목이 있는가
	//차후 확장여부 : 같은 책제목이더라도 저자가 다르면 입력받을 수 있게 수정
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