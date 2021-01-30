package com.kata.users.adapter.repository.jpa.postgres.entity;

import com.kata.users.domain.User;

import javax.persistence.*;

@Entity(name = "User")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "users_email_unique", columnNames = "email")
        }
)
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    public UserEntity() {
    }

    public UserEntity(String fullName, String address, String email) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
    }

    public UserEntity(Long id, String fullName, String address, String email) {
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

    public static User fromPgEntity(final UserEntity userEntity) {
        return new User.Builder()
                .withId(userEntity.getId())
                .withFullName(userEntity.getFullName())
                .withAddress(userEntity.getAddress())
                .withEmail(userEntity.getEmail())
                .build();
    }

    public static UserEntity fromDomainUser(final com.kata.users.domain.User user) {
        return new UserEntity(
                user.getId(),
                user.getFullName(),
                user.getAddress(),
                user.getEmail());
    }
}
