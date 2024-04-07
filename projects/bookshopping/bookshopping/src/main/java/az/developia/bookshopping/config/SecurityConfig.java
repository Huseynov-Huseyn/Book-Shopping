package az.developia.bookshopping.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
		jdbcDao.setDataSource(dataSource);
		return jdbcDao;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests().requestMatchers(HttpMethod.GET, "/").permitAll()
				.requestMatchers(HttpMethod.GET, "/create-account").permitAll()
				.requestMatchers(HttpMethod.POST, "/create-account-process").permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/show-login").loginProcessingUrl("/authenticate-user").permitAll().and()
				.logout().and().httpBasic().and().build();

	}

}