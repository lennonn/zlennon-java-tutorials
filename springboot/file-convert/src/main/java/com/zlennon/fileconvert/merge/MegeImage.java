package com.zlennon.fileconvert.merge;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;



public class MegeImage {
    public String mergeImage(String firstUrl, String secondUrl) {
        try (InputStream inputStream = new URL(firstUrl).openStream();
             InputStream inputStream1 = new URL(secondUrl).openStream();
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            BufferedImage image1 = ImageIO.read(inputStream);
            BufferedImage image2 = ImageIO.read(inputStream1);

            int combinedWidth = image1.getWidth() + image2.getWidth() + 1;
            int combinedHeight = Math.max(image1.getHeight(), image2.getHeight());
            BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_3BYTE_BGR);

            Graphics2D g2d = combinedImage.createGraphics();
            g2d.drawImage(image1, 0, 0, null);
            g2d.drawImage(image2, image1.getWidth() + 1, 0, null);
            g2d.dispose();

            ImageIO.write(combinedImage, "JPEG", os);

        } catch (IOException e) {
            //log.error("图片合并失败！", e);
        }
        return "";
    }

}
