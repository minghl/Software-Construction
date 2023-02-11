package org.appache.GameStart;

import org.appache.CheckMan.CheckMan;
import org.appache.Logic.Logic;

import java.util.Scanner;


public class Play {

    public static void main(String[] args) {
        CheckMan checkMan1 = new CheckMan();
        Logic logic1 = new Logic();
        checkMan1.drawBoard();
        while (!checkMan1.isGameOver()) {
            redPlay(checkMan1, logic1);
            if (checkMan1.isGameOver() == true) {
                break;
            }
            whitePlay(checkMan1, logic1);
        }
    }

    private static void redPlay(CheckMan checkMan1, Logic logic1) {
        boolean isAutoMove = false;
        if ((logic1.isRedExecute(checkMan1))) {
            System.out.println("As you could capture opponent’s piece(s) by jumping over it, so the system has done it automatically, which means your turn is over ");
            isAutoMove = true;
            checkMan1.drawBoard();
        }
        boolean inPutObeyRules = false;
        while (inPutObeyRules == false && isAutoMove == false) {
            Scanner sc = new Scanner(System.in);
            String str = null;
            System.out.println("Red player, please enter your movement:");
            str = sc.nextLine();
            //check whether the input of player is in the form of [(a-h)(1-8)]x[(a-h)(1-8)]
            if (!str.matches("\\[[a-h][1-8]\\]x\\[[a-h][1-8]\\]")) {
                System.out.println("illegal movement, please enter your movement again");
                continue;
            }
            char col1Char = str.charAt(1);
            char row1Char = str.charAt(2);
            char col2Char = str.charAt(6);
            char row2Char = str.charAt(7);
            int row1 = 8 - Character.getNumericValue(row1Char);
            int row2 = 8 - Character.getNumericValue(row2Char);
            int col1 = Character.getNumericValue(col1Char) - 10;
            int col2 = Character.getNumericValue(col2Char) - 10;
            //check is there a red piece in the starting place, if not, ask the player do it again
            if (!(checkMan1.isOnBoard(row1, col1) && checkMan1.isRed(row1, col1))) {
                System.out.println("Sorry, there is no piece in the starting place, or the piece belongs to the opponent");
                continue;
            }
            //now we can make sure that this chessman is red
            if (logic1.isRedAchieve(checkMan1, row1, col1, row2, col2) && (!checkMan1.isOnBoard(row2, col2))) {
                checkMan1.moveChessMan(row1, col1, row2, col2);
                checkMan1.drawBoard();
                inPutObeyRules = true;
            } else {
                System.out.println("sorry, there is already a chessMan in your destination or the destination is out of your movement range");
                continue;
            }
        }
    }

    private static void whitePlay(CheckMan checkMan1, Logic logic1) {
        boolean isAutoMove = false;
        if ((logic1.isWhiteExecute(checkMan1))) {
            System.out.println("As you could capture opponent’s piece(s) by jumping over it, so the system has done it automatically, which means your turn is over ");
            isAutoMove = true;
            checkMan1.drawBoard();
        }
        boolean inPutObeyRules = false;
        while (inPutObeyRules == false && isAutoMove == false) {
            Scanner sc = new Scanner(System.in);
            String str = null;
            System.out.println("White player, please enter your movement:");
            str = sc.nextLine();
            //check whether the input of player is in the form of [(a-h)(1-8)]x[(a-h)(1-8)]
            if (!str.matches("\\[[a-h][1-8]\\]x\\[[a-h][1-8]\\]")) {
                System.out.println("illegal movement, please enter your movement again");
                continue;
            }
            char col1Char = str.charAt(1);
            char row1Char = str.charAt(2);
            char col2Char = str.charAt(6);
            char row2Char = str.charAt(7);
            int row1 = 8 - Character.getNumericValue(row1Char);
            int row2 = 8 - Character.getNumericValue(row2Char);
            int col1 = Character.getNumericValue(col1Char) - 10;
            int col2 = Character.getNumericValue(col2Char) - 10;
            //check is there a red piece in the starting place, if not, ask the player do it again
            if (!(checkMan1.isOnBoard(row1, col1) && !checkMan1.isRed(row1, col1))) {
                System.out.println("Sorry, there is no piece in the starting place, or the piece belongs to the opponent");
                continue;
            }
            //now we can make sure that it's a red chessMan
            if (logic1.isWhiteAchieve(checkMan1, row1, col1, row2, col2) && (!checkMan1.isOnBoard(row2, col2))) {
                checkMan1.moveChessMan(row1, col1, row2, col2);
                checkMan1.drawBoard();
                inPutObeyRules = true;
            } else {
                System.out.println("sorry, there is already a chessMan in your destination or the destination is out of your movement range");
                continue;
            }
        }
    }
}


