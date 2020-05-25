package com.ruoyi.competition.mapper;

import com.ruoyi.competition.domain.EssayAttachment;
import java.util.List;

/**
 * 文章附件Mapper接口
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
public interface EssayAttachmentMapper 
{
    /**
     * 查询文章附件
     * 
     * @param attachmentId 文章附件ID
     * @return 文章附件
     */
    public EssayAttachment selectEssayAttachmentById(Integer attachmentId);

    /**
     * 查询文章附件列表
     * 
     * @param essayAttachment 文章附件
     * @return 文章附件集合
     */
    public List<EssayAttachment> selectEssayAttachmentList(EssayAttachment essayAttachment);

    /**
     * 新增文章附件
     * 
     * @param essayAttachment 文章附件
     * @return 结果
     */
    public int insertEssayAttachment(EssayAttachment essayAttachment);

    /**
     * 修改文章附件
     * 
     * @param essayAttachment 文章附件
     * @return 结果
     */
    public int updateEssayAttachment(EssayAttachment essayAttachment);

    /**
     * 删除文章附件
     * 
     * @param attachmentId 文章附件ID
     * @return 结果
     */
    public int deleteEssayAttachmentById(Integer attachmentId);

    /**
     * 批量删除文章附件
     * 
     * @param attachmentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEssayAttachmentByIds(String[] attachmentIds);
}
