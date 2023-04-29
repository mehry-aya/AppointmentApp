package com.pfe.myappointmentapp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "customers")
    private List<Appointment> upcoming_appointments;

    public Customer() {}

    public Customer(List<Appointment> upcoming_appointments) {
        this.upcoming_appointments = upcoming_appointments;
    }

    public List<Appointment> getUpcoming_appointments() {
        return upcoming_appointments;
    }

    public void setUpcoming_appointments(List<Appointment> upcoming_appointments) {
        this.upcoming_appointments = upcoming_appointments;
    }

    @Override
    public String toString() {
        return "Customer{" + "upcoming_appointments=" + upcoming_appointments + '}';
    }
}
