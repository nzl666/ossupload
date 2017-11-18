package com.liumapp.oss.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.liumapp.oss.config.Configure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by liumapp on 9/5/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class OssUtil {

    @Autowired
    private Configure configure = new Configure();

    private  OSSClient ossClient = null;

    private  void connect() {
        ossClient = new OSSClient(configure.getEndPoint() , configure.getAccessKeyId() , configure.getAccessKeySecret());
    }

    /**
     *
     OssUtil ossUtil = new OssUtil();
     ossUtil.uploadFile("test/test2.docx" , new File("./data/test0.docx"));
     * @param key
     * @param file
     */
    public void uploadFile(String key , File file) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(configure.getBucket() , key , file);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }

    /**
     * OssUtil ossUtil = new OssUtil();
      ossUtil.uploadFile(map);
     * @param map key:oss的key    value:上传的文件对象
     */
    public void uploadManyFile(Map<String,File> map) {
        if (ossClient == null) {
            connect();
        }
        try {
            for (String key :map.keySet()) {
            ossClient.putObject(configure.getBucket() , key , map.get(key));
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }


    /**
     *
     OssUtil ossUtil = new OssUtil();
     ossUtil.downloadFile("test/test0.docx" , new File("./data/download.docx"));
     * @param key
     * @param file
     */
    public void downloadFile(String key , File file) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.getObject(new GetObjectRequest(configure.getBucket() , key) , file);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }

    /**
     * 流上传到OSS
     * @param key 路径
     * @param inputStream  文件流
     */
    public void uploadFile(String key , InputStream inputStream) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(configure.getBucket() , key , inputStream);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }
    /**
     * 流上传到OSS
     * @param key 路径
     * @param bytes  byte数组
     */
    public void uploadFile(String key , byte[] bytes) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(configure.getBucket() , key , new ByteArrayInputStream(bytes));
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }

    public void deleteFile(String key) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.deleteObject(configure.getBucket(), key);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }
    public static void main(String[] args) {
        OssUtil o = new OssUtil();
        o.deleteFile("sign/contract1510393411552.jpg");
    }
}
