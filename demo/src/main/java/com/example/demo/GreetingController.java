package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// add annotation to GreetingController to convert it to Rest Controller component
@RestController
public class GreetingController {
	
// final = constant, always allocate to the new memory area
	//static = constant variable eg. x++
	private static final String template = "Hello,%s!";
	private final AtomicLong counter = new AtomicLong(); // new --> initialization
	
	//define GreetingComponent Variable without initialization
	private GreetingComponent g;
	
	//inject/initialize GreetingComponent in the Constructor
	@Autowired
	public GreetingController(GreetingComponent g) {
		this.g =g;
		
	}
	
	// Test the Greeting Component
	@GetMapping("/testgreeting")
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok(g.getMessage());
		
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
		
	}
	
	@GetMapping("/add/{num1}/{num2}")
	public int addTwoNumbers(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {
		return num1+num2;
		
	}
	
	@GetMapping("/sub/{num1},{num2}") //not recommend, should consistent to use /	
	public int subTwoNumbers(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {
		return num1-num2;
		
	}
	
}
