package com.xwdx.html2pdf.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwdx.html2pdf.entity.WeixinPubMessage;
import com.xwdx.html2pdf.utils.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author kongmingliang
 * @date 2021-12-17 14:12
 **/
@Service
public class IndexService {

    @Autowired
    private WeixinPubMessageService weixinPubMessageService;

    private static final String WEIXIN_URL = "https://mp.weixin.qq.com/cgi-bin/appmsg";

    public boolean goGoGo(JSONObject param) {
        String pubName = "CR 润心坊"; // TODO 公众号名称
        JSONObject urlParam = param.getJSONObject("urlParam");  // url参数
        JSONObject headerParam = param.getJSONObject("headerParam"); // 请求头参数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int begin = 0;
        for (; ; ) {
            urlParam.put("begin", begin);
            JSONObject result = HttpRequestUtils.get4Json(WEIXIN_URL, headerParam, urlParam);
            if (result == null || result.isEmpty()) {
                break;
            }
            savePubMsg(result, pubName, simpleDateFormat);
            begin += 5;
        }

        return true;
    }

    private void savePubMsg(JSONObject result, String pubName, SimpleDateFormat format) {
        // 解析结果并保存数据库
        JSONArray appMsgList = result.getJSONArray("app_msg_list");
        for (int i = 0; i < appMsgList.size(); i++) {
            JSONObject item = appMsgList.getJSONObject(i);
            WeixinPubMessage pubMessage = new WeixinPubMessage();

            long createTime = item.getLong("create_time");
            long updateTime = item.getLong("update_time");

            pubMessage.setPubName(pubName);
            pubMessage.setAppMsgId(item.getLong("appmsgid"));
            pubMessage.setTitle(item.getString("title"));
            pubMessage.setDigest(item.getString("digest"));
            pubMessage.setCover(item.getString("cover"));
            pubMessage.setLink(item.getString("link"));
            pubMessage.setJsonContent(item.toString());
            pubMessage.setCreateTime(format.format(new Date(createTime * 1000)));
            pubMessage.setUpdateTime(format.format(new Date(updateTime * 1000)));

            weixinPubMessageService.savePubMessage(pubMessage);
        }
    }
}
