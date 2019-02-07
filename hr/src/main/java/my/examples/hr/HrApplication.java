package my.examples.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import javax.xml.crypto.Data;


// 자동으로 생성된 어플리케이션은 설정파일이자 메인메소드를 가지고 있는 자바클래스이다.


@SpringBootApplication
public class HrApplication implements CommandLineRunner {// 2. commadlinerunner를 사용하여 static main메소드의 args를 사용하려고 한다.

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) { // 1. static  이 붙지않은 필드는 사용할 수 없다. 그래서 dataSource를 사용 못함
        SpringApplication.run(HrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { //... 가변형 필드   3. 을 오버라이딩해서 dataSource를 사용
        if(dataSource != null){
            System.out.println(dataSource.getClass().getName()); // com.zaxxer.hikari.HikariDataSource 출력
            /* @EnableAutoConfiguration 이 붙어있으면 autoconfig에서 자동설정을 불러오고 때문에 hikari로 만들어진다.
               key로 설정된 설정을 불러온다.
               DataSourceAutoConfiguration 가 자동설정으로 hikariDataSource가 빈으로 등록된다.
               @ConditionalOnClass({HikariDataSource.class}) - HikariDataSource.class가 있을 경우
               @ConditionalOnMissingBean - DataSource를 구현하는 빈을 사용자가 직접 등록하지 않았을 경우
            */
        }
        System.out.println("run 메소드 실행");
    }
}

