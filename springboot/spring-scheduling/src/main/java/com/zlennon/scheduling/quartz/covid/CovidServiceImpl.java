package com.zlennon.scheduling.quartz.covid;

import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zlennon on 2018/08/27.
 */
@Service
@Transactional
public class CovidServiceImpl implements CovidService {

    Logger logger = LoggerFactory.getLogger(CovidServiceImpl.class);
    @Autowired
    private CovidRepository covidRepository;

    ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private static final Logger LOGGER = LoggerFactory.getLogger(CovidServiceImpl.class);



    @Value("${covid.daily.data.api}")
    private String covidDaliyDataApi;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void saveDailyData() {
        Covid[] dailyList= restTemplate.getForObject(covidDaliyDataApi,Covid[].class);
        logger.info("COVID daily data size ===>>>>>[{}]",dailyList.length);
    }

    @Override
    public void importCovidData(String path) {
        List<Future<String>> futures = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            Future<String> future = readCsv(path, file1.getName());
            futures.add(future);
        }
        futures.forEach((f) -> {
            try {
                LOGGER.info("{}文件已写入数据库", f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        while (threadPool.isTerminated()) {
            LOGGER.info("{write all data success");
            threadPool.isShutdown();
        }
    }


    private Future<String> readCsv(String path, String name) {
        String fileName = path + File.separator + name;
        List<Covid> covids = null;
        try {
            covids = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Covid.class).build().parse();
            String substring = name.substring(0, name.indexOf("."));

            List<Covid> finalCovids = covids;
            covids.forEach(c -> {
                LocalDate parse = LocalDate.parse(substring, DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.CHINA));
                c.setConfirmedDate(parse);
            });
            LOGGER.info("read file {} is success", name);
            Future<String> submit = threadPool.submit(
                    () -> {
                        covidRepository.saveAll(finalCovids);
                        LOGGER.info("submit task batch {} succes", name);
                        return name;
                    });
            return submit;
        } catch (Exception e) {
            LOGGER.error("read file {} is error", name, e);
        }
        return null;
    }

}
