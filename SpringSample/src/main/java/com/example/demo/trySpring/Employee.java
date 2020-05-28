package com.example.demo.trySpring;

import lombok.Data;

@Data	//setter,getterを自動生成(lombok)
public class Employee {
	
	private int employeeId; // 従業員ID
	private String employeeName; // 従業員名
	private int age; // 年齢
}
