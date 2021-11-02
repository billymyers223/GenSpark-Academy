package com.dragoncave;
import java.util.Scanner;
public class DragonCave {
    public static void main(String[] args) {
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\n" +
                "Which cave will you go into? (1 or 2)");
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try {
            num = scan.nextInt();
        }catch (Exception e){
            System.out.println("please try again");
            num = scan.nextInt();
        }


        if(num ==1){
            System.out.println("You approach the cave...\n" +
                    "\n" +
                    "It is dark and spooky...\n" +
                    "\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "\n" +
                    "Gobbles you down in one bite!");
        }else if(num ==2){
            System.out.println("You approach the cave...\n" +
                    "\n" +
                    "It is warm and Welcoming...\n" +
                    "\n" +
                    "A large dragon jumps out in front of you! And invites you further into the cave...\n" +
                    "\n" +
                    "You both share a nice cup of tea!\n" +
                    "\n");
        }else{
            System.out.println("You suffer the consequences of your actions. " + num+ " was not a choice, \n and you find yourself " +
                    "crushed by a boulder that was sitting atop the cave.....");
        }
    }
}
