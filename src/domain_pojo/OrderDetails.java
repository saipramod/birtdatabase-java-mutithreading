package domain_pojo;

public class OrderDetails {

	private Integer order_number;
	private String product_code;
	private Integer quantity_ordered;
	private Float price_each;
	private Integer order_line_number;

	public OrderDetails(Integer order_number, String product_code,
			Integer quantity_ordered, Float price_each,
			Integer order_line_number) {
		super();
		this.order_number = order_number;
		this.product_code = product_code;
		this.quantity_ordered = quantity_ordered;
		this.price_each = price_each;
		this.order_line_number = order_line_number;
	}

	public Integer getOrder_number() {
		return order_number;
	}

	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public Integer getQuantity_ordered() {
		return quantity_ordered;
	}

	public void setQuantity_ordered(Integer quantity_ordered) {
		this.quantity_ordered = quantity_ordered;
	}

	public Float getPrice_each() {
		return price_each;
	}

	public void setPrice_each(Float price_each) {
		this.price_each = price_each;
	}

	public Integer getOrder_line_number() {
		return order_line_number;
	}

	public void setOrder_line_number(Integer order_line_number) {
		this.order_line_number = order_line_number;
	}

	@Override
	public String toString() {
		return "OrderDetails [order_number=" + order_number + ", product_code="
				+ product_code + ", quantity_ordered=" + quantity_ordered
				+ ", price_each=" + price_each + ", order_line_number="
				+ order_line_number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((order_line_number == null) ? 0 : order_line_number
						.hashCode());
		result = prime * result
				+ ((order_number == null) ? 0 : order_number.hashCode());
		result = prime * result
				+ ((price_each == null) ? 0 : price_each.hashCode());
		result = prime * result
				+ ((product_code == null) ? 0 : product_code.hashCode());
		result = prime
				* result
				+ ((quantity_ordered == null) ? 0 : quantity_ordered.hashCode());
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
		OrderDetails other = (OrderDetails) obj;
		if (order_line_number == null) {
			if (other.order_line_number != null)
				return false;
		} else if (!order_line_number.equals(other.order_line_number))
			return false;
		if (order_number == null) {
			if (other.order_number != null)
				return false;
		} else if (!order_number.equals(other.order_number))
			return false;
		if (price_each == null) {
			if (other.price_each != null)
				return false;
		} else if (!price_each.equals(other.price_each))
			return false;
		if (product_code == null) {
			if (other.product_code != null)
				return false;
		} else if (!product_code.equals(other.product_code))
			return false;
		if (quantity_ordered == null) {
			if (other.quantity_ordered != null)
				return false;
		} else if (!quantity_ordered.equals(other.quantity_ordered))
			return false;
		return true;
	}

}
