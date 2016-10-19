package dataAccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LoanFile")
public class LoanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private Short duration;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    private LoanType loanType;

    public LoanFile(Customer customer, LoanType loanType, BigDecimal cost, Short duration) {
        this.customer = customer;
        this.loanType = loanType;
        this.cost = cost;
        this.duration = duration;
    }

    public LoanFile() {
    }

    @Override
    public String toString() {
        return "Customer: " + customer + "\nloanType: " + loanType;
    }
}
