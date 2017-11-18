package cc.suyu.utils;


import cc.suyu.entity.FileOpea;
import cc.suyu.entity.InfoCode;
import cc.suyu.entity.RespInfo;
import com.liumapp.oss.utils.OssUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FileUploadUtil {
    private static Logger logger = LogManager.getLogger(FileUploadUtil.class);
    private static String fileName;
    private static String fileType;
    private static String oss_file_path ;
    private final static String OSS_PATH = "http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com";
    /**
     * 文件上传
     * @param file,path:osskey例如:"person/sign"
     * @return
     */
    public static RespInfo fileupload (MultipartFile file, String path) {
        OssUtil ossUtil = new OssUtil();
        FileOpea fileOpea = new FileOpea();
        RespInfo respInfo = new RespInfo();
        oss_file_path = path;
        try {
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            fileName = file.getOriginalFilename();
            fileOpea.setName(fileName);
            // 获取文件的后缀名
            fileType = fileName.substring(fileName.lastIndexOf("."));
            fileOpea.setSuffix(fileType);
            fileName = System.currentTimeMillis()+MathRand.getCode()+fileType;
            fileOpea.setOssname(fileName);
            oss_file_path += fileName;
            ossUtil.uploadFile(oss_file_path,inputStream);
            fileOpea.setOss_path(OSS_PATH+"/"+oss_file_path);
            respInfo.setContent(fileOpea);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
            return respInfo;
    }

    /**
     * code为没有前缀的base64编码
     * @param code
     * @return
     */
    public static RespInfo uploadbase64 (String code) {
        RespInfo respInfo = new RespInfo();
        oss_file_path ="person/sign/" ;
        byte [] bytes = Base64toImg.GenerateByte(code);
        fileName =oss_file_path+ System.currentTimeMillis()+MathRand.getCode()+".png";
        if(bytes.length > 0) {
            OssUtil ossUtil = new OssUtil();
            ossUtil.uploadFile(fileName,bytes);
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setMessage("上传成功");
            respInfo.setContent(OSS_PATH+"/"+fileName);
        } else {
            respInfo.setStatus(InfoCode.ERROR);
            respInfo.setMessage("上传错误");
        }
        return respInfo;
    }

    public static RespInfo upload(String path) {
        RespInfo respInfo = new RespInfo();
        File file = new File(path);
        String suffixName = path.substring(path.lastIndexOf("."));
        oss_file_path ="person/sign/" ;
        OssUtil ossUtil = new OssUtil();
        fileName =oss_file_path+ System.currentTimeMillis()+MathRand.getCode()+suffixName;
        ossUtil.uploadFile(fileName,file);
        respInfo.setContent(OSS_PATH+"/"+fileName);
        return respInfo;
    }

}
