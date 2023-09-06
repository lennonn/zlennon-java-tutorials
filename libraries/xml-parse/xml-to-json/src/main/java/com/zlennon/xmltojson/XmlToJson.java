package com.zlennon.xmltojson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XmlToJson {

    public static void main(String[] args) throws IOException {
        convertToXml();
    }

    public static void convertToXml() throws IOException {
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "    <parent>\n" +
                "        <groupId>com.zlennon</groupId>\n" +
                "        <artifactId>xml-parse</artifactId>\n" +
                "        <version>0.0.1-SNAPSHOT</version>\n" +
                "        <relativePath>../pom.xml</relativePath>\n" +
                "    </parent>\n" +
                "    <artifactId>xstream</artifactId>\n" +
                "    <packaging>pom</packaging>\n" +
                "</project>\n";
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xml.getBytes());
        node.get("modelVersion");
    }
}
