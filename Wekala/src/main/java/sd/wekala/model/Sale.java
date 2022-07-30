package sd.wekala.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productType")
	private String productType;

	@Column(name = "purchasePrice")
	private Double purchasePrice;

	@Column(name = "salePrice")
	private Double salePrice;

	@Column(name = "stock")
	private String stock;

	@Column(name = "createBy")
	private String user;

	@Column(name = "createdAt")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt = LocalDate.now().plusDays(1);

	@Column(name = "invoiceNumber")
	private String invoiceNumber;

	public Sale() {
	}

	public Sale(String productName, String productType, Double purchasePrice, Double salePrice, String stock,
			String user, LocalDate createdAt, String invoiceNumber) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.stock = stock;
		this.user = user;
		this.createdAt = createdAt;
		this.invoiceNumber = invoiceNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
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

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

}
