package com.entity.view;

import com.entity.JifenduihuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 积分兑换
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@TableName("jifenduihuan")
public class JifenduihuanView  extends JifenduihuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JifenduihuanView(){
	}
 
 	public JifenduihuanView(JifenduihuanEntity jifenduihuanEntity){
 	try {
			BeanUtils.copyProperties(this, jifenduihuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
