import java.util.Scanner;

public class SimpleCipher{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in); //declare scanner

		System.out.println("What is the message?"); //get the message and shift amount
		String message = scan.nextLine();
		System.out.println("What is the amount to shift?");
		int shift = scan.nextInt();

		String shifter = "abcdefghijklmnopqrstuvwxyz";

		String cipher = "";
		for (int i = 0; i < message.length(); i++){ //goes through the whole message to create the cipher
			char charCheckMessage = message.charAt(i); //finds character in message to do the cipher
			for (int x = 0; x < shifter.length(); x++){
				char charCheckShifter = shifter.charAt(x); //finds character in shifter to do the cipher
				int shifterCharacter = x + shift; //checks if shift is inside the alphabet or if it needs to loop
				if (charCheckMessage == charCheckShifter){ //finds what character it is in message
					if (shifterCharacter <= 25){
						cipher = cipher + shifter.charAt(shifterCharacter); //does shift if in alphabet length
					} else {
						cipher = cipher + shifter.charAt(shifterCharacter - 26); //does shift if not in alphabet length
					}
				}
			}
		}

		System.out.println(cipher);
	}
}