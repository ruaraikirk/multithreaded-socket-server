import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * This main method acts as the entry point to the client side program and attempts to 
 * connect to the server on a given port (in this case port 44444). 
 */

public class GolfClient {

	public static void main(String[] args) {
		
		// Data
		String hostName = "127.0.0.1";
		int portNumber = 44444;
		Socket clientSocket;
		PrintWriter out;
		BufferedReader in;
		InputStreamReader ir;
		
		try {
			clientSocket = new Socket(hostName, portNumber); // Create new Socket object and establish connection to server.
			
			// Create IO streams:
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			ir = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(ir);
			
			while(true) {
				// Client menu
				System.out.println("Welcome to the DT265A Golf Classic Portal.");
				System.out.println("1. Register Player");
				System.out.println("2. Enter Score");
				System.out.println("3. Display Top Player");
				//System.out.println("4. Display All Players");
				System.out.println("Please enter option:");
				
				Scanner scanner = new Scanner(System.in); // Create Scanner object to read input from console.
				// Scanner is a class in java.util package used for obtaining the input of the primitive types like int, double etc. and strings.
				String stdIn = scanner.nextLine(); // Take user input from console as String.
				int userInput1 = Integer.parseInt(stdIn); // Call method to  convert String to Integer.
				
				switch(userInput1) {
				case 1: // Case to register Player.
					System.out.println("Register");
					out.println("register"); // Send register command to server.
					System.out.println("Enter your name:");
					String name = scanner.nextLine();
					out.println(name); // Send Player name to server.
					System.out.println("Your competition code is: " + in.readLine()); // Read/Get response from server.
					break;
					
				case 2: // Case to input Player score.
					out.println("score"); // Send score command to server
					System.out.println("Enter your competition code:");
					String compCode = scanner.nextLine();
					out.println(compCode);
					System.out.println("Enter your score: ");
					String score = scanner.nextLine();
					out.println(score);
					System.out.println(in.readLine());
					break;
					
				case 3: // Case to return the current leader.
					System.out.println("Current competition leader:");
					out.println("high"); // Send high command to server.
					System.out.println(in.readLine());
					System.out.println(in.readLine());
					System.out.println(in.readLine());
					break;

				default: System.out.println("You entered an invalid option!"); // Default if user does not enter an integer 1-3.
				
				} // end switch statements
				
			} // end while loop
			
		} catch (UnknownHostException e) {
			System.exit(1);
		} catch (IOException e) {
			System.exit(1);
		} // end try catch
		
	} // end main

} // end class
