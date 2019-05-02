import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * The SocketServer class when called will create an object that will listen 
 * for client connections on a given port (in this case port 44444).
 */

public class SocketServer {
	int portNumber = 44444;
    ServerSocket serverSocket = null;
    PlayerList mainList = new PlayerList(); // Create an object of type PlayerList (which stores Player objects and provides methods using an ArrayList).
    
    
    public void runServer () {
    	try {
            serverSocket = new ServerSocket(portNumber); // Create new server socket which listens on a given port number.
            
		} catch (IOException e) {
            System.out.println(e.getMessage());
        }
    	
    	// Create an infinite loop, accepting connections from client programs.
    	while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new GolfRunnable(clientSocket, mainList)).start(); // Each client connection accepted will be passed to a thread for execution (along with the shared list of players).
                // The socket will be kept open between the client and the server until the client disconnects.
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
