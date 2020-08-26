package com.casestudy.stockexchange.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {
    private String userName;

    private String userType;

    private String email;

    private String mobileNumber;
}
