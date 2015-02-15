
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
public class Generator {
    
    /**
     * This metod generates all 8 queen positions.Each row have one queen.
     *
     * @return ArrayList
     */
    public ArrayList getRandomQueenPositions() {
        ArrayList<Integer> queenPositionList = new ArrayList<>();
        int random;
        Random rand = new Random(System.nanoTime());
        while (queenPositionList.toArray().length != 8) {
            random = rand.nextInt(8);
            if (!queenPositionList.contains(random)) {
                queenPositionList.add(random);
            }
        }
        return queenPositionList;

    }

    /**
     * This metod creates chess board with queen list.
     * @param qPositions -Queen Position List
     * @return 
     */
    public int[][] createChessBoard(ArrayList<Integer> qPositions) {
        int[][] chessBoard = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (qPositions.get(i).equals(j)) {
                    chessBoard[i][j] = 1;
                }
            }
        }
        return chessBoard;
    }

}
