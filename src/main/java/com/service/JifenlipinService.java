package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JifenlipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JifenlipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JifenlipinView;


/**
 * 积分礼品
 *
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
public interface JifenlipinService extends IService<JifenlipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JifenlipinVO> selectListVO(Wrapper<JifenlipinEntity> wrapper);
   	
   	JifenlipinVO selectVO(@Param("ew") Wrapper<JifenlipinEntity> wrapper);
   	
   	List<JifenlipinView> selectListView(Wrapper<JifenlipinEntity> wrapper);
   	
   	JifenlipinView selectView(@Param("ew") Wrapper<JifenlipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JifenlipinEntity> wrapper);

   	

}

