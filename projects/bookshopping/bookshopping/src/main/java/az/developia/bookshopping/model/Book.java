package az.developia.bookshopping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	@Size(min = 2, message = "Ad min 2 simvoldan ibarət olmalıdır!")
	@Size(max = 30, message = "Ad max 30 simvoldan ibarət olmalıdır!")
	@Column(columnDefinition = "VARCHAR(30)")
	private String name;
	@Column(columnDefinition = "VARCHAR(300)")
	@Size(max = 300, message = "Təsvir max 300 simvoldan ibarət olmalıdır!")
	private String description;
	@Min(value = 0, message = "Qiymət min 0 ola bilər!")
	@Max(value = 1000, message = "Qiymət max 1000 ola bilər!")
	@NotNull(message = "Boş qoymaq olmaz!")
	private double price;
	@Column(columnDefinition = "VARCHAR(50)")
	@Size(max = 50, message = "Müəllif adı max 50 simvoldan ibarət olmalıdır!")
	private String author;
	@Min(value = 0, message = "Səhifə sayı min 0 ola bilər!")
	@Max(value = 10000, message = "Səhifə sayı max 10000 ola bilər!")
	private Integer pageCount;
	private String image;
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", author="
				+ author + ", pageCount=" + pageCount + ", image=" + image + ", username=" + username + "]";
	}

}