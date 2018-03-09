public class ExtraCredit {

	public static void main(String[] args) {
		String music = args[0];

		String danceMove;

    switch (music) {
    	case "metal":
      danceMove = "mosh";
    		break;
    	case "jazz":
      danceMove = "sip a martini";
        break;
    	case "funk":
      danceMove = "snap awkwardly";
    		break;
    	default:
      danceMove = "do the bernie";
    		break;
    }

		System.out.println("Your dance move is to " + danceMove + " to " + music + ".");
	}
}
