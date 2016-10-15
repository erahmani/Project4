package dataAccess.entity;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String birthDay;

    @Column(nullable = false)
    private String nationalId;

    public Customer() {
    }

    public Customer(Integer customerId, String firstName, String lastName, String fatherName, String birthDay, String nationalId) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.nationalId = nationalId;
    }

    public Customer(String firstName, String lastName, String fatherName, String birthDay, String nationalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.nationalId = nationalId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getNationalId() {
        return nationalId;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
