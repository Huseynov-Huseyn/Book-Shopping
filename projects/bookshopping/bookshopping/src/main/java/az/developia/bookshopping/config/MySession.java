package az.developia.bookshopping.config;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import az.developia.bookshopping.model.BasketBook;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySession {
	private String username;
	private List<BasketBook> basketBooks;

	public MySession() {
		System.out.println("MYSESSION CONSTRACTOR");
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@PostConstruct
	public void initSession() {
		System.out.println("My session InIt");
	}

	@PreDestroy
	public void destroySession() {
		System.out.println("My session Destroy");
	}

	public List<BasketBook> getBasketBooks() {
		return basketBooks;
	}

	public void setBasketBooks(List<BasketBook> basketBooks) {
		this.basketBooks = basketBooks;
	}

}
