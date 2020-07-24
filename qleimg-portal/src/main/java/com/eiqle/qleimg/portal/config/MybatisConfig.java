package com.eiqle.qleimg.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.eiqle.qleimg.portal.dao"})
public class MybatisConfig {
}
