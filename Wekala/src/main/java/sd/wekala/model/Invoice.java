package sd.wekala.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "invoiceDate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate invoiceDate = LocalDate.now().plusDays(1);

	@Column(name = "paymentMethod")
	private String paymentMethod;

	@Column(name = "invoiceNumber")
	private String invoiceNumber;

	@Column(name = "invoiceUser")
	private String invoiceUser;

	@Column(name = "invoiceTotal")
	private Double invoiceTotal;

	@Column(name = "invoicePayed")
	private Double invoicePayed;

	@Column(name = "invoicePlus")
	private Double invoicePlus;

	@Column(name = "qty")
	private int qty;

	/** The Client. */
	@NotNull
	@ManyToOne
	private Client c;

	/** The Product. */
	// @NotNull
	@ManyToOne
	private Product p;

	public Invoice() {
	}

	public Invoice(LocalDate invoiceDate, String paymentMethod, String invoiceNumber, String invoiceUser,
			Double invoiceTotal, Double invoicePayed, Double invoicePlus, int qty, @NotNull Client c, Product p) {
		super();
		this.invoiceDate = invoiceDate;
		this.paymentMethod = paymentMethod;
		this.invoiceNumber = invoiceNumber;
		this.invoiceUser = invoiceUser;
		this.invoiceTotal = invoiceTotal;
		this.invoicePayed = invoicePayed;
		this.invoicePlus = invoicePlus;
		this.qty = qty;
		this.c = c;
		this.p = p;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceUser() {
		return invoiceUser;
	}

	public void setInvoiceUser(String invoiceUser) {
		this.invoiceUser = invoiceUser;
	}

	public Double getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(Double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public Double getInvoicePayed() {
		return invoicePayed;
	}

	public void setInvoicePayed(Double invoicePayed) {
		this.invoicePayed = invoicePayed;
	}

	public Double getInvoicePlus() {
		return invoicePlus;
	}

	public void setInvoicePlus(Double invoicePlus) {
		this.invoicePlus = invoicePlus;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

}
