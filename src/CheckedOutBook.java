
//대출된 책들을 저장하고 나열해주는 능력.
//Book 객체에 Author 객체가 추가된 이후 이 객체의 용도가.... 필요없어짐.

class CheckedOutBook {
	
	public Author author = null; // 저자객체 ( 저자명, 책리스트 )
	public Book book = null; // 책 ( 책제목, 작가객체, 빌려간사람객체 )

	public CheckedOutBook() {
	}

}