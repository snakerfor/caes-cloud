package com.ruoyi.competition.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章发布对象 t_essay_publish
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
public class EssayPublish extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    @Excel(name = "文章id")
    private Integer essayId;

    /** 文章栏目类型 */
    @Excel(name = "文章栏目类型")
    private String essayType;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String essayTitle;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String essayContent;

    /** 附件id */
    private Integer attachmentId;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Integer viewCount;

    /** fileId集合 */
    @Excel(name = "fileId集合")
    private String fileIds;

    public void setEssayId(Integer essayId) 
    {
        this.essayId = essayId;
    }

    public Integer getEssayId() 
    {
        return essayId;
    }
    public void setEssayType(String essayType) 
    {
        this.essayType = essayType;
    }

    public String getEssayType() 
    {
        return essayType;
    }
    public void setEssayTitle(String essayTitle) 
    {
        this.essayTitle = essayTitle;
    }

    public String getEssayTitle() 
    {
        return essayTitle;
    }
    public void setEssayContent(String essayContent) 
    {
        this.essayContent = essayContent;
    }

    public String getEssayContent() 
    {
        return essayContent;
    }
    public void setAttachmentId(Integer attachmentId) 
    {
        this.attachmentId = attachmentId;
    }

    public Integer getAttachmentId() 
    {
        return attachmentId;
    }
    public void setViewCount(Integer viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Integer getViewCount() 
    {
        return viewCount;
    }
    public void setFileIds(String fileIds)
    {
        this.fileIds = fileIds;
    }

    public String getFileIds()
    {
        return fileIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("essayId", getEssayId())
            .append("essayType", getEssayType())
            .append("essayTitle", getEssayTitle())
            .append("essayContent", getEssayContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("attachmentId", getAttachmentId())
            .append("viewCount", getViewCount())
            .append("fileIds", getFileIds())
            .toString();
    }
}
