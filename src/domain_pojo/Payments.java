package domain_pojo;

public class Payments {
	private Integer customer_number;
	private Integer check_number;
	private String payment_date;
	private Integer amount;

	public Payments(Integer customer_number, Integer check_number,
			String payment_date, Integer amount) {
		super();
		this.customer_number = customer_number;
		this.check_number = check_number;
		this.payment_date = payment_date;
		this.amount = amount;
	}

	public Integer getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(Integer customer_number) {
		this.customer_number = customer_number;
	}

	public Integer getCheck_number() {
		return check_number;
	}

	public void setCheck_number(Integer check_number) {
		this.check_number = check_number;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payments [customer_number=" + customer_number
				+ ", check_number=" + check_number + ", payment_date="
				+ payment_date + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((check_number == null) ? 0 : check_number.hashCode());
		result = prime * result
				+ ((customer_number == null) ? 0 : customer_number.hashCode());
		result = prime * result
				+ ((payment_date == null) ? 0 : payment_date.hashCode());
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
		Payments other = (Payments) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (check_number == null) {
			if (other.check_number != null)
				return false;
		} else if (!check_number.equals(other.check_number))
			return false;
		if (customer_number == null) {
			if (other.customer_number != null)
				return false;
		} else if (!customer_number.equals(other.customer_number))
			return false;
		if (payment_date == null) {
			if (other.payment_date != null)
				return false;
		} else if (!payment_date.equals(other.payment_date))
			return false;
		return true;
	}

}
