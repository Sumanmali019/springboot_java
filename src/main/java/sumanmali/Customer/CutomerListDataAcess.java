package sumanmali.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository("list")
public class CutomerListDataAcess implements CustomerDAO {

    // db
    private static List<Customer> customers;
    static {
        customers = new ArrayList<>();

        Customer suman = new Customer(
                1,
                "suman",
                "suman019@gmail.com",
                27);
        customers.add(suman);
        Customer alex = new Customer(
                2,
                "alex",
                "alex@gmail.com",
                21);
        customers.add(alex);
        Customer paul = new Customer(
                3,
                "paul",
                "paul@gmail.com",
                25);
        customers.add(paul);
    }

    @Override
    public List<Customer> selectCustomer() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerByID(Integer id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();

    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existPersonwithEmail(String email) {
        return customers.stream().anyMatch(c -> c.getEmail().equals(email));
    }

}
