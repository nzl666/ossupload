package com.liumapp.oss.config;

import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 9/4/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component("OSSConfigure")
public class Configure {

    private String AccessKeyId = "xxxx";

    private String AccessKeySecret = "xxxxx";

    private String AccessBaseUrl = "http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com";

    private String EndPoint = "http://oss-cn-qingdao.aliyuncs.com";

    private String Bucket = "huluwa-pdf";

    private int Expires = 7200;

    private boolean UseAlias = false;

    private String FileUrl ;

    private String ImageUrl ;

    private String FileAliasUrl ;

    private String ImageAliasUrl ;

    public String getAccessKeyId() {
        return AccessKeyId;
    }

    public String getAccessKeySecret() {
        return AccessKeySecret;
    }

    public String getAccessBaseUrl() {
        return AccessBaseUrl;
    }

    public String getEndPoint() {
        return EndPoint;
    }

    public String getBucket() {
        return Bucket;
    }

    public int getExpires() {
        return Expires;
    }

    public boolean isUseAlias() {
        return UseAlias;
    }

    public String getFileUrl() {
        return FileUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getFileAliasUrl() {
        return FileAliasUrl;
    }

    public String getImageAliasUrl() {
        return ImageAliasUrl;
    }

}

