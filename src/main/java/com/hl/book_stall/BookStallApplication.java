package com.hl.book_stall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//TODO
// 扫描dao层接口所在的包，若不添加该注解，则需要在每个Dao类上添加@Mapper注解,为什么这里失效了？
//@MapperScan("com.hl.book_stall.dao")
public class BookStallApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStallApplication.class, args);
    }

}
