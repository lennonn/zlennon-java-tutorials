package com.zlennon;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.PathFileComparator;
import org.apache.commons.io.filefilter.*;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.output.TeeOutputStream;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@Slf4j
public class FileUtilsDemo {

    File file = FileUtils.getFile(getClass().getClassLoader()
            .getResource("test.txt")
            .getPath());


    public void  testFileUtils() throws IOException {
        String path="https://www.zlennon.com/userfiles/ckeditor/files/log-history_drawio.png";
        File tempDir = FileUtils.getTempDirectory();
        FileUtils.copyFileToDirectory(file, tempDir);
        FileUtils.copyURLToFile(new URL(path),tempDir);

        File newTempFile = FileUtils.getFile(tempDir, file.getName());
        String data = FileUtils.readFileToString(newTempFile,
                Charset.defaultCharset());

        File file1 = new File("D:\\tmp\\test.png");
        FileUtils.copyURLToFile(new URL(path), file1);
        log.info("test.txt content:{}",data);
        log.info("after use file still read:{}",file1.canRead());
    }

    @Test
    public void testFilter(){
        //filters
        String path=file.getAbsolutePath();
        String fullPath = FilenameUtils.getFullPath(path);
        File dir = FileUtils.getFile(fullPath);

        String[] pngs = dir.list(new AndFileFilter(
                new WildcardFileFilter("*test*", IOCase.INSENSITIVE),
                new SuffixFileFilter("png")));
        assertEquals(1,pngs.length);
    }

    @Test
    public void testInputOutput() throws IOException {

        String str = "Hello World.";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();

        FilterOutputStream teeOutputStream
                = new TeeOutputStream(outputStream1, outputStream2);
        new TeeInputStream(inputStream, teeOutputStream, true)
                .read(new byte[str.length()]);

        log.info("outputStream1:{}", outputStream1);
        log.info("outputStream2:{}", outputStream2);
    }

    @Test
    public  void testFilenameUtils() throws IOException {
        String path=file.getAbsolutePath();
        String fullPath = FilenameUtils.getFullPath(path);
        String extension = FilenameUtils.getExtension(path);
        String baseName = FilenameUtils.getBaseName(path);

        log.info("fullPath:{},extension:{},baseName:{}",fullPath,extension,baseName);

        long freeSpace = FileSystemUtils.freeSpaceKb("D://");
        log.info("freeSpace(kb):{},mb:{},gb:{}",freeSpace,freeSpace/1024,freeSpace/1024/1024);
    }


    @Test
    public void fileComparator(){
        PathFileComparator pathFileComparator = new PathFileComparator(
                IOCase.INSENSITIVE);
        String path = FilenameUtils.getFullPath(getClass()
                .getClassLoader()
                .getResource("test.txt")
                .getPath());
        // 创建一些文件路径示例
        File[] files = {
                new File(path+"/log4j2.xml"),
                new File(path+"/test.png"),
                new File(path+ "/aaa.png"),
        };

        // 使用 PathFileComparator 进行升序排序
        pathFileComparator.sort(files);

        System.out.println("Files sorted in ascending order:");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        LastModifiedFileComparator modifiedFileComparator = new LastModifiedFileComparator();
        int compare = modifiedFileComparator.compare(files[0], files[2]);
        System.out.println(compare);
    }


    @Test
    public void fileMonitor() throws Exception {

        String path = FilenameUtils.getFullPath(getClass()
                .getClassLoader()
                .getResource("test.txt")
                .getPath());
        FileAlterationObserver observer = new FileAlterationObserver(path);
        FileAlterationMonitor monitor = new FileAlterationMonitor(5000);

        FileAlterationListener fal = new FileAlterationListenerAdaptor() {

            @Override
            public void onFileCreate(File file) {
                log.info("{} file created",file.getName());
            }

            @Override
            public void onFileDelete(File file) {
                log.info("{} file deleted",file.getName());
                // on delete action
            }
        };

        observer.addListener(fal);
        monitor.addObserver(observer);
        monitor.start();
        Thread.sleep(9999990);
    }



    @Test
    public void testFunction(){
        IOConsumer<FileInputStream> closeFileInputStream =
                fileInputStream -> fileInputStream.close();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            closeFileInputStream.accept(fileInputStream);
            assertEquals(false,fileInputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testRename() throws IOException {
        String url="D:\\IdeaProject\\zlennon-java-tutorials\\java-modules\\java-core\\src\\main\\java\\com\\zlennon\\nio\\sockets\\";
        File directory = new File(url);

        IOFileFilter javaFileFilter = new SuffixFileFilter(".java");
        IOFileFilter dirFilter = TrueFileFilter.INSTANCE;

        // Use FileUtils.listFiles to get all Java files recursively
        Collection<File> javaFiles = FileUtils.listFiles(directory, javaFileFilter, dirFilter);
        for (File javaFile : javaFiles) {
            String dic =javaFile.getParent();
            String name = javaFile.getName();
            name=name.substring(0,name.indexOf("."));
           String fileName=name+dic.substring(dic.lastIndexOf("\\")+1)+".java";
            System.out.println(fileName);
            javaFile.renameTo(new File(url+fileName));
        }

    }

}
