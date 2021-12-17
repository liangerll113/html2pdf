package com.xwdx.html2pdf.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwdx.html2pdf.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author kongmingliang
 * @date 2021-12-17 10:11
 **/
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("goGoGo")
    @ResponseBody
    public String goGoGo(@RequestBody JSONObject param) {
        indexService.goGoGo(param);
        return "success";
    }


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/testCh")
    @ResponseBody
    public String testCh() {
        String result = restTemplate.getForObject("http://localhost:8086/runworkapi/annualReport/test", String.class);
        return result;
        // return "彳亍 不 彳亍 口牙";
    }

}
