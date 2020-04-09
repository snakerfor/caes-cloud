package com.ruoyi.utils;
import java.io.File;

// 文件对象
public class FileInfo {
    // 文件存储状态 成功 写入错误 文件名或文件大小错误
    public enum saveStatus { SUCCESS, IO_ERROR, FILETYPE_ERROR, FILENAME_OR_FILESIZE_ERROR };
    // 文件读取状态 成功 文件不存在
    public enum readStatus { SUCCESS, FILE_NOT_EXISTS };

    private String fileName;
    private String fileId;
    private String fileMD5;
    private String fileSize;
    private File fileDir;
    private saveStatus saveStatus;
    private readStatus readStatus;

    public String getFileName()
    {
        return this.fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileId()
    {
        return this.fileId;
    }

    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }

    public String getFileMD5()
    {
        return this.fileMD5;
    }

    public void setFileMD5(String fileMD5)
    {
        this.fileMD5 = fileMD5;
    }

    public String getFileSize()
    {
        return this.fileSize;
    }

    public void setFileSize(String fileSize)
    {
        this.fileSize = fileSize;
    }

    public saveStatus getSaveStatus()
    {
        return this.saveStatus;
    }

    public void setSaveStatus(saveStatus saveStatus)
    {
        this.saveStatus = saveStatus;
    }

    public File getFileDir()
    {
        return this.fileDir;
    }

    public void setFileDir(File fileDir)
    {
        this.fileDir = fileDir;
    }

    public readStatus getReadStatus()
    {
        return this.readStatus;
    }

    public void setReadStatus(readStatus readStatus)
    {
        this.readStatus = readStatus;
    }
}
