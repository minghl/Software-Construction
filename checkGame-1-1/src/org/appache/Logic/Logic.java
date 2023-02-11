package org.appache.Logic;

import org.appache.CheckMan.CheckMan;

public class Logic {
    //Whether the red check can jump move
    public boolean canRedJumpMove(CheckMan checkMan, int i, int j) {
        if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == false) {
            if (checkMan.isOnBoard(i + 1, j - 1) == true && checkMan.isOnBoard(i + 2, j - 2) == false && checkMan.isRed(i + 1, j - 1) == false && (j >= 2) && (i <= 5)) {
                return true;
            } else if (checkMan.isOnBoard(i + 1, j + 1) == true && checkMan.isOnBoard(i + 2, j + 2) == false && checkMan.isRed(i + 1, j + 1) == false && (j <= 5) && (i <= 5)) {
                return true;
            } else
                return false;
        } else if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == true) {
            if (checkMan.isOnBoard(i - 1, j - 1) == true && checkMan.isOnBoard(i - 2, j - 2) == false && checkMan.isRed(i - 1, j - 1) == false && (i >= 2) && (j >= 2)) {
                return true;
            } else if (checkMan.isOnBoard(i - 1, j + 1) == true && checkMan.isOnBoard(i - 2, j + 2) == false && checkMan.isRed(i - 1, j + 1) == false && (i >= 2) && (j <= 5)) {
                return true;
            } else if (checkMan.isOnBoard(i + 1, j + 1) == true && checkMan.isOnBoard(i + 2, j + 2) == false && checkMan.isRed(i + 1, j + 1) == false && (i <= 5) && (j <= 5)) {
                return true;
            } else if (checkMan.isOnBoard(i + 1, j - 1) == true && checkMan.isOnBoard(i + 2, j - 2) == false && checkMan.isRed(i + 1, j - 1) == false && (i <= 5) && (j >= 2)) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    ////Whether the white check can jump move
    public boolean canWhiteJumpMove(CheckMan checkMan, int i, int j) {
        if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == false) {
            if (checkMan.isOnBoard(i - 1, j + 1) == true && checkMan.isOnBoard(i - 2, j + 2) == false && checkMan.isRed(i - 1, j + 1) == true && (i >= 2) && (j <= 5)) {
                return true;
            } else if (checkMan.isOnBoard(i - 1, j - 1) == true && checkMan.isOnBoard(i - 2, j - 2) == false && checkMan.isRed(i - 1, j - 1) == true && (i >= 2) && (j >= 2)) {
                return true;
            } else
                return false;
        } else if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == true) {
            if (checkMan.isOnBoard(i - 1, j - 1) == true && checkMan.isOnBoard(i - 2, j - 2) == false && checkMan.isRed(i - 1, j - 1) == true && (i >= 2) && (j >= 2)) {
                return true;
            } else if (checkMan.isOnBoard(i - 1, j + 1) == true && checkMan.isOnBoard(i - 2, j + 2) == false && checkMan.isRed(i - 1, j + 1) == true && (i >= 2) && (j <= 5)) {
                return true;
            } else if (checkMan.isOnBoard(i + 1, j + 1) == true && checkMan.isOnBoard(i + 2, j + 2) == false && checkMan.isRed(i + 1, j + 1) == true && (i <= 5) && (j <= 5)) {
                return true;
            } else if (checkMan.isOnBoard(i + 1, j - 1) == true && checkMan.isOnBoard(i + 2, j - 2) == false && checkMan.isRed(i + 1, j - 1) == true && (i <= 5) && (j >= 2)) {
                return true;
            } else
                return false;
        } else
            return false;
    }


    //Method of red multiple jump move
    public void continueRedMove(CheckMan checkMan, int i, int j) {
        while (this.canRedJumpMove(checkMan, i, j) == true) {
            if (checkMan.isOnBoard(i, j) == true && checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == false) {
                if (checkMan.isOnBoard(i + 1, j - 1) == true && checkMan.isOnBoard(i + 2, j - 2) == false && checkMan.isRed(i + 1, j - 1) == false) {
                    checkMan.removeChessMan(i + 1, j - 1);
                    checkMan.moveChessMan(i, j, i + 2, j - 2);
                    i = i + 2;
                    j = j - 2;
                } else if (checkMan.isOnBoard(i + 1, j + 1) == true && checkMan.isOnBoard(i + 2, j + 2) == false && checkMan.isRed(i + 1, j + 1) == false) {
                    checkMan.removeChessMan(i + 1, j + 1);
                    checkMan.moveChessMan(i, j, i + 2, j + 2);
                    i = i + 2;
                    j = j + 2;
                }
            } else if (checkMan.isOnBoard(i, j) == true && checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == true) {
                if (checkMan.isOnBoard(i - 1, j - 1) == true && checkMan.isOnBoard(i - 2, j - 2) == false && checkMan.isRed(i - 1, j - 1) == false) {
                    checkMan.removeChessMan(i - 1, j - 1);
                    checkMan.moveChessMan(i, j, i - 2, j - 2);
                    i = i - 2;
                    j = j - 2;
                } else if (checkMan.isOnBoard(i - 1, j + 1) == true && checkMan.isOnBoard(i - 2, j + 2) == false && checkMan.isRed(i - 1, j + 1) == false) {
                    checkMan.removeChessMan(i - 1, j + 1);
                    checkMan.moveChessMan(i, j, i - 2, j + 2);
                    i = i - 2;
                    j = j + 2;
                } else if (checkMan.isOnBoard(i + 1, j + 1) == true && checkMan.isOnBoard(i + 2, j + 2) == false && checkMan.isRed(i + 1, j + 1) == false) {
                    checkMan.removeChessMan(i + 1, j + 1);
                    checkMan.moveChessMan(i, j, i + 2, j + 2);
                    i = i + 2;
                    j = j + 2;
                } else if (checkMan.isOnBoard(i + 1, j - 1) == true && checkMan.isOnBoard(i + 2, j - 2) == false && checkMan.isRed(i + 1, j - 1) == false) {
                    checkMan.removeChessMan(i + 1, j - 1);
                    checkMan.moveChessMan(i, j, i + 2, j - 2);
                    i = i + 2;
                    j = j - 2;
                }
            }

        }
    }

    //Method of white multiple jump move
    public void continueWhiteMove(CheckMan checkMan, int i, int j) {
        while (this.canWhiteJumpMove(checkMan, i, j) == true) {
            if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == false) {
                if (checkMan.isOnBoard(i - 1, j + 1) == true && checkMan.isOnBoard(i - 2, j + 2) == false && checkMan.isRed(i - 1, j + 1) == true) {
                    checkMan.removeChessMan(i - 1, j + 1);
                    checkMan.moveChessMan(i, j, i - 2, j + 2);
                    i = i - 2;
                    j = j + 2;
                } else if (checkMan.isOnBoard(i - 1, j - 1) == true && checkMan.isOnBoard(i - 2, j - 2) == false && checkMan.isRed(i - 1, j - 1) == true) {
                    checkMan.removeChessMan(i - 1, j - 1);
                    checkMan.moveChessMan(i, j, i - 2, j - 2);
                    i = i - 2;
                    j = j - 2;
                }
            } else if (checkMan.isOnBoard(i, j) == true && checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == true) {
                if (checkMan.isOnBoard(i - 1, j - 1) == true && checkMan.isOnBoard(i - 2, j - 2) == false && checkMan.isRed(i - 1, j - 1) == true) {
                    checkMan.removeChessMan(i - 1, j - 1);
                    checkMan.moveChessMan(i, j, i - 2, j - 2);
                    i = i - 2;
                    j = j - 2;
                } else if (checkMan.isOnBoard(i - 1, j + 1) == true && checkMan.isOnBoard(i - 2, j + 2) == false && checkMan.isRed(i - 1, j + 1) == true) {
                    checkMan.removeChessMan(i - 1, j + 1);
                    checkMan.moveChessMan(i, j, i - 2, j + 2);
                    i = i - 2;
                    j = j + 2;
                } else if (checkMan.isOnBoard(i + 1, j + 1) == true && checkMan.isOnBoard(i + 2, j + 2) == false && checkMan.isRed(i + 1, j + 1) == true) {
                    checkMan.removeChessMan(i + 1, j + 1);
                    checkMan.moveChessMan(i, j, i + 2, j + 2);
                    i = i + 2;
                    j = j + 2;
                } else if (checkMan.isOnBoard(i + 1, j - 1) == true && checkMan.isOnBoard(i + 2, j - 2) == false && checkMan.isRed(i + 1, j - 1) == true) {
                    checkMan.removeChessMan(i + 1, j - 1);
                    checkMan.moveChessMan(i, j, i + 2, j - 2);
                    i = i + 2;
                    j = j - 2;
                }
            }
        }
    }

    // Traverse red checkers and judge whether you can jump move and jump move
    public boolean isRedExecute(CheckMan checkMan) {
        int[][] myChessManposition = checkMan.myChessManPosition();
        for (int k = 0; k < myChessManposition.length; k++) {
            int i = myChessManposition[k][0];
            int j = myChessManposition[k][1];
            if (this.canRedJumpMove(checkMan, i, j) == true) {
                this.continueRedMove(checkMan, i, j);//
                return true;
            }
        }
        return false;
    }

    // Traverse white checkers and judge whether you can jump move and jump move
    public boolean isWhiteExecute(CheckMan checkMan) {
        int[][] myChessManposition = checkMan.myChessManPosition();
        for (int k = 0; k < myChessManposition.length; k++) {
            int i = myChessManposition[k][0];
            int j = myChessManposition[k][1];
            if (this.canWhiteJumpMove(checkMan, i, j) == true) {
                this.continueWhiteMove(checkMan, i, j);
                return true;
            }
        }
        return false;
    }

    //Judge the destination is out of red checkers' movement range
    public boolean isRedAchieve(CheckMan checkMan, int i, int j, int l, int m) {
        if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == false && l == i + 1 && m == j + 1) {
            return true;
        } else if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == false && l == i + 1 && m == j - 1) {
            return true;
        } else if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == true && l == i - 1 && m == j - 1) {
            return true;
        } else if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == true && l == i + 1 && m == j - 1) {
            return true;
        } else if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == true && l == i + 1 && m == j + 1) {
            return true;
        } else if (checkMan.isRed(i, j) == true && checkMan.isKing(i, j) == true && l == i - 1 && m == j + 1) {
            return true;
        } else
            return false;
    }

    //Judge the destination is out of white checkers' movement range
    public boolean isWhiteAchieve(CheckMan checkMan, int i, int j, int l, int m) {
        if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == false && l == i - 1 && m == j + 1) {
            return true;
        } else if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == false && l == i - 1 && m == j - 1) {
            return true;
        } else if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == true && l == i - 1 && m == j - 1) {
            return true;
        } else if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == true && l == i + 1 && m == j - 1) {
            return true;
        } else if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == true && l == i + 1 && m == j + 1) {
            return true;
        } else if (checkMan.isRed(i, j) == false && checkMan.isKing(i, j) == true && l == i - 1 && m == j + 1) {
            return true;
        } else
            return false;
    }
}