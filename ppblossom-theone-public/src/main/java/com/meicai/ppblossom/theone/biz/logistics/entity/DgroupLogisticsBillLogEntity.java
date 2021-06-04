package com.meicai.ppblossom.theone.biz.logistics.entity;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
/**		
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_bill_log
 * 表注释：客户物流账单日志表
 * 类型：table
 * @author：guohaibin@meicai.cn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DgroupLogisticsBillLogEntity  implements Serializable  {
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
	 * 列类型：varchar(500)
	 * 默认值：
	 * 列的数据类型的长度：500
	 * 列注释：操作参数
	 * 列的扩展：
	 * 列名：operator_param
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("operator_param")
	private String operatorParam;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(500)
	 * 默认值：
	 * 列的数据类型的长度：500
	 * 列注释：操作文档
	 * 列的扩展：
	 * 列名：operator_text
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("operator_text")
	private String operatorText;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：bigint(20)
	 * 默认值：0
	 * 列的数据类型的长度：19.0
	 * 列注释：操作人id
	 * 列的扩展：
	 * 列名：operator_id
	 * 列的数据类型：bigint
	 * 是否是主键：否
	 */
	//@JsonProperty("operator_id")
	private Long operatorId;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(30)
	 * 默认值：
	 * 列的数据类型的长度：30
	 * 列注释：操作人名称
	 * 列的扩展：
	 * 列名：operator_name
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("operator_name")
	private String operatorName;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11)
	 * 默认值：0
	 * 列的数据类型的长度：10.0
	 * 列注释：操作类型1新增2编辑3审核
	 * 列的扩展：
	 * 列名：operator_type
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("operator_type")
	private Integer operatorType;	
	
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

	
	public Long getBillId(){
		return this.billId;
	}
	
	public void setBillId(Long billId){
		this.billId = billId;
	}

	
	public String getOperatorParam(){
		return this.operatorParam;
	}
	
	public void setOperatorParam(String operatorParam){
		this.operatorParam = operatorParam;
	}

	
	public String getOperatorText(){
		return this.operatorText;
	}
	
	public void setOperatorText(String operatorText){
		this.operatorText = operatorText;
	}

	
	public Long getOperatorId(){
		return this.operatorId;
	}
	
	public void setOperatorId(Long operatorId){
		this.operatorId = operatorId;
	}

	
	public String getOperatorName(){
		return this.operatorName;
	}
	
	public void setOperatorName(String operatorName){
		this.operatorName = operatorName;
	}

	
	public Integer getOperatorType(){
		return this.operatorType;
	}
	
	public void setOperatorType(Integer operatorType){
		this.operatorType = operatorType;
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
	public  DgroupLogisticsBillLogEntity deepClone() {
		DgroupLogisticsBillLogEntity entity = new DgroupLogisticsBillLogEntity();
		entity.setId(this.getId());
		entity.setBillId(this.getBillId());
		entity.setOperatorParam(this.getOperatorParam());
		entity.setOperatorText(this.getOperatorText());
		entity.setOperatorId(this.getOperatorId());
		entity.setOperatorName(this.getOperatorName());
		entity.setOperatorType(this.getOperatorType());
		entity.setCt(this.getCt());
		entity.setUt(this.getUt());
		entity.setIsDeleted(this.getIsDeleted());
		return entity;
	}

	@Override
	public String toString() {
		return "DgroupLogisticsBillLogEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"billId\":" + this.getBillId() +","
        	+ " \"operatorParam\":\"" + this.getOperatorParam() +"\","
        	+ " \"operatorText\":\"" + this.getOperatorText() +"\","
        	+ " \"operatorId\":" + this.getOperatorId() +","
        	+ " \"operatorName\":\"" + this.getOperatorName() +"\","
        	+ " \"operatorType\":" + this.getOperatorType() +","
        	+ " \"ct\":" + this.getCt() +","
        	+ " \"ut\":" + this.getUt() +","
        	+ " \"isDeleted\":" + this.getIsDeleted() +""
		+"}";
	}
}