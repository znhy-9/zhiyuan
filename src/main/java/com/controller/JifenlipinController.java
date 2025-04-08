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

import com.entity.JifenlipinEntity;
import com.entity.view.JifenlipinView;

import com.service.JifenlipinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 积分礼品
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@RestController
@RequestMapping("/jifenlipin")
public class JifenlipinController {
    @Autowired
    private JifenlipinService jifenlipinService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JifenlipinEntity jifenlipin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JifenlipinEntity> ew = new EntityWrapper<JifenlipinEntity>();


        //查询结果
		PageUtils page = jifenlipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenlipin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JifenlipinEntity jifenlipin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JifenlipinEntity> ew = new EntityWrapper<JifenlipinEntity>();

        //查询结果
		PageUtils page = jifenlipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenlipin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JifenlipinEntity jifenlipin){
       	EntityWrapper<JifenlipinEntity> ew = new EntityWrapper<JifenlipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jifenlipin, "jifenlipin")); 
        return R.ok().put("data", jifenlipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JifenlipinEntity jifenlipin){
        EntityWrapper< JifenlipinEntity> ew = new EntityWrapper< JifenlipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jifenlipin, "jifenlipin")); 
		JifenlipinView jifenlipinView =  jifenlipinService.selectView(ew);
		return R.ok("查询积分礼品成功").put("data", jifenlipinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JifenlipinEntity jifenlipin = jifenlipinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jifenlipin,deSens);
        return R.ok().put("data", jifenlipin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JifenlipinEntity jifenlipin = jifenlipinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jifenlipin,deSens);
        return R.ok().put("data", jifenlipin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JifenlipinEntity jifenlipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenlipin);
        jifenlipinService.insert(jifenlipin);
        return R.ok().put("data",jifenlipin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JifenlipinEntity jifenlipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenlipin);
        jifenlipinService.insert(jifenlipin);
        return R.ok().put("data",jifenlipin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JifenlipinEntity jifenlipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenlipin);
        //全部更新
        jifenlipinService.updateById(jifenlipin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jifenlipinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
