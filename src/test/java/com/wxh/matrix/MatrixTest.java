package com.wxh.matrix;

import org.junit.Test;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.doublematrix.DoubleMatrix;
import org.ujmp.core.genericmatrix.GenericMatrix;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/17
 * @time: 上午9:53
 */
public class MatrixTest {

    @Test
    public void test1() throws InterruptedException {
        // create matrix with random values between 0 and 1
        Matrix rand = Matrix.Factory.rand(100, 10);

        // create matrix with random values between -1 and - 1
        Matrix randn = Matrix.Factory.randn(100, 10);

        System.out.println(rand);
    }

    @Test
    public void test2() throws IOException {
        File file = new File("res_before.csv");
        Matrix m = Matrix.Factory.importFrom().file(file).asDenseCSV().transpose();
        System.out.println(m.allValues());
//        System.out.println(m);
//        System.out.println(m.getAsMatrix(0,1));
//        System.out.println(m.getColumnCount());
//        System.out.println(m.getColumnList());
//        m = m.deleteColumns(Calculation.Ret.NEW, 0);
//        System.out.println(m);
//        System.out.println(m.selectColumns(Calculation.Ret.NEW, 0,1,2));
    }

    public void test3(){
//        GenericMatrix<Double> matrix = Matrix.Factory.
    }
}
