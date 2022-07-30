package sd.wekala.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "paymentMethod")
	private String paymentMethod;

	@Column(name = "Depite")
	private String depite;

	@Column(name = "credite")
	private String credite;

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(String paymentMethod, String depite, String credite) {
		super();
		this.paymentMethod = paymentMethod;
		this.depite = depite;
		this.credite = credite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDepite() {
		return depite;
	}

	public void setDepite(String depite) {
		this.depite = depite;
	}

	public String getCredite() {
		return credite;
	}

	public void setCredite(String credite) {
		this.credite = credite;
	}

}
