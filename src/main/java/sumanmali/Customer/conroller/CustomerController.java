package sumanmali.Customer.conroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sumanmali.Customer.model.Customer;
import sumanmali.Customer.model.update_request.CustomerUpdateRequest;
import sumanmali.Customer.model.update_request.customerRestrationRequest;
import sumanmali.Customer.services.CustomerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{customerId}")
    public Customer getCustomersbyID(@PathVariable("customerId") Integer id) {
        return customerService.getAllCustomersById(id);
    }

    @PostMapping
    public void regesterCustomer(@RequestBody customerRestrationRequest request) {
        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer customerId,
    @RequestBody CustomerUpdateRequest updateRequest) 
    {
        customerService.updateCustomer(customerId, updateRequest);
    }

}
