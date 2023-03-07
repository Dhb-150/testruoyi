package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.CommodityCategory;
import com.ruoyi.business.domain.core.domain.Ztree;
import com.ruoyi.business.mapper.CommodityCategoryMapper;
import com.ruoyi.business.service.ICommodityCategoryService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类别Service业务层处理
 * 
 * @author zebra
 * @date 2020-07-01
 */
@Service
public class CommodityCategoryServiceImpl implements ICommodityCategoryService {
    @Autowired
    private CommodityCategoryMapper commodityCategoryMapper;

    /**
     * 查询产品类别
     * 
     * @param categoryId 产品类别ID
     * @return 产品类别
     */
    @Override
    public CommodityCategory selectCommodityCategoryById(Long categoryId)
    {
        return commodityCategoryMapper.selectCommodityCategoryById(categoryId);
    }

    /**
     * 查询产品类别列表
     * 
     * @param commodityCategory 产品类别
     * @return 产品类别
     */
    @Override
    public List<CommodityCategory> selectCommodityCategoryList(CommodityCategory commodityCategory)
    {
        return commodityCategoryMapper.selectCommodityCategoryList(commodityCategory);
    }

    /**
     * 新增产品类别
     * 
     * @param commodityCategory 产品类别
     * @return 结果
     */
    @Override
    public int insertCommodityCategory(CommodityCategory commodityCategory)
    {
        commodityCategory.setCreateTime(DateUtils.getNowDate());
        commodityCategory.setUpdateTime(DateUtils.getNowDate());
        commodityCategory.setUpdateBy(SecurityUtils.getUsername());
        return commodityCategoryMapper.insertCommodityCategory(commodityCategory);
    }

    /**
     * 修改产品类别
     * 
     * @param commodityCategory 产品类别
     * @return 结果
     */
    @Override
    public int updateCommodityCategory(CommodityCategory commodityCategory)
    {
        commodityCategory.setUpdateTime(DateUtils.getNowDate());
        commodityCategory.setUpdateBy(SecurityUtils.getUsername());
        return commodityCategoryMapper.updateCommodityCategory(commodityCategory);
    }

    /**
     * 删除产品类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityCategoryByIds(String ids)
    {
        return commodityCategoryMapper.deleteCommodityCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品类别信息
     * 
     * @param categoryId 产品类别ID
     * @return 结果
     */
    @Override
    public int deleteCommodityCategoryById(Long categoryId)
    {
        return commodityCategoryMapper.deleteCommodityCategoryById(categoryId);
    }

    /**
     * 查询产品类别树列表
     * 
     * @return 所有产品类别信息
     */
    @Override
    public List<Ztree> selectCommodityCategoryTree()
    {
        List<CommodityCategory> commodityCategoryList = commodityCategoryMapper.selectCommodityCategoryList(new CommodityCategory());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (CommodityCategory commodityCategory : commodityCategoryList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(commodityCategory.getCategoryId());
            ztree.setpId(commodityCategory.getCategoryParid());
            ztree.setName(commodityCategory.getCategoryName());
            ztree.setTitle(commodityCategory.getCategoryName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
