package sumanmali.Customer.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import sumanmali.Customer.model.Customer;

public interface CustomerReposerty extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Integer id);
}
