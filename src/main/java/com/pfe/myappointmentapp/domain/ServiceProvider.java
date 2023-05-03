package com.pfe.myappointmentapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "service_provider")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@PrimaryKeyJoinColumn(name = "id")
public class ServiceProvider extends User implements Serializable {

    @OneToMany(mappedBy = "serviceProvider", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Services> services_offered;

    @OneToMany(mappedBy = "serviceProvider")
    private List<Availability> availabilities;

    @OneToMany(mappedBy = "serviceProvider")
    private List<Appointment> appointments;

    public List<Services> getServices_offered() {
        return services_offered;
    }

    public void setServices_offered(List<Services> services_offered) {
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
