import java.net.*;
import java.io.*;
	
	public class Server {
	    public static void main(String[] args){
	        try {
	        
	            ServerSocket server = new ServerSocket(6013); // we use a 6013 port number
	            Socket client = server.accept(); // we establish a connection and waited for the client
	            
	            while(true){
	            
	            // if the client is connected 
	                if(client.isConnected()){ 
	                // display
	                    System.out.println("Connected");
	                    PrintWriter print = new PrintWriter(client.getOutputStream(), true);
			
	                    InputStream input = client.getInputStream();
	                    BufferedReader read = new BufferedReader(new InputStreamReader(input));
	                    String message = read.readLine();
			// server response
	                    print.println("Server: "+message);
	                }
	            }
	            
	        } 
	        catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}
