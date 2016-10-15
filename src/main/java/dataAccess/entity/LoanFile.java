package dataAccess.entity;

import javax.persistence.*;

@Entity
@Table
public class LoanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @Column(nullable = false)
    private Customer customer;

    @ManyToOne
    @Column(nullable = false)
    private LoanType loanType;

    public LoanFile(Customer customer, LoanType loanType) {
        this.customer = customer;
        this.loanType = loanType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }
}
