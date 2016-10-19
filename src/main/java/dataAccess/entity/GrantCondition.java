package dataAccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private Short minDuration;

    @Column(nullable = false)
    private Short maxDuration;

    @Column(nullable = false)
    private BigDecimal minCost;

    @Column(nullable = false)
    private BigDecimal maxCost;

    public GrantCondition(String name, Short minDuration, Short maxDuration, BigDecimal minCost, BigDecimal maxCost) {
        this.name = name;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minCost = minCost;
        this.maxCost = maxCost;
    }

    public GrantCondition() {
    }

    @Override
    public String toString() {
        return "name: " + name + " minDuration: " + minDuration + " maxDuration: " + maxDuration + " minCost: " + minCost + " maxCost: " + maxCost + "\n";
    }

    public BigDecimal getMinCost() {
        return minCost;
    }

    public BigDecimal getMaxCost() {
        return maxCost;
    }

    public Short getMinDuration() {
        return minDuration;
    }

    public Short getMaxDuration() {
        return maxDuration;
    }

    public String getName() {
        return name;
    }
}
