package org.acme.persistence.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "budget_plan")
public class ProcurementEntity {

    @Id
    private Long id;
    @Column(name = "budget_name")
    private String budgetName;
    @Column(name = "cost_center")
    private String costCenter;
    @Column(name = "nama_anggaran")
    private String namaAnggaran;


    public ProcurementEntity() {
    }

    public ProcurementEntity(Long id, String budgetName, String costCenter, String namaAnggaran) {
        this.id = id;
        this.budgetName = budgetName;
        this.costCenter = costCenter;
        this.namaAnggaran = namaAnggaran;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudgetName() {
        return this.budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getCostCenter() {
        return this.costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getNamaAnggaran() {
        return this.namaAnggaran;
    }

    public void setNamaAnggaran(String namaAnggaran) {
        this.namaAnggaran = namaAnggaran;
    }

    public ProcurementEntity id(Long id) {
        this.id = id;
        return this;
    }

    public ProcurementEntity budgetName(String budgetName) {
        this.budgetName = budgetName;
        return this;
    }

    public ProcurementEntity costCenter(String costCenter) {
        this.costCenter = costCenter;
        return this;
    }

    public ProcurementEntity namaAnggaran(String namaAnggaran) {
        this.namaAnggaran = namaAnggaran;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProcurementEntity)) {
            return false;
        }
        ProcurementEntity procurementEntity = (ProcurementEntity) o;
        return Objects.equals(id, procurementEntity.id) && Objects.equals(budgetName, procurementEntity.budgetName) && Objects.equals(costCenter, procurementEntity.costCenter) && Objects.equals(namaAnggaran, procurementEntity.namaAnggaran);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, budgetName, costCenter, namaAnggaran);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", budgetName='" + getBudgetName() + "'" +
            ", costCenter='" + getCostCenter() + "'" +
            ", namaAnggaran='" + getNamaAnggaran() + "'" +
            "}";
    }

    
}
