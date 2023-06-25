package com.example.daoexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})       // 하나의 클래스에 모든 설정 정보를 갖고 있는 게 아니라, DB는 DB 관련 등 따로 나눠서 작성할 거임
public class ApplicationConfig {
}
