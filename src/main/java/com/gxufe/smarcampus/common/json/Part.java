package com.gxufe.smarcampus.common.json;

public class Part {
	private Integer id;
	private String partName;
	private String partDescription;
	private String remark;
	
	public Part() {
		super();
	}
	public Part(Integer id, String partName, String partDescription,
			String remark) {
		super();
		this.id = id;
		this.partName = partName;
		this.partDescription = partDescription;
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
