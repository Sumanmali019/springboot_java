package sumanmali.Customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sumanmali.Customer.DAO.CustomerDAO;
import sumanmali.Customer.model.Customer;
import sumanmali.Customer.model.update_request.CustomerUpdateRequest;
import sumanmali.Customer.model.update_request.customerRestrationRequest;
import sumanmali.exception.DupicateEmailException;
import sumanmali.exception.RequestValidException;
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

    public void deleteCustomerById(Integer customerId) {
        if (!customerDAO.existPersonwithById(customerId)) {
            throw new DupicateEmailException("Id [%s] not present".formatted(
                    customerId));
        }
        customerDAO.deleteCustomer(customerId);
    }

    public Customer getCustomer(Integer id) {
        return customerDAO.selectCustomerByID(id).orElseThrow(
                () -> new ResourrceNotFoundException("Id [%s] not present".formatted(
                        id)));
    }

    public void updateCustomer(Integer customerId, CustomerUpdateRequest updateRequest) {
        Customer customer = getCustomer(customerId);
        boolean change = false;
        if (updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            change = true;
        }
        if (updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())) {
            customer.setAge(updateRequest.age());
            change = true;
        }
        if (updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())) {
            if (customerDAO.existPersonwithEmail(updateRequest.email())) {
                throw new DupicateEmailException("email already taken");
            }
            customer.setEmail(updateRequest.email());
            change = true;
        }
        if (!change) {
            throw new RequestValidException("No data found");
        }
        customerDAO.updateCustomer(customer);
    }
}
