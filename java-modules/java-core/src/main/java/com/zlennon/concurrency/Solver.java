package com.zlennon.concurrency;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Solver {
        final int N;
        final double[][] data;
        final CyclicBarrier barrier;

        class Worker implements Runnable {
            int myRow;
            Worker(int row) { myRow = row; }
            public void run() {
                    double[] doubles = processRow(myRow);
                    data[myRow]=doubles;
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"完成");
                        barrier.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"继续执行任务");

                    } catch (InterruptedException ex) {
                        return;
                    } catch (BrokenBarrierException ex) {
                        return;
                    }
            }

            private boolean done() {
                return barrier.isBroken();
            }

            private double[] processRow(int myRow) {
                double[] datum = data[myRow];
                return Arrays.stream(datum).map(d->d*2).toArray();
            }
        }
    public Solver(double[][] matrix) {
        data = matrix;
        N = matrix.length;
        Runnable barrierAction = this::mergeRows;
        barrier = new CyclicBarrier(N, barrierAction);

        List<Thread> threads = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }
    }

    private void mergeRows() {
        System.out.println("处理后数据================================================================");
        printMatrix(data);
    }

    public static void printMatrix(double [][] data) {
        for (double[] d : data) {
            System.out.println(Arrays.toString(d));
        }
    }

    public static void main(String[] args) {
            int n =5;
            double[][] rmdata = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rmdata[i][j] = RandomUtils.nextInt(1, 10 * n);
                }
            }
        System.out.println("处理前数据================================================================");
        printMatrix(rmdata);
        Solver solver = new Solver(rmdata);
    }
}