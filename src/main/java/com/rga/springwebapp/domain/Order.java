package com.rga.springwebapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderPosition> positions;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPositions(List<OrderPosition> positions) {
        this.positions = positions;
    }

    public Order() {
    }
}