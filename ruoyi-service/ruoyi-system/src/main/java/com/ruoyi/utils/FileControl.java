package com.ruoyi.utils;

// import com.ruoyi.common.constant.Constants;
// import com.ruoyi.common.utils.StringUtils;
// import com.ruoyi.common.utils.security.Md5Utils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.net.URLEncoder;

// 文件上传控制 文件大小 文件类型白名单 读写控制
public class FileControl {
    // 默认大小 50M
    private static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;
    // 默认的文件名最大长度 100
    private static final int DEFAULT_FILE_NAME_LENGTH = 100;
    // 默认文件保存路径 需手工创建 兼容Windows与linux
    private static final String SAVE_PATH = OSType() == "windows" ? "D:\\upload\\" : "/opt/upload/";
    private static final String[] DEFAULT_ALLOWED_EXTENSION = {
            // 图片
            "bmp", "gif", "jpg", "jpeg", "png",
            // word excel powerpoint
            "doc", "docx", "xls", "xlsx", "ppt", "pptx", "html", "htm", "txt",
            // 压缩文件
            "rar", "zip", "gz", "bz2",
            // pdf
            "pdf",
            // flash
            "swf", "flv",
            // other media
            "mp3", "mp4", "wav", "wma", "wmv", "mid", "avi", "mpg", "asf", "rm", "rmvb"
    };

    // 取得服务器执行目录
    private static String getServerRoot() {
        String serverRoot = ClassLoader.getSystemClassLoader().getResource("").getPath();
        return serverRoot;
    }

    // 根据文件扩展名判断文件是否合法
    private static final boolean isAllowedExtension(String extension, String[] allowedExtension) {
        for (String str : allowedExtension) {
            // 扩展名不分大小写
            if (str.equals(extension)) {
                return true;
            }
        }
        return false;
    }

    // 文件大小转字串
    private static String getStrSize(long size) {
        if (size >= 1024 * 1024 * 1024) {
            return new Long(size / 1073741824L) + "G";
        } else if (size >= 1024 * 1024) {
            return new Long(size / 1048576L) + "M";
        } else if (size >= 1024) {
            return new Long(size / 1024) + "K";
        } else {
            return size + "B";
        }
    }

    // 取得扩展名
    private static String getFileSuffix(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }

    // 系统类型 由于除Windows外大多数操作系统为Linux内核 所以仅区分Windows和Linux
    public static String OSType() {
        return System.getProperty("os.name").toLowerCase().contains("windows") ? "windows" : "linux";
    }

    // 文件上传
    private static FileInfo uploadFile(String baseDir, MultipartFile file, String[] allowedExtension, long maxSize, int nameLength) throws IOException {
        FileInfo fileInfo = new FileInfo();
        String fileName = new File(file.getOriginalFilename().trim()).getName();
        ;// 此处为兼容Linux使用getName获取文件名 未测试
        long fileSize = file.getSize();

        // 文件大小,文件名长度符合要求
        if (fileSize <= maxSize && fileName.length() <= nameLength) {
            // 若文件合法
            if (isAllowedExtension(getFileSuffix(fileName), allowedExtension)) {
                // 获取服务器保存路径 根据上传日期对文件进行分类保存
                String fileDir = LocalDate.now().toString() + File.separator + System.currentTimeMillis() + "_" + fileName;
                File savePath = new File(baseDir + File.separator + fileDir);
                // 当上级目录不存在则创建
                File parentDir = new File(savePath.getParent());
                if (!parentDir.exists()) {
                    parentDir.mkdir();
                }
                try {
                    // 直接保存
                    file.transferTo(savePath);
                } catch (IOException e) {
                    // IO异常不向上throw 直接以标识传递给上一级
                    fileInfo.setSaveStatus(FileInfo.saveStatus.IO_ERROR);
                    return fileInfo;
                }
                // 正常上传
                fileInfo.setSaveStatus(FileInfo.saveStatus.SUCCESS);
                fileInfo.setFileSize(getStrSize(fileSize));
                fileInfo.setFileName(fileName);
                fileInfo.setFileDir(new File(fileDir));
                // 返回文件名 文件大小
                return fileInfo;
            } else {
                // 文件类型不支持
                fileInfo.setSaveStatus(FileInfo.saveStatus.FILETYPE_ERROR);
                return fileInfo;
            }
        } else {
            // 文件大小或文件名异常
            fileInfo.setSaveStatus(FileInfo.saveStatus.FILENAME_OR_FILESIZE_ERROR);
            return fileInfo;
        }
    }

    // 文件上传 供Controller层调用
    public static FileInfo upload(MultipartFile file) throws IOException {
        FileInfo fileInfo = uploadFile(SAVE_PATH, file, DEFAULT_ALLOWED_EXTENSION, DEFAULT_MAX_SIZE, DEFAULT_FILE_NAME_LENGTH);
        // 判断上传成功 增加文件相关信息
        if (fileInfo.getSaveStatus() == FileInfo.saveStatus.SUCCESS) {
            // 文件MD5
            // fileInfo.setFileMD5(Md5Utils.fileHash(fileInfo.getFullFileDir()));
            // UUID作为文件id
            fileInfo.setFileId(UUID.randomUUID().toString().replaceAll("-", ""));
        }

        return fileInfo;
    }

    // 文件下载
    private static FileInfo downloadFile(String filePath, String baseDir, String[] allowedExtension) {
        File file = new File(baseDir + File.separator + filePath);
        FileInfo fileInfo = new FileInfo();

        // 文件存在且属于允许的文件类型
        if (file.exists() && isAllowedExtension(getFileSuffix(filePath), allowedExtension)) {
            fileInfo.setFileDir(file);
            fileInfo.setReadStatus(FileInfo.readStatus.SUCCESS);
        } else {
            fileInfo.setReadStatus(FileInfo.readStatus.FILE_NOT_EXISTS);
        }
        return fileInfo;
    }

    // 文件下载 供Controller层调用
    public static FileInfo download(String filePath) {
        FileInfo info = downloadFile(filePath, SAVE_PATH, DEFAULT_ALLOWED_EXTENSION);
        return info;
    }

    // 文件删除
    private static boolean deleteFile(String filePath, String baseDir) {
        File file = new File(baseDir + File.separator + filePath);
        // 文件存在
        if (file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }

    // 文件删除 供Controller层调用
    public static boolean delete(String filePath) {
        return deleteFile(filePath, SAVE_PATH);
    }

    // 文件名重编码
    public static String fileNameEncode(String fileName, HttpServletRequest request) throws UnsupportedEncodingException {
        // 文件名重编码
        String userAgent = request.getHeader("User-Agent");//获取浏览器名 IE/Chome/firefox
        if (userAgent.contains("firefox")) {
            return new String(fileName.getBytes("UTF-8"), "ISO8859-1"); // firefox浏览器
        } else if (userAgent.contains("MSIE")) {
            return URLEncoder.encode(fileName, "UTF-8");// IE浏览器
        } else if (userAgent.contains("CHROME")) {
            return new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 谷歌
        } else {
            return URLEncoder.encode(fileName, "utf-8");// 其它浏览器
        }
    }
}
