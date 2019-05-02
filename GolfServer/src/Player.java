import java.util.Random;

/*
 * The Player class creates objects which store Player data, along with accompanying methods.
 * This class implements the Comparable interface. Java Comparable interface is used to order 
 * the objects of user-defined class.This interface is found in java.lang package and contains 
 * only one method named compareTo(Object).
 */

public class Player implements Comparable<Player> {
	// Data
	public String name;
	public String code;
	public int score;
	
	// Constructor
	public Player(String name) {
		this.name = name;
		this.code = genCode();
		this.score = 0;
	}
	
	// Methods
	private synchronized String genCode() { // Synchronised method to generate code.
		int charLength = 9;
		return String.valueOf(charLength < 1 ? 0 : new Random()
				.nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
				+ (int) Math.pow(10,charLength - 1));
	}
	
	@Override // Override the compareTo method.
    public int compareTo(Player comparePlayer) { // Method taken from https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/ 
        int compareScore=((Player)comparePlayer).getScore();
        /* For Ascending order*/
        return this.score-compareScore;
        /* For Descending order do like this */
        //return compareScore-this.score;
    }

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
