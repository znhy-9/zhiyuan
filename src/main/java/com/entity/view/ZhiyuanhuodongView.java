package com.entity.view;

import com.entity.ZhiyuanhuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 志愿活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@TableName("zhiyuanhuodong")
public class ZhiyuanhuodongView  extends ZhiyuanhuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiyuanhuodongView(){
	}
 
 	public ZhiyuanhuodongView(ZhiyuanhuodongEntity zhiyuanhuodongEntity){
 	try {
			BeanUtils.copyProperties(this, zhiyuanhuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
