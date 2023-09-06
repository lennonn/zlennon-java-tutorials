package com.zlennon.math34;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.junit.Test;


public class Math3Test {
    @Test
    public void testMean(){
        double[] values = new double[] { 0.33, 1.33,0.27333, 0.3, 0.501,
                 0.444, 0.44, 0.34496, 0.33,0.3, 0.292, 0.667 };
        Mean mean = new Mean();
        double avg=mean.evaluate(values);
       // print(avg);
    }
}
