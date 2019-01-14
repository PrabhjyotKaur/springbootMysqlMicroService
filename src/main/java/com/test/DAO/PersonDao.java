/**
 * 
 */
package com.test.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.test.pojo.Person;

/**
 * @author pprab
 *
 */
@Repository
public class PersonDao {

	public Person getPersonDetails (Long id) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con  = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database1?useSSL=false","root","root");
	     Statement s=con.createStatement();
	     ResultSet rs=s.executeQuery("select * from person");
	     while(rs.next())
	     {
	      System.out.println(rs.getString(1)+" "+rs.getString(2));
	    }
		return null;
	}

}
