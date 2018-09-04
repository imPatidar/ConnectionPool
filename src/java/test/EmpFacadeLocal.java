/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author niit
 */
@Local
public interface EmpFacadeLocal {

    void create(Emp emp);

    void edit(Emp emp);

    void remove(Emp emp);

    Emp find(Object id);

    List<Emp> findAll();

    List<Emp> findRange(int[] range);

    int count();
    
}
