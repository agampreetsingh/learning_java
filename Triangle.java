import java.math.*;

public class Triangle {

    public static void main(String[] args) {
        System.out.println("-- left triangle");
        printRightLeftTriangle(5);
        System.out.println("-------");
        System.out.println("-- right triangle");
        printRightTriangle(5);
        System.out.println("-------");
        System.out.println("-- isocele triangle");
        printEquilateralTriangle(5);
    }

    private static void printRightLeftTriangle(int height) {
        for (int i = 0; i < height; i++) { // create a row on each iteration
            for (int j = 0; j < i + 1; j++) { // print i + 1 start
                System.out.print("*");
            }
            System.out.println(); // new line
        }
    }

    private static void printRightTriangle(int height) {
        for (int i = 0; i < height; i++) { // create a row on each iteration
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" "); // print height - i empty char
            }
            for (int j = 0; j < i + 1; j++) { // complete the line with i start
                System.out.print("*");
            }
            System.out.println(); // new line
        }
    }

    private static void printEquilateralTriangle(int height) {
        if (height % 2 == 0) {
            height++; // if height is pair we need to add 1 to have the same number of star at the left and the right of the taller column
        }

        int nbSpace = (int) Math.floor((height) / 2.0);

        for (int i = 0; i < Math.ceil(height / 2.0); i++) { // create a row on each iteration, we need half row than height value

            for (int j = 0; j < nbSpace; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < height - nbSpace * 2; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < nbSpace; j++) {
                System.out.print(" ");
            }
            System.out.println();
            nbSpace--;
        }
    }
}
