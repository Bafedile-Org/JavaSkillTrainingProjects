package za.co.mecer.soduku;

import za.co.mecer.impl.Sodukus;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Soduku implements Sodukus {

    private final int[][] nums = new int[GRID_LENGTH][GRID_LENGTH];

    public void populateGrid() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = getRandomNum();
                displayGrid();
                System.out.println("");
                while (!(checkRow(i, nums[i][j]) && checkColumn(j, nums[i][j]) && checkBlock(i, j, nums[i][j]))) {
                    nums[i][j] = getRandomNum();
                    displayGrid();
                    System.out.println("");
                }
            }
        }
    }

    private int getRandomNum() {
        return (int) (Math.random() * GRID_LENGTH) + 1;
    }

    private boolean checkRow(int row, int num) {
        int count = 0;
        for (int i = 0; i < nums[row].length; i++) {
            if (nums[row][i] == num) {
                count++;
            }
        }
        return count == 1;
    }

    private boolean checkColumn(int col, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][col] == num) {
                count++;
            }
        }
        return count == 1;
    }

    private boolean checkBlock(int row, int col, int num) {
        if (((double) row / 2) <= 1) {
            if (((double) col / 2) <= 1) {
                return block(0, 0, 3, 3, num);
            }
            if (((double) col / 2) <= 2.5) {
                return block(0, 3, 3, 6, num);
            }

            if (((double) col / 2) <= 4) {
                return block(0, 6, 3, 9, num);
            }
        } else if (((double) row / 2) <= 2.5) {
            if (((double) col / 2) <= 1) {
                return block(3, 0, 6, 3, num);
            }
            if (((double) col / 2) <= 2.5) {
                return block(3, 3, 6, 6, num);
            }

            if (((double) col / 2) <= 4) {
                return block(3, 6, 6, 9, num);
            }
        } else {
            if (((double) col / 2) <= 1) {
                return block(6, 0, 9, 3, num);
            }
            if (((double) col / 2) <= 2.5) {
                return block(6, 3, 9, 6, num);
            }

            if (((double) col / 2) <= 4) {
                return block(6, 6, 9, 9, num);
            }
        }
        return false;
    }

    private boolean block(int row, int col, int rowEnd, int colEnd, int num) {
        int count = 0;
        for (int i = row; i < rowEnd; i++) {

            for (int j = col; j < colEnd; j++) {
                if (nums[i][j] == num) {
                    count++;
                }
            }
        }
        return count == 1;
    }

    public void displayGrid() {
        for (int[] num : nums) {
            for (int value : num) {
                System.out.printf("%d  ", value);
            }
            System.out.println();
        }
    }
}
