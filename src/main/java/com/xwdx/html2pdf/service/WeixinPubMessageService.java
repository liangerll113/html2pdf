package com.xwdx.html2pdf.service;

import com.xwdx.html2pdf.entity.WeixinPubMessage;
import com.xwdx.html2pdf.mapper.WeixinPubMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kongmingliang
 * @date 2021-12-17 18:31
 **/
@Service
public class WeixinPubMessageService {

    @Autowired
    private WeixinPubMessageMapper weixinPubMessageMapper;

    public int savePubMessage(WeixinPubMessage weixinPubMessage) {
        return weixinPubMessageMapper.savePubMessage(weixinPubMessage);
    }

}
