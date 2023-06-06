package main.java.combinatorpattern;

import java.time.LocalDate;

import static main.java.combinatorpattern.CustomerRegistrationValidator.*;
import static main.java.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {

    public static void main(String[] args) {
        Customer customer =new Customer("Raja", LocalDate.of(1997,4,26));

//        CustomerValidatorService validatorService = new CustomerValidatorService();
//        System.out.println(new CustomerValidatorService().isValid(customer));

        ValidationResult result = isNameValid().and(isDOBValid()).apply(customer);

        System.out.println(result);

        if(result != SUCCESS){
            throw new IllegalStateException(result.name()+" Bad record");
        }

    }
}
