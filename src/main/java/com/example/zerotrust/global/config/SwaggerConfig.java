package com.example.zerotrust.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Repoo API") // API의 제목
                .description("Repoo API docs\n이 API는 자체 로그인과 소셜 로그인(구글, 네이버, 카카오)을 지원합니다. 엑세스 토큰과 리프레시 토큰은 Body로 반환됩니다.\n" + "\n" +
                        "소셜 로그인 API 엔드포인트:\n" +
                        "카카오 로그인: /oauth2/authorization/kakao\n" +
                        "네이버 로그인: /oauth2/authorization/naver\n" +
                        "구글 로그인: /oauth2/authorization/google\n\n" +
                        "새로운 유저이면 newUser가 1이고, 기존 유저이면 newUser가 0입니다.") // API에 대한 설명
                .version("0.1"); // API의 버전
    }
}
