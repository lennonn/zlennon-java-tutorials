package com.zlennon.captcha.tianai;


import cloud.tianai.captcha.common.constant.CaptchaTypeConstant;
import cloud.tianai.captcha.spring.application.ImageCaptchaApplication;
import cloud.tianai.captcha.spring.plugins.secondary.SecondaryVerificationApplication;
import cloud.tianai.captcha.spring.vo.CaptchaResponse;
import cloud.tianai.captcha.spring.vo.ImageCaptchaVO;
import cloud.tianai.captcha.validator.common.model.dto.ImageCaptchaTrack;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CaptchaController {


    @Autowired
    private ImageCaptchaApplication imageCaptchaApplication;

    @GetMapping("/gen")
    @ResponseBody
    public CaptchaResponse<ImageCaptchaVO> genCaptcha(HttpServletRequest request, @RequestParam(value = "type", required = false)String type) {
        if (StringUtils.isBlank(type)) {
            type = CaptchaTypeConstant.SLIDER;
        }
        CaptchaResponse<ImageCaptchaVO> response = imageCaptchaApplication.generateCaptcha(type);
        return response;
    }

    @PostMapping("/check")
    @ResponseBody
    public boolean checkCaptcha(@RequestParam("id") String id,
                                @RequestBody ImageCaptchaTrack imageCaptchaTrack,
                                HttpServletRequest request) {
        System.out.println(JSONObject.toJSONString(imageCaptchaApplication.matching(id, imageCaptchaTrack).isSuccess()));
        return imageCaptchaApplication.matching(id, imageCaptchaTrack).isSuccess();

    }

    /**
     * 二次验证，一般用于机器内部调用，这里为了方便测试
     * @param id id
     * @return boolean
     */
    @GetMapping("/check2")
    @ResponseBody
    public boolean check2Captcha(@RequestParam("id") String id) {
        // 如果开启了二次验证
        if (imageCaptchaApplication instanceof SecondaryVerificationApplication) {
            return ((SecondaryVerificationApplication) imageCaptchaApplication).secondaryVerification(id);
        }
        return false;
    }
}
