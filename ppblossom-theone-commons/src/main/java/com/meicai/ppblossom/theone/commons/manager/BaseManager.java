package com.meicai.ppblossom.theone.commons.manager;

import java.util.LinkedHashMap;
import java.util.List;

public interface BaseManager<T, P, ID> {
    /**
     * 保存
     * @param object
     * @author guohaibin@meicai.cn
     * @return
     */
    public int insert(T object);

    /**
     * 保存
     * @param object
     * @author guohaibin@meicai.cn
     * @return
     */
    public int insertNotNull(T object);

    /**
     * 保存
     * @param list
     * @author guohaibin@meicai.cn
     * @return
     */
    public int insertBatch(List<T> list, Class classz);

    /**
     * 修改
     * @param t
     * @param id
     * @author guohaibin@meicai.cn
     * @return
     */
    public int updateById(T t, ID id);

    /**
     * 删除
     * @param object
     * @author guohaibin@meicai.cn
     * @return
     */
    public int delete(T object);

    /**
     * 删除
     * @param id
     * @author guohaibin@meicai.cn
     * @return
     */
    public int deleteById(ID id);

    /**
     * 删除
     * @param ids
     * @author guohaibin@meicai.cn
     * @return
     */
    public int deleteByIds(List<ID> ids);

    /**
     *
     * @param id
     * @author guohaibin@meicai.cn
     * @return
     */
    public T getById(ID id);

    /**
     *
     * @param ids
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> getByIds(List<ID> ids);

    /**
     * 根据条件查询
     * @param object ：查询条件
     * @param sort ：排序规则
     * @param offset ：起始值
     * @param limit ：返回多少条
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> select(P object, LinkedHashMap<String, String> sort, Integer offset, Integer limit);

    /**
     * 分页查询
     * @param object ：查询条件
     * @param offset ：起始值
     * @param limit ：返回多少条
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> select(P object, Integer offset, Integer limit);

    /**
     * 分页查询
     * @param object ：查询条件
     * @param sort ：排序规则
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> select(P object, LinkedHashMap<String, String> sort);

    /**
     * 分页查询
     * @param object ：查询条件
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> select(P object);

    /**
     * 获取总条数
     * @param object
     * @author guohaibin@meicai.cn
     * @return
     */
    public int selectCount(P object);

    /**
     * 根据条件查询
     * @param object ：查询条件
     * @param sort ：排序规则
     * @param offset ：起始值
     * @param limit ：返回多少条
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> selectElse(T object, LinkedHashMap<String, String> sort, Integer offset, Integer limit);

    /**
     * 分页查询
     * @param object ：查询条件
     * @param offset ：起始值
     * @param limit ：返回多少条
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> selectElse(T object, Integer offset, Integer limit);

    /**
     * 分页查询
     * @param object ：查询条件
     * @param sort ：排序规则
     * @author guohaibin@meicai.cn
     * @return
     */
    public List<T> selectElse(T object, LinkedHashMap<String, String> sort);

    /**
     * 获取总条数
     * @param object
     * @author guohaibin@meicai.cn
     * @return
     */
    public int selectCountElse(T object);

}