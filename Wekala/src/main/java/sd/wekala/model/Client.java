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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "clientName")
	@NotNull
	private String clientName;

	@Column(name = "clientPhone")
	@NotNull
	private String clientPhone;

	@Column(name = "clientOwner")
	@NotNull
	private String clientOwner;

	@Column(name = "clientLocation")
	@NotNull
	private String clientLocation;

	/** The Invoice. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "c")
	private List<Invoice> invoice;

	public Client() {
	}

	public Client(@NotNull String clientName, @NotNull String clientPhone, @NotNull String clientOwner,
			@NotNull String clientLocation, List<Invoice> invoice) {
		super();
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.clientOwner = clientOwner;
		this.clientLocation = clientLocation;
		this.invoice = invoice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientOwner() {
		return clientOwner;
	}

	public void setClientOwner(String clientOwner) {
		this.clientOwner = clientOwner;
	}

	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	public List<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}
}
