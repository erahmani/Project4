package dataAccess.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LoanType")
public class LoanType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Short interestRate;

    public LoanType() {
    }

    public List<GrantCondition> getGrantConditionList() {
        return grantConditionList;
    }

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name="loanType_id")
    private List<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();

    public LoanType(String name, Short interestRate, List<GrantCondition> grantConditionList) {
        this.name = name;
        this.interestRate = interestRate;
        this.grantConditionList = grantConditionList;
    }

    @Override
    public String toString() {
        return "Name: " + name + "Interest Rate: " + interestRate + "\n" + grantConditionList;
    }

    public void setGrantConditionList(List<GrantCondition> grantConditionList) {
        this.grantConditionList = grantConditionList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Short getInterestRate() {
        return interestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestRate(Short interestRate) {
        this.interestRate = interestRate;
    }
}
