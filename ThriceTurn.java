import java.util.Scanner;

public class ThriceTurn{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in); //declare variables that are needed in all 3 rounds
		double tally = 0;
		int tripletWorth = 0;


		System.out.println("Round 1:"); //everything for round one
		boolean triplet = false; //checks if it is a triplet
		int iRoundOne = 1; //checks if it is a third roll
		while (! triplet){
			int diceOne = (int)(Math.random()*6 + 1); //calculate value of the rolls
			int diceTwo = (int)(Math.random()*6 + 1);
			int diceThree = (int)(Math.random()*6 + 1);
			System.out.println("This is your roll:"); //output for each roll
			System.out.println("Dice one: " + diceOne);
			System.out.println("Dice two: " + diceTwo);
			System.out.println("Dice three: " + diceThree);
			int roundValue = diceOne + diceTwo + diceThree; //value of all dice added up
			if (iRoundOne % 3 == 0){ //third roll check area, calculate the tally
				tally = tally - roundValue;
			} else {
				tally = tally + roundValue;
			}
			iRoundOne++;
			if (diceOne == diceTwo && diceOne == diceThree) { //checks if triplet, if so ends round one
				System.out.println("That is the end of round one. Your current tally is: " + tally);
				triplet = true;
				tripletWorth = diceOne;
			} else {
				System.out.println("Your current tally is: " + tally); //keep track of tally
			}
		}


		System.out.println(""); //break to make output between rounds more clean


		System.out.println("Round Two:");//signify round two is starting
		for (int iRoundTwo = 0; iRoundTwo < tripletWorth; iRoundTwo++){ //to roll the triplet's worth # of times
			int diceOne = (int)(Math.random()*6 + 1); //calculate value of rolls
			int diceTwo = (int)(Math.random()*6 + 1);
			int diceThree = (int)(Math.random()*6 + 1);
			System.out.println("This is your roll:"); //output for each roll
			System.out.println("Dice one: " + diceOne);
			System.out.println("Dice two: " + diceTwo);
			System.out.println("Dice three: " + diceThree);
			int roundValue = diceOne * diceTwo * diceThree; //calculate value of all dice multiplied
			tally = tally + roundValue; //calculate
			System.out.println("Your current tally is: " + tally); //keep track of tally
		}
		System.out.println("That is the end of round two. Your current tally is: " + tally); //end round two


		System.out.println(""); //break to keep output clean


		System.out.println("Round 3:"); //round 3 is starting
		System.out.println("Would you like to retire? Your turn will be over. (enter yes if so, if not enter anything)");
		String retirement = scan.nextLine(); //check to see if they would like to retire or not.
		int iRoundThree = 1; //count number of rolls
		while (! retirement.equals("yes")){
			System.out.println("This is roll: " + iRoundThree); //display number of rolls
			int diceOne = (int)(Math.random()*6 + 1); //calculate value of rolls
			int diceTwo = (int)(Math.random()*6 + 1);
			int diceThree = (int)(Math.random()*6 + 1);
			System.out.println("This is your roll:"); //output for each roll
			System.out.println("Dice one: " + diceOne);
			System.out.println("Dice two: " + diceTwo);
			System.out.println("Dice three: " + diceThree);
			double additive = 1.0; //how much to add based on the roll count
			if (iRoundThree != 1){
				for (int rollCount = 1; rollCount < iRoundThree; rollCount++){
				additive = additive * 3;
				}	
			} else {
				additive = 1;
			}
			tally = tally + additive;
			if (diceOne == diceTwo && diceOne == diceThree){ //if triplet, check if original and apply rules based on result
				if (diceOne == tripletWorth){
					tally = tally * 3;
				} else {
					tally = diceOne;
				}
				System.out.println("Congratulations! Your turn is over, and your final tally is: " + tally);
				retirement = "yes";
			} else {
				System.out.println("Your current tally is: " + tally);
				System.out.println("Would you like to retire? Your turn will be over. (enter yes if so, if not enter anything)");
				retirement = scan.nextLine();
				iRoundThree++; 
			}
		}
	}
}