/**
 * This class is used to make mysql db connection and allowing  
 */
package com.test.dbconnection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author pprab
 *
 */
@Configuration
@PropertySource(value = "classpath:/${spring.profiles.active}/app.properties")
@EnableTransactionManagement
public class DbConfig {
	// This is one approach to get values from external properties file using file system
	
	/*
	 * Properties props = new Properties(); FileInputStream in = new
	 * FileInputStream("/external/configuration/dir/db.properties"); props.load(in);
	 * in.close(); String driver = props.getProperty("jdbc.driver");
	 */

	@Value("${jdbc.driver}")
	public String driver;

	@Value("${jdbc.url}")
	public String url;

	@Value("${jdbc.username}")
	public String username;

	@Value("${jdbc.password}")
	public String password;

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DataSource dataSource = DataSourceBuilder.create().username(username).password(password).url(url)
				.driverClassName(driver).build();
		return dataSource;
	}
	
	@Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
    {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		return dataSourceInitializer;
    }

}
