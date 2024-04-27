package sumanmali.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReposerty extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Integer id);
}
