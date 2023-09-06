package com.zlennon.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@Slf4j
@RestController
public class CompressedFileOpreator {

    //static String zipFilePath = "F:\\WXwork\\WXWork\\1688856999309948\\Cache\\File\\2023-04\\";
    static String zipFilePath = "C:\\Users\\EDY\\Documents\\WeChat Files\\wxid_hlaffy90tvzw21\\FileStorage\\File\\2023-04\\";

    static String destDirPath = "E:\\feihu\\project_files\\";

    public static void main(String[] args) throws IOException {
        CompressedFileOpreator cfo =new CompressedFileOpreator();
        List<String> fielNames = new ArrayList<>();
        String name="log-1.*zip";
        findFile(name,fielNames);

        fielNames.stream().forEach(fileName ->{
            unCompress(fileName.toString(),"copy");
        });


    }

     static void  findFile(String name, List<String> fileNames) throws IOException {
         Files.list(Path.of(zipFilePath))
                 .forEach(line->{
                     Path fileName = line.getFileName();
                     Pattern pattern = Pattern.compile(name);
                     if(pattern.asMatchPredicate().test(fileName.toString())){
                         fileNames.add(fileName.toString());
                     }
                 });
         if(fileNames.isEmpty()){
             zipFilePath="F:\\WXwork\\WXWork\\1688856999309948\\Cache\\File\\2023-04\\";
             findFile(name,fileNames);
         }
    }

    public static void  unCompress(String name,String moveOrCopy){
        zipFilePath+=name;
        Path sourcePath = Paths.get(zipFilePath);
        Path destPath = Paths.get(destDirPath+name);

            try {
                if(!Files.exists(destPath)) {
                    Files.createDirectories(Path.of(destDirPath));
                }
                moveOrCopy(sourcePath,destPath,moveOrCopy);
                if(name.endsWith("rar")){
                    unRar(sourcePath,destPath);
                }else {
                    unzip(destDirPath,name);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    private static void unzip(String destDirPath, String name) {
        String yyyyMMddHHmm = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        String destUnzipDir=destDirPath +"/" +name.substring(0,name.lastIndexOf("."))+"_"+yyyyMMddHHmm;
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;
        try {
            zis = new ZipInputStream(new FileInputStream(destDirPath+name));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(new File(destUnzipDir), zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // write file content
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }

                zipEntry = zis.getNextEntry();
            }
        } catch (Exception e) {

        }finally {
            try {
                zis.closeEntry();
                zis.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    static void unRar(Path sourcePath, Path destPath){
        FileInputStream fileInputStream = null;
        String cmd = "D:/Program Files/WinRAR/WinRAR.exe x -Plzccb@123  -y " + destPath.toString() +" "+ destPath.getParent().toString();
        try {
            exe(cmd);
        }catch (Exception e){
            log.error("error,cmd:{}",cmd,e);
        }
    }


    public static boolean exe(String cmd) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));

            String line = reader.readLine();
            while(line!=null) {
                log.info(line);
                line = reader.readLine();
            }
            reader.close();
            if(p.waitFor()!=0) {
                return false;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    private static void moveOrCopy(Path sourcePath, Path destPath, String moveOrCopy) {
        try {
            if (moveOrCopy.equals("move")) {
                if (!Files.exists(destPath)) {
                        Files.move(sourcePath, destPath);
                }

            }else{
                if (!Files.exists(destPath)) {
                    Files.copy(sourcePath, destPath);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}
