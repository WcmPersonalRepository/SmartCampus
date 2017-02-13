package com.gxufe.smarcampus.common;

import java.util.List;

public class PaginationSupport {
	private List items;
	private Integer totalCount;
	private Integer pageSize;
	private Integer startIndex;
	public PaginationSupport(List items,Integer totalCount, Integer pageSize, Integer startIndex) {
		this.items=items;
		this.totalCount=totalCount;
		this.pageSize=pageSize;
		this.startIndex=startIndex;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	
	
}
