package com.example.course.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    public Order() {
    }

    public Order(long ID, Instant moment, User client) {
        this.ID = ID;
        this.moment = moment;
        this.client = client;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getID() == order.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getID());
    }
}
