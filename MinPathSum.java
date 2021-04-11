import java.util.*;


public class MinPathSum {
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(minPathSum(matrix));
    }

    public static int minPathSum(int[][] matrix) {

        int[][] steps = new int[matrix.length][matrix[0].length];
        steps[0][0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            steps[0][i] = steps[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            steps[i][0] = steps[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                steps[i][j] = Math.min(steps[i][j -  1], steps[i - 1][j]) + matrix[i][j];
            }
        }
        return steps[matrix.length - 1][matrix[0].length - 1];
    }

    public static int minPathSum(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i < matrix.length - 1 && j < matrix[0].length - 1) {
            return Math.min(minPathSum(matrix, i + 1, j), minPathSum(matrix, i, j + 1)) + matrix[i][j];
        } else if (i < matrix.length - 1 && j == matrix[0].length - 1){
            return minPathSum(matrix, i + 1, j) + matrix[i][j];
        } else if (i == matrix.length - 1 && j < matrix[0].length - 1) {
            return minPathSum(matrix, i, j + 1) + matrix[i][j];
        }
        return matrix[i][j];
    }
}
