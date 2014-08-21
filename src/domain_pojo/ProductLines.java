package domain_pojo;

public class ProductLines {

	private String product_line;
	private String text_description;
	private String html_desciption;
	private String image;

	public ProductLines(String product_line, String text_description,
			String html_desciption, String image) {
		this.product_line = product_line;
		this.text_description = text_description;
		this.html_desciption = html_desciption;
		this.image = image;
	}

	public String getProduct_line() {
		return product_line;
	}

	public void setProduct_line(String product_line) {
		this.product_line = product_line;
	}

	public String getText_description() {
		return text_description;
	}

	public void setText_description(String text_description) {
		this.text_description = text_description;
	}

	public String getHtml_desciption() {
		return html_desciption;
	}

	public void setHtml_desciption(String html_desciption) {
		this.html_desciption = html_desciption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductLines [product_line=" + product_line
				+ ", text_description=" + text_description
				+ ", html_desciption=" + html_desciption + ", image=" + image
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((html_desciption == null) ? 0 : html_desciption.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result
				+ ((product_line == null) ? 0 : product_line.hashCode());
		result = prime
				* result
				+ ((text_description == null) ? 0 : text_description.hashCode());
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
		ProductLines other = (ProductLines) obj;
		if (html_desciption == null) {
			if (other.html_desciption != null)
				return false;
		} else if (!html_desciption.equals(other.html_desciption))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (product_line == null) {
			if (other.product_line != null)
				return false;
		} else if (!product_line.equals(other.product_line))
			return false;
		if (text_description == null) {
			if (other.text_description != null)
				return false;
		} else if (!text_description.equals(other.text_description))
			return false;
		return true;
	}

}
