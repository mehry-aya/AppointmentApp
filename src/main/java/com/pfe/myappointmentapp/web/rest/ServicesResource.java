package com.pfe.myappointmentapp.web.rest;

import com.pfe.myappointmentapp.domain.Services;
import com.pfe.myappointmentapp.repository.ServicesRepository;
import com.pfe.myappointmentapp.service.ServicesService;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
public class ServicesResource {

    private final Logger log = LoggerFactory.getLogger(ServicesResource.class);
    private final ServicesService servicesService;
    private final ServicesRepository servicesRepository;

    public ServicesResource(ServicesService servicesService, ServicesRepository servicesRepository) {
        this.servicesService = servicesService;
        this.servicesRepository = servicesRepository;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Services> addService(@Valid @RequestBody Services services, @PathVariable("id") Long id_sProvider) {
        return ResponseEntity.ok(this.servicesService.addService(services, id_sProvider));
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Services> getService(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.servicesService.getService(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(this.servicesService.findAllServices());
    }

    /*@GetMapping("/serviceProvider/{id}")
    public ResponseEntity<Set<Services>> getServicesByServiceProvider(@PathVariable("id") Long idServiceProvider){
        return ResponseEntity.ok(this.servicesService);
    }*/
    @GetMapping("/serviceProvider/{id}")
    public ResponseEntity<List<Services>> getservicesByProvider(@PathVariable("id") Long id_sProvider) {
        return ResponseEntity.ok(this.servicesService.findServicesByProviders(id_sProvider));
    }

    @PutMapping("/update")
    public ResponseEntity<Services> updateService(@RequestBody Services service) {
        return ResponseEntity.ok(this.servicesService.updateService(service));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable("id") long id) {
        this.servicesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
