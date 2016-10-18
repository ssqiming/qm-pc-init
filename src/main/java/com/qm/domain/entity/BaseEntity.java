package com.qm.domain.entity;

import java.io.Serializable;

/** 
 * @ClassName: BaseEntity 
 * @Description: 实体基础类 
 * @author caizhen
 * @date 2015年7月27日 下午10:46:24  
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 4034437877924885763L;
	protected Long id;
	protected Integer state;
	protected String createUserId;
	protected String createTime;
	protected String updateUserId;
	protected String updateTime;
	protected Integer deleted=0;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
}
