package com.mhp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MhpApplication {
    
    private static final Logger log = LoggerFactory.getLogger(MhpApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(MhpApplication.class, args);
        log.info("服务启动成功！");
    }
}

