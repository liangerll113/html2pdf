package com.xwdx.html2pdf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kongmingliang
 * @date 2021-12-17 9:46
 **/
@RestController
public class TestController {

    @RequestMapping("/health")
    public String health(){
        return "success";
    }
}
