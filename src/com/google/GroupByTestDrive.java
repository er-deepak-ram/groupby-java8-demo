// Use case: Given a list of employees, create a map with key as age and value 
// as list of employees in that age group
package com.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupByTestDrive {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Johny", 30));
		empList.add(new Employee(2, "Rocky", 35));
		empList.add(new Employee(3, "Tim", 30));
		empList.add(new Employee(4, "Alex", 28));
		empList.add(new Employee(5, "Eric", 30));
		
		Map<Integer, List<Employee>> empMap = empList.stream()
													.collect(Collectors.groupingBy(emp -> emp.getAge()));
		
		TreeMap<Integer, List<Employee>> sortedEmpMap = empList.stream()
													.collect(Collectors.groupingBy(emp -> emp.getAge(), TreeMap::new, Collectors.toList()));
		System.out.println(empMap);
		System.out.println(sortedEmpMap);
	}
}
/* groupingBy() of Collectors is overloaded
 * 1. According to 1st version groupingBy(<the-key-given-by-user>, Collectors.toList()), 
 *    that's why value of the map is list
 * 2. According to 2nd version groupingBy(<the-key-given-by-user>, downstream), where downstream
 *    is the value given by you. So at line #20 you can write 
 *    Collectors.groupingBy(emp -> emp.getAge(), Collectors.toSet())
 * 3. According to 3rd version groupingBy(<the-key-given-by-user>, mapFactory, downstream)
 *    So rather than HashMap if you want to declare some other map then give its constructor reference in mapFactory
 *    Sorting purpose is solved by default by TreeMap!
 * */
