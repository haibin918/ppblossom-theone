package com.meicai.ppblossom.theone.commons.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
@Component
public interface BaseMapper<T, P, ID> {

    public T getById(ID id);

    public List<T> getByIds(List<ID> ids);

    public Integer selectCount(@Param("tb") P p);

    public List<T> select(@Param("tb") P p, @Param("sort") LinkedHashMap<String, String> sort,
                          @Param("offset") Integer offset, @Param("limit") Integer limit);

    public List<T> select(@Param("tb") P p, @Param("sort") LinkedHashMap<String, String> sort);

    public Integer insert(T t);

    public Integer insertNotNull(T t);

    public Integer insertBatch(List<T> list);

    public Integer updateById(@Param("tb") T t, @Param("id") ID id);

    public Integer delete(T t);

    public Integer deleteById(ID id);

    public Integer deleteByIds(List<ID> list);

    public List<T> selectElse(@Param("tb") T t, @Param("sort") LinkedHashMap<String, String> sort,
                              @Param("offset") Integer offset, @Param("limit") Integer limit);

    public Integer selectCountElse(@Param("tb") T t);
}