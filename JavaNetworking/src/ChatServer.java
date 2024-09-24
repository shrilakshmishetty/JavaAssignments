import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    static List<ClientHandler> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Server has started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            list.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                out.println("Enter your username:");
                username = in.readLine();
                ChatServer.broadcast(username + " has joined the chat.",this);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("/exit")) {
                        list.remove(this);
                    	ChatServer.broadcast(username + " has left the chat.",this); 
                    }     
                    else if(message.equalsIgnoreCase("/list")) {
                    	out.println("the list of people in the chat");
                    	for(ClientHandler c:list) {
                    		out.println(c.username); 
                    	}
                    }else {
                    ChatServer.broadcast(username + ": " + message,this);}
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
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }

    public static void broadcast(String message,ClientHandler sender) {
    

       
            for (ClientHandler client : list) {
                if(client!=sender) {
                           	client.sendMessage(message);
                }    
        }
    }
}
