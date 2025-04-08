package com.entity.model;

import com.entity.JifenduihuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 积分兑换
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
public class JifenduihuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 礼品封面
	 */
	
	private String lipinfengmian;
		
	/**
	 * 兑换数量
	 */
	
	private Integer lipinshuliang;
		
	/**
	 * 所需积分
	 */
	
	private Double suoxujifen;
		
	/**
	 * 总积分
	 */
	
	private Double zhiyuanjifen;
		
	/**
	 * 志愿者账号
	 */
	
	private String zhiyuanzhezhanghao;
		
	/**
	 * 志愿者姓名
	 */
	
	private String zhiyuanzhexingming;
		
	/**
	 * 剩余积分
	 */
	
	private Double shengyujifen;
		
	/**
	 * 兑换时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date duihuanshijian;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
				
	
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
	 * 设置：兑换数量
	 */
	 
	public void setLipinshuliang(Integer lipinshuliang) {
		this.lipinshuliang = lipinshuliang;
	}
	
	/**
	 * 获取：兑换数量
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
	 * 设置：总积分
	 */
	 
	public void setZhiyuanjifen(Double zhiyuanjifen) {
		this.zhiyuanjifen = zhiyuanjifen;
	}
	
	/**
	 * 获取：总积分
	 */
	public Double getZhiyuanjifen() {
		return zhiyuanjifen;
	}
				
	
	/**
	 * 设置：志愿者账号
	 */
	 
	public void setZhiyuanzhezhanghao(String zhiyuanzhezhanghao) {
		this.zhiyuanzhezhanghao = zhiyuanzhezhanghao;
	}
	
	/**
	 * 获取：志愿者账号
	 */
	public String getZhiyuanzhezhanghao() {
		return zhiyuanzhezhanghao;
	}
				
	
	/**
	 * 设置：志愿者姓名
	 */
	 
	public void setZhiyuanzhexingming(String zhiyuanzhexingming) {
		this.zhiyuanzhexingming = zhiyuanzhexingming;
	}
	
	/**
	 * 获取：志愿者姓名
	 */
	public String getZhiyuanzhexingming() {
		return zhiyuanzhexingming;
	}
				
	
	/**
	 * 设置：剩余积分
	 */
	 
	public void setShengyujifen(Double shengyujifen) {
		this.shengyujifen = shengyujifen;
	}
	
	/**
	 * 获取：剩余积分
	 */
	public Double getShengyujifen() {
		return shengyujifen;
	}
				
	
	/**
	 * 设置：兑换时间
	 */
	 
	public void setDuihuanshijian(Date duihuanshijian) {
		this.duihuanshijian = duihuanshijian;
	}
	
	/**
	 * 获取：兑换时间
	 */
	public Date getDuihuanshijian() {
		return duihuanshijian;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
			
}
