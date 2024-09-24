import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		// TODO Auto-generated method stub
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		Library library=new Library(key);
		library.addBook(new Book("Inferno","Dan Brown","2020","1"));
		library.addBook(new Book("Harry Potter","jk Rowling","2004","2"));
		library.addBook(new Book("The host","Stephenie Meyer","2018","3"));
		library.listBooks();
		library.saveLibrary("file1.txt");
		library.loadLibrary("file1.txt");
	

	}

}
