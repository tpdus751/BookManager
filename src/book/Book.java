package book;

public class Book {
	private int no;
	private String name;
	private String genre;
	private String author;
	private String publisher;
	private int price;
	
	public Book(int no, String name, String genre, String author, String publisher, int price) {
		this.no = no;
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public Book(String name, String genre, String author, String publisher, int price) {
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + ", genre=" + genre + ", author=" + author + ", publisher="
				+ publisher + ", price=" + price + "]";
	}
	
}
