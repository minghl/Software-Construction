package org.appache.CheckMan;

//the class of all the checkman
public class CheckMan {
    //we design the checkBoard as a two dimensional arrays, in the form[[i0,j0,l0,m0][i1,j1,l1,m1]...[i23,j23,l23,m23]]
    //in which i means the row of the chessMan, j means the column, l means red(1) or White(0), m means king(1) or pawn(0)
    // as there would be
    int[][] checkerInfo;
    int whiteNum;
    int redNum;

    //Methodes of checkMan class
    public CheckMan() {
        this.checkerInfo = new int[][]{
                {0, 1, 1, 0}, {0, 3, 1, 0}, {0, 5, 1, 0}, {0, 7, 1, 0},
                {1, 0, 1, 0}, {1, 2, 1, 0}, {1, 4, 1, 0}, {1, 6, 1, 0},
                {2, 1, 1, 0}, {2, 3, 1, 0}, {2, 5, 1, 0}, {2, 7, 1, 0},
                {5, 0, 0, 0}, {5, 2, 0, 0}, {5, 4, 0, 0}, {5, 6, 0, 0},
                {6, 1, 0, 0}, {6, 3, 0, 0}, {6, 5, 0, 0}, {6, 7, 0, 0},
                {7, 0, 0, 0}, {7, 2, 0, 0}, {7, 4, 0, 0}, {7, 6, 0, 0}
        };
        System.out.println("successfully initialization ");
        this.whiteNum = 12;
        this.redNum = 12;
    }

    public boolean isGameOver() {
        if (this.whiteNum <= 0) {
            System.out.println(" ██████╗  █████╗ ███╗   ███╗███████╗ ██████╗ ██╗   ██╗███████╗██████╗  ");
            System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔═══██╗██║   ██║██╔════╝██╔══██╗");
            System.out.println("██║  ███╗███████║██╔████╔██║█████╗  ██║   ██║██║   ██║█████╗  ██████╔╝");
            System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
            System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
            System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝ ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝");
            System.out.println("Red Player win");
            return true;
        }
        if (this.redNum <= 0) {
            System.out.println(" ██████╗  █████╗ ███╗   ███╗███████╗ ██████╗ ██╗   ██╗███████╗██████╗  ");
            System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔═══██╗██║   ██║██╔════╝██╔══██╗");
            System.out.println("██║  ███╗███████║██╔████╔██║█████╗  ██║   ██║██║   ██║█████╗  ██████╔╝");
            System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
            System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
            System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝ ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝");
            System.out.println("White Player win");
            return true;
        }
        return false;
    }

    //draw the checkBoard
    public void drawBoard() {
        System.out.print("+");
        for (int i = 0; i <= 7; i++) {
            System.out.print("---- ");
        }
        System.out.println("+");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (this.isOnBoard(i, j)) {
                    if (this.isRed(i, j)) {
                        if (this.isKing(i, j)) {
                            System.out.print("[R_K]");
                        } else {
                            System.out.print("[R_P]");
                        }
                    } else {
                        if (this.isKing(i, j)) {
                            System.out.print("[W_K]");
                        } else {
                            System.out.print("[W_P]");
                        }
                    }
                } else {
                    System.out.print("[   ]");
                }
                if (j == 7) {
                    System.out.print("|");
                    System.out.println(8 - i);
                }
            }
        }
        System.out.print("+");
        for (int i = 0; i <= 7; i++) {
            System.out.print("---- ");
        }
        System.out.println("+");
        System.out.print("  a  ");
        System.out.print("  b  ");
        System.out.print("  c  ");
        System.out.print("  d  ");
        System.out.print("  e  ");
        System.out.print("  f  ");
        System.out.print("  g  ");
        System.out.println("  h  ");


    }

    //check whether there is a piece in the position(i,j)
    public boolean isOnBoard(int i, int j) {
        for (int k = 0; k < this.checkerInfo.length; k++) {
            if (this.checkerInfo[k][0] == i && this.checkerInfo[k][1] == j) {
                return true;
            }
        }
        return false;
    }

    //check whether the chessMan(i,j) is red, return true if yes,
    // used together with isOnBoard(), so that we can know whether there is a red or white chessMan in a given position
    public boolean isRed(int i, int j) {
        for (int k = 0; k < this.checkerInfo.length; k++) {
            if (this.checkerInfo[k][0] == i && this.checkerInfo[k][1] == j) {
                if (this.checkerInfo[k][2] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //check whether the piece in the position(i,j) is a king or not
    public boolean isKing(int i, int j) {
        for (int k = 0; k < this.checkerInfo.length; k++) {
            if (this.checkerInfo[k][0] == i && this.checkerInfo[k][1] == j) {
                if (this.checkerInfo[k][3] == 1) {
                    return true;
                }
            }
        }
//        System.out.println("no, it's pawn");
        return false;
    }

    //change the chessMan in(i,j) to King
    public void changeToKing(int i, int j) {
        for (int k = 0; k < this.checkerInfo.length; k++) {
            if (this.checkerInfo[k][0] == i && this.checkerInfo[k][1] == j) {
                this.checkerInfo[k][3] = 1;
            }
        }
    }

    //remove the chess in (i,j) from the board
    public void removeChessMan(int i, int j) {
        for (int k = 0; k < this.checkerInfo.length; k++) {
            if (this.checkerInfo[k][0] == i && this.checkerInfo[k][1] == j) {
                this.checkerInfo[k][0] = -9;
                this.checkerInfo[k][1] = -9;
                if (checkerInfo[k][2] == 1) {
                    this.redNum--;
                } else {
                    this.whiteNum--;
                }
            }
        }
    }

    //move chessMan from (i,j) to (l,m)
    public void moveChessMan(int i, int j, int l, int m) {
        for (int k = 0; k < this.checkerInfo.length; k++) {
            if (this.checkerInfo[k][0] == i && this.checkerInfo[k][1] == j) {
                this.checkerInfo[k][0] = l;
                this.checkerInfo[k][1] = m;
                if (l == 0 || l == 7) {
                    this.checkerInfo[k][3] = 1;
                }
            }
        }
    }

    //return a two-dimensional arrays which contains the row and col of all checkman
    public int[][] myChessManPosition() {
        int[][] chessPositionArray = new int[24][2];
        for (int i = 0; i < this.checkerInfo.length; i++) {
            chessPositionArray[i][0] = this.checkerInfo[i][0];
            chessPositionArray[i][1] = this.checkerInfo[i][1];
        }
        return chessPositionArray;
    }

    //for security, we do not set checkManInfo as public, so we need a function to return the length of checkManInfo, this is what this function does
    public int checkerInfoLength() {
        return this.checkerInfo.length;
    }
}
