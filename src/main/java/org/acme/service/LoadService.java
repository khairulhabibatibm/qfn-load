package org.acme.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.persistence.ProcurService;
import org.acme.persistence.entity.ProcurementEntity;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@ApplicationScoped
public class LoadService {
    
    @Inject
    ProcurService service;

    @Inject
    @DataSource("pg")
    AgroalDataSource stagingDs;

    public void readAllData(){
        Connection conn = null;
        try {
            conn = stagingDs.getConnection();
            Stream<ProcurementEntity> stream = service.getAllData();

            PreparedStatement ps = conn.prepareStatement("insert into public.proc_staging values (?,?,?,?)");
            stream.forEach(d -> {
                try {
                    // System.out.println(d.getId() + ":" + d.getCostCenter() + ":" + d.getNamaAnggaran());

                    ps.setLong(1, d.getId());    
                    ps.setString(2, d.getBudgetName());
                    ps.setString(3, d.getCostCenter());
                    ps.setString(4, d.getNamaAnggaran());

                    ps.addBatch();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            });    
            ps.executeBatch();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        
    }

}
