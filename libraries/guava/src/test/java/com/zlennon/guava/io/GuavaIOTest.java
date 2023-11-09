package com.zlennon.guava.io;

import com.google.common.io.*;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.lessThan;

public class GuavaIOTest {

    public File useByteSink() throws IOException {
        File file = new File("byte-sink.txt");
        ByteSink byteSink = Files.asByteSink(file);
        byteSink.write("guava".getBytes(StandardCharsets.UTF_8));
        return file;
    }

    public File useCharSink() throws IOException {
        File file = new File("char-sink.txt");
        CharSink byteSink = Files.asCharSink(file,StandardCharsets.UTF_8);
        byteSink.write("first line");
        byteSink.writeLines(Stream.of("two line,three line,four line,five line"),",");
        return file;
    }

    @Test
    public void useByteStreams() throws IOException {
        InputStream inputStream = new FileInputStream(useByteSink());
        OutputStream outputStream = new FileOutputStream("byte-streams.txt");

        byte[] byteArray = ByteStreams.toByteArray(inputStream);
        assertThat(new String(byteArray)).isEqualTo("guava");
        //使用copy方法
        ByteStreams.copy(inputStream,outputStream);
    }

    @Test
    public void useCharStreams() throws IOException {
        InputStream inputStream = new FileInputStream(useByteSink());
        OutputStream outputStream = new FileOutputStream("char-streams.txt");

/*        byte[] byteArray = CharStreams;
        assertThat(new String(byteArray)).isEqualTo("guava");
        //使用copy方法
        ByteStreams.copy(inputStream,outputStream);*/
    }

    @Test
    public void useByteSource() throws IOException {

        ByteSource bytes = ByteSource.wrap(new String("byte-").getBytes());
        ByteSource source = ByteSource.wrap(new String("source").getBytes());
        ByteSource concat = ByteSource.concat(bytes,source);
        assertThat(new String(concat.read())).isEqualTo("byte-source");
    }

    @Test
    public void useCharSource() throws IOException {
        CharSource bytes = CharSource.wrap(new String("char-"));
        CharSource source = CharSource.wrap(new String("source"));
        CharSource concat = CharSource.concat(bytes,source);
        assertThat(new String(concat.read())).isEqualTo("char-source");
    }

    @Test
    public void useFiles() throws IOException {
        ByteSink byteSink = Files.asByteSink(useByteSink());
        CharSink charSink = Files.asCharSink(useByteSink(), Charset.defaultCharset(),FileWriteMode.APPEND);
        Iterable<File> files = Files.fileTraverser().breadthFirst(new File("D:\\logs\\"));
        assertThat(IterableUtils.size(files)).isEqualTo(3);
        files.forEach(file->{
            if(!Files.isDirectory().test(file)) {

                String fileExtension = Files.getFileExtension(file.getName());
                try {
                    Files.copy(file, new File("new-" + file.getName()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        ByteSource byteSource = Files.asByteSource(useByteSink());
        Files.write("Files".getBytes(),new File("files.txt"));

    }

    @Test
    public void userInputStreamTwice() throws IOException {
        // 从资源文件加载数据
        ByteSource byteSource = Resources.asByteSource(Resources.getResource("byte-sink.txt"));

        // 第一次使用 InputStream 读取数据
        InputStream inputStream1 = byteSource.openBufferedStream();
        String result1 = new String(ByteStreams.toByteArray(inputStream1), StandardCharsets.UTF_8);
        System.out.println("First read: " + result1);

        // 第二次使用 InputStream 读取数据
        InputStream inputStream2 = byteSource.openBufferedStream();
        String result2 = new String(ByteStreams.toByteArray(inputStream2), StandardCharsets.UTF_8);
        System.out.println("Second read: " + result2);
    }
}
