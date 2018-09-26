public class ThriceSimulation{
	public static void main(String[] args){
		double totalTally = 0;
		for (int i = 0; i < 1000; i++){
			double tally = 0; //declare variables we always need
			int tripletWorth = 0;


			//everything for round 1
			boolean triplet = false; //checks if it is a triplet
			int iRoundOne = 1; //checks if it is a third roll
			while (! triplet){
				int diceOne = (int)(Math.random()*6 + 1); //calculate value of the rolls
				int diceTwo = (int)(Math.random()*6 + 1);
				int diceThree = (int)(Math.random()*6 + 1);
				int roundValue = diceOne + diceTwo + diceThree; //value of all dice added up
				if (iRoundOne % 3 == 0){ //third roll check area, calculate the tally
					tally = tally - roundValue;
				} else {
					tally = tally + roundValue;
				}
				iRoundOne++;
				if (diceOne == diceTwo && diceOne == diceThree) { //checks if triplet, if so ends round one
					triplet = true;
					tripletWorth = diceOne;
				}
			}


			//everything for round two
			for (int iRoundTwo = 0; iRoundTwo < tripletWorth; iRoundTwo++){ //to roll the triplet's worth # of times
				int diceOne = (int)(Math.random()*6 + 1); //calculate value of rolls
				int diceTwo = (int)(Math.random()*6 + 1);
				int diceThree = (int)(Math.random()*6 + 1);
				int roundValue = diceOne * diceTwo * diceThree; //calculate value of all dice multiplied
				tally = tally + roundValue; //calculate
			}


			//everything for round three
			int iRoundThree = 1; //count number of rolls
			boolean tripletRoundThree = false; //keep running the loop or end it
			while (! tripletRoundThree){
				int diceOne = (int)(Math.random()*6 + 1); //calculate value of rolls
				int diceTwo = (int)(Math.random()*6 + 1);
				int diceThree = (int)(Math.random()*6 + 1);
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
					tripletRoundThree = true;
				} else {
					iRoundThree++;
				}
			}
			totalTally = totalTally + tally;	
		} 
		double averageTally = totalTally/1000;
		System.out.println("The average tally is: " + averageTally);
	}
}