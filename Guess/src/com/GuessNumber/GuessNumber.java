package com.GuessNumber;
import java.util.Scanner;
import java.lang.Math;
public class GuessNumber {
    public static void main(String[] args) {
        GuessNum();
    }
    public static String GuessNum(){
        int a = 1+ (int)(Math.random()*20);
        Boolean w = false;
        int flag = 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! what is your name?");
        String name = scan.nextLine();

        System.out.println("Well, " + name+ " I am thinking of a number between 1 and 20 \nTake a guess");
        int guess = scan.nextInt();

        while (w == false){
            if(flag ==6){
                w = true;
                System.out.println("You've run out of tries");
                break;
            }
            if(guess == a){
                System.out.println("You are correct after "+ flag + " tries!" );
                w = true;
            } else if(guess >a){
                System.out.println("Your guess is too high.\nTake a guess.");
                guess = scan.nextInt();
            } else if(guess < a){
                System.out.println("Your guess is too low.\nTake a guess.");
                guess = scan.nextInt();
            }
            flag++;
        }
        return again();
    }

    public static String again(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play again? (y or n)");
        String again = scan.nextLine();
        if(again.equals("y")){
            GuessNum();
        }
        return "";
    }


}
