package edu.mum.dream.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.dream.domain.CreditCard; 
import edu.mum.dream.service.CreditCardService;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@PostMapping
	public void save(@RequestBody CreditCard creditCard) {
		creditCardService.save(creditCard);
	}

	@PutMapping
	public CreditCard update(@RequestBody CreditCard creditCard) {
		return creditCardService.update(creditCard);
	}

	@GetMapping
	public List<CreditCard> findAll() {
		return creditCardService.findAll();
	}

	@GetMapping("/{id}")
	public CreditCard findOne(@PathVariable Long id) {
		return creditCardService.findOne(id);
	}
	
}
