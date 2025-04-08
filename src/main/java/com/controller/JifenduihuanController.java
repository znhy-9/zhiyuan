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

import com.entity.JifenduihuanEntity;
import com.entity.view.JifenduihuanView;

import com.service.JifenduihuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 积分兑换
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@RestController
@RequestMapping("/jifenduihuan")
public class JifenduihuanController {
    @Autowired
    private JifenduihuanService jifenduihuanService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JifenduihuanEntity jifenduihuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			jifenduihuan.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JifenduihuanEntity> ew = new EntityWrapper<JifenduihuanEntity>();


        //查询结果
		PageUtils page = jifenduihuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenduihuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JifenduihuanEntity jifenduihuan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JifenduihuanEntity> ew = new EntityWrapper<JifenduihuanEntity>();

        //查询结果
		PageUtils page = jifenduihuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenduihuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JifenduihuanEntity jifenduihuan){
       	EntityWrapper<JifenduihuanEntity> ew = new EntityWrapper<JifenduihuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jifenduihuan, "jifenduihuan")); 
        return R.ok().put("data", jifenduihuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JifenduihuanEntity jifenduihuan){
        EntityWrapper< JifenduihuanEntity> ew = new EntityWrapper< JifenduihuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jifenduihuan, "jifenduihuan")); 
		JifenduihuanView jifenduihuanView =  jifenduihuanService.selectView(ew);
		return R.ok("查询积分兑换成功").put("data", jifenduihuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JifenduihuanEntity jifenduihuan = jifenduihuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jifenduihuan,deSens);
        return R.ok().put("data", jifenduihuan);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JifenduihuanEntity jifenduihuan = jifenduihuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jifenduihuan,deSens);
        return R.ok().put("data", jifenduihuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JifenduihuanEntity jifenduihuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenduihuan);
        jifenduihuanService.insert(jifenduihuan);
        return R.ok().put("data",jifenduihuan.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JifenduihuanEntity jifenduihuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenduihuan);
        jifenduihuanService.insert(jifenduihuan);
        return R.ok().put("data",jifenduihuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JifenduihuanEntity jifenduihuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenduihuan);
        //全部更新
        jifenduihuanService.updateById(jifenduihuan);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jifenduihuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
