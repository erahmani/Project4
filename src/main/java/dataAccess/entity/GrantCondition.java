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

    public GrantCondition() {
    }

    public GrantCondition(String name, String minDuration, String maxDuration, String minCost, String maxCost) {
        this.name = name;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minCost = minCost;
        this.maxCost = maxCost;
    }


    @Override
    public String toString() {
        return "name: " + name + " minDuration: " + minDuration + " maxDuration: " + maxDuration + " minCost: " + minCost + " maxCost: " + maxCost + "\n";
    }
}
