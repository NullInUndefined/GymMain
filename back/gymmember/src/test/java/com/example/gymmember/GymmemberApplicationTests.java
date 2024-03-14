package com.example.gymmember;

import com.example.dao.memberDao;
import com.example.dao.userDao;
import com.example.dao.venueDao;
import com.example.model.user;
import com.example.service.memberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class GymmemberApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("name","zhangsan");
    }


    @Autowired
    DataSource dataSource;
    @Test
    void testDBcon() throws SQLException {
        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
    }

    @Autowired
    memberDao md;
    @Autowired
    memberService memS;

    @Autowired
    userDao usDao;
    @Test
    void testmemshow(){
        System.out.println(usDao.selectUserPassword("G1234567"));
        user us=new user();
        us.setAccount("G1234561");
        us.setType("Member");
        us.setPasswd("123");
        usDao.insert(us);
    }

    @Autowired
    private venueDao vend;
    @Test
    void testvenGetAll(){
        System.out.println(vend.findAll());
    }

}
