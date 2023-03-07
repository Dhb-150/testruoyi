package com.ruoyi.business.controller.extend;


import com.ruoyi.business.domain.Merchaninfo;
import com.ruoyi.business.domain.page.MerchantInfoPage;
import com.ruoyi.business.service.impl.extend.MerchaninfoServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class MerchaninfoControllerExtend extends MerchaninfoServiceImplExtend {

	protected List<MerchantInfoPage> getMerchantInfoPage(List<Merchaninfo> list) {
		List<MerchantInfoPage> pages = new ArrayList<>(list.size());
		BeanUtils.copyProperties(list, pages);
		list.forEach(source -> {
			pages.add(this.getMerchantInfoPage(source));
		});
		return pages;
	}

	protected MerchantInfoPage getMerchantInfoPage(Merchaninfo source) {
		MerchantInfoPage page = new MerchantInfoPage();
		BeanUtils.copyProperties(source, page);
		//page.setCityName(super.getCityName(page.getProvinceId(),page.getCityCode()));
		page.setDeptName(super.getDeptName(page.getDeptId()));
		return page;

	}
}
