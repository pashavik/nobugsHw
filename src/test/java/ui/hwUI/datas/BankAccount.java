package ui.hwUI.datas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder

public class BankAccount {


    private String firstName;
    private String lastName;

    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;
    private String username;
    private String password;
   // private String confirmPassword;

}
