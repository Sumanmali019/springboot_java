package sumanmali;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


     
    // @Bean
    // CommandLineRunner runner(CustomerReposerty customerReposerty) {

        // return args -> {
        //     Customer suman = new Customer(
        //             "suman",
        //             "suman019@gmail.com",
        //             27);

        //     Customer alex = new Customer(
        //             "alex",
        //             "alex@gmail.com",
        //             21);

        //     Customer sam = new Customer(

        //             "sam",
        //             "sam@sam.com",
        //             20);

        //     List<Customer> customers = List.of(suman, alex, sam);
        //     customerReposerty.saveAll(customers);
        // };
    }

// }

/*
 * N-TEIR ARCHETURCTURE
 * 
 * CONTROLLER ( API -LAYER)
 * |
 * SERVICE LAYER ( BUSNINESS LAYER )
 * |
 * DATA ASSESS LAYER (DAO LAYER)
 * |
 * DATA BASE
 * 
 *
 */