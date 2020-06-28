package com.hp.mapper;

import com.hp.pojo.District;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictMapper {
    //1.查询所有的城区 did=1   //2.根据城区查询对应的街道 did=？
    @Select("select * from h_district where parentId=#{did}")
    @Results(@Result(column = "dis_name",property = "disName"))
    List<District> selectDisArea(Integer did);
}
