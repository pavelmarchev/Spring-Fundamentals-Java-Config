import com.pafkata.model.Customer;
import com.pafkata.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    // testing some laziness and purity with FRP (Functional Reactive Programming):

    // Given numbers n and k, compute the total sum of sqrt of the first k even numbers starting from n to k:
    public static double compute(int n, int k) {
        int index = n;
        int count = 0;
        double result = 0;

        while (count < k) {
            if (index % 2 == 0) {
                result += Math.sqrt(index);
                count++;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {

        //loose coupling from hardcoded implementation of CustomerRepository. Spring's job is to inject the impl by xml configuration
//        CustomerService service = new CustomerServiceImpl();

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

//        CustomerService service = appContext.getBean("customerService", CustomerService.class);
        CustomerService service = appContext.getBean("customerService", CustomerService.class);

        // test if it is singleton:
        System.out.println(service);
        CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
        System.out.println(service2); // if this is the same address, customerService bean is singleton

        System.out.println(service.findAll().get(0).getFirstName()); // "happy path testing" - the simplest temporary testing possible
    }
}
