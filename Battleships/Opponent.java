package org.koan.battleships;

import java.util.Scanner;

public class Opponent extends Battlemap {
    public Opponent(String player) {
        super(player);
    }

    @Override
    public void shoot() {
        Scanner sc= new Scanner(System.in);
        String userInput;
        System.out.println("Opponent's map:");
        this.printMap();
        int op = 0;
        while (true) {
            if (this.getMasts() == 0) {
                System.out.println("Captain, we have sunk all of their ships!!!! Victoryyy!!!! :)");
                break;
            }
            System.out.print("Time to shoot! Enter coords to shoot at: ");
            userInput = sc.nextLine().toUpperCase();
            if (!this.validInput(userInput)) {
                System.out.println("You provided wrong coordinates. Syntax: <letter (row)><number (column)>");
                continue;
            }
            int col = userInput.charAt(0) - 'A';
            int row = Integer.parseInt(userInput.substring(1)) - 1;

            if (this.getMap()[row][col] == 'O' || this.getMap()[row][col] == 'X') {
                System.out.println("You have shot here previously. Try again ;)");
                continue;
            }

            while (true) {
                System.out.print("Did you shoot at ship?\n1. Yes\n2. No\nEnter the number: ");
                try {
                    int result = Integer.parseInt(sc.nextLine());
                    if (result == 1) {
                        System.out.println("Niceeee!!! Let's go with another shoot\nOpponent map:");
                        this.changeMap(row, col, 'X');
                        this.changeMasts();
                        System.out.println("Opponent's masts: " + this.getMasts());
                        this.printMap();
                        break;
                    } else if (result == 2) {
                        System.out.println("One square less to check ;)\nOpponent map:");
                        this.changeMap(row, col, 'O');
                        this.printMap();
                        op = 1;
                        break;
                    } else {
                        System.out.println("Enter 1 or 2");
                    }
                }
                catch (Exception e) {
                    System.out.println("Enter the number 1 or 2");
                }

            }
            if (op == 1) {
                break;
            }

        }
    }
}
