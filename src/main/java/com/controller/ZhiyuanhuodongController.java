package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhiyuanhuodongEntity;
import com.entity.view.ZhiyuanhuodongView;

import com.service.ZhiyuanhuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 志愿活动
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@RestController
@RequestMapping("/zhiyuanhuodong")
public class ZhiyuanhuodongController {
    @Autowired
    private ZhiyuanhuodongService zhiyuanhuodongService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();


        //查询结果
		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();

        //查询结果
		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanhuodongEntity zhiyuanhuodong){
       	EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanhuodong, "zhiyuanhuodong")); 
        return R.ok().put("data", zhiyuanhuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanhuodongEntity zhiyuanhuodong){
        EntityWrapper< ZhiyuanhuodongEntity> ew = new EntityWrapper< ZhiyuanhuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanhuodong, "zhiyuanhuodong")); 
		ZhiyuanhuodongView zhiyuanhuodongView =  zhiyuanhuodongService.selectView(ew);
		return R.ok("查询志愿活动成功").put("data", zhiyuanhuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhiyuanhuodong,deSens);
        return R.ok().put("data", zhiyuanhuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhiyuanhuodong,deSens);
        return R.ok().put("data", zhiyuanhuodong);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
        if(type.equals("1")) {
        	zhiyuanhuodong.setThumbsupnum(zhiyuanhuodong.getThumbsupnum()+1);
        } else {
        	zhiyuanhuodong.setCrazilynum(zhiyuanhuodong.getCrazilynum()+1);
        }
        zhiyuanhuodongService.updateById(zhiyuanhuodong);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok().put("data",zhiyuanhuodong.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok().put("data",zhiyuanhuodong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        //全部更新
        zhiyuanhuodongService.updateById(zhiyuanhuodong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
