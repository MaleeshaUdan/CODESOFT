import java.util.Scanner;
import java.util.Random;

public class TaskOne{
	public static void main(String[] args) {
		Random random=new Random();
		Scanner sc=new Scanner(System.in);
		int genNum=0;
		int count=0;
		int marks=0;
		int userEnteredNum=0;
		System.out.println("/.........How many times do you want to play the game ........./");
		int numOfTime=sc.nextInt();
		while(numOfTime>0){
			numOfTime--;
			count++;
			genNum=random.nextInt(100)+1;
			System.out.println("Enter the Number : Attempt "+count);
			userEnteredNum=sc.nextInt();

			while(userEnteredNum<1 || userEnteredNum>100){
			System.out.println("------------------------------------");	
			System.out.println("Your Number Must be in the range of 1-100 Retry");	
			System.out.println("Enter the Number : Attempt "+count);
			userEnteredNum=sc.nextInt();
			System.out.println("------------------------------------");	
			}

			System.out.println("");
			System.out.println("------------------------------------");	
			System.out.println("Random Number is : "+genNum);
			System.out.println("The Number you entered is : "+userEnteredNum);
			System.out.println("------------------------------------");	
			System.out.println("");
			if (genNum==userEnteredNum) {
				System.out.println("------------------------------------");	
				System.out.println("!!!Both are same!!!");	
				marks=marks+10;
				System.out.println("Your Current Marks : "+marks);
				System.out.println("------------------------------------");	
				System.out.println("");
			}
			else if(userEnteredNum-genNum>=20){
				/*check whther guessed number is too far*/
				System.out.println("------------------------------------");	
				System.out.println("!!!Guessed Number is too high try again!!!");
				System.out.println("Your Current Marks : "+marks);
				System.out.println("------------------------------------");	
				System.out.println("");
			}
			else if(genNum-userEnteredNum >=20){
				/*check whther guessed number is too low*/
				System.out.println("------------------------------------");	
				System.out.println("!!!Guessed Number is too low try again!!!");
				System.out.println("Your Current Marks : "+marks);
				System.out.println("------------------------------------");	
				System.out.println("");
			}
			else{
				System.out.println("------------------------------------");	
				System.out.println("!!!Guessed Number and Random numbers are not equal try again!!!");
				System.out.println("Your Current Marks : "+marks);	
				System.out.println("------------------------------------");	
				System.out.println("");
			}

		}
		System.out.println("------------------------------------");
		System.out.println("Your All Attempts are over");
		System.out.println("Your Total Marks is : "+marks);
		System.out.println("------------------------------------");
	}
}