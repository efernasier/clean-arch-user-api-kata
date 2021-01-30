package com.kata.users.domain;

public class User {

    private Long id;
    private String fullName;
    private String address;
    private String email;

    private User(){}

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
        }

        public Builder withId(final Long id) {
            user.id = id;
            return this;
        }

        public Builder withFullName(final String fullName) {
            user.fullName = fullName;
            return this;
        }

        public Builder withAddress(final String address){
            user.address = address;
            return this;
        }

        public Builder withEmail(final String email){
            user.email = email;
            return this;
        }

        public User build(){
            return user;
        }

    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
