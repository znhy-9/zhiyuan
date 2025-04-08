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

import com.entity.DiscusszhiyuanhuodongEntity;
import com.entity.view.DiscusszhiyuanhuodongView;

import com.service.DiscusszhiyuanhuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿活动评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-07 19:25:24
 */
@RestController
@RequestMapping("/discusszhiyuanhuodong")
public class DiscusszhiyuanhuodongController {
    @Autowired
    private DiscusszhiyuanhuodongService discusszhiyuanhuodongService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhiyuanhuodongEntity discusszhiyuanhuodong,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscusszhiyuanhuodongEntity> ew = new EntityWrapper<DiscusszhiyuanhuodongEntity>();


        //查询结果
		PageUtils page = discusszhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiyuanhuodong), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscusszhiyuanhuodongEntity discusszhiyuanhuodong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscusszhiyuanhuodongEntity> ew = new EntityWrapper<DiscusszhiyuanhuodongEntity>();

        //查询结果
		PageUtils page = discusszhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiyuanhuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhiyuanhuodongEntity discusszhiyuanhuodong){
       	EntityWrapper<DiscusszhiyuanhuodongEntity> ew = new EntityWrapper<DiscusszhiyuanhuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhiyuanhuodong, "discusszhiyuanhuodong")); 
        return R.ok().put("data", discusszhiyuanhuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhiyuanhuodongEntity discusszhiyuanhuodong){
        EntityWrapper< DiscusszhiyuanhuodongEntity> ew = new EntityWrapper< DiscusszhiyuanhuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhiyuanhuodong, "discusszhiyuanhuodong")); 
		DiscusszhiyuanhuodongView discusszhiyuanhuodongView =  discusszhiyuanhuodongService.selectView(ew);
		return R.ok("查询志愿活动评论表成功").put("data", discusszhiyuanhuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhiyuanhuodongEntity discusszhiyuanhuodong = discusszhiyuanhuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discusszhiyuanhuodong,deSens);
        return R.ok().put("data", discusszhiyuanhuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhiyuanhuodongEntity discusszhiyuanhuodong = discusszhiyuanhuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discusszhiyuanhuodong,deSens);
        return R.ok().put("data", discusszhiyuanhuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhiyuanhuodongEntity discusszhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhiyuanhuodong);
        discusszhiyuanhuodongService.insert(discusszhiyuanhuodong);
        return R.ok().put("data",discusszhiyuanhuodong.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhiyuanhuodongEntity discusszhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhiyuanhuodong);
        discusszhiyuanhuodongService.insert(discusszhiyuanhuodong);
        return R.ok().put("data",discusszhiyuanhuodong.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusszhiyuanhuodongEntity discusszhiyuanhuodong = discusszhiyuanhuodongService.selectOne(new EntityWrapper<DiscusszhiyuanhuodongEntity>().eq("", username));
        return R.ok().put("data", discusszhiyuanhuodong);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusszhiyuanhuodongEntity discusszhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhiyuanhuodong);
        //全部更新
        discusszhiyuanhuodongService.updateById(discusszhiyuanhuodong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhiyuanhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusszhiyuanhuodongEntity discusszhiyuanhuodong, HttpServletRequest request,String pre){
        EntityWrapper<DiscusszhiyuanhuodongEntity> ew = new EntityWrapper<DiscusszhiyuanhuodongEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discusszhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiyuanhuodong), params), params));
        return R.ok().put("data", page);
    }








}
