package com.zlennon.springprogressbar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String upload() {
        return "upload";
    }
}
