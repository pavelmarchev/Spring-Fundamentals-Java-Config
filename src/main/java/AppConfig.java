import com.pafkata.repository.CustomerRepository;
import com.pafkata.repository.HibernateCustomerRepositoryImpl;
import com.pafkata.service.CustomerService;
import com.pafkata.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.pafkata"}) //for autowiring
public class AppConfig {

    /*
    @Bean(name = "customerService") // instead of this, you could use a @Service in the injected class
    public CustomerService getCustomerervice() {
        // setter injection
        CustomerServiceImpl service =  new CustomerServiceImpl();
//        service.setCustomerRepository(getCustomerRepositort()); //autowiring does not need this line
        //Constructor injection
//        CustomerServiceImpl service =  new CustomerServiceImpl(getCustomerRepositort());
        return service;
    }
    */

    /*
    @Bean(name = "customerRepository") // instead of this, you could use a @Repository in the injectable class
    public CustomerRepository getCustomerRepositort() {
        return new HibernateCustomerRepositoryImpl();
    }
    */
}
