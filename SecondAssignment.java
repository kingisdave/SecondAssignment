//Creating methods inside the class;
import java.util.Scanner;
public class SecondAssignment{
	static Scanner userInput = new Scanner(System.in);
	public static String[][] studentInfo;
	static int[] allResult;
	static String[] startOptions = {
			"\n>  1: Register your Students",
			">  2: Write your Test",
			">  3: Check the student(s) with the maximum score",
			">  4: Totally Finish the Ending Completely\n"
		};
	static String optionChosen;
	public static void openApp(){
		System.out.println("\n WELCOME TO JAVA CLASS !!!");
		System.out.println("Select one of the options and reply with the number:");
		for(String opts : startOptions){
			System.out.println(opts);
		}
		System.out.print("Reply with number> ");
		optionChosen = userInput.nextLine();
		
		if (Integer.parseInt(optionChosen) == 1) {
			System.out.println("\n!!!REGISTRATION ZONE!!!\n");
			register();
		} else if (Integer.parseInt(optionChosen) > 1 || Integer.parseInt(optionChosen) < 1) {
			openApp();
		} else {
			System.out.println("\n!!!END PAGE!!!\n");
			endPage();
		}
	}
	
	public static void register(){
		System.out.print("How many students do you want to register?> ");
		String studentNos = userInput.nextLine();	
		String[][] studentInfos = new String[Integer.parseInt(studentNos)][4];
		studentInfo = studentInfos;
		int[] allResults = new int[Integer.parseInt(studentNos)];
		allResult = allResults;
		System.out.println("\nWelcome to the Register Page");
		System.out.println("Click Enter to continue ");
		userInput.nextLine();
		for(int i = 0; i < studentInfo.length; i++){
			int serialNo = i+1;
			System.out.println("Student "+ serialNo);
			System.out.print("Enter your FirstName> ");
			studentInfo[i][0] = userInput.nextLine();

			System.out.print("Enter your LastName> ");
			studentInfo[i][1] = userInput.nextLine();

			System.out.print("Enter your Password> ");
			studentInfo[i][2] = userInput.nextLine();

			studentInfo[i][3] = "0";

			String fullname = studentInfo[i][0] + " "+ studentInfo[i][1];
			System.out.println("fullname: "+ studentInfo[i][0] + " "+ studentInfo[i][1]);
				
			if( i+1 == studentInfo.length ){
				System.out.println("Thanks to all Students for supplying their details");
				System.out.println("\n > 1: Enter 1 to continue to write the test: ");
				System.out.println("> 2: Enter 2 to re-register your students: ");
				optionChosen = userInput.nextLine();
				if (Integer.parseInt(optionChosen) > 0 && Integer.parseInt(optionChosen) < 3) {
					if(Integer.parseInt(optionChosen) == 1){
						System.out.println("\n!!!CBT TEST ARENA!!!\n");
						writeTest();
					}else{
						System.out.println("\n!!!REGISTRATION ZONE!!!\n");
						register();
					}				
				} else {
					System.out.println("\nInvalid Reply. CLOSING!!!\n");
					openApp();
				}
			}else {
				System.out.println("Thanks for registering your details!!! "+ fullname + ", Click enter for next student");
			}
			userInput.nextLine();
		}
	}
	public static void writeTest(){

		for(int ii = 0; ii< studentInfo.length; ii++){
			String id = studentInfo[ii][0];
			String pin = studentInfo[ii][2];	
			System.out.print("Enter your id> ");
			String userId = userInput.nextLine();
			System.out.print("Enter your pin> ");
			String userPin = userInput.nextLine();
			
			if (id.equals(userId) && pin.equals(userPin)) {
				System.out.println("You are successfully login");
				String[] questions= {
						"Is Boolean a programming language? True or False",
						"Are you a programmer? Yes or No",
						"Does Java starts with an alphabet J? True or False",
				};
				String[] myAnswers = {"False", "Yes", "True"};
				int[] answerArr = {0,0,0};
				int reslt = 0;
				System.out.println("Welcome "+ studentInfo[ii][0].toUpperCase() + " " + studentInfo[ii][1].toUpperCase());
				System.out.println("Click to write your Test "+ studentInfo[ii][0].toUpperCase());
				userInput.nextLine();
				for(int qq = 0; qq < questions.length; qq++){
					System.out.print("Question "+ (qq+1 + ": "));
					System.out.println(questions[qq]);
					System.out.print("Answer: ");
					String myAnswer = userInput.nextLine();
					if (myAnswer.toLowerCase().equals(myAnswers[qq].toLowerCase())) {
						answerArr[qq] = 1;
					} else {
						System.out.println("This is Incorrect");
					}
				}
				reslt = answerArr[0] + answerArr[1] + answerArr[2];
				System.out.println(studentInfo[ii][0].toUpperCase() + ", You scored "+ reslt +" out of "+ questions.length + " with " + (reslt*100)/questions.length + "%.");
				studentInfo[ii][2] = "" + reslt;
				userInput.nextLine();
				
				System.out.println("Goodluck! "+studentInfo[ii][0] + " " + studentInfo[ii][1] + " on your Results");
				if( ii+1 == studentInfo.length ){
					System.out.println("\n> 1: Enter 1 to continue see the Winner of the quiz: ");
					System.out.println("> 2: Enter 2 to re-take the quiz: ");
					optionChosen = userInput.nextLine();
					if (Integer.parseInt(optionChosen) > 0 && Integer.parseInt(optionChosen) < 3) {
						if(Integer.parseInt(optionChosen) == 1){
							System.out.println("\n!!!WINNERS ZONES!!!\n");
							checkMarks();
						}else{
							System.out.println("\n!!!CBT TEST ARENA!!!\n");
							writeTest();
						}				
					} else {
						System.out.println("\nInvalid Reply. CLOSING!!!\n");
						System.out.println("You are redirected the homepage!!");
						openApp();
					}
				}
			} else {
				System.out.println("\n You entered invalid details");
				System.out.println("You are redirected the homepage!! \n");
				openApp();
			}
		}	
	}
	public static void checkMarks(){
		for(int std = 0; std < studentInfo.length; std++){
			allResult[std] = Integer.parseInt(studentInfo[std][2]);
		}
		String winnerName = null;
		int maxRes = allResult[0];
		
		for(int yy = 1; yy < allResult.length; yy++){
			int eachRes= allResult[yy];
		 	if(eachRes > maxRes){
				maxRes = eachRes;
			}
		}
		for(int std = 0; std < studentInfo.length; std++){
			if(maxRes == Integer.parseInt(studentInfo[std][2])){
				winnerName = studentInfo[std][0] + " " +studentInfo[std][1];
			}
		}
		System.out.println("The Winner is: " + winnerName);
		System.out.println("The maximum score is: " + maxRes);
	}
	public static void endPage(){
		System.out.println("\n Are you willing to Exit this Application?: ");
		System.out.println(" If Yes, enter Yes: ");
		System.out.println(" If No, enter No: ");
		optionChosen = userInput.nextLine();
		if (optionChosen.toLowerCase.equals("yes")) {
			System.out.println(" THANK YOU FOR YOUR TIME... NICE TIME!!!");
		} else {
			System.out.println(" Go back to the Homepage... HAVE A NICE TIME");
			openApp();
		}	
	}	

	public static void main(String[] args) {
		openApp();
	}
}