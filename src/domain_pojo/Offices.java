package domain_pojo;

public class Offices {
	private Integer office_code;
	private String city;
	private String phone;
	private String address_line1;
	private String address_line2;
	private String state;
	private String country;
	private Integer postal_code;
	private String territory;

	public Offices(String office_code, String city, String phone,
			String address_line1, String address_line2, String state,
			String country, String postal_code, String territory) {
		super();
		this.office_code = Integer.parseInt(office_code);
		this.city = city;
		this.phone = phone;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.state = state;
		this.country = country;
		this.postal_code = Integer.parseInt(postal_code);
		this.territory = territory;
	}

	public Integer getOffice_code() {
		return office_code;
	}

	public void setOffice_code(Integer office_code) {
		this.office_code = office_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(Integer postal_code) {
		this.postal_code = postal_code;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	@Override
	public String toString() {
		return "Offices [office_code=" + office_code + ", city=" + city
				+ ", phone=" + phone + ", address_line1=" + address_line1
				+ ", address_line2=" + address_line2 + ", state=" + state
				+ ", country=" + country + ", postal_code=" + postal_code
				+ ", territory=" + territory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address_line1 == null) ? 0 : address_line1.hashCode());
		result = prime * result
				+ ((address_line2 == null) ? 0 : address_line2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((office_code == null) ? 0 : office_code.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((postal_code == null) ? 0 : postal_code.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((territory == null) ? 0 : territory.hashCode());
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
		Offices other = (Offices) obj;
		if (address_line1 == null) {
			if (other.address_line1 != null)
				return false;
		} else if (!address_line1.equals(other.address_line1))
			return false;
		if (address_line2 == null) {
			if (other.address_line2 != null)
				return false;
		} else if (!address_line2.equals(other.address_line2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (office_code == null) {
			if (other.office_code != null)
				return false;
		} else if (!office_code.equals(other.office_code))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postal_code == null) {
			if (other.postal_code != null)
				return false;
		} else if (!postal_code.equals(other.postal_code))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (territory == null) {
			if (other.territory != null)
				return false;
		} else if (!territory.equals(other.territory))
			return false;
		return true;
	}

}
