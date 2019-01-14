/**
 * 
 */
package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.pojo.Person;
import com.test.service.PersonService;

/**
 * @author pprab
 *
 */

@RestController
@RequestMapping(value="/svc/person")
public class PersonController {
	@Autowired PersonService personService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET, produces = "application/json")
	public Person getPerson(@PathVariable Long id){
		Person p1=new Person();
		try {
		p1 = personService.getPersonDetails(id);
		}
		 catch(Exception ex) 
        { 
            System.err.println(ex); 
        } 

		return p1;
	}
}
