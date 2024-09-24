import java.io.*;
import java.net.*;

public class ChatClient {
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        try {
            // Connect to the server
            socket = new Socket("localhost", 6666);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Read and send username
            System.out.println(in.readLine()); // Prompt from the server
            String username = userInput.readLine();
            out.println(username);

            // Start a thread to listen for messages from the server
            Thread listenerThread = new Thread(() -> {
                String messageFromServer;
                try {
                    while ((messageFromServer = in.readLine()) != null) {
                        System.out.println(messageFromServer); 
                       // Print server message to the client console
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            listenerThread.start();

            // Main thread handles user input and sends messages to the server
            String message;
            while (true) {
                message = userInput.readLine();
                if (message.equalsIgnoreCase("/exit")) {
                    out.println(message);
                    break;
                    
                }
                else if(message.equalsIgnoreCase("/list")) {
                	out.println(message);
                	
                }
                else {
                
                
                out.println(message);
                }
            }

        }catch (SocketException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
