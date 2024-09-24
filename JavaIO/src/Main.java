import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileManager fileManager = new FileManager();
		String filePath = "C:\\Users\\shrilakshmi.shetty\\eclipse-workspace\\sample.txt";
		String content = "Helooo guys how are youuuu????";
		fileManager.createFile(filePath, content);
		System.out.println(fileManager.readFile(filePath));
		content = "\nnew line has been appended to the above file!\n";
		fileManager.appendToFile(filePath, content);
		System.out.println(fileManager.readFile(filePath));
		
		String sourcePath = "C:\\Users\\shrilakshmi.shetty\\eclipse-workspace\\sample.txt";
		String destPath = "C:\\Users\\shrilakshmi.shetty\\eclipse-workspace\\sample.txt";
		fileManager.copyFile(sourcePath, destPath);
		System.out.println(fileManager.readFile(destPath));
		
		String dirPath = "C:\\Users\\shrilakshmi.shetty\\eclipse-workspace\\";
		System.out.println(fileManager.listDirectory(dirPath));
		
		fileManager.deleteFile(filePath);
//		confirming delete
		fileManager.deleteFile(filePath);
		
		dirPath = "C:\\Users\\shrilakshmi.shetty\\eclipse-workspace\\StreamsAndLamda\\src\\com\\shri\\Streams";
		String extension = ".java";
		System.out.println(fileManager.listDirectory(dirPath));
		System.out.println(fileManager.searchFilesByExtension(dirPath, extension).toString());
		
		String sourceDirPath = "C:\\Users\\shrilakshmi.shetty\\OneDrive - VCTI\\Documents\\snmp";
		String destDirPath = "C:\\Users\\shrilakshmi.shetty\\OneDrive - VCTI\\Documents\\snmp1";
		System.out.println(fileManager.listDirectory(sourceDirPath));
		fileManager.copyDirectory(sourceDirPath, destDirPath);
		System.out.println(fileManager.listDirectory(destDirPath));
	}
 
}
 
