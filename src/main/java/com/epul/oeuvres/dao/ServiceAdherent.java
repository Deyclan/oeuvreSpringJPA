package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.AdherentEntity;
import com.epul.oeuvres.metier.OeuvreventeEntity;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceAdherent extends EntityService {

    public void insertAdherent(AdherentEntity adherent) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(adherent);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<AdherentEntity> getListAdherent(){
        List<AdherentEntity> adherentEntityList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            adherentEntityList = (List<AdherentEntity>) entityManager.createQuery("select a from AdherentEntity a order by a.idAdherent").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return adherentEntityList;
    }

    public AdherentEntity getAdherentById(int id){
        AdherentEntity adherent = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            adherent = entityManager.find(AdherentEntity.class, id);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return adherent;
    }

    public void updateAdherent(AdherentEntity adherent) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.merge(adherent);
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAdherent(AdherentEntity adherent){
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.remove(entityManager.contains(adherent) ? adherent : entityManager.merge(adherent));
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
