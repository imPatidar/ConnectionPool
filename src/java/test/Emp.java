/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author niit
 */
@Entity
@Table(name = "EMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e"),
    @NamedQuery(name = "Emp.findByEmpid", query = "SELECT e FROM Emp e WHERE e.empid = :empid"),
    @NamedQuery(name = "Emp.findByEmpname", query = "SELECT e FROM Emp e WHERE e.empname = :empname"),
    @NamedQuery(name = "Emp.findBySalary", query = "SELECT e FROM Emp e WHERE e.salary = :salary")})
public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPID")
    private Integer empid;
    @Size(max = 40)
    @Column(name = "EMPNAME")
    private String empname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private Double salary;

    public Emp() {
    }

    public Emp(Integer empid) {
        this.empid = empid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Emp[ empid=" + empid + " ]";
    }
    
}
