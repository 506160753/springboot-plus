package com.example.demo.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{required}")
    private String name;

    @Email(message = "{invalid}")
    private String email;

}
