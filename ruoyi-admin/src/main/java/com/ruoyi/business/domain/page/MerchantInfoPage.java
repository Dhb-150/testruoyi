package com.ruoyi.business.domain.page;

import com.ruoyi.business.domain.Merchaninfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MerchantInfoPage extends Merchaninfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 城市名称
	 */
	private String cityName;
}
