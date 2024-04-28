package sumanmali.Customer.DAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import sumanmali.Customer.DAO.CustomerDAO;
import sumanmali.Customer.model.Customer;

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

    @Override
    public boolean existPersonwithById(Integer id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(customers::remove);
    }

    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);
    }
}
