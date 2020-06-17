package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InsertAdministratorForm {

	/**
	 * 名前
	 */
	@NotBlank(message="氏名を入力してください")
	private String name;

	/**
	 * メールアドレス
	 */
	@Size(min=1, max=127, message="メールアドレスを入力してください")
	@Email(message="Emailの形式が不正です")
	private String mailAddress;

	/**
	 * パスワード
	 */
	@NotBlank(message="パスワードを入力してください")
	private String password;

	// getter setter
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

	// toString
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

}
