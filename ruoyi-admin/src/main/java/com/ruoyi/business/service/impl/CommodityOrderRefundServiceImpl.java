package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.CommodityOrderRefund;
import com.ruoyi.business.mapper.CommodityOrderRefundMapper;
import com.ruoyi.business.service.ICommodityOrderRefundService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退款订单Service业务层处理
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Service
public class CommodityOrderRefundServiceImpl implements ICommodityOrderRefundService {
    @Autowired
    private CommodityOrderRefundMapper commodityOrderRefundMapper;

    /**
     * 查询退款订单
     * 
     * @param refundId 退款订单ID
     * @return 退款订单
     */
    @Override
    public CommodityOrderRefund selectCommodityOrderRefundById(String refundId)
    {
        return commodityOrderRefundMapper.selectCommodityOrderRefundById(refundId);
    }

    /**
     * 查询退款订单列表
     * 
     * @param commodityOrderRefund 退款订单
     * @return 退款订单
     */
    @Override
    public List<CommodityOrderRefund> selectCommodityOrderRefundList(CommodityOrderRefund commodityOrderRefund)
    {
        return commodityOrderRefundMapper.selectCommodityOrderRefundList(commodityOrderRefund);
    }

    /**
     * 新增退款订单
     * 
     * @param commodityOrderRefund 退款订单
     * @return 结果
     */
    @Override
    public int insertCommodityOrderRefund(CommodityOrderRefund commodityOrderRefund)
    {
        commodityOrderRefund.setCreateTime(DateUtils.getNowDate());
        commodityOrderRefund.setUpdateTime(DateUtils.getNowDate());
        commodityOrderRefund.setUpdateBy(SecurityUtils.getUsername());
        return commodityOrderRefundMapper.insertCommodityOrderRefund(commodityOrderRefund);
    }

    /**
     * 修改退款订单
     * 
     * @param commodityOrderRefund 退款订单
     * @return 结果
     */
    @Override
    public int updateCommodityOrderRefund(CommodityOrderRefund commodityOrderRefund)
    {
        commodityOrderRefund.setUpdateTime(DateUtils.getNowDate());
        commodityOrderRefund.setUpdateBy(SecurityUtils.getUsername());
        return commodityOrderRefundMapper.updateCommodityOrderRefund(commodityOrderRefund);
    }

    /**
     * 删除退款订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderRefundByIds(String ids)
    {
        return commodityOrderRefundMapper.deleteCommodityOrderRefundByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除退款订单信息
     * 
     * @param refundId 退款订单ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderRefundById(String refundId)
    {
        return commodityOrderRefundMapper.deleteCommodityOrderRefundById(refundId);
    }
}
