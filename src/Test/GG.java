package Test;

public class GG {
    public static void main(String[] args) {
        int[][] x = new int[3][3];
        int y = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = y++;
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(x[1][2]);

    }
}
