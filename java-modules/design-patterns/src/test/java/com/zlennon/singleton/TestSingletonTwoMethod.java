package com.zlennon.singleton;

import org.junit.Test;

public class TestSingletonTwoMethod {

    @Test
    public void  test(){
        for(int j=0;j<10;j++){

            for(int i=0;i<2;i++){
                // ThreadSafeLazyLoadedIvoryTower instance =new ThreadSafeLazyLoadedIvoryTower();
                ThreadSafeLazyLoadedIvoryTower instance =ThreadSafeLazyLoadedIvoryTower.getInstance();
                Thread t1 =new Thread(instance);
                t1.start();
            }
        }


    }

}
