package az.developia.bookshopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
//
//	@Autowired
//	private DataSource dataSource;

//	@Bean
//	public UserDetailsService userDetailsService() {
//		JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
//		jdbcDaoImpl.setDataSource(dataSource);
//		return jdbcDaoImpl;
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests().requestMatchers(HttpMethod.GET, "/").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/show-login").loginProcessingUrl("/authenticate-user")
				.permitAll().and().logout().and().httpBasic().and().build();

	}

}