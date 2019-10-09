package com.ruoyi.caes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 霍兰德对照对象 t_hol_map
 * 
 * @author snakerfor
 * @date 2019-10-08
 */
public class HolMap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 霍兰德结果 */
    @Excel(name = "霍兰德结果")
    private String holRes;

    /** 建议专业 */
    @Excel(name = "建议专业")
    private String major;

    public void setHolRes(String holRes) 
    {
        this.holRes = holRes;
    }

    public String getHolRes() 
    {
        return holRes;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("holRes", getHolRes())
            .append("major", getMajor())
            .toString();
    }
}
