package com.vijay.vz.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.vijay.vz.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Employee save(Employee employee){
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployeeById(String empId){
        return dynamoDBMapper.load(Employee.class,empId);
    }

    public String delete(String empId){
        Employee emp = dynamoDBMapper.load(Employee.class,empId);
        dynamoDBMapper.delete(emp);

        return "Employee deleted.";
    }

    public String update(String empId,Employee employee){
        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("empId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(empId)
                                )));

        return empId;

    }
}
