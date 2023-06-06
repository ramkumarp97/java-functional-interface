package main.java.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static main.java.combinatorpattern.CustomerRegistrationValidator.*;
import static main.java.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isNameValid() {
        return customer -> customer.getName().contains("a") ?
                SUCCESS : NAME_NOT_VALID;
    }

    static CustomerRegistrationValidator isDOBValid() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears()>16 ?
                SUCCESS : DOB_NOT_VALID;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other){
        return customer -> {
            return this.apply(customer).equals(SUCCESS) ? other.apply(customer) : this.apply(customer);
        };
    }


    enum ValidationResult {
        SUCCESS,
        DOB_NOT_VALID,
        NAME_NOT_VALID;

    }


}
