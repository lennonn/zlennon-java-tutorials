package com.zlennon.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DirectoryToTable {
    private static  final  String  sourcePath="D:\\IdeaProject\\appdevelop\\changshunongshangbank-server-vbank2.9\\vbank-data-cent\\target\\classes";
    private static  final  String  targetPath="E:\\feihu\\发版\\常熟\\后管首页统计优化\\";
    private static List<String> fileNames = new ArrayList<String>();
    static {
        fileNames.add("SessionEventDao.xml");
        fileNames.add("ComputeCallable.class");
        fileNames.add("CallStatisticsService.class");
    }

    public static void main(String[] args)  {
        try{
            File file = new File(sourcePath);
            test(file);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test(File file){
            if(file.isFile()){
                String name=file.getName();
                if(fileNames.contains(name)) {
                    String path = file.getPath();
                    path = path.substring(path.indexOf("classes"));
                    path =path.substring(0, path.lastIndexOf(name));
                    String dectoryName=targetPath+path;
                    File taget = new File(dectoryName);
                    if (!taget.exists()) {
                        taget.mkdirs();
                    }
                    File tagetFile = new File(dectoryName+name);
                    Path sourcePath = Paths.get(file.getPath());
                    Path targetPath = Paths.get(tagetFile.getPath());
                    try {
                        Files.copy(sourcePath,targetPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //文件写到对应的目录


                    System.out.println(name + ",新增," + file.getName() + ",后管加载缓慢优化," + file.getAbsolutePath() + "\r\n");
                }
            }else{
                Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(DirectoryToTable::test);
            }
    }
}
