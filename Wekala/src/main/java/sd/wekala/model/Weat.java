package sd.wekala.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weat")
public class Weat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "weatName")
	private String weatName;

	@Column(name = "weatType")
	private String weatType;

	@Column(name = "weatLocation")
	private String weatLocation;

	@Column(name = "weatPhone")
	private String weatPhone;

	public Weat() {
		super();
	}

	public Weat(String weatName, String weatType, String weatLocation, String weatPhone) {
		super();
		this.weatName = weatName;
		this.weatType = weatType;
		this.weatLocation = weatLocation;
		this.weatPhone = weatPhone;
	}

	public String getWeatName() {
		return weatName;
	}

	public void setWeatName(String weatName) {
		this.weatName = weatName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWeatType() {
		return weatType;
	}

	public void setWeatType(String weatType) {
		this.weatType = weatType;
	}

	public String getWeatLocation() {
		return weatLocation;
	}

	public void setWeatLocation(String weatLocation) {
		this.weatLocation = weatLocation;
	}

	public String getWeatPhone() {
		return weatPhone;
	}

	public void setWeatPhone(String weatPhone) {
		this.weatPhone = weatPhone;
	}
}
