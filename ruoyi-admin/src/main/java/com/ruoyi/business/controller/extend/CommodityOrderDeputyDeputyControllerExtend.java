package com.ruoyi.business.controller.extend;


import com.ruoyi.business.domain.CommodityOrderDeputy;
import com.ruoyi.business.domain.page.CommodityOrderDeputyPage;
import com.ruoyi.business.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommodityOrderDeputyDeputyControllerExtend extends BaseServiceImplExtend {

    protected List<CommodityOrderDeputyPage> getCommodityOrderDeputyPage(List<CommodityOrderDeputy> list) {
        List<CommodityOrderDeputyPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCommodityOrderDeputyPage(source));
        });
        return pages;
    }

    protected CommodityOrderDeputyPage getCommodityOrderDeputyPage(CommodityOrderDeputy source) {
        CommodityOrderDeputyPage page = new CommodityOrderDeputyPage();
        BeanUtils.copyProperties(source, page);
        page.setCommodityName(super.getCommodityName(page.getCommodityId()));
        return page;
    }

}
