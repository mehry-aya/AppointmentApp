package com.pfe.myappointmentapp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "service_provider")
public class ServiceProvider extends User implements Serializable {

    @OneToMany(mappedBy = "serviceProvider")
    private List<Service> services_offered;

    @OneToMany(mappedBy = "serviceProvider")
    private List<Availability> availabilities;

    @OneToMany(mappedBy = "serviceProvider")
    private List<Appointment> appointments;

    public List<Service> getServices_offered() {
        return services_offered;
    }

    public void setServices_offered(List<Service> services_offered) {
        this.services_offered = services_offered;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return (
            "ServiceProvider{" +
            "services_offered=" +
            services_offered +
            ", availabilities=" +
            availabilities +
            ", appointments=" +
            appointments +
            '}'
        );
    }
}
