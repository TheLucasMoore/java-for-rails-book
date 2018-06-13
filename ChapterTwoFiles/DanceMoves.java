public class DanceMoves {

	// the method called at initialization
	public static void main(String[] args) {
		String music = args[0];

		// declare the variable danceMove here
		String danceMove;
		// we'll use flow control decide its value

		if (music.equals("metal")) {
			danceMove = "mosh";
		} else if (music.equals("jazz")) {
			danceMove = "sip a martini";
		} else {
			danceMove = "snap awkwardly";
		}

		System.out.println("Your dance move is to " + danceMove + " to " + music + ".");
	}
}
