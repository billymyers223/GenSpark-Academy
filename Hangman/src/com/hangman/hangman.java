package com.hangman;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

public class hangman {
    public static void main(String[] args) {
        hang();
    }
    public static String hang(){
        String[] words = {"ham","dog","map","plant","cat","power","live","home","fame"};
        ArrayList wrong = new ArrayList();
        boolean flag = false;
        String word = words[(int)(Math.random() * words.length)];
        System.out.println(word);
        int tries = 0;
        boolean w = false;
        String[] disp = new String[word.length()];
        System.out.println("\n===WELCOME TO HANGMAN!===\n");
        System.out.println("+-----+\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "    =====");
        for (int i =0; i<disp.length; i++){
            disp[i] = "_";
            System.out.print(disp[i]);
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("\nGuess the word by letter! You have 5 attempts!");
        String guess = "";
        try {
            guess = scan.nextLine();
        }
        catch (Exception e){
            System.out.println(e);
        }
        guess = guess.toLowerCase(Locale.ROOT);
        String dispWord = "";

        while (w == false){
            guess = guess.toLowerCase(Locale.ROOT);
            if(!word.contains(guess)){
                flag = true;
                tries++;
            }
            if(tries ==0 && flag == false){
                System.out.println("+-----+\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "    =====");
            }
            if(tries ==1){
                System.out.println("+-----+\n" +
                        "   O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "    =====");
            } else if(tries ==2){
                System.out.println("+-----+\n" +
                        "   O   |\n" +
                        "   |   |\n" +
                        "      |\n" +
                        "    =====");
            } else if(tries ==3){
                System.out.println("+-----+\n" +
                        "   O   |\n" +
                        "  /|   |\n" +
                        "      |\n" +
                        "    =====");
            } else if(tries ==4){
                System.out.println("+-----+\n" +
                        "   O/  |\n" +
                        "  /|   |\n" +
                        "      |\n" +
                        "    =====");
            }
            if(word.contains(guess)) {
                if (word.equals(guess)) {
                    System.out.println("You win after " + tries + " attempts");
                    w =true;
                } else {
                    if (dispWord.contains(guess)){
                        System.out.println("YOU HAVE ALREADY GUESSED THAT LETTER!");
                    }
                    dispWord ="";
                    System.out.println("Wrong guesses:" + wrong );
                    disp[word.indexOf(guess)] = guess;
                    for (int i = 0; i < disp.length; i++) {
                        System.out.print(disp[i]);
                        dispWord = dispWord+ disp[i];
                    }


                    if(word.equals(dispWord)){
                        System.out.println("\nYou win the word was " + word + "!");
                        w = true;
                        break;
                    }

                    System.out.println("\nGuess again");
                    try {
                        guess = scan.nextLine();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            }else{

                wrong.add(guess);

                if(tries ==5) {
                    System.out.println("+-----+\n" +
                            "   O/   |\n" +
                            "  /|   |\n" +
                            "   |   |\n" +
                            "    =====");
                    System.out.println("You Lose!");
                    w = true;
                    break;
                }
                System.out.println("Wrong guesses:" + wrong );
                for (int i = 0; i < disp.length; i++) {
                    System.out.print(disp[i]);

                }
                System.out.println("\nWrong guess again!");
                try {
                    guess = scan.nextLine();
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        }
        return again();
    }
    public static String again(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play again? (y or n)");
        String again = scan.nextLine();
        if(again.equals("y")){
            hang();
        }
        return "";
    }
}
