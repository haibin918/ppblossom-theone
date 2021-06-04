package com.meicai.ppblossom.theone.biz.logistics.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
/**		
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_bill
 * 表注释：客户物流账单表
 * 类型：table
 * @author：guohaibin@meicai.cn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DgroupLogisticsBillEntity  implements Serializable  {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：bigint(20) unsigned
	 * 默认值：
	 * 列的数据类型的长度：20.0
	 * 列注释：主键
	 * 列的扩展：auto_increment
	 * 列名：id
	 * 列的数据类型：bigint
	 * 是否是主键：是
	 */
	//@JsonProperty("id")
	private Long id;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11)
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：客户id
	 * 列的扩展：
	 * 列名：group_id
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("group_id")
	private Integer groupId;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：decimal(15,2)
	 * 默认值：0.00
	 * 列的数据类型的长度：15.2
	 * 列注释：应收金额
	 * 列的扩展：
	 * 列名：amount_receivable
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("amount_receivable")
	private BigDecimal amountReceivable;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11)
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：状态0未审核1已审核
	 * 列的扩展：
	 * 列名：status
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("status")
	private Integer status;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11) unsigned
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：审核时间
	 * 列的扩展：
	 * 列名：audit_time
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("audit_time")
	private Integer auditTime;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(200)
	 * 默认值：
	 * 列的数据类型的长度：200
	 * 列注释：备注
	 * 列的扩展：
	 * 列名：remark
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("remark")
	private String remark;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：bigint(20) unsigned
	 * 默认值：0
	 * 列的数据类型的长度：20.0
	 * 列注释：创建时间
	 * 列的扩展：
	 * 列名：c_t
	 * 列的数据类型：bigint
	 * 是否是主键：否
	 */
	//@JsonProperty("c_t")
	private Long ct;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：bigint(20) unsigned
	 * 默认值：0
	 * 列的数据类型的长度：20.0
	 * 列注释：修改时间
	 * 列的扩展：
	 * 列名：u_t
	 * 列的数据类型：bigint
	 * 是否是主键：否
	 */
	//@JsonProperty("u_t")
	private Long ut;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：tinyint(2)
	 * 默认值：0
	 * 列的数据类型的长度：3.0
	 * 列注释：是否生效 0：有效；1：无效；
	 * 列的扩展：
	 * 列名：is_deleted
	 * 列的数据类型：tinyint
	 * 是否是主键：否
	 */
	//@JsonProperty("is_deleted")
	private Integer isDeleted;	

	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	
	public Integer getGroupId(){
		return this.groupId;
	}
	
	public void setGroupId(Integer groupId){
		this.groupId = groupId;
	}

	
	public BigDecimal getAmountReceivable(){
		return this.amountReceivable;
	}
	
	public void setAmountReceivable(BigDecimal amountReceivable){
		this.amountReceivable = amountReceivable;
	}

	
	public Integer getStatus(){
		return this.status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}

	
	public Integer getAuditTime(){
		return this.auditTime;
	}
	
	public void setAuditTime(Integer auditTime){
		this.auditTime = auditTime;
	}

	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	
	public Long getCt(){
		return this.ct;
	}
	
	public void setCt(Long ct){
		this.ct = ct;
	}

	
	public Long getUt(){
		return this.ut;
	}
	
	public void setUt(Long ut){
		this.ut = ut;
	}

	
	public Integer getIsDeleted(){
		return this.isDeleted;
	}
	
	public void setIsDeleted(Integer isDeleted){
		this.isDeleted = isDeleted;
	}


	/**
	* 深度复制
	*/
	public  DgroupLogisticsBillEntity deepClone() {
		DgroupLogisticsBillEntity entity = new DgroupLogisticsBillEntity();
		entity.setId(this.getId());
		entity.setGroupId(this.getGroupId());
		entity.setAmountReceivable(this.getAmountReceivable());
		entity.setStatus(this.getStatus());
		entity.setAuditTime(this.getAuditTime());
		entity.setRemark(this.getRemark());
		entity.setCt(this.getCt());
		entity.setUt(this.getUt());
		entity.setIsDeleted(this.getIsDeleted());
		return entity;
	}

	@Override
	public String toString() {
		return "DgroupLogisticsBillEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"groupId\":" + this.getGroupId() +","
        	+ " \"amountReceivable\":" + this.getAmountReceivable() +","
        	+ " \"status\":" + this.getStatus() +","
        	+ " \"auditTime\":" + this.getAuditTime() +","
        	+ " \"remark\":\"" + this.getRemark() +"\","
        	+ " \"ct\":" + this.getCt() +","
        	+ " \"ut\":" + this.getUt() +","
        	+ " \"isDeleted\":" + this.getIsDeleted() +""
		+"}";
	}
}