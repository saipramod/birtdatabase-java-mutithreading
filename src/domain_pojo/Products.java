package domain_pojo;

public class Products {

	private Integer product_code;
	private String product_name;
	private String product_line;
	private String product_scale;
	private String product_vendor;
	private String produc_description;
	private Integer quantity_in_stock;
	private Double buy_price;

	public Products(Integer product_code, String product_name,
			String product_line, String product_scale, String product_vendor,
			String produc_description, Integer quantity_in_stock,
			Double buy_price) {
		super();
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_line = product_line;
		this.product_scale = product_scale;
		this.product_vendor = product_vendor;
		this.produc_description = produc_description;
		this.quantity_in_stock = quantity_in_stock;
		this.buy_price = buy_price;
	}

	public Integer getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Integer product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_line() {
		return product_line;
	}

	public void setProduct_line(String product_line) {
		this.product_line = product_line;
	}

	public String getProduct_scale() {
		return product_scale;
	}

	public void setProduct_scale(String product_scale) {
		this.product_scale = product_scale;
	}

	public String getProduct_vendor() {
		return product_vendor;
	}

	public void setProduct_vendor(String product_vendor) {
		this.product_vendor = product_vendor;
	}

	public String getProduc_description() {
		return produc_description;
	}

	public void setProduc_description(String produc_description) {
		this.produc_description = produc_description;
	}

	public Integer getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setQuantity_in_stock(Integer quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	public Double getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(Double buy_price) {
		this.buy_price = buy_price;
	}

	@Override
	public String toString() {
		return "Products [product_code=" + product_code + ", product_name="
				+ product_name + ", product_line=" + product_line
				+ ", product_scale=" + product_scale + ", product_vendor="
				+ product_vendor + ", produc_description=" + produc_description
				+ ", quantity_in_stock=" + quantity_in_stock + ", buy_price="
				+ buy_price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((buy_price == null) ? 0 : buy_price.hashCode());
		result = prime
				* result
				+ ((produc_description == null) ? 0 : produc_description
						.hashCode());
		result = prime * result
				+ ((product_code == null) ? 0 : product_code.hashCode());
		result = prime * result
				+ ((product_line == null) ? 0 : product_line.hashCode());
		result = prime * result
				+ ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result
				+ ((product_scale == null) ? 0 : product_scale.hashCode());
		result = prime * result
				+ ((product_vendor == null) ? 0 : product_vendor.hashCode());
		result = prime
				* result
				+ ((quantity_in_stock == null) ? 0 : quantity_in_stock
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (buy_price == null) {
			if (other.buy_price != null)
				return false;
		} else if (!buy_price.equals(other.buy_price))
			return false;
		if (produc_description == null) {
			if (other.produc_description != null)
				return false;
		} else if (!produc_description.equals(other.produc_description))
			return false;
		if (product_code == null) {
			if (other.product_code != null)
				return false;
		} else if (!product_code.equals(other.product_code))
			return false;
		if (product_line == null) {
			if (other.product_line != null)
				return false;
		} else if (!product_line.equals(other.product_line))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (product_scale == null) {
			if (other.product_scale != null)
				return false;
		} else if (!product_scale.equals(other.product_scale))
			return false;
		if (product_vendor == null) {
			if (other.product_vendor != null)
				return false;
		} else if (!product_vendor.equals(other.product_vendor))
			return false;
		if (quantity_in_stock == null) {
			if (other.quantity_in_stock != null)
				return false;
		} else if (!quantity_in_stock.equals(other.quantity_in_stock))
			return false;
		return true;
	}

}
