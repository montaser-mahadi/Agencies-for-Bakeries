package sd.wekala.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Expenses")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "expensesName")
	private String expensesName;

	@Column(name = "expensesDate")
	private Date expensesDate;

	@Column(name = "expensesTotal")
	private Double expensesTotal;

	@Column(name = "expensesComment")
	private String expensesComment;

	public Expenses() {
		super();
	}

	public Expenses(String expensesName, Date expensesDate, Double expensesTotal, String expensesComment) {
		super();
		this.expensesName = expensesName;
		this.expensesDate = expensesDate;
		this.expensesTotal = expensesTotal;
		this.expensesComment = expensesComment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExpensesName() {
		return expensesName;
	}

	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}

	public Date getExpensesDate() {
		return expensesDate;
	}

	public void setExpensesDate(Date expensesDate) {
		this.expensesDate = expensesDate;
	}

	public Double getExpensesTotal() {
		return expensesTotal;
	}

	public void setExpensesTotal(Double expensesTotal) {
		this.expensesTotal = expensesTotal;
	}

	public String getExpensesComment() {
		return expensesComment;
	}

	public void setExpensesComment(String expensesComment) {
		this.expensesComment = expensesComment;
	}
}
