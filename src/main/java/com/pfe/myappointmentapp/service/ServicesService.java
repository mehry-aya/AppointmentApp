package com.pfe.myappointmentapp.service;

import com.pfe.myappointmentapp.domain.ServiceProvider;
import com.pfe.myappointmentapp.domain.Services;
import com.pfe.myappointmentapp.repository.ServiceProviderRepository;
import com.pfe.myappointmentapp.repository.ServicesRepository;
import com.pfe.myappointmentapp.repository.UserRepository;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicesService {

    private final Logger log = LoggerFactory.getLogger(ServicesService.class);
    private final ServicesRepository servicesRepository;
    private final UserRepository userRepository;
    private final ServiceProviderRepository serviceProviderRepository;

    public ServicesService(
        ServicesRepository servicesRepository,
        UserRepository userRepository,
        ServiceProviderRepository serviceProviderRepository
    ) {
        this.servicesRepository = servicesRepository;
        this.userRepository = userRepository;
        this.serviceProviderRepository = serviceProviderRepository;
    }

    /* public Services addService(Services services){
        return this.serviceRepository.save(services);
    }*/

    /*public Services addService(Services services, Long id_sProvider) {
        Services newService = this.serviceRepository.save(services);
        ServiceProvider serviceProvider = this.serviceProviderRepository.findById(id_sProvider).get();
        serviceProvider.setServices_offered((List<Services>) newService);
        this.serviceProviderRepository.save(serviceProvider);
        return newService;
    }*/
    public Services addService(Services services, Long id_sProvider) {
        Services newService = this.servicesRepository.save(services);
        ServiceProvider serviceProvider = this.serviceProviderRepository.findById(id_sProvider).get();
        List<Services> servicesOffered = new ArrayList<>();
        servicesOffered.add(newService);
        serviceProvider.setServices_offered(servicesOffered);
        this.serviceProviderRepository.save(serviceProvider);
        newService.setServiceProvider(serviceProvider);
        return newService;
    }

    public List<Services> findAllServices() {
        return this.servicesRepository.findAll();
    }

    public List<Services> findServicesByProviders(Long id_sProvider) {
        ServiceProvider serviceProvider = this.serviceProviderRepository.findById(id_sProvider).get();
        return serviceProvider.getServices_offered();
    }

    /* public List<Services> findServicesByCurrentUser(){
        return SecurityUtils.getCurrentUserLogin()
            .flatMap(userRepository::findOneByLogin)
            .get().getServices();
    }*/

    public Services getService(long id) {
        return this.servicesRepository.getOne(id);
    }

    public Services updateService(Services services) {
        Optional<Services> optionalService = servicesRepository.findById(services.getId());
        if (optionalService.isPresent()) {
            Services service = optionalService.get();
            service.setName(services.getName());
            service.setDescription(services.getDescription());
            service.setPlace(services.getPlace());
            service.setPrice(services.getPrice());

            //                service.setUser(services.getUser());

            return this.servicesRepository.save(service);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void deleteService(Services services) {
        this.servicesRepository.deleteById(services.getId());
    }
}
