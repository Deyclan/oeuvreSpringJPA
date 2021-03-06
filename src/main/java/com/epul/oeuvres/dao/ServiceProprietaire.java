package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.ProprietaireEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceProprietaire extends EntityService {

    public void insertProprietaire(ProprietaireEntity proprietaire) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(proprietaire);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ProprietaireEntity> getListProprietaire(){
        List<ProprietaireEntity> OeuvrePretList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            OeuvrePretList = (List<ProprietaireEntity>) entityManager.createQuery("select distinct p from ProprietaireEntity p order by p.idProprietaire").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return OeuvrePretList;
    }

    public ProprietaireEntity getProprietaireById(int id){
        ProprietaireEntity proprietaire = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            proprietaire = entityManager.find(ProprietaireEntity.class, id);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return proprietaire;
    }
}
