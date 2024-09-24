import java.io.Serializable;

public class Book implements Serializable{
	String title;
	String author;
	String yearPublished;
	String isbn;
	
	Book(String title,String author,String yearPublished,String isbn){
		this.title=title;
		this.author=author;
		this.yearPublished=yearPublished;
		this.isbn=isbn;
		
	}
	
	String getTitle() {
		return title;
	}
	String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "Book Title : "+title+"\n"+"Author : "+author+"\n"+"Published Year : "+yearPublished+"\n";
	}
	
	
	

}
