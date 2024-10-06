package spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
/*
@ComponentScan을 붙이면 @Component가 붙은 클래스를 스캔해서 스프링빈으로 등록
 + @configuration을 붙인 설정정보도 자동으로 등록
=> 설정정보를 제외ㅏㅎ게 만듦.
 */
public class AutoAppConfig {

}
