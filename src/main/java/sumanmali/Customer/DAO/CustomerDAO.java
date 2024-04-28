package sumanmali.Customer.DAO;

import java.util.List;
import java.util.Optional;

import sumanmali.Customer.model.Customer;

public interface CustomerDAO {

    List<Customer> selectCustomer();

    Optional<Customer> selectCustomerByID(Integer Id);

    void insertCustomer(Customer customer);

    boolean existPersonwithEmail(String email);

    boolean existPersonwithById(Integer id);

    void deleteCustomer(Integer id);

    void updateCustomer(Customer update);
}
