package dataAccess.entity;

import javax.persistence.*;

@Entity
@Table
public class GrantCondition{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String minDuration;

    @Column(nullable = false)
    private String maxDuration;

    @Column(nullable = false)
    private String minCost;

    @Column(nullable = false)
    private String maxCost;

    @ManyToOne
    private LoanType loanType;

    public GrantCondition() {
    }

    public GrantCondition(String name, String minDuration, String maxDuration, String minCost, String maxCost) {
        this.name = name;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minCost = minCost;
        this.maxCost = maxCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public String getMinDuration() {
        return minDuration;
    }

    public String getMinCost() {
        return minCost;
    }

    public String getMaxCost() {
        return maxCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinDuration(String minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(String maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMinCost(String minCost) {
        this.minCost = minCost;
    }

    public void setMaxCost(String maxCost) {
        this.maxCost = maxCost;
    }

    @Override
    public String toString() {
        return "name: " + name + " minDuration: " + minDuration + " maxDuration: " + maxDuration + " minCost: " + minCost + " maxCost: " + maxCost + "\n";
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }
}
