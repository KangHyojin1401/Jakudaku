package passionx3.jkdk.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {
	int categoryId;
	String name;
	
	public Category() {
	}

	public Category(int categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
