package biz.gomboczmarton.microservice.customerprofileservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerprofileserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerprofileserviceApplication.class, args);
    }


    /**
     * Run specific code when an application is fully started by interfaces that get called just before run() once SpringApplication completed.
     */
    @Bean
    CommandLineRunner init(CustomerRepository repo) {
        return (evt) -> {
            repo.save(createCustomer("Adam", "adam@boot.com"));
            repo.save(createCustomer("John", "john@boot.com"));
            repo.save(createCustomer("Smith", "smith@boot.com"));
            repo.save(createCustomer("Edgar", "edgar@boot.com"));
            repo.save(createCustomer("Martin", "martin@boot.com"));
        };
    }

    private Customer createCustomer(String name, String email) {
        return Customer.builder()
                .name(name)
                .email(email)
                .build();
    }
}
