package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * UpdateEmployeeFormをインスタンス化しそのままreturnする。
	 * 
	 * @return UpdateEmployeeFormオブジェクト（自動的にrequestスコープに格納）
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員一覧を出力する。
	 * 
	 * @param model モデルオブジェクト
	 * @return employee/list.html
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {

		List<Employee> employeeList = employeeService.showList();

		model.addAttribute("employeeList", employeeList);

		return "employee/list.html";
	}

	/**
	 * 従業員詳細を出力する。
	 * 
	 * @param id    リクエストパラメータから送られてくる従業員ID
	 * @param model モデルオブジェクト
	 * @return employee/detail.html
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {

		Employee employee = employeeService.showDetail(Integer.parseInt(id));

		model.addAttribute("employee", employee);

		return "employee/detail";
	}
}
