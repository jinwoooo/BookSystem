
//�� �۰���  ����å�� ���������Ƿ� �ϸ���Ʈ ����. �ϸ���Ʈ����
//���ڰ� ����å�� ��� ����.

class Author {
	
	public String name;//���ڸ�
	public BookList books = new BookList();//���ڰ� �� å ����Ʈ.
	
	public Author() {
	}
	
	
	//���� �̸��� ���ڰ� �ִ��� üũ
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