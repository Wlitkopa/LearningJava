package org.koan.battleships;
import javax.swing.plaf.synth.SynthUI;
import java.util.*;

public class Mymap extends Battlemap {

    private final int largShip;

    public Mymap(String player) {
        super(player);
        this.largShip = 2;
    }

    @Override
    public void shoot(){
        System.out.println("My map:");
        this.printMap();
        Scanner sc = new Scanner(System.in);
        String userInput;
        while (true) {
            if (this.getMasts() == 0) {
                System.out.println("Captain, all ships are sunk! :((");
                break;
            }
            System.out.print("Enter coordination's that opponent shot at: ");
            userInput = sc.nextLine().toUpperCase();

            if (!this.validInput(userInput)) {
                System.out.println("You provided wrong coordinates. Syntax: <letter (row)><number (column)>");
                continue;
            }

            int col = userInput.charAt(0) - 'A';
            int row = Integer.parseInt(userInput.substring(1)) - 1;

            if (this.getMap()[row][col] == 'O' || this.getMap()[row][col] == 'X') {
                System.out.println("Opponent shot here previously. Let him enter different coords ;)");
                continue;
            }
            if (this.getMap()[row][col] == ' ') {
                System.out.println("Opponent has missed hehe :)\nYour map:");
                this.changeMap(row, col, 'O');
                this.printMap();
                break;
            }
            if (this.getMap()[row][col] == 'M') {
                System.out.println("Opponent shoot accurately :(\nYour map:");
                this.changeMap(row, col, 'X');
                this.changeMasts();
                this.printMap();
            }

        }

    }

    public void putShips(){
        System.out.println("=== Now You are putting the ships on your map ===");
        this.printMap();
        Scanner sc= new Scanner(System.in);
        int size = this.getMap().length;
        for (int i = this.largShip; i > 0; i--){
//          Putting ships
            for (int j = 0; j < (this.largShip + 1 - i); j++) {
                int[][] shipCoords = new int[i][2];
                int[][] availCoords = new int[4*i][2];
                int aind = 0;

//              Putting masts of ship
                for (int k = 0 ; k < i; k++) {
                    String str;
                    System.out.print("Enter a coordination's for ship with " + i + " masts: ");
                    while (true){
                        str = sc.nextLine().toUpperCase();

                        if (this.validInput(str)) {

//                            int col = this.findIndex(this.getAlpha(), str.charAt(0));
                            int col = str.charAt(0) - 'A';
                            int row = Integer.parseInt(str.substring(1)) - 1;

                            if (this.getMap()[row][col] != ' ') {
                                System.out.print("Enter coords where there aren't any rocks or other ships: ");
                                continue;
                            }
                            if (k > 0) {
                                int op = 0;
                                for (int m = 0; m < availCoords.length; m ++) {
                                    if (availCoords[m][0] == row && availCoords[m][1] == col) {
                                        op = 1;
                                        break;
                                    }
                                }
                                if (op == 0) {
                                    System.out.print("Enter coords next to the previously putted mast: ");
                                    continue;
                                }
                            }

                            shipCoords[k][0] = row;
                            shipCoords[k][1] = col;

//                            this.getMap()[row][col] = 'M';
                            this.changeMap(row, col, 'M');


                            if (col > 0) {
                                availCoords[aind][0] = row;
                                availCoords[aind][1] = col - 1;
                                aind++;
                            }

                            if (row > 0) {
                                availCoords[aind][0] = row - 1;
                                availCoords[aind][1] = col;
                                aind++;
                            }

                            if (col < 9) {
                                availCoords[aind][0] = row;
                                availCoords[aind][1] = col + 1;
                                aind++;
                            }

                            if (row < 9) {
                                availCoords[aind][0] = row + 1;
                                availCoords[aind][1] = col;
                                aind++;
                            }
//                            for (int z = 0; z < availCoords.length; z++) {
//                                System.out.println("\navailCoords[" + z + "][0]" + availCoords[z][0]);
//                                System.out.println("availCoords[" + z + "][1]" + availCoords[z][1]);
//
//                            }
//                            System.out.print("\n");
                            this.printMap();
                            break;
                        } else {
                            System.out.print("Enter coords in proper way: <letter (row)><number (column)>\nCoords: ");
                        }
                    }
                }
//              Putting rocks after putting masts
                for (int[] shipCoord : shipCoords) {
                    int row = shipCoord[0] - 1;
                    int col = shipCoord[1] - 1;
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            int trow = row + l;
                            int tcol = col + m;
                            if (trow >= 0 && trow < 10 && tcol >= 0 && tcol < 10) {
                                if (this.getMap()[trow][tcol] == ' ') {
                                    this.changeMap(trow, tcol, '^');
                                }
                            }
                        }
                    }
                }
                this.printMap();

            }
        }
        for (int k = 0; k < this.getMap().length; k++) {
            for (int l = 0; l < this.getMap()[k].length; l++) {
                if (this.getMap()[k][l] == '^') {
                    this.changeMap(k, l, ' ');
                }
            }
        }

    }
}
