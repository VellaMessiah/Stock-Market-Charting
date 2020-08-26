package com.casestudy.stockexchange.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {

    private String userName;
    private String userType;
    private String email;
    private String password;
    private String mobileNumber;

}
