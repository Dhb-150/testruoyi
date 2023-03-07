package com.ruoyi.business.controller.extend;


import com.ruoyi.business.domain.CommodityCart;
import com.ruoyi.business.domain.CommodityInfo;
import com.ruoyi.business.domain.page.CommodityCartPage;
import com.ruoyi.business.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommodityCartExtendController extends BaseServiceImplExtend {
    protected List<CommodityCartPage> getCommodityCartPage(List<CommodityCart> list) {
        List<CommodityCartPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCommodityCartPage(source));
        });
        return pages;
    }

    protected CommodityCartPage getCommodityCartPage(CommodityCart source) {
        CommodityCartPage page = new CommodityCartPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        page.setUserName(super.getUsername());
        CommodityInfo commodityInfo = super.getCommodityById(page.getCommodityId());
        if (commodityInfo != null) {
            page.setCommodityImg(commodityInfo.getCommodityImg());
            page.setCommodityName(commodityInfo.getCommodityName());
        }
        return page;
    }
}
