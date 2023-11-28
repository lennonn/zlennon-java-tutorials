package zlennon.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DirectoryToTable {
    private static  final  String  sourcePath="D:\\IdeaProject\\appdevelop\\beijingbank_server_vbank3.0.000113\\vbank-record\\vbank-record-busi\\target\\classes\\";
    private static  final  String  targetPath="E:\\feihu\\发版\\北京\\20231113-credit-two\\record\\";
    private static List<String> fileNames = new ArrayList<String>();
    private static  final  String  classPath="D:\\IdeaProject\\appdevelop\\langfangbank-busiroom\\issue\\20230608";

    static {
        File file = new File(classPath);
        //getClassFile(file,fileNames);
        //读取文件名
        fileNames.add("VideoDownloader.*");
        fileNames.add("FfmpegService.*");
        fileNames.add("FillRecordServicelmpl.*");
        fileNames.add("UploadOssService.*");
        fileNames.add("application-recordConfig.*");

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
                if(fileNames.stream().anyMatch(name::matches)) {
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
                        Files.copy(sourcePath,targetPath, StandardCopyOption.REPLACE_EXISTING);
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

    public static void getClassFile(File file, List<String> fileNames){
        try{

            if(file.isFile()){
                String name=file.getName();
                if(name.contains("."))
                fileNames.add(name.substring(0,name.lastIndexOf("."))+".*");
            }else{
                Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(file1 -> getClassFile(file1, fileNames));
            }
        }catch(Exception e){
            System.out.println(e.getMessage()+"=="+file.getName());
        }
    }
}
