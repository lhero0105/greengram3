package com.green.greengram3;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션을 아래와 같이 생성합니다. 컨트롤러에서 사용할거입니다.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AutoConfigureMockMvc
@Import( {MockMvcConfig.MockMvc.class } ) // 몰라도 되는 내용들 입니다.
public @interface MockMvcConfig {

    class MockMvc{
        @Bean
        MockMvcBuilderCustomizer utf8Config(){
            return (builder) ->
                builder.addFilter(new CharacterEncodingFilter("UTF-8", true));
        }
    }
}
