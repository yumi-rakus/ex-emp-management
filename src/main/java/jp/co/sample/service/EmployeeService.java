package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	
	/**
	 * 従業員情報を全件取得する
	 * 
	 * @return 従業員情報一覧
	 */
	public List<Employee> showList() {
		return employeeRepository.findAll();
	}

	/**
	 * 従業員情報を取得する。
	 * 
	 * @param id ID
	 * @return 従業員情報
	 */
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
	}

	/**
	 * 従業員情報（扶養人数）を更新する。
	 * 
	 * @param employee 更新される扶養人数のデータをもつ従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}

}
