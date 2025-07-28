package com.teste.maven.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.maven.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "TB_ORDER")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd'T'HH:mm:ss'Z",timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "Client_ID")
    private User client;

    private Integer status;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order",cascade =CascadeType.ALL)
    private Payments payment;

    public Order() {
    }

    public Order(Long id, Instant moment, User client, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setStatus(status);
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if(status != null){
            this.status = status.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Double    getTotal(){
        double sum = 0;
        for(OrderItem x : items){
            sum += x.getSubTotal();
        }
            return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
