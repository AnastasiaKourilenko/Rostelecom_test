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
        System.out.println(isCorrectVersion2(sudoku) ? "корректно" : "некорректно");
    }

    public static boolean isCorrectVersion2(int[][] sudoku) {
        //проверка размерности переданной матрицы
        if (sudoku.length != 9) {
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (sudoku[i].length != 9) {
                    return false;
                }
            }
        }

        //проверка корректности горизонталей
        Set<Integer> horizontalSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] < 1 || sudoku[i][j] > 9) {
                    return false;
                } else {
                    horizontalSet.add(sudoku[i][j]);
                }
            }
            if (horizontalSet.size() != 9) {
                return false;
            }
            horizontalSet.clear();
        }

        //проверка корректности вертикалей
        Set<Integer> verticalSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                verticalSet.add(sudoku[j][i]);
            }
            if (verticalSet.size() != 9) {
                return false;
            }
            verticalSet.clear();
        }

        //проверка корректности сегментов 3*3
        Set<Integer> segmentSet = new HashSet<>();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int l = i; l < i + 3; l++) {
                    for (int k = j; k < j + 3; k++) {
                        segmentSet.add(sudoku[l][k]);
                    }
                }
                if (segmentSet.size() != 9) {
                    return false;
                }
                segmentSet.clear();
            }
        }
        return true;
    }

    static void showSudoku(int[][] sudoku) {
        for (int[] horizontal : sudoku) {
            for (int a : horizontal) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
