package main.java.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isNameValid(String name){
        return name.contains("a");
    }

    private boolean isDOBValid(LocalDate date){
        return Period.between(date,LocalDate.now()).getYears()>16;
    }

    public boolean isValid(Customer customer){
        return isDOBValid(customer.getDob()) || isNameValid(customer.getName());
    }

}
