package com.ruoyi.competition.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.competition.mapper.EssayAttachmentMapper;
import com.ruoyi.competition.domain.EssayAttachment;
import com.ruoyi.competition.service.IEssayAttachmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章附件Service业务层处理
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
@Service
public class EssayAttachmentServiceImpl implements IEssayAttachmentService 
{
    @Autowired
    private EssayAttachmentMapper essayAttachmentMapper;

    /**
     * 查询文章附件
     * 
     * @param attachmentId 文章附件ID
     * @return 文章附件
     */
    @Override
    public EssayAttachment selectEssayAttachmentById(Integer attachmentId)
    {
        return essayAttachmentMapper.selectEssayAttachmentById(attachmentId);
    }

    /**
     * 查询文章附件列表
     * 
     * @param essayAttachment 文章附件
     * @return 文章附件
     */
    @Override
    public List<EssayAttachment> selectEssayAttachmentList(EssayAttachment essayAttachment)
    {
        return essayAttachmentMapper.selectEssayAttachmentList(essayAttachment);
    }

    /**
     * 新增文章附件
     * 
     * @param essayAttachment 文章附件
     * @return 结果
     */
    @Override
    public int insertEssayAttachment(EssayAttachment essayAttachment)
    {
        return essayAttachmentMapper.insertEssayAttachment(essayAttachment);
    }

    /**
     * 修改文章附件
     * 
     * @param essayAttachment 文章附件
     * @return 结果
     */
    @Override
    public int updateEssayAttachment(EssayAttachment essayAttachment)
    {
        return essayAttachmentMapper.updateEssayAttachment(essayAttachment);
    }

    /**
     * 删除文章附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEssayAttachmentByIds(String ids)
    {
        return essayAttachmentMapper.deleteEssayAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章附件信息
     * 
     * @param attachmentId 文章附件ID
     * @return 结果
     */
    public int deleteEssayAttachmentById(Integer attachmentId)
    {
        return essayAttachmentMapper.deleteEssayAttachmentById(attachmentId);
    }
}
