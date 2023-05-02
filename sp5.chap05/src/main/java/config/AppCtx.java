package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages= {"spring"}) 
//component로 자동 스캔을 통해 빈을 지웠기 때문에 
//spring 패키지에 있는 자동주입대상을 스캔해서 사용한다는 것을 정의해야함
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
		
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	

}
