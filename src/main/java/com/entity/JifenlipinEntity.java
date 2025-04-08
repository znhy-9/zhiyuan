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
 * 积分礼品
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@TableName("jifenlipin")
public class JifenlipinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JifenlipinEntity() {
		
	}
	
	public JifenlipinEntity(T t) {
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
	 * 礼品编号
	 */
					
	private String lipinbianhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	
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
	 * 设置：礼品编号
	 */
	public void setLipinbianhao(String lipinbianhao) {
		this.lipinbianhao = lipinbianhao;
	}
	/**
	 * 获取：礼品编号
	 */
	public String getLipinbianhao() {
		return lipinbianhao;
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
