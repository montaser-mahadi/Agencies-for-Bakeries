package sd.wekala.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String productTypeName;

	@Column(length = 45, nullable = false, unique = true)
	private String productTypeBrand;

	/** The Product. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pro")
	private List<Product> product;

	public ProductType() {
	}

	public ProductType(String productTypeName, String productTypeBrand, List<Product> product) {
		super();
		this.productTypeName = productTypeName;
		this.productTypeBrand = productTypeBrand;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductTypeBrand() {
		return productTypeBrand;
	}

	public void setProductTypeBrand(String productTypeBrand) {
		this.productTypeBrand = productTypeBrand;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
