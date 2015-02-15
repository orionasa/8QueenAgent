
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AsA
 */
public class Movements {

    /**
     * This metod finds minimum value of attacks
     *
     * @param attackBoard
     * @return int
     */
    public int findMinValue(int[][] attackBoard) {
        int temp = attackBoard[0][0];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (attackBoard[i][j] < temp) {
                    temp = attackBoard[i][j];
                }
            }
        }
        return temp;
    }

    /**
     * This metod creates list as posible movements
     *
     * @param attackBoard
     * @param min
     * @return ArrayList
     */
    public ArrayList<String> getPosibleMovements(int[][] attackBoard, int min) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8; j++) {
                if (attackBoard[i][j] == min) {
                    result.add(i+""+j);
                }
            }
        }
        return result;
    }

    /**
     * This metod picks next move for any queen
     *
     * @param movements
     * @return
     */
    public String pickQueenMovement(ArrayList<String> movements) {
        if (movements != null) {
            Random rand = new Random(System.nanoTime());
            int move = rand.nextInt(movements.size());
            String result = movements.get(move);
            return result;
        } else {
            return "STOP";
        }
    }
    /**
     * This metod generate new queen positions with chosen movements
     * @param i
     * @param oldPositions
     * @return 
     */
    public ArrayList<Integer> generateNewQueens(String i, ArrayList<Integer> oldPositions) {
        if (i.equals("STOP")) {
            return oldPositions;
        } else {
            oldPositions.remove(Integer.parseInt(i.substring(0, i.length() - 1)));
            oldPositions.add(Integer.parseInt(i.substring(0, i.length() - 1)), Integer.parseInt(i.substring(i.length() - 1, i.length())));
            return oldPositions;
        }
    }

}
