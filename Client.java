import java.net.*;
import java.io.*;
	
	public class Client{
	    public static void main(String[] args){
	    
	        try {
	        
	            Socket socket = new Socket("127.0.0.1",6013);// port number
	            
	            while(true){
	            	//get the message
	                PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
	                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	                System.out.print("Please enter message: ");
	                String message = in.readLine();
	                
	                print.println(message);
			// display the server messsage
	                InputStream input = socket.getInputStream();
	                BufferedReader read = new BufferedReader(new InputStreamReader(input));
	                String Response = read.readLine();
	                System.out.println(Response); 
		//condition
	                System.out.print("Do you want to continue? (y/n) "); 
	                String resp = in.readLine();
	                
	                if(!(resp.equals("y")))
	                {
	                    in.close();
	                    socket.close();
	                    break;
	                }   
	            }
	            
	        } 
	        catch (Exception e) 
	        {
	            System.out.println(e);
	        }
        }
     }
	
	    
	
