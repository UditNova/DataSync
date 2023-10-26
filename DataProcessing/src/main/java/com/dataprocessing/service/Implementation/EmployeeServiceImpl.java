package com.dataprocessing.service.Implementation;

import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dataprocessing.entity.Employee;
import com.dataprocessing.repository.EmployeeRepository;
import com.dataprocessing.service.EmployeeService;
import com.opencsv.CSVReader;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(MultipartFile file) {
        
        try ( CSVReader reader= new CSVReader(new InputStreamReader(file.getInputStream()) ) ){
            String[] nextRecord;
            while((nextRecord=reader.readNext())!=null){

                //proces each line of record
                Employee emp=new Employee();
                emp.setEmp_id(Integer.parseInt(nextRecord[0]));
                emp.setFirst_name(nextRecord[1]);
                emp.setLast_name(nextRecord[2]);
                emp.setEmail(nextRecord[3]);
                emp.setPhonenumber(nextRecord[4]);
                //date parsing
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
                Date hireDate = dateFormat.parse(nextRecord[5]);
                emp.setHire_date(hireDate);
                emp.setJob_id(nextRecord[6]);
                emp.setSalary(Integer.parseInt(nextRecord[7]));
                emp.setManager_id(Integer.parseInt(nextRecord[8]));
                emp.setDepartment_id(Integer.parseInt(nextRecord[9]));

                //saving data to database
                employeeRepository.save(emp);
                
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            
        }

        return "Data Successfully loaded!! ";
    }
    
}
