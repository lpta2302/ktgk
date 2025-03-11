package bit.ueh.user_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import bit.ueh.user_service.entity.CCCD;
import bit.ueh.user_service.repository.CCCDRepository;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
    CommandLineRunner initData(CCCDRepository cccdRepository) {
        return args -> {
			CCCD cccd = new CCCD(null, "123456789", "Nguyen Van A", "01/01/1990", "Ho Chi Minh");
			cccdRepository.save(cccd);
			System.out.println("✅ CCCD added: " + cccd.getCccdNumber());
			
			CCCD cccd2 = new CCCD(null, "987654321", "Tran Thi B", "02/02/1995", "Ha Noi");
			cccdRepository.save(cccd2);
			System.out.println("✅ CCCD added: " + cccd2.getCccdNumber());
        };
    }
}
