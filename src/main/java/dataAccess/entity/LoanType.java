package dataAccess.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class LoanType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String interestRate;

    @Column(nullable = false)
    @OneToMany(mappedBy = "loanType", cascade = CascadeType.REMOVE )
    private List<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();

    public List<GrantCondition> getGrantConditionList() {
        return grantConditionList;
    }

    public void setGrantConditionList(List<GrantCondition> grantConditionList) {
        this.grantConditionList = grantConditionList;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Name: " + name + "Interest Rate: " + interestRate;
    }
}
