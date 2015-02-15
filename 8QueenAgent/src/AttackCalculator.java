
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AsA
 */
public class AttackCalculator {

    /**
     * This metod creates a list from queen attacks
     *
     * @param chessBoard
     * @param qPositions
     * @return ArrayList
     */
    public int getAttackNumber(int[][] chessBoard, ArrayList<Integer> qPositions) {
        ArrayList<String> result = new ArrayList<>();
        int x, y;

        //x+ y+ direction
        for (int i = 0; i < 8; i++) {
            x = qPositions.get(i) + 1;
            y = i + 1;
            while (x < 8 && y < 8) {
                if (chessBoard[y][x] == 1 && !checkReverse(result, i + "" + qPositions.get(i) + "" + y + "" + x)) {
                    result.add(i + "" + qPositions.get(i) + "" + y + "" + x);
                }
                x++;
                y++;
            }
        }

        //x- y- direction
        for (int i = 0; i < 8; i++) {
            x = qPositions.get(i) - 1;
            y = i - 1;
            while (x >= 0 && y >= 0) {
                if (chessBoard[y][x] == 1 && !checkReverse(result, i + "" + qPositions.get(i) + "" + y + "" + x)) {
                    result.add(i + "" + qPositions.get(i) + "" + y + "" + x);
                }
                x--;
                y--;
            }
        }

        //x+ y- direction
        for (int i = 0; i < 8; i++) {
            x = qPositions.get(i) + 1;
            y = i - 1;
            while (x < 8 && y >= 0) {
                if (chessBoard[y][x] == 1 && !checkReverse(result, i + "" + qPositions.get(i) + "" + y + "" + x)) {
                    result.add(i + "" + qPositions.get(i) + "" + y + "" + x);
                }
                x++;
                y--;
            }
        }

        //x- y+ direction
        for (int i = 0; i < 8; i++) {
            x = qPositions.get(i) - 1;
            y = i + 1;
            while (x >= 0 && y < 8) {
                if (chessBoard[y][x] == 1 && !checkReverse(result, i + "" + qPositions.get(i) + "" + y + "" + x)) {
                    result.add(i + "" + qPositions.get(i) + "" + y + "" + x);
                }
                x--;
                y++;
            }
        }

        //horizonal check
        for (int i = 0; i < 8; i++) {
            x = qPositions.get(i);
            for (int j = i + 1; j < 8; j++) {
                if (chessBoard[j][x] == 1 && !checkReverse(result, i + "" + x + "" + j + "" + x)) {
                    result.add(i + "" + x + "" + j + "" + x);
                }
            }

        }

        return result.size();

    }

    /**
     * This metod check queen attacks.Example A beat B also B beat A, we take
     * one enemy couple from attacks.
     *
     * @param list
     * @param s
     * @return
     */
    private static boolean checkReverse(ArrayList<String> list, String s) {
        String reverse;
        if (s.equals("")) {
            return false;
        } else {
            reverse = s.substring(2, 4) + s.substring(0, 2);
            return list.contains(s) || list.contains(reverse);
        }
    }

    /**
     * This metod finds all posible quneen attacks each other.
     * @param qPositions
     * @return int[][]
     */
    public int[][] findAllPosibleAttacks(ArrayList<Integer> qPositions) {
        Generator g = new Generator();
        ArrayList<Integer> tempList = new ArrayList<>();
        int[][] result = new int[8][8];
        for (int i = 0; i < 8; i++) {
            tempList = (ArrayList)qPositions.clone();
            for (int j = 0; j < 8; j++) {
                tempList.remove(i);
                tempList.add(i, j);
                result[i][j] = getAttackNumber(g.createChessBoard(tempList), tempList);
            }

        }
        return result;
    }
    
    
    

}
