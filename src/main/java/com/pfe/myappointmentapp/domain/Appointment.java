package com.pfe.myappointmentapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date start_time;
    private Date end_time;
    private boolean status;

    @ManyToMany
    @JoinTable(
        name = "appointment_customer",
        joinColumns = @JoinColumn(name = "appointment_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    //private Service service;

    public Appointment() {}

    public Appointment(Long id, Date start_time, Date end_time, boolean status, List<Customer> customers, ServiceProvider serviceProvider) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.customers = customers;
        this.serviceProvider = serviceProvider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return (
            "Appointment{" +
            "id='" +
            id +
            '\'' +
            ", start_time=" +
            start_time +
            ", end_time=" +
            end_time +
            ", status=" +
            status +
            ", customers=" +
            customers +
            ", serviceProvider=" +
            serviceProvider +
            '}'
        );
    }
}
