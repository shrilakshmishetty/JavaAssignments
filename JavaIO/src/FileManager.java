
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
 
public class FileManager {
	public void createFile(String filePath, String content) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("File "+ filePath + " created successfully");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readFile(String filePath) {
		String result="";
		
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
			    content.append(line).append("\n");
			}
			bufferedReader.close();
			 result = content.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;	
	}
	public void appendToFile(String filePath, String content) {
		try {
			FileWriter fileWriter = new FileWriter(filePath,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
			System.out.println("Content appended successfully in "+filePath);
			bufferedWriter.close();
			fileWriter.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile(String sourcePath, String destPath) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(sourcePath)));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(destPath)));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
		        bufferedWriter.write(line);
		        bufferedWriter.newLine();
		    }
			bufferedWriter.close();
			bufferedReader.close();
			System.out.println("Copied successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFile(String filePath) {
		try {
			File file = new File(filePath);
			if(file.delete()) {
				System.out.println(file + " deleted successfully!");
			} else {
				System.out.println(file + " not found!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> listDirectory(String dirPath) {
		List<String> list = new ArrayList<>();
		try {
			File file = new File(dirPath);
			String[] fileAndDirArray = file.list();
			for(String fileAndDir:fileAndDirArray) {
				list.add(fileAndDir);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void copyDirectory(String sourceDirPath,String destDirPath) {
		try {
            Path sourceDir = Paths.get(sourceDirPath);
            Path destDir = Paths.get(destDirPath);
            
            Files.walk(sourceDir).forEach(source -> {
                Path destination = destDir.resolve(sourceDir.relativize(source));
                try {
                    if (Files.isDirectory(source)) {
                        if (!Files.exists(destination)) {
                            Files.createDirectory(destination);
                        }
                    } else {
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            });
            System.out.println("Directory copied successfully from " + sourceDirPath + " to " + destDirPath);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	public List<String> searchFilesByExtension(String dirPath, String extension){
		List<String> filesListByExtension = new ArrayList<>();
		try {
			List<String> fileAndDirList = listDirectory(dirPath);
			for(String fileAndDir:fileAndDirList) {
				if(fileAndDir.endsWith(extension)) {
					filesListByExtension.add(fileAndDir);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return filesListByExtension;
	}
}