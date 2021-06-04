package com.meicai.ppblossom.theone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.meicai.ppblossom.theone.*.mapper", "com.meicai.ppblossom.theone.biz.*.mapper"})
@ImportResource({"classpath:spring-dubbo.xml", "classpath:dubbo-consumer.xml", "classpath:dubbo-provider.xml"})
public class PPBlossomTheoneMainApplication {

    public static void main(String[] args) {
        System.setProperty("java.specification.version", "1.8");
        SpringApplication.run(PPBlossomTheoneMainApplication.class, args);
    }

}
