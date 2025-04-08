package com.entity.vo;

import com.entity.JifenlipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 积分礼品
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
public class JifenlipinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 礼品名称
	 */
	
	private String lipinmingcheng;
		
	/**
	 * 礼品封面
	 */
	
	private String lipinfengmian;
		
	/**
	 * 礼品数量
	 */
	
	private Integer lipinshuliang;
		
	/**
	 * 所需积分
	 */
	
	private Double suoxujifen;
		
	/**
	 * 简介
	 */
	
	private String jianjie;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
	/**
	 * 设置：礼品名称
	 */
	 
	public void setLipinmingcheng(String lipinmingcheng) {
		this.lipinmingcheng = lipinmingcheng;
	}
	
	/**
	 * 获取：礼品名称
	 */
	public String getLipinmingcheng() {
		return lipinmingcheng;
	}
				
	
	/**
	 * 设置：礼品封面
	 */
	 
	public void setLipinfengmian(String lipinfengmian) {
		this.lipinfengmian = lipinfengmian;
	}
	
	/**
	 * 获取：礼品封面
	 */
	public String getLipinfengmian() {
		return lipinfengmian;
	}
				
	
	/**
	 * 设置：礼品数量
	 */
	 
	public void setLipinshuliang(Integer lipinshuliang) {
		this.lipinshuliang = lipinshuliang;
	}
	
	/**
	 * 获取：礼品数量
	 */
	public Integer getLipinshuliang() {
		return lipinshuliang;
	}
				
	
	/**
	 * 设置：所需积分
	 */
	 
	public void setSuoxujifen(Double suoxujifen) {
		this.suoxujifen = suoxujifen;
	}
	
	/**
	 * 获取：所需积分
	 */
	public Double getSuoxujifen() {
		return suoxujifen;
	}
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	
	/**
	 * 获取：简介
	 */
	public String getJianjie() {
		return jianjie;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
			
}
