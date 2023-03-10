package com.ruoyi.business.service.impl.extend;


import com.ruoyi.business.annotation.AuthMerchantAnnotaion;
import com.ruoyi.business.config.ConfigServerApplication;
import com.ruoyi.business.domain.CommodityInfo;
import com.ruoyi.business.domain.Merchaninfo;
import com.ruoyi.business.exception.BusinessException;
import com.ruoyi.business.mapper.CommodityInfoMapper;
import com.ruoyi.business.mapper.MerchaninfoMapper;
import com.ruoyi.business.utils.GenerateID;
import com.ruoyi.business.utils.RandomUtil;
import com.ruoyi.business.utils.file.FileUploadUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BaseServiceImplExtend extends BaseController {
    //@Autowired
    //private UserInfoMapper userInfoMapper;
    @Autowired
    private MerchaninfoMapper merchaninfoMapper;
    //@Autowired
    //private ProvinceInfoMapper provinceInfoMapper;
    @Autowired
    private CommodityInfoMapper commodityInfoMapper;
    @Autowired
    private ISysConfigService sysConfigService;
    @Autowired
    private ConfigServerApplication configServerApplication;
    @Autowired
    private GenerateID generateID;

    @AuthMerchantAnnotaion
    protected List<Merchaninfo> getMerchantInfo(Merchaninfo merchaninfo) {
        merchaninfo.getParams().put("dataOther", " order by u.create_time desc ");
        return merchaninfoMapper.selectMerchaninfoList(merchaninfo);
    }

    protected void merchantAuth(ModelMap mmap) {
        mmap.addAttribute("mts", this.getMerchantInfo(new Merchaninfo()));
    }

    //protected void getActivity(ModelMap mmap) {
    //    mmap.addAttribute("activity", activityInfoMapper.selectActivityInfoList(new ActivityInfo()));
    //}

    protected String getMerchantName(String merchantId) {
        Merchaninfo merchaninfo = merchaninfoMapper.selectByPrimaryKey(merchantId);
        if (merchaninfo == null)
            return null;
        return merchaninfo.getMerchantName();
    }

    protected Merchaninfo getMerchantById(String merchantId) {
        Merchaninfo merchaninfo = merchaninfoMapper.selectByPrimaryKey(merchantId);
        if (merchaninfo == null)
            throw new BusinessException("?????????????????????");

        if (merchaninfo.getExamineStatus() == 2)
            throw new BusinessException("???????????????????????????????????????????????????");
        return merchaninfo;
    }

    //protected String getProvinceName(String provinceId) {
    //    ProvinceInfo provinceInfo = provinceInfoMapper.selectByPrimaryKey(provinceId);
    //    if (provinceInfo == null)
    //        return null;
    //    return provinceInfo.getProvinceName();
    //}
    //
    //protected List<ProvinceInfo> getProvinceList() {
    //    Example example = new Example(ProvinceInfo.class);
    //    example.setOrderByClause(" province_id asc");
    //    return provinceInfoMapper.selectByExample(example);
    //}

    protected String getFtileHttp() {
        return sysConfigService.selectConfigByKey("bussiness.file.http");
    }

    /**
     * ??????????????????
     *
     * @param pic_file
     * @param fileName
     * @param path
     * @param isMast
     * @return
     */
    protected String saveFile(MultipartFile pic_file, String fileName, String path, Boolean isMast) {
        try {
            fileName += ".png";
            path += "/";
            if (pic_file != null && !pic_file.isEmpty()) {
                if (configServerApplication.getUploadImageFileExts().contains(pic_file.getName())) {
                    throw new BusinessException("????????????????????????");
                }
                if (Long.parseLong(configServerApplication.getUploadImageFileMaxSize()) < pic_file.getSize()) {
                    throw new BusinessException("???????????????????????????");
                }
                FileUploadUtils.savefile(configServerApplication.getUploadPath() + path, fileName, pic_file.getBytes());
                return StringUtils.format("/upload/{}{}?r={}", path, fileName, RandomUtil.generateRandomNumber(3));
            }
            if (isMast) {
                throw new BusinessException("???????????????????????????");
            }
            return null;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * ????????????
     *
     * @param commodityId
     * @return
     */
    protected String getCommodityName(String commodityId) {
        CommodityInfo commodityInfo = this.getCommodityById(commodityId);
        if (commodityInfo != null)
            return commodityInfo.getCommodityName();
        return null;
    }

    protected CommodityInfo getCommodityById(String commodityId) {
        return commodityInfoMapper.selectByPrimaryKey(commodityId);

    }

    ///**
    // * ????????????
    // *
    // * @param activityId
    // * @return
    // */
    //protected String getActivityName(String activityId) {
    //    ActivityInfo activityInfo = activityInfoMapper.selectByPrimaryKey(activityId);
    //    if (activityInfo != null)
    //        return activityInfo.getActivityName();
    //    return null;
    //}

    /**
     * ??????uuid
     *
     * @return
     */
    public String getUid() {
        return generateID.nextId();
    }


    ///**
    // * ??????????????????
    // *
    // * @param userId
    // * @return
    // */
    //protected String getUserName(String userId) {
    //    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
    //    if (userInfo != null)
    //        return StringUtils.format("{}[{}]", userInfo.getUserPhone(), userInfo.getUserNickname());
    //    return null;
    //}
}
