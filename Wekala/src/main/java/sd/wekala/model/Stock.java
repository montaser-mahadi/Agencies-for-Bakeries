package sd.wekala.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "stockName")
	private String stockName;

	@Column(name = "stockLocation")
	private String stockLocation;

	@Column(name = "personMan")
	private String personMan;

	@Column(name = "phone")
	private String phone;

	/** The Product. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "s")
	private List<Product> product;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String stockName, String stockLocation, String personMan, String phone, List<Product> product) {
		super();
		this.stockName = stockName;
		this.stockLocation = stockLocation;
		this.personMan = personMan;
		this.phone = phone;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockLocation() {
		return stockLocation;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}

	public String getPersonMan() {
		return personMan;
	}

	public void setPersonMan(String personMan) {
		this.personMan = personMan;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
