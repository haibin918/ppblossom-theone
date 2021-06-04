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
 * 表名称：d_group_logistics_expenses
 * 表注释：客户物流费用表
 * 类型：table
 * @author：guohaibin@meicai.cn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DgroupLogisticsExpensesEntity  implements Serializable  {
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
	 * 列类型：bigint(20)
	 * 默认值：0
	 * 列的数据类型的长度：19.0
	 * 列注释：账单id
	 * 列的扩展：
	 * 列名：bill_id
	 * 列的数据类型：bigint
	 * 是否是主键：否
	 */
	//@JsonProperty("bill_id")
	private Long billId;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11)
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：费用分类id
	 * 列的扩展：
	 * 列名：expenses_class_id
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("expenses_class_id")
	private Integer expensesClassId;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(100)
	 * 默认值：
	 * 列的数据类型的长度：100
	 * 列注释：费用分类名称
	 * 列的扩展：
	 * 列名：expenses_class_name
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("expenses_class_name")
	private String expensesClassName;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11)
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：费用名称id
	 * 列的扩展：
	 * 列名：expenses_name_id
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("expenses_name_id")
	private Integer expensesNameId;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(100)
	 * 默认值：
	 * 列的数据类型的长度：100
	 * 列注释：费用名称
	 * 列的扩展：
	 * 列名：expenses_name
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("expenses_name")
	private String expensesName;	
	
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
	 * 列类型：decimal(12,2)
	 * 默认值：0.00
	 * 列的数据类型的长度：12.2
	 * 列注释：应收款项
	 * 列的扩展：
	 * 列名：amount_receivable
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("amount_receivable")
	private BigDecimal amountReceivable;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11) unsigned
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：业务开始时间
	 * 列的扩展：
	 * 列名：business_start
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("business_start")
	private Integer businessStart;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11) unsigned
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：业务结束时间
	 * 列的扩展：
	 * 列名：business_end
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("business_end")
	private Integer businessEnd;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11)
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：状态0未结算1结算中2已结算
	 * 列的扩展：
	 * 列名：status
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("status")
	private Integer status;	
	
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

	
	public Long getBillId(){
		return this.billId;
	}
	
	public void setBillId(Long billId){
		this.billId = billId;
	}

	
	public Integer getExpensesClassId(){
		return this.expensesClassId;
	}
	
	public void setExpensesClassId(Integer expensesClassId){
		this.expensesClassId = expensesClassId;
	}

	
	public String getExpensesClassName(){
		return this.expensesClassName;
	}
	
	public void setExpensesClassName(String expensesClassName){
		this.expensesClassName = expensesClassName;
	}

	
	public Integer getExpensesNameId(){
		return this.expensesNameId;
	}
	
	public void setExpensesNameId(Integer expensesNameId){
		this.expensesNameId = expensesNameId;
	}

	
	public String getExpensesName(){
		return this.expensesName;
	}
	
	public void setExpensesName(String expensesName){
		this.expensesName = expensesName;
	}

	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	
	public BigDecimal getAmountReceivable(){
		return this.amountReceivable;
	}
	
	public void setAmountReceivable(BigDecimal amountReceivable){
		this.amountReceivable = amountReceivable;
	}

	
	public Integer getBusinessStart(){
		return this.businessStart;
	}
	
	public void setBusinessStart(Integer businessStart){
		this.businessStart = businessStart;
	}

	
	public Integer getBusinessEnd(){
		return this.businessEnd;
	}
	
	public void setBusinessEnd(Integer businessEnd){
		this.businessEnd = businessEnd;
	}

	
	public Integer getStatus(){
		return this.status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
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
	public  DgroupLogisticsExpensesEntity deepClone() {
		DgroupLogisticsExpensesEntity entity = new DgroupLogisticsExpensesEntity();
		entity.setId(this.getId());
		entity.setGroupId(this.getGroupId());
		entity.setBillId(this.getBillId());
		entity.setExpensesClassId(this.getExpensesClassId());
		entity.setExpensesClassName(this.getExpensesClassName());
		entity.setExpensesNameId(this.getExpensesNameId());
		entity.setExpensesName(this.getExpensesName());
		entity.setRemark(this.getRemark());
		entity.setAmountReceivable(this.getAmountReceivable());
		entity.setBusinessStart(this.getBusinessStart());
		entity.setBusinessEnd(this.getBusinessEnd());
		entity.setStatus(this.getStatus());
		entity.setCt(this.getCt());
		entity.setUt(this.getUt());
		entity.setIsDeleted(this.getIsDeleted());
		return entity;
	}

	@Override
	public String toString() {
		return "DgroupLogisticsExpensesEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"groupId\":" + this.getGroupId() +","
        	+ " \"billId\":" + this.getBillId() +","
        	+ " \"expensesClassId\":" + this.getExpensesClassId() +","
        	+ " \"expensesClassName\":\"" + this.getExpensesClassName() +"\","
        	+ " \"expensesNameId\":" + this.getExpensesNameId() +","
        	+ " \"expensesName\":\"" + this.getExpensesName() +"\","
        	+ " \"remark\":\"" + this.getRemark() +"\","
        	+ " \"amountReceivable\":" + this.getAmountReceivable() +","
        	+ " \"businessStart\":" + this.getBusinessStart() +","
        	+ " \"businessEnd\":" + this.getBusinessEnd() +","
        	+ " \"status\":" + this.getStatus() +","
        	+ " \"ct\":" + this.getCt() +","
        	+ " \"ut\":" + this.getUt() +","
        	+ " \"isDeleted\":" + this.getIsDeleted() +""
		+"}";
	}
}