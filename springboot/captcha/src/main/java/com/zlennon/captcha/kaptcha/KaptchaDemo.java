package com.zlennon.captcha.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * 生成随机吗，然后生成图片
 */
public class KaptchaDemo {
    public static void main(String[] args) {
        // 创建Kaptcha实例
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        String outputFilePath = "src/main/resources/captcha.png";



        // 配置Kaptcha参数
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "200");
        properties.setProperty("kaptcha.image.height", "50");
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        Config config = new Config(properties);

        // 设置Kaptcha配置
        kaptcha.setConfig(config);

        // 生成验证码文字
        String captchaText = kaptcha.createText();

        // 生成验证码图片
        BufferedImage captchaImage = kaptcha.createImage(captchaText);

        // 输出验证码图片到文件
        try {
            File outputFile = new File("captcha.png");
            ImageIO.write(captchaImage, "png", outputFile);
            System.out.println("验证码已生成：" + outputFile.getAbsolutePath());
            System.out.println("验证码文字：" + captchaText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
