package com.ruoyi.competition.service;

import com.ruoyi.competition.domain.EssayPublish;
import java.util.List;

/**
 * 文章发布Service接口
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
public interface IEssayPublishService
{
    /**
     * 查询文章发布
     * 
     * @param essayId 文章发布ID
     * @return 文章发布
     */
    public EssayPublish selectEssayPublishById(Integer essayId);

    /**
     * 查询文章发布列表
     * 
     * @param essayPublish 文章发布
     * @return 文章发布集合
     */
    public List<EssayPublish> selectEssayPublishList(EssayPublish essayPublish);

    /**
     * 新增文章发布
     * 
     * @param essayPublish 文章发布
     * @return 结果
     */
    public int insertEssayPublish(EssayPublish essayPublish);

    /**
     * 修改文章发布
     * 
     * @param essayPublish 文章发布
     * @return 结果
     */
    public int updateEssayPublish(EssayPublish essayPublish);

    /**
     * 批量删除文章发布
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEssayPublishByIds(String ids);

    /**
     * 删除文章发布信息
     * 
     * @param essayId 文章发布ID
     * @return 结果
     */
    public int deleteEssayPublishById(Integer essayId);
}
