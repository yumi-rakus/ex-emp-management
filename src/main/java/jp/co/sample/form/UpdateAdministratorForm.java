package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpdateAdministratorForm {
	
	
	private String id;
	
	@NotBlank(message = "名前を入力してください")
	private String name;
	
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="Emailの形式が不正です")
	private String mailAddress;
	
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	
	
	//getter setter
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

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "UpdateAdministratorForm [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password="
				+ password + "]";
	}
	
	

}
