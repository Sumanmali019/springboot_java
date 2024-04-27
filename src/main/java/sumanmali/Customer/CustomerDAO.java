package sumanmali.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> selectCustomer();

    Optional<Customer> selectCustomerByID(Integer Id);

    void insertCustomer(Customer customer);

    boolean existPersonwithEmail(String email);

    boolean existPersonwithById(Integer id);

    void deleteCustomer(Integer id);

    void updateCustomer(Customer update);
}
