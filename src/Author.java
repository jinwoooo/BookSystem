
//한 작가가  여러책을 쓸수있으므로 북리스트 생성. 북리스트에는
//저자가 만든책이 모두 존재.

class Author {
	
	public String name;//저자명
	public BookList books = new BookList();//저자가 쓴 책 리스트.
	
	public Author() {
	}
	
	
	//같은 이름의 저자가 있는지 체크
	public boolean equals(Object node) {
		return name.equals(((Author) node).name);
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public BookList getBookList() {
		return this.books;
	}
}