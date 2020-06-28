package com.hp.mapper;

import com.hp.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    //selectAll
    @Select("select * from h_users where role='房东'")
    List<User> selectAll();
}
