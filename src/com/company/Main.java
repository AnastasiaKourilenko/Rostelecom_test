package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int[][] sudoku = new int[9][9];

    public static void main(String[] args) {
        sudoku = new int[][]{
                {2, 9, 1, 5, 4, 3, 6, 7, 8},
                {5, 4, 3, 8, 7, 6, 1, 9, 2},
                {8, 7, 6, 2, 9, 1, 3, 4, 5},
                {4, 3, 2, 7, 6, 5, 8, 1, 9},
                {7, 6, 5, 9, 1, 8, 2, 3, 4},
                {9, 1, 8, 4, 3, 2, 5, 6, 7},
                {3, 2, 9, 6, 5, 4, 7, 8, 1},
                {6, 5, 4, 1, 8, 7, 9, 2, 3},
                {1, 8, 7, 3, 2, 9, 4, 5, 6}};

        showSudoku(sudoku);
        System.out.println(isCorrect(sudoku) ? "корректно" : "некорректно");
    }


    public static boolean isCorrect(int[][] sudoku) {
        Set<Integer> horizontalSet = new HashSet<>();
        Set<Integer> verticalSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (horizontalSet.contains(sudoku[i][j]) || verticalSet.contains(sudoku[j][i])) {
                    return false;
                } else {
                    horizontalSet.add(sudoku[i][j]);
                    verticalSet.add(sudoku[j][i]);
                }
            }
            horizontalSet.clear();
            verticalSet.clear();
        }

        Set<Integer> segmentSet = new HashSet<>();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int l = i; l < i + 3; l++) {
                    for (int k = j; k < j + 3; k++) {
                        if (segmentSet.contains(sudoku[l][k])) {
                            return false;
                        } else segmentSet.add(sudoku[l][k]);
                    }
                }
                segmentSet.clear();
            }
        }
        return true;
    }


    static void showSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

}
