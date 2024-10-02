package spring.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("nameA", 10000);
        statefulService2.order("nameB", 20000);

        // ThreadA : 사용자A가 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(10000);
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000); // test 성공 : 실제로 A는 10000원인데.. 2만원으로 나옴.
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}