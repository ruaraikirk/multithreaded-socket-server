import java.util.ArrayList;
import java.util.Collections;

/*
 * The PlayerList class creates an object which stores all the Player objects in an ArrayList.
 */

public class PlayerList {
	// Data attributes
	ArrayList<Player> competitionList;
	
	// Constructor
	public PlayerList() { // Default constructor creates an empty ArrayList of type 'Player'
		this.competitionList = new ArrayList<Player>();
	}
		
	// Methods
	public void addToList(Player i) { // Method for populating ArrayList (registering Player).
		competitionList.add(i);
	}
	
	public void updateScore(int score, String compCode) { // Method to update score of a given Player (via code property).
		for (int i = 0; i < competitionList.size(); i++) {
			Player tempPlayer1 = competitionList.get(i);
			if (tempPlayer1.getCode().equals(compCode)) {
				tempPlayer1.setScore(score);
				int position = competitionList.indexOf(tempPlayer1);
				competitionList.set(position, tempPlayer1);
			} 
		}
	}
	
	public String displayAll() { // Method which generates a string of names and scores of all objects of type Player to output to the browser.
		String linkedPlayers = "<p>";
		for(Player p: this.competitionList) { // Loop through ArrayList and print object info via getter methods.
			linkedPlayers = linkedPlayers + p.getName() + " " + p.getScore() + " " + "<br>"; // Concatenate string.
		} 
		return linkedPlayers; // Return the string.	
	}
	
	public void sortPlayers() { // Method to sort the ArrayList<Player> based on the Player score property.
		Collections.sort(competitionList);
	}

	// Getters and Setters
	public ArrayList<Player> getCompetitionList() { // Getter for ArrayList.
		return competitionList;
	}	
	
}
