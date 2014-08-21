package domain_pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import domain_exception.FileParsingException;

public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 804656414835371297L;
	private Integer order_nbr;
	private Date order_date;
	private Date required_date;
	private Date shipped_date;
	private String status;
	private String comments;
	private Integer customer_number;
	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	public Orders(String[] Record) throws FileParsingException {
		this.order_nbr = Integer.parseInt(Record[0]);
		try {
			if (Record[1].equals("0"))
				Record[1] = "0001-01-01";
			if (Record[2].equals("0"))
				Record[2] = "0001-01-01";
			if (Record[3].equals("0"))
				Record[3] = "0001-01-01";
			
			this.order_date =  formatter.parse(Record[1]);
			this.required_date = formatter.parse(Record[2]);
			this.shipped_date = formatter.parse(Record[3]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new FileParsingException(e,e.getMessage());
		}

		this.status = Record[4];
		this.comments = Record[5];
		this.customer_number = Integer.parseInt(Record[6]);
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOrder_nbr() {
		return order_nbr;
	}

	public void setOrder_nbr(Integer order_nbr) {
		this.order_nbr = order_nbr;
	}

	public String getOrder_date() {
		return formatter.format(order_date);
	}

	public void setOrder_date(String order_date) throws ParseException {
		this.order_date = formatter.parse(order_date);
	}

	public String getRequired_date() {
		return formatter.format(required_date);
	}

	public void setRequired_date(String required_date) throws ParseException {
		this.required_date = formatter.parse(required_date);
	}

	public String getShipped_date() {
		return formatter.format(shipped_date);
	}

	public void setShipped_date(String shipped_date) throws ParseException {
		this.shipped_date = formatter.parse(shipped_date);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(Integer customer_number) {
		this.customer_number = customer_number;
	}

	@Override
	public String toString() {
		return "Orders [order_nbr=" + order_nbr + ", order_date=" + order_date
				+ ", required_date=" + required_date + ", shipped_date="
				+ shipped_date + ", status=" + status + ", comments="
				+ comments + ", customer_number=" + customer_number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((customer_number == null) ? 0 : customer_number.hashCode());
		result = prime * result
				+ ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result
				+ ((order_nbr == null) ? 0 : order_nbr.hashCode());
		result = prime * result
				+ ((required_date == null) ? 0 : required_date.hashCode());
		result = prime * result
				+ ((shipped_date == null) ? 0 : shipped_date.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Orders other = (Orders) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (customer_number == null) {
			if (other.customer_number != null)
				return false;
		} else if (!customer_number.equals(other.customer_number))
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_nbr == null) {
			if (other.order_nbr != null)
				return false;
		} else if (!order_nbr.equals(other.order_nbr))
			return false;
		if (required_date == null) {
			if (other.required_date != null)
				return false;
		} else if (!required_date.equals(other.required_date))
			return false;
		if (shipped_date == null) {
			if (other.shipped_date != null)
				return false;
		} else if (!shipped_date.equals(other.shipped_date))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
