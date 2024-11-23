package com.example.teachertask.signup;

public class SignUpDTO {

    private String organizationName;
    private int phoneNumber;
    private String adress;
    private String userName;
    private String email;
    private String password;

    public SignUpDTO(String organizationName, int phoneNumber, String adress, String userName, String email, String password) {

        this.organizationName = organizationName;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.userName = userName;
        this.email = email;
        this.password = password;

    }


    public String getOrganizationName() {
        return organizationName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
