package com.zlennon.math34;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.testng.annotations.Test;

public class MathRandomTest {
    @Test
    public void testGetGaussianRandomGenerator(){
        JDKRandomGenerator jrg =new JDKRandomGenerator();
        double gaussian= Random.getGaussianRandomGenerator(jrg);
        System.out.println(gaussian);
    }
}
