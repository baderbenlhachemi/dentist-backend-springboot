package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "username")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 1)
public class User extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "cin", nullable = false, unique = true)
    private String cin;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Transient
    private String generatedPassword;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday", nullable = true)
    private Date birthday;

    @Column(name = "gender", nullable = true)
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login_date", nullable = true)
    private LocalDateTime lastLoginDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String firstName, String lastName, String cin, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String cin, String username, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", roles=" + roles +
                ", id=" + id +
                '}';
    }
}
