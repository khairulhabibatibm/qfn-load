package org.acme.service;

import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.persistence.ProcurService;
import org.acme.persistence.entity.ProcurementEntity;

@ApplicationScoped
public class LoadService {
    
    @Inject
    ProcurService service;

    public void readAllData(){
        Stream<ProcurementEntity> stream = service.getAllData();
        stream.forEach(d -> {
            System.out.println(d.getId() + ":" + d.getCostCenter() + ":" + d.getNamaAnggaran());
        });
    }
}
