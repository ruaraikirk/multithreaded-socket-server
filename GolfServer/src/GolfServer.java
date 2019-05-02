
public class GolfServer {

	public static void main(String[] args) {
		/*
		 * This main method acts as the entry point to the server side program and invokes the 
		 * runServer method once a new SocketServer object is created. The SocketServer will listen
		 * for client connections on a given port (in this case port 44444).
		 */
		System.out.println("Initialising Server.");
		SocketServer s = new SocketServer();
		s.runServer();
	}
}
