##oss文件上传
- oss模块主要是ossutil,里面写了上传下载删除的通用类
- upload 主要是写了文件通过流上传  本地文件上传  base64上传
-base64传递必须是截取掉了前缀的 如果base64上传失败,请检查时候是从前台传送到后台url进行啦转码,我记得+号全会被替换成' ',要进行处理后才能进行上传

- 文件流上传一般都是前台通过上传组件传到controller 直接用@RequestParam("file") MultipartFile file这个接收 然后通过流上传到oss就可以啦

	     /**
	     * 上传组件上传
	     * @param file
	     * @return
	     */
	    @RequestMapping(value = "uploadimg")
	    public String upload (@RequestParam("file") MultipartFile file) {
	        String fileName = file.getOriginalFilename();
	        String type = fileName.substring(fileName.lastIndexOf("."));
	        for (int i = 0 ; i < types.length ; i++) {
	            if (types[i].indexOf(type.toLowerCase()) != -1) {
	                break;
	            }
	            respInfo.setStatus(InfoCode.ERROR);
	            respInfo.setMessage("暂不支持"+type+"格式");
	        }
	        RespInfo res = FileUploadUtil.fileupload(file,"person/sign/");
	        FileOpea fileOpea = (FileOpea)res.getContent();
	        respInfo.setContent(fileOpea.getOss_path());
	        respInfo.setStatus(InfoCode.SUCCESS);
	        return JSON.toJSONString(respInfo);
	    }
- base64 一般canvas中得到的图片就是base64编码,前台传过来用string接收就好啦.

			
		/**上传base64到oss**/
	    @RequestMapping(value = "base64upload")
	    public String qrcodesign(String base64code) {
	        String code = code = base64code.replace(' ','+');
	        respInfo = FileUploadUtil.uploadbase64(code);
	        return JSON.toJSONString(respInfo);
	    }

- 首先改oss模块中的config里面的oss的配置