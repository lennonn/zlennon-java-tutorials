package com.zlennon.guava.io;

import com.google.common.io.*;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

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
    public OutputStream useByteStreams() throws IOException {
        InputStream inputStream = new FileInputStream(useByteSink());
        OutputStream outputStream = new FileOutputStream("byte-streams.txt");

        byte[] byteArray = ByteStreams.toByteArray(inputStream);
        assertThat(new String(byteArray)).isEqualTo("guava");
        //使用copy方法
        ByteStreams.copy(inputStream,outputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(byteArray);
        return byteArrayOutputStream;

    }

    @Test
    public void useCharStreams() throws IOException {
        InputStream inputStream = new FileInputStream(useByteSink());
        OutputStream outputStream = new FileOutputStream("char-streams.txt");
        List<String> strings = CharStreams.readLines(new InputStreamReader(inputStream));
        assertThat(strings.size()).isEqualTo(1);
        StringReader stringReader = new StringReader("zlennon");
        CharStreams.skipFully(stringReader,2);
        char[] chars = new char[5];
        stringReader.read(chars);
        assertThat(chars[0]).isEqualTo('e');
        String world = CharStreams.readLines(new FileReader("lines.txt"), new LineProcessor<>() {

            StringBuilder sb = new StringBuilder();
            @Override
            public boolean processLine(String line) throws IOException {
                if (line.equals("dddd")){
                    sb.append(line);
                    return false;
                }
                return true;
            }

            @Override
            public String getResult() {
                return sb.toString();
            }
        });
        assertThat(world).isEqualTo("dddd");

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
                String nameWithoutExtension = Files.getNameWithoutExtension(file.getAbsolutePath());
                assertThat(fileExtension).isEqualTo("log");
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
    public void useCountingStream() throws IOException {
        CountingInputStream cis = new CountingInputStream(new FileInputStream(new File("byte-sink.txt")));
        cis.read(new byte[1024],0,5);
        assertThat(cis.getCount()).isEqualTo(5);

        CountingOutputStream cos = new CountingOutputStream(new BufferedOutputStream(useByteStreams()));
        cos.write(new byte[1024],0,5);
        assertThat(cos.getCount()).isEqualTo(5);
    }


    @Test
    public void useReader() throws IOException {
        LineReader lineReader =new LineReader( Files.newReader(new File("lines.txt"),Charset.defaultCharset()));
        String line = lineReader.readLine();
        assertThat(line).isEqualTo("aaaa");
    }



}
