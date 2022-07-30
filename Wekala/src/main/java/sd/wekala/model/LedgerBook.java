package sd.wekala.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LadgerBook")

public class LedgerBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "credit")
	private Double credit;

	@Column(name = "depited")
	private Double depited;

	@Column(name = "trasactionName")
	private String trasactionName;

	public LedgerBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LedgerBook(Double credit, Double depited, String trasactionName) {
		super();
		this.credit = credit;
		this.depited = depited;
		this.trasactionName = trasactionName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Double getDepited() {
		return depited;
	}

	public void setDepited(Double depited) {
		this.depited = depited;
	}

	public String getTrasactionName() {
		return trasactionName;
	}

	public void setTrasactionName(String trasactionName) {
		this.trasactionName = trasactionName;
	}

}
