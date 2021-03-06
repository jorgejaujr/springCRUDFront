package br.jorge.teste2.frontend.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.jorge.teste2.frontend.model.Person;

@Service
public class PersonService {
	
	static final String URL_API_PERSONS = "http://localhost:8080/persons";
	
	RestTemplate restTemplate = new RestTemplate();
	
	public Person[] getPersons() {
		Person[] personResult = restTemplate.getForObject(URL_API_PERSONS, Person[].class);
		System.out.println(personResult);
		return personResult;
	}
	
	public void save(Person person) {
		HttpEntity<Person> requestBody = new HttpEntity<Person>(person);
		person = restTemplate.postForObject(URL_API_PERSONS, requestBody, Person.class);
	}

}
