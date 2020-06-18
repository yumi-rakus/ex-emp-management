package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public String showDetail(String id, Model model, UpdateEmployeeForm form) {

		Employee employee = employeeService.showDetail(Integer.parseInt(id));

		form.setId(Integer.toString(employee.getId()));
		form.setName(employee.getName());
		form.setImage(employee.getImage());
		form.setGender(employee.getGender());
		form.setHireDate(employee.getHireDate());
		form.setMailAddress(employee.getMailAddress());
		form.setZipCode(employee.getZipCode());
		form.setAddress(employee.getAddress());
		form.setTelephone(employee.getTelephone());
		form.setSalary(Integer.toString(employee.getSalary()));
		form.setCharacteristics(employee.getCharacteristics());
		form.setDependentsCount(Integer.toString(employee.getDependentsCount()));

		model.addAttribute("updateEmployeeForm", form);

		return "employee/detail";
	}

	/**
	 * 従業員詳細（扶養人数のみ）を更新する。
	 * 
	 * @param form 従業員詳細ページから受け取った値が格納されているフォームオブジェクト
	 * @return 「/employee/showList」にリダイレクト
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));

			form.setName(employee.getName());
			form.setImage(employee.getImage());
			form.setGender(employee.getGender());
			form.setHireDate(employee.getHireDate());
			form.setMailAddress(employee.getMailAddress());
			form.setZipCode(employee.getZipCode());
			form.setAddress(employee.getAddress());
			form.setTelephone(employee.getTelephone());
			form.setSalary(Integer.toString(employee.getSalary()));
			form.setCharacteristics(employee.getCharacteristics());

			model.addAttribute("updateEmployeeForm", form);

			return "employee/detail";
		}

		Employee employee = new Employee();

		employee.setId(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

		employeeService.update(employee);

		return "redirect:/employee/showList";
	}
}
