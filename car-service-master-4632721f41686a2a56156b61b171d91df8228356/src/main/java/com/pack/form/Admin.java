package com.pack.form;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="admin", schema="project")
public class Admin {
                @NotNull
                @NotEmpty
                private String fname;
                public Admin(String adminId, String password) {
                                super();
                                this.adminId = adminId;
                                this.password = password;
                }

                public Admin(String fname, String lname, Integer age, Gender gender, String contactNo, String adminId,
                                                String password) {
                                super();
                                this.fname = fname;
                                this.lname = lname;
                                this.age = age;
                                this.gender = gender;
                                this.contactNo = contactNo;
                                this.adminId = adminId;
                                this.password = password;
                }
                @NotNull
                @NotEmpty
                private String lname;
                @NotNull @Min(18) @Max(100)
                private Integer age;
                

                private Gender gender;
                public Admin() {
                                super();
                }
                @NotNull
                @NotEmpty
                private String contactNo;
                
                @Id
                @NotNull
                @NotEmpty
                private String adminId;
                public String getAdminId() {
                                return adminId;
                }

                public void setAdminId(String adminId) {
                                this.adminId = adminId;
                }
                @NotNull
                @NotEmpty
                private String password;

                public String getFname() {
                                return fname;
                }

                public void setFname(String fname) {
                                this.fname = fname;
                }

                public String getLname() {
                                return lname;
                }

                public void setLname(String lname) {
                                this.lname = lname;
                }



                public Integer getAge() {
                                return age;
                }

                public void setAge(Integer age) {
                                this.age = age;
                }

                public Gender getGender() {
                                return gender;
                }

                public void setGender(Gender gender) {
                                this.gender = gender;
                }

                public String getContactNo() {
                                return contactNo;
                }

                public void setContactNo(String contactNo) {
                                this.contactNo = contactNo;
                }

                

                public String getPassword() {
                                return password;
                }

                public void setPassword(String password) {
                                this.password = password;
                }

                public enum Gender{
                                MALE,FEMALE;
                }
                }
