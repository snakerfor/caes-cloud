package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUploadListMapper;
import com.ruoyi.system.domain.SysUploadList;
import com.ruoyi.system.service.ISysUploadListService;
import com.ruoyi.common.core.text.Convert;

/**
 * 上传文件列表Service业务层处理
 *
 * @author Random-pro
 * @date 2020-02-14
 */
@Service
public class SysUploadListServiceImpl implements ISysUploadListService
{
    @Autowired
    private SysUploadListMapper uploadListMapper;

    /**
     * 查询上传文件列表
     *
     * @param fileId 上传文件列表ID
     * @return 上传文件列表
     */
    @Override
    public SysUploadList selectUploadListById(String fileId)
    {
        return uploadListMapper.selectUploadListById(fileId);
    }

    /**
     * 查询上传文件列表列表
     *
     * @param uploadList 上传文件列表
     * @return 上传文件列表
     */
    @Override
    public List<SysUploadList> selectUploadList(SysUploadList uploadList)
    {
        return uploadListMapper.selectUploadList(uploadList);
    }

    /**
     * 新增上传文件列表
     *
     * @param uploadList 上传文件列表
     * @return 结果
     */
    @Override
    public int insertUploadList(SysUploadList uploadList)
    {
        return uploadListMapper.insertUploadList(uploadList);
    }

    /**
     * 修改上传文件列表
     *
     * @param uploadList 上传文件列表
     * @return 结果
     */
    @Override
    public int updateUploadList(SysUploadList uploadList)
    {
        return uploadListMapper.updateUploadList(uploadList);
    }

    /**
     * 删除上传文件列表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUploadListByIds(String ids)
    {
        return uploadListMapper.deleteUploadListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除上传文件列表信息
     * 
     * @param fileId 上传文件列表ID
     * @return 结果
     */
    public int deleteUploadListById(String fileId)
    {
        return uploadListMapper.deleteUploadListById(fileId);
    }
}
