package com.shan.test.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1 = new Employee("a-name1", 20, 10000, "dep1" );
		Employee e2 = new Employee("b-name2", 31, 20000, "dep1" );
		Employee e3 = new Employee("d-name3", 32, 30000, "dep2" );
		Employee e4 = new Employee("c-name4", 32, 40000, "dep2" );
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		System.out.println("****************** age > 30 ");
		
		// get names alone
		list.stream()
			.filter(s-> s.getAge() > 30)
			.map(s -> s.getName())
			.forEach(System.out::println);
		
		System.out.println("****************** name reversed ");
		
		List<Employee> list2 = list;
		
		list2.stream()
			.sorted(Comparator.comparing(Employee::getName).reversed())
			.map(s -> s.getName())
			.forEach(System.out::println);
		
		System.out.println("****************** sum of all salaries ");
		
		List<Employee> list3 = list;
		
		System.out.println(list3.stream()
			.filter(s -> s.getAge() > 30)
			.mapToInt(s -> s.getSalary())
			.sum());
		
		System.out.println("****************** GroupBy");
		
		List<Employee> list4 = list;
		
		Map<String, Optional<Employee>> maxSalariesByDept = list4.stream()
			.collect(Collectors.groupingBy(Employee::getDept, 
						Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
        maxSalariesByDept.forEach((dept, maxSalary) -> {
            System.out.println("Max salary for department " + dept + " is " +
                    (maxSalary.isPresent() ? maxSalary.get().getSalary() : "N/A"));
        });
		
        System.out.println("****************** Optional start");
        
        Optional<Integer> o1 = Optional.of(1);
        Optional<Integer> o2 = Optional.ofNullable(1);
        
        System.out.println("****************** Optional End");
        
        
		
		/*
		List<Employee> list2 = list;
		
		list.stream()
			.filter(s->s.getAge()>30)
			.map(s->s.getName())
			.forEach(System.out::println);
		
		System.out.println("**********************");
		
		list2.stream()
			.filter(s->s.getAge()>30)
			.sorted(Comparator.comparing(Employee::getName).reversed())
			.map(s->s.getName())
			.forEach(System.out::println);
			
		System.out.println("**********************");
		
		List<Employee> list3 = list;
		System.out.println(list3.stream()
			.filter(s->s.getAge()>30)
			.mapToInt(Employee::getSalary)
			.sum());
		
		System.out.println("**********************");*/
	}

	
	
}

class Employee {
	private String name;
	private int age;
	private int salary;
	private String dept;
	
	public Employee(String name, int age, int salary, String dept) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}


