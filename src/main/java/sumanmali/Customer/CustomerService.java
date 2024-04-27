package sumanmali.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sumanmali.exception.DupicateEmailException;
import sumanmali.exception.ResourrceNotFoundException;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.selectCustomer();
    }

    public Customer getAllCustomersById(Integer id) {
        return customerDAO.selectCustomerByID(id).orElseThrow(
                () -> new ResourrceNotFoundException("Customer with id [%s] not found".formatted(
                        id)));

    }

    public void addCustomer(customerRestrationRequest customerRestrationRequest) {
        // check is email exits if it deosnt't we add the user
        String email = customerRestrationRequest.email();
        if (customerDAO.existPersonwithEmail(email)) {
            throw new DupicateEmailException("email [%s] already taken".formatted(
                    email));

        }

        // add the customer
        Customer customer = new Customer(
                customerRestrationRequest.name(),
                customerRestrationRequest.email(),
                customerRestrationRequest.age());
        customerDAO.insertCustomer(customer);

    }
}
