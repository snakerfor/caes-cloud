package com.ruoyi.caes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测评提交对象 t_test_sumbit
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
public class TestSumbit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测评提交ID */
    private Long sumbitId;

    /** 测评序号 */
    @Excel(name = "测评序号")
    private String testNo;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 提交答案 */
    @Excel(name = "提交答案")
    private String answer;

    /** 试题ID */
    @Excel(name = "试题ID")
    private Long quesId;

    public void setSumbitId(Long sumbitId) 
    {
        this.sumbitId = sumbitId;
    }

    public Long getSumbitId() 
    {
        return sumbitId;
    }
    public void setTestNo(String testNo) 
    {
        this.testNo = testNo;
    }

    public String getTestNo() 
    {
        return testNo;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setQuesId(Long quesId) 
    {
        this.quesId = quesId;
    }

    public Long getQuesId() 
    {
        return quesId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sumbitId", getSumbitId())
            .append("testNo", getTestNo())
            .append("userId", getUserId())
            .append("answer", getAnswer())
            .append("quesId", getQuesId())
            .toString();
    }
}
