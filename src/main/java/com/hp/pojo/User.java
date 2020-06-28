package com.hp.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "h_users")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer uid;
    private String name;
    private  String psw;
    private String sex;
    private Date brith;
    private String headimg;
    private String role;
}
