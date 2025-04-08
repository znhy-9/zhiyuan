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
 * 志愿活动
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-07 19:25:23
 */
@TableName("zhiyuanhuodong")
public class ZhiyuanhuodongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhiyuanhuodongEntity() {
		
	}
	
	public ZhiyuanhuodongEntity(T t) {
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
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 服务人数
	 */
					
	private String fuwurenshu;
	
	/**
	 * 服务时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fuwushijian;
	
	/**
	 * 服务地点
	 */
					
	private String fuwudidian;
	
	/**
	 * 活动积分
	 */
					
	private Integer zhiyuanjifen;
	
	/**
	 * 报名要求
	 */
					
	private String baomingyaoqiu;
	
	/**
	 * 活动详情
	 */
					
	private String huodongxiangqing;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 评论数
	 */
					
	private Integer discussnum;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：服务人数
	 */
	public void setFuwurenshu(String fuwurenshu) {
		this.fuwurenshu = fuwurenshu;
	}
	/**
	 * 获取：服务人数
	 */
	public String getFuwurenshu() {
		return fuwurenshu;
	}
	/**
	 * 设置：服务时间
	 */
	public void setFuwushijian(Date fuwushijian) {
		this.fuwushijian = fuwushijian;
	}
	/**
	 * 获取：服务时间
	 */
	public Date getFuwushijian() {
		return fuwushijian;
	}
	/**
	 * 设置：服务地点
	 */
	public void setFuwudidian(String fuwudidian) {
		this.fuwudidian = fuwudidian;
	}
	/**
	 * 获取：服务地点
	 */
	public String getFuwudidian() {
		return fuwudidian;
	}
	/**
	 * 设置：活动积分
	 */
	public void setZhiyuanjifen(Integer zhiyuanjifen) {
		this.zhiyuanjifen = zhiyuanjifen;
	}
	/**
	 * 获取：活动积分
	 */
	public Integer getZhiyuanjifen() {
		return zhiyuanjifen;
	}
	/**
	 * 设置：报名要求
	 */
	public void setBaomingyaoqiu(String baomingyaoqiu) {
		this.baomingyaoqiu = baomingyaoqiu;
	}
	/**
	 * 获取：报名要求
	 */
	public String getBaomingyaoqiu() {
		return baomingyaoqiu;
	}
	/**
	 * 设置：活动详情
	 */
	public void setHuodongxiangqing(String huodongxiangqing) {
		this.huodongxiangqing = huodongxiangqing;
	}
	/**
	 * 获取：活动详情
	 */
	public String getHuodongxiangqing() {
		return huodongxiangqing;
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
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
