package biz.gomboczmarton.microservice.customerprofileservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Lazy
public class CustomerRegistrar {
    CustomerRepository customerRepository;
    Sender sender;

    @Autowired
    CustomerRegistrar(CustomerRepository customerRepository, Sender sender) {
        this.customerRepository = customerRepository;
        this.sender = sender;
    }

    // ideally repository will return a Mono object
    public Mono<Customer> register(Customer customer) {
        if (customerRepository
                .findByName(customer.getName())
                .isPresent())
            System.out.println("Duplicate Customer. No Action required");
        else {
            customerRepository.save(customer);
            sender.send(customer.getEmail());
        }
        return Mono.just(customer); //HARD CODED BECOSE THERE IS NO REACTIVE REPOSITORY.
    }
}
