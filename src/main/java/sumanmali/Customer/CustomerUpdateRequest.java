package sumanmali.Customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age) {

}