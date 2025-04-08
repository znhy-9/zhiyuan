package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JifenduihuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JifenduihuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JifenduihuanView;


/**
 * 积分兑换
 *
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
public interface JifenduihuanService extends IService<JifenduihuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JifenduihuanVO> selectListVO(Wrapper<JifenduihuanEntity> wrapper);
   	
   	JifenduihuanVO selectVO(@Param("ew") Wrapper<JifenduihuanEntity> wrapper);
   	
   	List<JifenduihuanView> selectListView(Wrapper<JifenduihuanEntity> wrapper);
   	
   	JifenduihuanView selectView(@Param("ew") Wrapper<JifenduihuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JifenduihuanEntity> wrapper);

   	

}

