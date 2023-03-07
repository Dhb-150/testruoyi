package com.ruoyi.business.service.impl;

import com.ruoyi.business.bean.Json;
import com.ruoyi.business.domain.CommodityOrder;
import com.ruoyi.business.mapper.CommodityOrderMapper;
import com.ruoyi.business.service.ICommodityOrderService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.OrderStatusEnum;
import com.ruoyi.common.enums.ResultEnum;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品订单Service业务层处理
 *
 * @author zebra
 * @date 2020-08-18
 */
@Service
public class CommodityOrderServiceImpl implements ICommodityOrderService {
    @Autowired
    private CommodityOrderMapper commodityOrderMapper;

    //@Autowired
    //private BussinessFienClient bussinessFienClient;

    /**
     * 查询商品订单
     *
     * @param orderId 商品订单ID
     * @return 商品订单
     */
    @Override
    public CommodityOrder selectCommodityOrderById(String orderId) {
        return commodityOrderMapper.selectCommodityOrderById(orderId);
    }

    /**
     * 查询商品订单列表
     *
     * @param commodityOrder 商品订单
     * @return 商品订单
     */
    @Override
    public List<CommodityOrder> selectCommodityOrderList(CommodityOrder commodityOrder) {
        return commodityOrderMapper.selectCommodityOrderList(commodityOrder);
    }

    /**
     * 新增商品订单
     *
     * @param commodityOrder 商品订单
     * @return 结果
     */
    @Override
    public int insertCommodityOrder(CommodityOrder commodityOrder) {
        commodityOrder.setCreateTime(DateUtils.getNowDate());
        commodityOrder.setUpdateTime(DateUtils.getNowDate());
        commodityOrder.setUpdateBy(SecurityUtils.getUsername());
        return commodityOrderMapper.insertCommodityOrder(commodityOrder);
    }

    /**
     * 修改商品订单
     *
     * @param commodityOrder 商品订单
     * @return 结果
     */
    @Override
    public AjaxResult updateCommodityOrder(CommodityOrder commodityOrder) {
        String orderId = commodityOrder.getOrderId();
        CommodityOrder orders = commodityOrderMapper.selectByPrimaryKey(orderId);
        if (orders == null)
            return AjaxResult.error(Json.other(ResultEnum.PARAMNULL).toString());

        if (orders.getOrderStatus() != OrderStatusEnum.ORDER_STATUS_2.getOrderStatus()&&orders.getOrderStatus() != OrderStatusEnum.ORDER_STATUS_4.getOrderStatus())
            return AjaxResult.error(Json.other(ResultEnum.ORDER_NOPAY).toString());

        /**
         * 真正退款支付实现忽略，后期版本增加
         */
        orders.setOrderStatus(OrderStatusEnum.ORDER_STATUS_5.getOrderStatus());
        orders.setUpdateTime(new Date());
        int falg = commodityOrderMapper.updateByPrimaryKeySelective(orders);
        if (falg == 0) {
            return AjaxResult.error(Json.other(ResultEnum.FLAG_FAIL).toString());
        }
        return AjaxResult.error("还没开发");
    }

    /**
     * 删除商品订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderByIds(String ids) {
        return commodityOrderMapper.deleteCommodityOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品订单信息
     *
     * @param orderId 商品订单ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderById(String orderId) {
        return commodityOrderMapper.deleteCommodityOrderById(orderId);
    }
}
