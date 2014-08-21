package domain_pojo;

import java.io.Serializable;

public class Employees implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2966374310424083864L;
	private Integer employee_number;
	private String last_name;
	private String first_name;
	private String extension;
	private String email;
	private Integer office_code;
	private String reports_to;
	private String job_title;

	public Employees(String[] Record) {
		super();
		this.employee_number = Integer.parseInt(Record[0]);
		this.last_name = Record[1];
		this.first_name = Record[2];
		this.extension = Record[3];
		this.email = Record[4];
		this.office_code = Integer.parseInt(Record[5]);
		this.reports_to = Record[6];
		this.job_title = Record[7];
	}

	public Employees() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployee_number() {
		return employee_number;
	}

	public void setEmployee_number(Integer employee_number) {
		this.employee_number = employee_number;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOffice_code() {
		return office_code;
	}

	public void setOffice_code(Integer office_code) {
		this.office_code = office_code;
	}

	public String getReports_to() {
		return reports_to;
	}

	public void setReports_to(String reports_to) {
		this.reports_to = reports_to;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	@Override
	public String toString() {
		return "Employees [employee_number=" + employee_number + ", last_name="
				+ last_name + ", first_name=" + first_name + ", extension="
				+ extension + ", email=" + email + ", office_code="
				+ office_code + ", reports_to=" + reports_to + ", job_title="
				+ job_title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((employee_number == null) ? 0 : employee_number.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result
				+ ((job_title == null) ? 0 : job_title.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result
				+ ((office_code == null) ? 0 : office_code.hashCode());
		result = prime * result
				+ ((reports_to == null) ? 0 : reports_to.hashCode());
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
		Employees other = (Employees) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employee_number == null) {
			if (other.employee_number != null)
				return false;
		} else if (!employee_number.equals(other.employee_number))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (job_title == null) {
			if (other.job_title != null)
				return false;
		} else if (!job_title.equals(other.job_title))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (office_code == null) {
			if (other.office_code != null)
				return false;
		} else if (!office_code.equals(other.office_code))
			return false;
		if (reports_to == null) {
			if (other.reports_to != null)
				return false;
		} else if (!reports_to.equals(other.reports_to))
			return false;
		return true;
	}

}
