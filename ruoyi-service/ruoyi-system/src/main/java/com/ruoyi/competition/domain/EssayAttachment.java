package com.ruoyi.competition.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章附件对象 t_essay_attachment
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
public class EssayAttachment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 附件id */
    private Integer attachmentId;

    /** t_upload_list对应的file_id */
    private String fileId;

    public void setAttachmentId(Integer attachmentId) 
    {
        this.attachmentId = attachmentId;
    }

    public Integer getAttachmentId() 
    {
        return attachmentId;
    }
    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attachmentId", getAttachmentId())
            .append("fileId", getFileId())
            .toString();
    }
}
