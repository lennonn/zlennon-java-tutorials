package com.zlennon.springprogressbar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class UploadController {

    @Autowired
    SocketTextHandler socketTextHandler;



    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public Object uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            OutputStream outputStream = new FileOutputStream(new File("/Users/zlennon/development/test/progress/"+file.getOriginalFilename()));
            byte[] buffer = new byte[1024];
            long total = file.getSize();
            long count = 0;
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                count += bytesRead;
                long currentProgress = (count * 100) / total;
                socketTextHandler.sendMessageToAllSessions(""+currentProgress);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return progress.get();
    }


    private final AtomicLong progress = new AtomicLong();

}
