package com.example.yida.demo.controller;

import com.example.yida.demo.common.utils.BCryptUtil;
import com.example.yida.demo.pojo.User;
import com.example.yida.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Resource
    UserService userService;

    @Test
    public void saveUser() {
        User user = new User();
        user.setId(5L);
        user.setUserName("dami");
        user.setLoginName("damimi");
        user.setPassWord(BCryptUtil.encode("111111"));

        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setId(6L);
        user1.setLoginName("11");
        userService.saveUser(user1);

    }

    @Test
    public void findAll() {
        List<User> all = (List<User>) userService.findAll();
        System.out.println(all);
    }

    @Test
    public void testBCrypt() {
        boolean a = BCryptUtil.matches("111111", "$2a$10$HnvTNjNGvEA08JhM1MQpVeOe5pfdhn3iMkSQ4LcgJKex7fwbNhhMC");
        boolean b = BCryptUtil.matches("111111", "$2a$10$9rs5TQNtNjoS22zPFViHXeO264DvKh.RWLezj8gpI0loLrBO7m4km");
        boolean c = BCryptUtil.matches("111111", "$2a$10$nfL1mE1gVwl3rwCC7q/AzuESuzEuTaijlokyRZhboh/OIaFezs0F6");

        System.out.println("======================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("======================");
    }
}