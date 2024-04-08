package az.developia.bookshopping.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
	@Size(min = 1, message = "Istifadəçi adı min 1 simvol olmalıdır!")
	@Size(max = 30, message = "Istifadəçi adı max 30 simvol olmalıdır!")
	@NotEmpty(message = "Boş qoymaq olmaz!")
	@Id
	private String username;

	@Size(min = 1, message = "Şifrə min 1 simvol olmalıdır!")
	@Size(max = 30, message = "Şifrə max 30 simvol olmalıdır!")
	@NotEmpty(message = "Boş qoymaq olmaz!")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
