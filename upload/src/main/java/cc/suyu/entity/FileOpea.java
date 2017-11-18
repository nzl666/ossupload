package cc.suyu.entity;

import org.springframework.stereotype.Component;

/**
 * 文件上传类
 */
@Component
public class FileOpea {
    /**userid**/
    private Long userid;
    /**文件源名称**/
    private String name;
    /**文件在oss上的名称**/
    private String ossname;
    /**文件大小**/
    private String size;
    /**文件后缀**/
    private String suffix;
    /**oss返回的地址**/
    private String oss_path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getOss_path() {
        return oss_path;
    }

    public void setOss_path(String oss_path) {
        this.oss_path = oss_path;
    }

    public String getOssname() {
        return ossname;
    }

    public void setOssname(String ossname) {
        this.ossname = ossname;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
