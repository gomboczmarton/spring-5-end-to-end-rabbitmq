package biz.gomboczmarton.microservice.customerprofileservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
    @Autowired
    CustomerRegistrar customerRegistrar;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    Mono<Customer> register(@RequestBody Customer customer) {
        System.out.println("New customer registration request with name: " + customer.getName() + " and email: " + customer.getEmail());
        return customerRegistrar.register(customer);
    }
}
