package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JifenlipinDao;
import com.entity.JifenlipinEntity;
import com.service.JifenlipinService;
import com.entity.vo.JifenlipinVO;
import com.entity.view.JifenlipinView;

@Service("jifenlipinService")
public class JifenlipinServiceImpl extends ServiceImpl<JifenlipinDao, JifenlipinEntity> implements JifenlipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JifenlipinEntity> page = this.selectPage(
                new Query<JifenlipinEntity>(params).getPage(),
                new EntityWrapper<JifenlipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JifenlipinEntity> wrapper) {
		  Page<JifenlipinView> page =new Query<JifenlipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JifenlipinVO> selectListVO(Wrapper<JifenlipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JifenlipinVO selectVO(Wrapper<JifenlipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JifenlipinView> selectListView(Wrapper<JifenlipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JifenlipinView selectView(Wrapper<JifenlipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
