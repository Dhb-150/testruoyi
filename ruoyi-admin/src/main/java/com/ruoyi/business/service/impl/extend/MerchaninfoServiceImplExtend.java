package com.ruoyi.business.service.impl.extend;

//import com.ruoyi.business.domain.CityInfo;
//import com.ruoyi.business.domain.ProvinceInfo;
//import com.ruoyi.business.mapper.CityInfoMapper;
//import com.ruoyi.business.mapper.ProvinceInfoMapper;

//import com.ruoyi.business.mapper.ProvinceInfoMapper;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MerchaninfoServiceImplExtend extends BaseServiceImplExtend {
	@Autowired
	private SysDeptMapper sysDeptMapper;
	//@Autowired
	//private ProvinceInfoMapper provinceInfoMapper;
	//@Autowired
	//private CityInfoMapper cityInfoMapper;

	//protected String getCityName(String provinceId, String cityCode) {
	//	ProvinceInfo provinceInfo = provinceInfoMapper.selectByPrimaryKey(provinceId);
	//	if (provinceInfo == null)
	//		return null;
	//	CityInfo cityInfo = cityInfoMapper.selectByPrimaryKey(cityCode);
	//	if (cityInfo == null)
	//		return provinceInfo.getProvinceName();
	//	return StringUtils.format("{}.{}", provinceInfo.getProvinceName(), cityInfo.getCityName());
	//}

	protected String getDeptName(Long deptId) {
		SysDept sysDept = sysDeptMapper.selectDeptById(deptId);
		if (sysDept == null)
			return null;
		return sysDept.getDeptName();
	}
}
