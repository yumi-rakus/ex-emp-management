package jp.co.sample.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.form.UpdateAdministratorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private HttpSession session;

	/**
	 * InsertAdministratorFormをインスタンス化しそのままreturnする。
	 * 
	 * @return InsertAdministratorFormオブジェクト（自動的にrequestスコープに格納）
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * LoginFormオブジェクトをインスタンス化しそのままreturnする。
	 * 
	 * @return LoginFormオブジェクト（自動的にrequestスコープに格納）
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	@ModelAttribute
	public UpdateAdministratorForm setUpUpdateAdministratorForm() {
		return new UpdateAdministratorForm();
	}

	/**
	 * administrator/insert.htmlにフォワードする。
	 * 
	 * @return administrator/insert.html
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する。
	 * 
	 * @param form フォーム
	 * @return 「/」にリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form, BindingResult result) {

		if (result.hasErrors()) {
			return toInsert();
		}

		Administrator administrator = new Administrator();

		administrator.setName(form.getName());
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());

		administratorService.insert(administrator);

		return "redirect:/";
	}

	/**
	 * administrator/login.htmlにフォワードする。
	 * 
	 * @return administrator/login.html
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {

		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());

		if (administrator == null) {
			model.addAttribute("result", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		} else {
			session.setAttribute("administratorName", administrator.getName());
			session.setAttribute("administratorId", administrator.getId());
			return "forward:/employee/showList";
		}
	}

	/**
	 * ログアウトする。
	 * 
	 * @return 「/」にリダイレクト
	 */
	@RequestMapping("/logout")
	public String logout() {

		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping("/showDetail")
	public String showDetail(Model model, UpdateAdministratorForm form) {

		if (Objects.isNull(administratorService.showDetail((Integer) session.getAttribute("administratorId")))) {
			return toLogin();
		}

		Administrator administrator = administratorService
				.showDetail((Integer) session.getAttribute("administratorId"));

		form.setId(Integer.toString(administrator.getId()));
		form.setName(administrator.getName());
		form.setMailAddress(administrator.getMailAddress());
		form.setPassword(administrator.getPassword());

		model.addAttribute("updateAdministratorForm", form);

		return "administrator/detail";
	}

	@RequestMapping("/update")
	public String update(@Validated UpdateAdministratorForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "administrator/detail";
		}

		Administrator administrator = new Administrator();

		administrator.setId(Integer.parseInt(form.getId()));
		administrator.setName(form.getName());
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());

		session.setAttribute("administratorName", form.getName());

		administratorService.update(administrator);

		return "redirect:/employee/showList";
	}

}
