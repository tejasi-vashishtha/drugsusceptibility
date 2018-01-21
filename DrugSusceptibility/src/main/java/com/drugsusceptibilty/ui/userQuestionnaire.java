package com.drugsusceptibilty.ui;
import java.util.Scanner;

import com.drugsusceptibilty.connectionToDB.getMongo;
import com.drugsusceptibilty.logic.MapReduceQuery;

public class userQuestionnaire {
	
	int e_up=0, e_lw=0, o_up=0, o_lw=0, a_up=0, a_lw=0;

	
	public void printForm() {
		Scanner sc =new Scanner(System.in);
		
		//e_up = Escore Upper Score
		//e_lw = Escore Lower Score
		//o_up = Oscore Upper Score
		//o_lw = Oscore Lower Score
		//a_up = Ascore Upper Score
		//a_lw = Ascore Lower Score
		
		System.out.println("What is your name?");
		String Name= sc.next();
		
		//QUESTION ONE
		QuestionOne();
		
		int flag=0;
		do{ 
			String input1= sc.next();
			if (input1.equalsIgnoreCase("a")|| input1.equalsIgnoreCase("b") || input1.equalsIgnoreCase("c") || input1.equalsIgnoreCase("d")|| input1.equalsIgnoreCase("e") || input1.equalsIgnoreCase("f")) {
			flag=1;
			
			String Age=getAge(input1);
						
		}else {
			
			showErrorMessage();}
	
		}while(flag!=1);
		
		String Gender="";
		int flag1=0; 
		do {
			System.out.println("Are you male or female?");
			Gender =sc.next();

			if(Gender.equalsIgnoreCase("male")) {
				Gender="Male";
				flag1 = 1;
			}else if(Gender.equalsIgnoreCase("female")) {
				Gender="Female";
				flag1 = 1;
			}
			
			else showErrorMessage();

		}while(flag1!=1);
		
		//QUESTION TWO
		QuestionTwo();
		
		int flag2=0;
		String Education="";
		do {
		String input2= sc.next();
		if (input2.equalsIgnoreCase("a")|| input2.equalsIgnoreCase("b") || input2.equalsIgnoreCase("c") || input2.equalsIgnoreCase("d")|| input2.equalsIgnoreCase("e") || input2.equalsIgnoreCase("f") || input2.equalsIgnoreCase("g") || input2.equalsIgnoreCase("h") || input2.equalsIgnoreCase("i")){
			flag2=1;
		
			Education=getEducation(input2);
			
			
		}else System.out.println("Please enter a valid option!try again");
		}while(flag2!=1);
			
		//QUESTION THREE
			QuestionThree();
		
			int flag3=0;
			do {
			String input3= sc.next();
			if (input3.equalsIgnoreCase("a")|| input3.equalsIgnoreCase("b") || input3.equalsIgnoreCase("c") || input3.equalsIgnoreCase("d")|| input3.equalsIgnoreCase("e") || input3.equalsIgnoreCase("f")){
				flag3=1;
				String OScore="";
				
				OScore=getOScore(input3);
				
				
			}else System.out.println("Please enter a valid option!try again");
			}while(flag3!=1);
		
			//QUESTION FOUR
				QuestionFour();
				
				int flag4=0;
				do {
					
				String input4= sc.next();
				if (input4.equalsIgnoreCase("a")|| input4.equalsIgnoreCase("b") || input4.equalsIgnoreCase("c") || input4.equalsIgnoreCase("d")|| input4.equalsIgnoreCase("e") || input4.equalsIgnoreCase("f")) {
					flag4=1;
				
					String EScore=getEScore(input4);
					
					
					
				}else System.out.println("Please enter a valid option!try again");
				}while (flag4!=1);
					
				////QUESTION FIVE
					QuestionFive();
					
					int flag5=0;
			do {				
					String input5= sc.next();
					if (input5.equalsIgnoreCase("a")|| input5.equalsIgnoreCase("b") || input5.equalsIgnoreCase("c") || input5.equalsIgnoreCase("d")|| input5.equalsIgnoreCase("e") || input5.equalsIgnoreCase("f")) {
						flag5=1;
						String AScore=getAScore(input5);
						
					}else System.out.println("Please enter a valid option!try again");
						
			}while(flag5!=1);
			
		
		
		
			MapReduceQuery mpr = new MapReduceQuery();	
			mpr.Mapper(Gender,Education, a_lw, o_lw, e_lw );
			//System.out.println("Processing results...");
		
		
		
		
	}
	
	
	
	
	public static String readCMD() {
	try {
	 Scanner sc =new Scanner(System.in).useDelimiter("\\n");

	String ch ="";
	 while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("\\n"))) {
		ch = sc.nextLine();
		
		}
		System.out.print(ch);
		 return ch;
		 } catch (Exception e) {
		 System.out.println(e.getCause());
		}
	return null;
	}
	
	private void QuestionOne() {
		
		 System.out.println("Enter your Age range:");
		  System.out.println("a. Age between 18-24");
		  System.out.println("b. Age between 25-34");
		  System.out.println("c. Age between 35-44");
		  System.out.println("d. Age between 45-54");
		  System.out.println("e. Age between 55-64");
		  System.out.println("f. Age 65 or more");
	}
	
	private void QuestionTwo() {
		
		System.out.println("Please enter your level of education: ");
		System.out.println("a. Left school before 16 years");
		System.out.println("b. Left school at 16 years");
		System.out.println("c. Left school at 17 years");
		System.out.println("d. Left school at 18 years");
		System.out.println("e. College/University, no certification");
		System.out.println("f. Certification/Diploma");
		System.out.println("g. University Degree");
		System.out.println("h. Masters Degree");
		System.out.println("i. Doctorate Degree");
		
	}
	
	private void QuestionThree() {
		
		System.out.println("You are at a house party hosted by some friends of your friend. One of them offers you a drink you have never seen or heard of before. You don’t want to play a spoilsport as you want to create a good first impression. What will you do?");
		System.out.println("a. Decline. Say no directly to that person without much thinking.");
		System.out.println("b. Tell that person you will be back in a while and avoid having that drink.");
		System.out.println("c. Call your friend and get him to try that drink for you.");
		System.out.println("d. Have a sip of that drink and then throw it away without him noticing.");
		System.out.println("e. Have the full drink.");
		System.out.println("f. Drink more than just one to have fun.");
	}
	
	private void QuestionFour() {
		
		System.out.println("At the same party, you see a charismatic personality and feel like approaching him/her. That person is surrounded by 6 other people in the room. What will you do?");
		System.out.println("a. Keep looking at that person throughout the party standing in a corner and not make a single move.");
		System.out.println("b. Drop hints at that person by making eye contact frequently.");
		System.out.println("c. Walk past the group multiple times to get some attention.");
		System.out.println("d. Go stand in the group and listen to the conversation without saying anything.");
		System.out.println("e. Approach and introduce yourself to that person. Make small talk.");
		System.out.println("f. Grab everyone’s attention by singing a song and addressing it to that person. Or something similar.");
		
	}
	
	private void QuestionFive() {
		
		System.out.println("Someone accidentally spills a drink on your new expensive shoes which you just bought for the party. What will be your reaction?");
		System.out.println("a. You understand that the person is not in his/her senses and don’t say anything to that person.");
		System.out.println("b. You tell the person to behave properly and demand an apology.");
		System.out.println("c. You shout and create a scene at the party.");
		System.out.println("d. You abuse that person and also his friends for not handling him/her properly.");
		System.out.println("e. You take that person’s drink and throw it on his/her face.");
		System.out.println("f. You slap that person and start a brawl at the party.");
		
	}
	
	private String getAge(String input1) {
		String Age="";
		
		switch(input1){
		case "a" : Age="18-24";
				break;
		case "b" : Age="25-34";
		break;
		case "c" : Age="35-44";
		break;
		case "d" : Age="45-54";
		break;
		case "e" : Age="55-64";
		break;
		case "f" : Age="65+";
		break;
		
				}
		return Age;
	}
	
	private String getEducation(String input2) {
			
			String Education="";
			switch(input2){
			case "a" : Education="E1";
					break;
			case "b" : Education="E2"; 
			break;
			case "c" : Education="E3";
			break;
			case "d" : Education="E4";
			break;
			case "e" : Education="E5";
			break;
			case "f" : Education="E6";
			break;
			case "g" : Education="E7";
			break;
			case "h" : Education="E8";
			break;
			case "i" : Education="E9";
			break;
				
			}
			return Education;
		}

		private String getOScore(String input3) {
		
		String OScore="";
		
		switch(input3){
		
		case "a" : { 
		OScore="34-36";
			o_lw=34;
			o_up=36;
			break;}
		case "b" : { OScore="36-38";
		o_lw = 36;
		o_up = 38;
		break;}
		case "c" :{ OScore="38-40";
		o_lw = 38;
		o_up = 40;
		break;}
		case "d" :{ OScore="40-42";
		o_lw = 40;
		o_up = 42;
		break;}
		case "e" :{ OScore="42-44";
		o_lw = 42;
		o_up = 44;
		break;}
		case "f" :{ OScore="42-46";
		o_lw = 44;
		o_up = 46;
		break;}
				
		}
		return OScore;
	}
		
		private String getEScore(String input4) {
			
			String EScore="";
			
			switch(input4){
			case "a" : { EScore="34-36";
			e_lw = 34;
			e_up = 36;
			break;}
			case "b" :{ EScore="36-38";
			e_lw = 36;
			e_up = 38;
			break;}
			case "c" :{ EScore="38-40";
			e_lw = 38;
			e_up = 40;
			break;}
			case "d" :{ EScore="40-42";
			e_lw = 40;
			e_up = 42;
			break;}
			case "e" :{ EScore="42-44";
			e_lw = 42;
			e_up = 44;
			break;}
			case "f" :{ EScore="44-46";
			e_lw = 44;
			e_up = 46;
			break;}
			}		
			return EScore;
		}

		private String getAScore(String input5) {
			String AScore="";
			switch(input5){
			case "a" : {AScore="34-36";
			a_lw = 34;
			a_up = 36;
			break;}
			case "b" :{ AScore="36-38";
			a_lw = 36;
			a_up = 38;
			break;}
			case "c" :{ AScore="38-40";
			a_lw = 38;
			a_up = 40;
			break;}
			case "d" :{ AScore="40-42";
			a_lw = 40;
			a_up = 42;
			break;}
			case "e" :{ AScore="42-44";
			a_lw = 42;
			a_up = 44;
			break;}
			case "f" : {AScore="44-46";
			a_lw = 44;
			a_up = 46;
			break;}
			}		
			return AScore;
		}
		
		private void showErrorMessage() {
			
			System.out.println("Please enter a valid option! try again");
			
		}

}

