package zlennon.tools;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class ReadDirectory {

    private static  final  String  sourcePath="E:\\feihu\\发版\\廊坊银行\\小程序开画失败事件上报\\20230809\\BOOT-INF\\";

    public static void main(String[] args) {
        System.out.println(String.valueOf(System.currentTimeMillis()));
        File file = new File(sourcePath);
        read(file);
    }

    public static void read(File file){
        if(file.isFile()){
           String name=file.getName();
           System.out.println(file.getAbsolutePath() + "\r\n");
        }else{
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(ReadDirectory::read);
        }
    }
}
