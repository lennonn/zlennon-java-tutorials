package com.zlennon.scheduling.quartz.covid;


/**
 *
 * Created by zlennon on 2018/07/28.
 */
public interface CovidService{
    public void importCovidData(String path);

    void saveDailyData();
}
