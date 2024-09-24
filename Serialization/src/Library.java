import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Library implements Serializable{
	List<Book> books;
	private transient SecretKey key;
	public Library(SecretKey key){
		books=new ArrayList<>();
		this.key=key;
		
	}
	void addBook(Book book) {
		books.add(book);
		System.out.println(book.getTitle()+" has been successfully added ");
	}
	void removeBook(String isbn) {
		for(Book b:books) {
			if(b.getIsbn().equals(isbn)) {
				books.remove(b);
			}
		}
		
	}
	void listBooks() {
		System.out.println("The list of books are : \n");
		for(Book b:books) {
			System.out.println(b);
			
		}
		
	}
	void saveLibrary(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
		
		//System.out.println(key);
		Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
		FileOutputStream file=new FileOutputStream(filename);
		ObjectOutputStream serial=new ObjectOutputStream(file);
		CipherOutputStream cos = new CipherOutputStream(serial,cipher);
		serial.writeObject(this);
		
		
		
		
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		
		
		
	}
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		
	}
	
	void loadLibrary(String filename) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
		
		System.out.println(key);
		Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
	
		FileInputStream file1=new FileInputStream(filename);
		ObjectInputStream deserial=new ObjectInputStream(file1);
		CipherInputStream cos = new CipherInputStream(deserial,cipher);
	    Library deserialized=(Library)deserial.readObject();
	deserialized.listBooks();
	
		
		
		
	}

}
