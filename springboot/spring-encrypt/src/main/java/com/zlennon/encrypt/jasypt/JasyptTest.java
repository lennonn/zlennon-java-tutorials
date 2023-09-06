package com.zlennon.encrypt.jasypt;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.NoIvGenerator;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptTest {
    public static void main(String[] args) {
        //BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        String password = "encrypt";
        String plaintext = "123456";
     StandardPBEStringEncryptor textEncryptor = new StandardPBEStringEncryptor();

        //加密所需的salt(盐),自定义
        textEncryptor.setPassword(password);
        textEncryptor.setIvGenerator(new NoIvGenerator());
        textEncryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        //要加密的数据（数据库的用户名或密码）
        String str1 = textEncryptor.encrypt(plaintext);
        String str2 = textEncryptor.encrypt("");
        String str3 = textEncryptor.encrypt("");
        System.out.println("str1:"+str1);
        System.out.println("str2:"+str2);
        System.out.println("str3:"+str3);
        //test();
    }

    public static void test(){
        String password = "encrypt";
        String plaintext = "123456";

        // 创建加密器
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        // 设置口令和盐值
        encryptor.setPassword(password);
        encryptor.setSaltGenerator(new RandomSaltGenerator());

        // 加密
        String ciphertext = encryptor.encrypt(plaintext);
        System.out.println("加密后的字符串: " + ciphertext);

        // 解密
        String decryptedText = encryptor.decrypt(ciphertext);
        System.out.println("解密后的字符串: " + decryptedText);
    }
}
