package com.zlennon.math34;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.Arrays;

public class MatrixOperate {
    public void operate() {
        double[][] dataA = getMatrixData(3);
        RealMatrix matrixA = createMatrix(dataA);
        System.out.println("新创建的创建的矩阵A：===========>>");
        printMatrix(matrixA);

        double[][] dataB = getMatrixData(3);
        RealMatrix matrixB = createMatrix(dataB);
        System.out.println("新创建的创建的矩阵B：===========>>");
        printMatrix(matrixB);

        //矩阵乘法;
        RealMatrix mulMatrix = mulMatrix(matrixA, matrixB);
        //矩阵加法;
        RealMatrix addMatrix = addMatrix(matrixA, matrixB);
        //矩阵减法
        RealMatrix subMatrix = subMatrix(matrixA, matrixB);
        //矩阵转置
        RealMatrix transMatrix = matrixA.transpose();
        System.out.println("矩阵A的转置矩阵：===========>>");
        printMatrix(transMatrix);

        //逆矩阵
        RealMatrix inverseMatrix = inverseMatrix(matrixA);
        System.out.println("矩阵A的逆矩阵：===========>>");
        printMatrix(inverseMatrix);

        //乘以或除以常数
        RealMatrix scalarMatrix = matrixA.scalarMultiply(2);
        System.out.println("矩阵A乘以常数2：===========>>");
        printMatrix(scalarMatrix);

        RealMatrix matrixARow1 = matrixA.getRowMatrix(1);
        System.out.println("矩阵A第二行：===========>>");
        printMatrix(matrixARow1);

        RealMatrix matrixAColumn1 = matrixA.getColumnMatrix(1);
        System.out.println("矩阵A第二列：===========>>");
        printMatrix(matrixAColumn1);

    }

    private RealMatrix inverseMatrix(RealMatrix matrixA) {
        RealMatrix inverse = new LUDecomposition(matrixA).getSolver().getInverse();
        RealMatrix inverseb = MatrixUtils.inverse(matrixA);//默认使用QR-decomposition计算
        //printMatrix(inverseb);
        return inverse;
    }

    private RealMatrix subMatrix(RealMatrix matrixA, RealMatrix matrixB) {
        return matrixA.subtract(matrixB);
    }

    private RealMatrix addMatrix(RealMatrix matrixA, RealMatrix matrixB) {
        return matrixA.add(matrixB);
    }

    private RealMatrix mulMatrix(RealMatrix matrixA, RealMatrix matrixB) {
        return matrixA.multiply(matrixB);
    }

    private RealMatrix createMatrix(double[][] data) {
        RealMatrix matrix = new Array2DRowRealMatrix(data);
        //RealMatrix matrix = MatrixUtils.createRealMatrix(data);
        return matrix;
    }

    public double[][] getMatrixData(int n) {
        double[][] rmdata = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rmdata[i][j] = RandomUtils.nextInt(1, 10 * n);
            }
        }
        return rmdata;
    }

    public void printMatrix(RealMatrix matrix) {
        double[][] matrixData = matrix.getData();
        for (double[] d : matrixData) {
            System.out.println(Arrays.toString(d));
        }
    }
}
