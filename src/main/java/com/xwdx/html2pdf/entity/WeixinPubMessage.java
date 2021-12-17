package com.xwdx.html2pdf.entity;

import java.io.Serializable;

/**
 * @author kongmingliang
 * @date 2021-12-17 18:27
 **/
public class WeixinPubMessage implements Serializable {

    private static final long serialVersionUID = 7944731480550612582L;

    private String pubName;
    private Long appMsgId;
    private String title;
    private String digest;
    private String cover;
    private String link;
    private String jsonContent;
    private String createTime;
    private String updateTime;


    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public Long getAppMsgId() {
        return appMsgId;
    }

    public void setAppMsgId(Long appMsgId) {
        this.appMsgId = appMsgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
