
import org.w3c.dom.html.HTMLImageElement;

import java.util.Random;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        int n = 1000;

        System.out.println(timereturn(100,n));
        System.out.println(timereturn(10,n));
        System.out.println(timereturn(1,n));
        System.out.println(timereturn(.1,n));
        System.out.println(timereturn(1/Math.log(n),n));
        System.out.println(timereturn(1/Math.pow(n,2),n));
        System.out.println(timereturn(1/Math.pow(java.lang.Math.E,n),n));



    }


    public static String timereturn(double percentzeros, int n) {
        double zeros =0;
        double total =0;

        int rows = n;
        int cols = n;
        double[][] matrix = new double[rows][cols];
        double[] vector = new double[cols];
        Random rnd = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ++total;
                double percentcalc = rnd.nextDouble()*100;
                if(percentcalc<percentzeros) {
                    matrix[i][j] = 0;
                    ++zeros;
                }
                else; matrix[i][j] = percentcalc/100;
            }
        }
        for (int i = 0; i < cols; i++) {
            ++total;
            double percentcalc = rnd.nextDouble()*100;
            if(percentcalc<percentzeros){
                vector[i] =0;
                ++zeros;
            }
            else;
            vector[i] = percentcalc/100;
        }


        long start_time = System.nanoTime();
        double[] result = matrixVectorMultiplication(matrix, vector);

        long end_time = System.nanoTime();
        return("Execution time: " + (end_time - start_time) + " ns ---- Expected percent of zeros was " + percentzeros + " actual percent was " + zeros/total*100);
    }

    public static double[] matrixVectorMultiplication(double[][] A, double[] x) {
        if (A[0].length != x.length) {
            throw new IllegalArgumentException("Matrix and vector dimensions do not match.");
        }
        double[] y = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < x.length; j++) {
                y[i] += A[i][j] * x[j];
            }
        }
        return y;
    }

}