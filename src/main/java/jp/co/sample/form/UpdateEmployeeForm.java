package jp.co.sample.form;

public class UpdateEmployeeForm {

	/**
	 * 従業員ID
	 */
	private String id;

	/**
	 * 扶養人数
	 */
	private String dependentsCount;

	// getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	// toString
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

}
