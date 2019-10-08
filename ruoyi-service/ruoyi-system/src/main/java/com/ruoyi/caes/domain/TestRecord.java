package com.ruoyi.caes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测评记录对象 t_test_record
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
public class TestRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测评序号 */
    private String testNo;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 测评类型ID */
    @Excel(name = "测评类型ID")
    private Integer typeId;

    /** 测评分数 */
    @Excel(name = "测评分数")
    private String testScore;

    /** 测评结果 */
    @Excel(name = "测评结果")
    private String testResult;

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
    public void setTypeId(Integer typeId) 
    {
        this.typeId = typeId;
    }

    public Integer getTypeId() 
    {
        return typeId;
    }
    public void setTestScore(String testScore) 
    {
        this.testScore = testScore;
    }

    public String getTestScore() 
    {
        return testScore;
    }
    public void setTestResult(String testResult) 
    {
        this.testResult = testResult;
    }

    public String getTestResult() 
    {
        return testResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testNo", getTestNo())
            .append("userId", getUserId())
            .append("typeId", getTypeId())
            .append("testScore", getTestScore())
            .append("testResult", getTestResult())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
