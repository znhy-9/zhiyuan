package com.entity.view;

import com.entity.JifenlipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 积分礼品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@TableName("jifenlipin")
public class JifenlipinView  extends JifenlipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JifenlipinView(){
	}
 
 	public JifenlipinView(JifenlipinEntity jifenlipinEntity){
 	try {
			BeanUtils.copyProperties(this, jifenlipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
