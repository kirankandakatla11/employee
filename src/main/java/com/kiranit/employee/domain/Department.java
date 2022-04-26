package com.kiranit.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int depId;
    private String firstName;
    private String lastName;
    private String address;

}
