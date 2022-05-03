package de.hsrm.cs.ads;

public class Matrix {
    double [][] data;
    Matrix(int dimension){
        data = new double[dimension][dimension];
    }

    Matrix mult(Matrix that){
        assert this.data.length == that.data.length;
        Matrix returnMatrix = new Matrix(this.data.length);

        // iterates through the rows of this
        for (int thisRow = 0; thisRow < this.data.length; thisRow++) {

            // iterates through the columns of that
            for (int thatColumn = 0; thatColumn < that.data.length; thatColumn++) {

                // Avoid mess from random values in allocated strorage
                returnMatrix.data[thisRow][thatColumn] = 0;

                // iterates through the elements of row and column of this and that
                for (int iterator = 0; iterator < this.data.length; iterator++) {
                    returnMatrix.data[thisRow][thatColumn] +=  // newline for better readability
                            this.data[thisRow][iterator] * that.data[iterator][thatColumn]; // i_n * j_n
                }
            }
        }

        return returnMatrix;
    }

    public static void main(String[] args) {
        Matrix a = new Matrix(5);
        Matrix b = new Matrix(5);
        Matrix c;

        a.data = new double[][] {
                {1, 2, 3, 7, -2},
                {3, .2, 1, 5, 3},
                {1, 1, -1, 9, 0},
                {3, 1, 2, .3, 6},
                {7, -8, 2, 4, .5}
        };

        b.data = new double[][] {
                {0, 0, -0, 7, .3},
                {3, 1, 2, 2, 6},
                {2, .2, -2, -5, 9},
                {4, .5, 7, 3, 9},
                {4, 7, 2, .8, 2}
        };

        c = a.mult(b);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(c.data[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }

    }
}