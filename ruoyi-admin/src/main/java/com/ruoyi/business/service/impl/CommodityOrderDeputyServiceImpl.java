package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.CommodityOrderDeputy;
import com.ruoyi.business.mapper.CommodityOrderDeputyMapper;
import com.ruoyi.business.service.ICommodityOrderDeputyService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单辅助Service业务层处理
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Service
public class CommodityOrderDeputyServiceImpl implements ICommodityOrderDeputyService {
    @Autowired
    private CommodityOrderDeputyMapper commodityOrderDeputyMapper;

    /**
     * 查询订单辅助
     * 
     * @param deputyId 订单辅助ID
     * @return 订单辅助
     */
    @Override
    public CommodityOrderDeputy selectCommodityOrderDeputyById(String deputyId)
    {
        return commodityOrderDeputyMapper.selectCommodityOrderDeputyById(deputyId);
    }

    /**
     * 查询订单辅助列表
     * 
     * @param commodityOrderDeputy 订单辅助
     * @return 订单辅助
     */
    @Override
    public List<CommodityOrderDeputy> selectCommodityOrderDeputyList(CommodityOrderDeputy commodityOrderDeputy)
    {
        return commodityOrderDeputyMapper.selectCommodityOrderDeputyList(commodityOrderDeputy);
    }

    /**
     * 新增订单辅助
     * 
     * @param commodityOrderDeputy 订单辅助
     * @return 结果
     */
    @Override
    public int insertCommodityOrderDeputy(CommodityOrderDeputy commodityOrderDeputy)
    {
        commodityOrderDeputy.setCreateTime(DateUtils.getNowDate());
        commodityOrderDeputy.setUpdateTime(DateUtils.getNowDate());
        commodityOrderDeputy.setUpdateBy(SecurityUtils.getUsername());
        return commodityOrderDeputyMapper.insertCommodityOrderDeputy(commodityOrderDeputy);
    }

    /**
     * 修改订单辅助
     * 
     * @param commodityOrderDeputy 订单辅助
     * @return 结果
     */
    @Override
    public int updateCommodityOrderDeputy(CommodityOrderDeputy commodityOrderDeputy)
    {
        commodityOrderDeputy.setUpdateTime(DateUtils.getNowDate());
        commodityOrderDeputy.setUpdateBy(SecurityUtils.getUsername());
        return commodityOrderDeputyMapper.updateCommodityOrderDeputy(commodityOrderDeputy);
    }

    /**
     * 删除订单辅助对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderDeputyByIds(String ids)
    {
        return commodityOrderDeputyMapper.deleteCommodityOrderDeputyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单辅助信息
     * 
     * @param deputyId 订单辅助ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderDeputyById(String deputyId)
    {
        return commodityOrderDeputyMapper.deleteCommodityOrderDeputyById(deputyId);
    }
}
