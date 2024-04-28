package sumanmali.Customer.DAS;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import sumanmali.Customer.DAO.CustomerDAO;
import sumanmali.Customer.model.Customer;
import sumanmali.Customer.reposistory.CustomerReposerty;

@Repository("jpa")
public class CustormerJPADataAcessService implements CustomerDAO {

    private final CustomerReposerty customerReposerty;

    public CustormerJPADataAcessService(CustomerReposerty customerReposerty) {
        this.customerReposerty = customerReposerty;
    }

    @Override
    public List<Customer> selectCustomer() {
        return customerReposerty.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerByID(Integer Id) {
        return customerReposerty.findById(Id);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerReposerty.save(customer);
    }

    @Override
    public boolean existPersonwithEmail(String email) {
        return customerReposerty.existsCustomerByEmail(email);

    }

    @Override
    public boolean existPersonwithById(Integer id) {
        return customerReposerty.existsCustomerById(id);
    }

    @Override
    public void deleteCustomer(Integer customerid) {
        customerReposerty.deleteById(customerid);
    }

    @Override
    public void updateCustomer(Customer update) {
        customerReposerty.save(update);
    }

}
