package org.koan.battleships;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Battlemap battlemap = new Battlemap("kot");
//        System.out.println("Player " + battlemap.getPlayer() + " map:");
//        battlemap.printMap();

        Scanner sc = new Scanner(System.in);
        int result = 0;
        Battlemap[] priority = new Battlemap[2];
        int[] masts = new int[2];

        System.out.print("Enter your name: ");
        String myName = sc.nextLine();
        System.out.print("Enter your opponent name: ");
        String opponentName = sc.nextLine();

        while (true) {
            System.out.print("Who starts?\n1. " + myName + "\n2. " + opponentName + "\nEnter the number: ");
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result != 1 && result != 2) {
                    System.out.println("Enter 1 or 2");
                } else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Enter the number 1 or 2");
            }
        }
        Mymap mymap = new Mymap(myName);
        Opponent opponent = new Opponent(opponentName);


        if (result == 1) {
            priority[0] = opponent;
            priority[1] = mymap;
        } else {
            priority[0] = mymap;
            priority[1] = opponent;
        }

        mymap.putShips();

        while (mymap.getMasts() > 0 && opponent.getMasts() > 0) {
            priority[0].shoot();
            priority[1].shoot();
//            System.out.println("My masts: " + mymap.getMasts() + "\nOpponent's masts: " + opponent.getMasts());
        }


        if (mymap.getMasts() == 0 && opponent.getMasts() == 0) {
            System.out.println("It's a tie! Good leadership of both of You!!");
        }
        else if (mymap.getMasts() == 0) {
            System.out.println("But don't worry captain, do not give up!");
        } else {
            System.out.println("Congratulations!!! You have won the game :)");
        }


    }
}
