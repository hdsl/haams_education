/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.ejb.services;

import haams.ejb.entities.CommonEntity;
import haams.ejb.entities.GeneratePk;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbdulMumin
 */
@Stateless
public class CrudService {

    @PersistenceContext
    private EntityManager em;

    public CommonEntity save(CommonEntity commonEntity) {
        try {

            commonEntity.setDeleted('N');
            commonEntity.setUpdated('N');
            em.merge(commonEntity);
            em.flush();

            return commonEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(CommonEntity commonEntity, boolean includeLogicalDelete) {
        try {

            if (includeLogicalDelete == true) {

                commonEntity.setDeleted('Y');
                commonEntity.setUpdated('N');
                em.merge(commonEntity);
                em.flush();

            } else {
                em.remove(em.merge(commonEntity));
                em.flush();
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(CommonEntity commonEntity) {
        try {

            commonEntity.setDeleted('N');
            commonEntity.setUpdated('Y');
            em.merge(commonEntity);
            em.flush();

            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public <T> T find(Class<T> t, String id) {
        
        try {
            return em.find(t, id);
        } catch (Exception e) {
        }
        return null;
    }

    public List findAll(Class t, boolean includeLogicalDelete) {
        try {

            String qry = "";

            if (includeLogicalDelete == true) {
                qry = "SELECT t FROM " + t.getSimpleName() + " t ";
               
            } else if (includeLogicalDelete == false) {

                qry = "SELECT t FROM " + t.getSimpleName() + " t WHERE t.deleted = 'N' ";
            }

            return em.createQuery(qry).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public List findAll(Class t, boolean includeLogicalDelete, String orderBy) {
        try {

            String qry = "";

            if (includeLogicalDelete == true) {
                qry = "SELECT t FROM " + t.getSimpleName() + " t ORDER BY t." + orderBy + " ";
            } else if (includeLogicalDelete == false) {

                qry = "SELECT t FROM " + t.getSimpleName() + " t WHERE t.deleted = 'N' ORDER BY t." + orderBy + " ";
            }

            return em.createQuery(qry).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" GeneratePk Persistence Functionalities">
    public boolean generatePkUpdate(GeneratePk generatePk) {
        try {

            em.merge(generatePk);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Integer generatePk(String pkName) {
        try {

            GeneratePk generatePk = em.find(GeneratePk.class, pkName);

            int in = generatePk.getPkValue();
            int a = 1 + in;

            generatePk.setPkValue(a);

            em.merge(generatePk);
            em.flush();
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    // </editor-fold>
}
