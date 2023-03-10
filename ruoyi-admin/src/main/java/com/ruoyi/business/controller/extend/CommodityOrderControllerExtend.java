package com.ruoyi.business.controller.extend;


import com.ruoyi.business.domain.CommodityOrder;
import com.ruoyi.business.domain.page.CommodityOrderPage;
import com.ruoyi.business.service.impl.extend.CommodityOrderServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommodityOrderControllerExtend extends CommodityOrderServiceImplExtend {


    protected List<CommodityOrderPage> getCommodityOrderPage(List<CommodityOrder> list) {
        List<CommodityOrderPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCommodityOrderPage(source));
        });
        return pages;
    }

    protected CommodityOrderPage getCommodityOrderPage(CommodityOrder source) {
        CommodityOrderPage page = new CommodityOrderPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        return page;
    }

}
