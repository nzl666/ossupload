package cc.suyu;

import cc.suyu.entity.RespInfo;
import cc.suyu.utils.Base64toImg;
import cc.suyu.utils.FileUploadUtil;

public class Main {
    public static void main(String[] args) {
        //base64转图片到oss
         /* String base64 =  Base64toImg.GetImageStr("C:/20171013194519.jpg");
        RespInfo respInfo = FileUploadUtil.uploadbase64(base64);*/
        //上传本地文件
        RespInfo respInfo = FileUploadUtil.upload("C:/20171013194519.jpg");
        System.out.println(respInfo.getContent());


    }
}
