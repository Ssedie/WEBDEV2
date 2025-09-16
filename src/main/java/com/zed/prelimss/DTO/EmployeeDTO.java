package com.zed.prelimss.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class EmployeeDTO {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        @NotBlank(message = "We need a name")
        String name;

        @NotBlank(message = "We need an email")
        @Email(message = "Email format is required")
        String email;

        public EmployeeDTO() {
        }

        public EmployeeDTO(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public Integer getId() {return id;}
        public void setId(Integer id) {this.id = id;}
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
}
