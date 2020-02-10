package com.ruoyi.competition.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 大赛作品申报提交对象 t_contest_production
 * 继承BaseEntity基类 需修改:定义了与基类功能相同而名称不同的方法
 * 
 * @author Random-pro
 * @date 2020-02-03
 */
public class competition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String productionId;

    /** 作品名称 */
    @Excel(name = "作品名称")
    private String name;

    /** 作品领域 */
    @Excel(name = "作品领域")
    private String domain;

    /** 作品介绍 */
    @Excel(name = "作品介绍")
    private String desc;

    /** 作品负责人 */
    @Excel(name = "作品负责人")
    private String leader;

    /** 作品团队 */
    @Excel(name = "作品团队")
    private String team;

    /** 团队描述 */
    @Excel(name = "团队描述")
    private String teamDesc;

    /** 目前阶段描述 */
    @Excel(name = "目前阶段描述")
    private String currentDesc;

    /** 未来达成描述 */
    @Excel(name = "未来达成描述")
    private String futureDesc;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date editTime;

    /** 修改人 */
    @Excel(name = "修改人")
    private String editUser;

    /** 作品层级 */
    @Excel(name = "作品层级")
    private char prodLevel;

    /** 作品评价 */
    @Excel(name = "作品评价")
    private String prodEvaluate;

    public void setProductionId(String productionId) 
    {
        this.productionId = productionId;
    }

    public String getProductionId() 
    {
        return productionId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDomain(String domain) 
    {
        this.domain = domain;
    }

    public String getDomain() 
    {
        return domain;
    }
    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public String getDesc() 
    {
        return desc;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }
    public void setTeam(String team) 
    {
        this.team = team;
    }

    public String getTeam() 
    {
        return team;
    }
    public void setTeamDesc(String teamDesc) 
    {
        this.teamDesc = teamDesc;
    }

    public String getTeamDesc() 
    {
        return teamDesc;
    }
    public void setCurrentDesc(String currentDesc) 
    {
        this.currentDesc = currentDesc;
    }

    public String getCurrentDesc() 
    {
        return currentDesc;
    }
    public void setFutureDesc(String futureDesc) 
    {
        this.futureDesc = futureDesc;
    }

    public String getFutureDesc() 
    {
        return futureDesc;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setEditTime(Date editTime) 
    {
        this.editTime = editTime;
    }

    public Date getEditTime() 
    {
        return editTime;
    }
    public void setEditUser(String editUser)
    {
        this.editUser = editUser;
    }

    public String getEditUser()
    {
        return editUser;
    }

    public void setProdLevel(char prodLevel)
    {
        this.prodLevel = prodLevel;
    }

    public char getProdLevel()
    {
        return prodLevel;
    }

    public void setProdEvaluate(String prodEvaluate)
    {
        this.prodEvaluate = prodEvaluate;
    }

    public String getProdEvaluate()
    {
        return prodEvaluate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productionId", getProductionId())
            .append("name", getName())
            .append("domain", getDomain())
            .append("desc", getDesc())
            .append("leader", getLeader())
            .append("team", getTeam())
            .append("teamDesc", getTeamDesc())
            .append("currentDesc", getCurrentDesc())
            .append("futureDesc", getFutureDesc())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("editTime", getEditTime())
            .append("editUser", getEditUser())
            .append("prodLevel", getProdLevel())
            .append("prodEvaluate", getProdEvaluate())
            .toString();
    }
}
