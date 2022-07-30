package sd.wekala.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "purchasePrice")
	private Double purchasePrice;

	@Column(name = "salePrice")
	private Double salePrice;

	@Column(name = "qty")
	private int qty;

	@Column(name = "createBy")
	private String user;

	@Column(name = "createdAt")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt = LocalDate.now().plusDays(1);

	/** The Invoice. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "p")
	private List<Invoice> invoice;

	/** The Stock. */
	// @NotNull
	@ManyToOne
	private Stock s;

	/** The ProductTypes. */
	// @NotNull
	@ManyToOne
	private ProductType pro;

	public Product() {
	}

	public Product(String productName, Double purchasePrice, Double salePrice, int qty, String user,
			LocalDate createdAt, List<Invoice> invoice, Stock s, ProductType pro) {
		super();
		this.productName = productName;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.qty = qty;
		this.user = user;
		this.createdAt = createdAt;
		this.invoice = invoice;
		this.s = s;
		this.pro = pro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public List<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}

	public Stock getS() {
		return s;
	}

	public void setS(Stock s) {
		this.s = s;
	}

	public ProductType getPro() {
		return pro;
	}

	public void setPro(ProductType pro) {
		this.pro = pro;
	}
}
