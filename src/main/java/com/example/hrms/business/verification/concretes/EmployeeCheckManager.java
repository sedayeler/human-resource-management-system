package com.example.hrms.business.verification.concretes;

import com.example.hrms.business.verification.abstracts.EmployeeCheckService;
import com.example.hrms.entities.dtos.EmployeeDto;
import com.example.hrms.mernis.SVMKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCheckManager implements EmployeeCheckService {

    @Override
    public boolean isRealPerson(EmployeeDto employeeDto) throws Exception {
        SVMKPSPublicSoap client = new SVMKPSPublicSoap();
        return client.TCKimlikNoDogrula(Long.valueOf(employeeDto.getNationalityId()), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getDateOfBirthYear());
    }
}
