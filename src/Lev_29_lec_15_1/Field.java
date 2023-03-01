package Lev_29_lec_15_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    private int width;
    private int height;
    private int[][] matrix;
    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public int[][] getMatrix() { return matrix; }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }



    public static void main(String[] args) {
        Field field = new Field(5, 5);
        for (int i = 0; i < field.height; i++) {
            field.matrix[1][i] = i % 2;
        }
        for (int i = 0; i < field.height; i++) {
            field.matrix[2][i] = 1;
        }
        for (int i = 0; i < field.height; i++) {
            field.matrix[3][i] = 1;
        }

        System.out.println("Матрица ДО удаления");
        field.purePrint();
        field.removeFullLines();
        System.out.println("Матрица ПОСЛЕ удаления");
        field.purePrint();
    }

    void purePrint() {
        System.out.println("--------------------------");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix[y][x] == 0 ){
                    System.out.print(".");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println("\t\t\t" + matrix[y].toString());
        }
        System.out.println("--------------------------");
    }

    void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        //Копируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    void removeFullLines() {
    List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (check(matrix[i])) { list.add(matrix[i]); } }
    int count = list.size() - 1;
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (count >= 0) { matrix[i] = list.get(count--); }
            else matrix[i] = new int[width]; } }

    boolean check(int[] x) {
        int y = 0;
        for (int i = 0 ; i < x.length; i++) { y += x[i]; }
        return y < width; }

    Integer getValue(int x, int y){
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];
        return null;
    }
    void setValue(int x, int y, int value){
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }
}
