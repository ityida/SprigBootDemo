package com.example.yida.demo.dao;

import com.example.yida.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
