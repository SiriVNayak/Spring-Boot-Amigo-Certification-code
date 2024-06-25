package com.amigo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//
//import com.amigo.AmigosCodeApplication.NewCustomerRequesr;
//import com.amigo.AmigosCodeApplication.UpdateCustomerRequesr;

public class CustomerController {
	private final CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	@GetMapping
	public List<Customer> getCustomer() {
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") Integer id) {
		return customerRepository.findById(id);
	}

	record NewCustomerRequesr(String name, String email, Integer age) {
	}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequesr request) {
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id) {
		customerRepository.deleteById(id);
	}

	@DeleteMapping
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
	}

	record UpdateCustomerRequesr(String name, String email, Integer age) {
	}

	@PutMapping("/{id}")
	public void updateCustomer(@PathVariable("id") Integer id,
			@RequestBody UpdateCustomerRequesr updateR) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customer.setName(updateR.name());
			customer.setEmail(updateR.email());
			customer.setAge(updateR.age());
			customerRepository.save(customer);
		}
	}
//	@PutMapping("/{id}")
//	public void updateCustomer(@PathVariable("id") Integer id, @RequestBody UpdateCustomerRequesr updateR) {
//		Optional<Customer> optionalCustomer = customerRepository.findById(id);
//		 if (optionalCustomer.isPresent()) {
//			Customer customer = new Customer();
//			customer.setName(updateR.name());
//			customer.setEmail(updateR.email());
//			customer.setAge(updateR.age());
//			customerRepository.save(customer);
//		}
//	}
//	@PutMapping("/{id}")
//	public void updateCustomer(@PathVariable("id") Integer id, @RequestBody UpdateCustomerRequesr updateR) {
//		Customer customer = new Customer();
//		customer.setId(id);
//		customer.setName(updateR.name());
//		customer.setEmail(updateR.email());
//		customer.setAge(updateR.age());
//		customerRepository.save(customer);
//	}
}

//@GetMapping("/greet")
//public String greet() {
//public GreetResponse greet() {
//	GreetResponse response = new GreetResponse(
//			"Hello World",
//			List.of("Java", "JavaScript", "React", "Node"),
//			new Person("Nayak", 25, 3000000));
//	return response;
//}
//
//record Person(String name, int age, double savings) {
//};
//
//record GreetResponse(String greet, List<String> favProgrammingLanguage, Person person) {
//};

//record GreetResponse(String greet) {};
//class GreetResponse{
//	private final String greet;
//	GreetResponse(String greet){
//		this.greet=greet;
//	}
//
//	public String getGreet() {
//		return greet;
//	}
//
//	@Override
//	public String toString() {
//		return "GreetResponse [greet=" + greet + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + getEnclosingInstance().hashCode();
//		result = prime * result + Objects.hash(greet);
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		GreetResponse other = (GreetResponse) obj;
//		if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
//			return false;
//		return Objects.equals(greet, other.greet);
//	}
//
//	private AmigosCodeApplication getEnclosingInstance() {
//		return AmigosCodeApplication.this;
//	}
//}