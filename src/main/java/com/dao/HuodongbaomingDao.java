package com.dao;

import com.entity.HuodongbaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongbaomingVO;
import com.entity.view.HuodongbaomingView;


/**
 * 活动报名
 * 
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
public interface HuodongbaomingDao extends BaseMapper<HuodongbaomingEntity> {
	
	List<HuodongbaomingVO> selectListVO(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);
	
	HuodongbaomingVO selectVO(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);
	
	List<HuodongbaomingView> selectListView(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);

	List<HuodongbaomingView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);

	
	HuodongbaomingView selectView(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);
	

}
