package com.ssafy.board.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.ssafy.board.model.mapper"
)
public class DatabaseConfig {

}
