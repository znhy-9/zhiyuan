package com.dao;

import com.entity.JifenlipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JifenlipinVO;
import com.entity.view.JifenlipinView;


/**
 * 积分礼品
 * 
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
public interface JifenlipinDao extends BaseMapper<JifenlipinEntity> {
	
	List<JifenlipinVO> selectListVO(@Param("ew") Wrapper<JifenlipinEntity> wrapper);
	
	JifenlipinVO selectVO(@Param("ew") Wrapper<JifenlipinEntity> wrapper);
	
	List<JifenlipinView> selectListView(@Param("ew") Wrapper<JifenlipinEntity> wrapper);

	List<JifenlipinView> selectListView(Pagination page,@Param("ew") Wrapper<JifenlipinEntity> wrapper);

	
	JifenlipinView selectView(@Param("ew") Wrapper<JifenlipinEntity> wrapper);
	

}
