package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class UpdateEmployeeForm {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 名前
	 */
	@NotBlank(message = "名前を入力してください")
	private String name;

	/**
	 * 画像
	 */
	private String image;

	/**
	 * 性別
	 */
	@NotBlank(message = "性別を選んでください")
	private String gender;

	/**
	 * 入社日（年）
	 */
	@Pattern(regexp = "[1-2][0-9]{3}", message = "年：半角数字4桁を入力してください")
	@NotBlank(message = "年を入力してください")
	private String hireYear;

	/**
	 * 入社日（月）
	 */
	@Pattern(regexp = "[1-9]|1[0-2]", message = "月：1~12の半角数字を入力してください")
	@NotBlank(message = "月を入力してください")
	private String hireMonth;

	/**
	 * 入社日（日）
	 */
	@Pattern(regexp = "[1-9]|[12][0-9]|3[01]", message = "日：1~31の半角数字を入力してください")
	@NotBlank(message = "日を入力してください")
	private String hireDay;

	/**
	 * メールアドレス
	 */
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="Emailの形式が不正です")
	private String mailAddress;

	/**
	 * 郵便番号
	 */
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}$", message="(半角数字3桁)-(半角数字4桁)で入力してください")
	private String zipCode;

	/**
	 * 住所
	 */
	@NotBlank(message="住所を入力してください")
	private String address;

	/**
	 * 電話番号
	 */
	@Pattern(regexp="^0[789]0-[0-9]{4}-[0-9]{4}$", message="(半角数字3桁)-(半角数字4桁)で入力してください")
	private String telephone;

	/**
	 * 給料
	 */
	@NotBlank(message = "給料を入力してください")
	@Pattern(regexp = "[0-9]+", message = "半角数字を入力してください")
	private String salary;

	/**
	 * 特性
	 */
	@NotBlank(message = "特性を入力してください")
	private String characteristics;

	/**
	 * 扶養人数
	 */

	@Pattern(regexp = "[0-9]+", message = "半角数字を入力してください")
	@NotBlank(message = "扶養人数を入力してください")
	private String dependentsCount;

	// getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	public String getHireYear() {
		return hireYear;
	}

	public void setHireYear(String hireYear) {
		this.hireYear = hireYear;
	}

	public String getHireMonth() {
		return hireMonth;
	}

	public void setHireMonth(String hireMonth) {
		this.hireMonth = hireMonth;
	}

	public String getHireDay() {
		return hireDay;
	}

	public void setHireDay(String hireDay) {
		this.hireDay = hireDay;
	}

	// toString
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender
				+ ", hireYear=" + hireYear + ", hireMonth=" + hireMonth + ", hireDay=" + hireDay + ", mailAddress="
				+ mailAddress + ", zipCode=" + zipCode + ", address=" + address + ", telephone=" + telephone
				+ ", salary=" + salary + ", characteristics=" + characteristics + ", dependentsCount=" + dependentsCount
				+ "]";
	}

}
