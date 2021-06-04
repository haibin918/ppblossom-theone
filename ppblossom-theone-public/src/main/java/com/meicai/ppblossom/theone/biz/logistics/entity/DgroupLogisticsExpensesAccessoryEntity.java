package com.meicai.ppblossom.theone.biz.logistics.entity;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
/**		
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_expenses_accessory
 * 表注释：客户物流费用附件信息表
 * 类型：table
 * @author：guohaibin@meicai.cn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DgroupLogisticsExpensesAccessoryEntity  implements Serializable  {
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
	 * 列注释：物流费用id
	 * 列的扩展：
	 * 列名：expenses_id
	 * 列的数据类型：bigint
	 * 是否是主键：否
	 */
	//@JsonProperty("expenses_id")
	private Long expensesId;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(100)
	 * 默认值：
	 * 列的数据类型的长度：100
	 * 列注释：附件名称
	 * 列的扩展：
	 * 列名：accessory_name
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("accessory_name")
	private String accessoryName;	
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：varchar(100)
	 * 默认值：
	 * 列的数据类型的长度：100
	 * 列注释：附件地址
	 * 列的扩展：
	 * 列名：accessory_path
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("accessory_path")
	private String accessoryPath;	
	
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

	
	public Long getExpensesId(){
		return this.expensesId;
	}
	
	public void setExpensesId(Long expensesId){
		this.expensesId = expensesId;
	}

	
	public String getAccessoryName(){
		return this.accessoryName;
	}
	
	public void setAccessoryName(String accessoryName){
		this.accessoryName = accessoryName;
	}

	
	public String getAccessoryPath(){
		return this.accessoryPath;
	}
	
	public void setAccessoryPath(String accessoryPath){
		this.accessoryPath = accessoryPath;
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
	public  DgroupLogisticsExpensesAccessoryEntity deepClone() {
		DgroupLogisticsExpensesAccessoryEntity entity = new DgroupLogisticsExpensesAccessoryEntity();
		entity.setId(this.getId());
		entity.setExpensesId(this.getExpensesId());
		entity.setAccessoryName(this.getAccessoryName());
		entity.setAccessoryPath(this.getAccessoryPath());
		entity.setCt(this.getCt());
		entity.setUt(this.getUt());
		entity.setIsDeleted(this.getIsDeleted());
		return entity;
	}

	@Override
	public String toString() {
		return "DgroupLogisticsExpensesAccessoryEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"expensesId\":" + this.getExpensesId() +","
        	+ " \"accessoryName\":\"" + this.getAccessoryName() +"\","
        	+ " \"accessoryPath\":\"" + this.getAccessoryPath() +"\","
        	+ " \"ct\":" + this.getCt() +","
        	+ " \"ut\":" + this.getUt() +","
        	+ " \"isDeleted\":" + this.getIsDeleted() +""
		+"}";
	}
}