package org.koan.battleships;

import java.util.Arrays;

public class Battlemap {

    private String player;
    private char[][] map = new char[10][10];
    private int masts;

    private char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    //TODO: Create external class from which methods putShips and shot will be inherited for opponent and "me" classes

    public Battlemap(String player) {
        this.player = player;
        this.masts = 4;
        for (char[] chars : this.map) {
            Arrays.fill(chars, ' ');
        }
    }

    public void shoot() {
        return;
    }

    public void printMap() {
        System.out.print("   ");
        for (int i = 0; i < this.map[0].length; i++) {
            System.out.print("|" + this.getAlpha()[i] + "|");
        };
        System.out.print("\n");
        for (int i = 0; i < this.map.length; i++ ) {
            System.out.printf("%-3d", (i+1));
            for (int j = 0; j < (this.map[i].length); j++) {
                System.out.print("|" + this.map[i][j] + "|");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public int getMasts() {
        return masts;
    }

    public void setMasts(int masts) {
        this.masts = masts;
    }

    public void changeMasts() {
        this.masts = this.masts - 1;
    }

    public Boolean validInput(String userInput) {

        int userInt;
        int size = this.map.length;

        if (userInput.length() != 2 && userInput.length() != 3) {
            return false;
        }

        if (userInput.charAt(0) < 'A' || userInput.charAt(0) >= this.alpha[size]) {
            return false;
        }

        userInput = userInput.substring(1);
        try {
            userInt = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return false;
        }

        return userInt <= size && userInt >= 1;

    }


    public int findIndex(char[] arr, char t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (t == arr[i]) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public void changeMap(int row, int col, char c) {
        this.map[row][col] = c;
    }

    public char[] getAlpha() {
        return alpha;
    }

    public void setAlpha(char[] alpha) {
        this.alpha = alpha;
    }
};
