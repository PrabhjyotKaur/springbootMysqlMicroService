/**
 * 
 */
package com.test.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.DAO.PersonDao;
import com.test.pojo.Person;

/**
 * @author pprab
 *
 */
@Service
public class PersonService {
	@Autowired PersonDao personDao;

	public Person getPersonDetails(Long id) throws SQLException,ClassNotFoundException{
		// TODO Auto-generated method stub
		Person p1=new Person();
		p1 = personDao.getPersonDetails(id);
		return null;
	}

}
