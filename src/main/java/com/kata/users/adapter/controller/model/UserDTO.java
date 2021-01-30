package com.kata.users.adapter.controller.model;

import com.kata.users.domain.User;

public class UserDTO {

    private Long id;
    private String fullName;
    private String address;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String address, String email) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toUser() {
        return new User.Builder()
                .withFullName(fullName)
                .withAddress(address)
                .withEmail(email)
                .build();
    }

    public static UserDTO toUserDTO(final User user) {

        UserDTO dto = new UserDTO(
                user.getId(),
                user.getFullName(),
                user.getAddress(),
                user.getEmail()
        );

        return dto;
    }
}
