package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 积分兑换
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@TableName("jifenduihuan")
public class JifenduihuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JifenduihuanEntity() {
		
	}
	
	public JifenduihuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 礼品名称
	 */
					
	private String lipinmingcheng;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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
