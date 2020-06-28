package com.hp.mapper;

import com.hp.pojo.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeMapper {
    @Select("select * from h_type")
    List<Type> selectAll();
}
