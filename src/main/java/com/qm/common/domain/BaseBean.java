package com.qm.common.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qm.common.exception.CustomException;

/**
 * Bean基础类
 * 
 * @created 2014-5-19
 * @author  niezhegang
 */
public abstract class BaseBean implements Cloneable, Serializable {
	private static final long serialVersionUID = -3707046914855595598L;

	/**
	 * @see java.lang.Object#hashCode()
	 * @created 2014年5月28日
	 * @author  niezhegang
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @created 2014年5月28日
	 * @author  niezhegang
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * @see java.lang.Object#toString()
	 * @created 2014-5-19
	 * @author  niezhegang
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 浅层复制(如果属性为引用类型则只复制属性的引用值)当前对象
	 * 
	 * @param <T>
	 * @return
	 * @created 2014-5-19
	 * @author  niezhegang
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseBean> T shallowClone() {
		try {
			return (T)clone();
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

}
