package com.raviit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.raviit.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
