package com.ruoyi.caes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评测试题对象 t_test_lib
 * 
 * @author snakerfor
 * @date 2019-09-10
 */
public class TestLib extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 试题ID */
    private Integer quesId;

    /** 试题题干 */
    @Excel(name = "试题题干")
    private String quesContent;

    /** 测评类型 */
    @Excel(name = "测评类型")
    private Integer typeId;

    /** 试题答案 */
    @Excel(name = "试题答案")
    private String answer;

    /** 试题分类 */
    @Excel(name = "试题分类")
    private String quesSort;

    /** 计算分数 */
    @Excel(name = "计算分数")
    private Integer calcScore;

    public Integer getQuesOrder() {
        return quesOrder;
    }

    public void setQuesOrder(Integer quesOrder) {
        this.quesOrder = quesOrder;
    }

    /** 计算分数 */
    @Excel(name = "试题顺序")
    private Integer quesOrder;

    public void setQuesId(Integer quesId) 
    {
        this.quesId = quesId;
    }

    public Integer getQuesId() 
    {
        return quesId;
    }
    public void setQuesContent(String quesContent) 
    {
        this.quesContent = quesContent;
    }

    public String getQuesContent() 
    {
        return quesContent;
    }
    public void setTypeId(Integer typeId) 
    {
        this.typeId = typeId;
    }

    public Integer getTypeId() 
    {
        return typeId;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setQuesSort(String quesSort) 
    {
        this.quesSort = quesSort;
    }

    public String getQuesSort() 
    {
        return quesSort;
    }
    public void setCalcScore(Integer calcScore) 
    {
        this.calcScore = calcScore;
    }

    public Integer getCalcScore() 
    {
        return calcScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quesId", getQuesId())
            .append("quesContent", getQuesContent())
            .append("typeId", getTypeId())
            .append("answer", getAnswer())
            .append("quesSort", getQuesSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("calcScore", getCalcScore())
            .append("quesOrder", getQuesOrder())
            .append("remark", getRemark())
            .toString();
    }
}
