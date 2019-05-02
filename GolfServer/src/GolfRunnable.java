import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * The GolfRunnable class when called will create an object that will be run in a thread.
 * The GolfRunnable class implements the Runnable interface, which should be implemented 
 * by any class whose instances are intended to be executed by a thread.
 */

public class GolfRunnable implements Runnable {
	protected Socket clientSocket = null;
	protected PlayerList mainList = null; //new PlayerList(); // Create an object of type PlayerList (which stores Player objects and provides methods using an ArrayList.
	private Player p; // Defines a Player object that will be used to pass Player information from the client to the PlayerList object.
	
	public GolfRunnable(Socket clientSocket, PlayerList mainList) { // Pass in client socket and player list via constructor (avoid dependency).
		this.clientSocket = clientSocket;
		this.mainList = mainList;
	}

	public void run() {
		
		try {
			
			/*
			 * The BufferedReader and InputStreamReader are used to get data from the client program.
			 * The PrintWriter is used to send data from the server to the Client.
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);	
						
			while(true) {
				String userInput = in.readLine(); // Read in option from client.
				
				switch(userInput) {
				case "register":
					String newPlayerName = in.readLine(); // Create String parameter to be passed into Player constructor.
					p = new Player(newPlayerName); // Create Player object.
					// PLEASE NOTE: Missing code validation step (compare new code to existing Player codes...
					mainList.addToList(p); // Populate ArrayList with Player data (register Player).
					out.println(p.getCode()); // Send the result to the client program.
					break;
				
				case "score":
					String compCode; // Create String parameter to be passed into updateScore method.
					int score; // Create integer parameter to be passed into updateScore method.
					compCode = in.readLine(); // Read in competition code from client.
					score = Integer.parseInt(in.readLine()); // Read in score from client.
					mainList.updateScore(score, compCode); // Call update score method.
					out.println("Score registered successfully!"); // Send the result to the client program.
					break;
			
				case "high":
					mainList.sortPlayers(); // Call sort players method.
					Player top = mainList.getCompetitionList().get(0); // Get the current winner (lowest score).
					// Send result to client (name and score).
					out.println("--------------------------------------------------------");
					out.printf("[Name = %s, Score = %s]\n", 
							top.getName(), top.getScore());
					out.println("--------------------------------------------------------");
					break;
					
				default: // Display to browser
					String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "<h1>DT265A Golf Classic Leaderboard:</h1>" 
							+ mainList.displayAll() +  "<p>";
					this.clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
					this.clientSocket.close();
                	break;

				}
				
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
