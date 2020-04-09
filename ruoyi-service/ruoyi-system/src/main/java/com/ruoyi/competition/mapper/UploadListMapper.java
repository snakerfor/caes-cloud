package com.ruoyi.competition.mapper;

import com.ruoyi.competition.domain.UploadList;
import java.util.List;

/**
 * 上传文件列表Mapper接口
 * 
 * @author Random-pro
 * @date 2020-02-14
 */
public interface UploadListMapper
{
    /**
     * 查询上传文件列表
     * 
     * @param fileId 上传文件列表ID
     * @return 上传文件列表
     */
    public UploadList selectUploadListById(String fileId);

    /**
     * 查询上传文件列表列表
     * 
     * @param uploadList 上传文件列表
     * @return 上传文件列表集合
     */
    public List<UploadList> selectUploadList(UploadList uploadList);

    /**
     * 新增上传文件列表
     * 
     * @param uploadList 上传文件列表
     * @return 结果
     */
    public int insertUploadList(UploadList uploadList);

    /**
     * 修改上传文件列表
     * 
     * @param uploadList 上传文件列表
     * @return 结果
     */
    public int updateUploadList(UploadList uploadList);

    /**
     * 删除上传文件列表
     * 
     * @param fileId 上传文件列表ID
     * @return 结果
     */
    public int deleteUploadListById(String fileId);

    /**
     * 批量删除上传文件列表
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUploadListByIds(String[] fileIds);
}
