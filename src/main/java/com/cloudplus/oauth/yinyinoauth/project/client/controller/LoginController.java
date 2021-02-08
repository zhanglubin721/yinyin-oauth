package com.cloudplus.oauth.yinyinoauth.project.client.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zhanglubin
 * @date 2021/1/29
 */
@Controller
@RequestMapping("/oauth")
public class LoginController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/error/401")
    public String error401(Map<String, Object> param, HttpServletRequest request, Model model) {
        request.getContextPath();
        model.getAttribute("aaa");
        return "401";
    }

    //生成自定义验证码
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

    @RequestMapping("/checkVerCode")
    @ResponseBody
    public int checkVerCode(String verCode, HttpServletRequest request){
        // 获取session中的验证码
        String sessionCode = (String) request.getSession().getAttribute("captcha");
        // 判断验证码
        if (verCode==null || !sessionCode.equals(verCode.trim().toLowerCase())) {
            return 1;
        } else {
            return 0;
        }
    }
}
