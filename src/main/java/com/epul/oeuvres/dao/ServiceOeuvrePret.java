package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvrepretEntity;
import com.epul.oeuvres.metier.OeuvreventeEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceOeuvrePret extends EntityService {

    public void insertOeuvrePret(OeuvrepretEntity oeuvrepret) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(oeuvrepret);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<OeuvrepretEntity> getListOeuvrePret(){
        List<OeuvrepretEntity> OeuvrePretList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            OeuvrePretList = (List<OeuvrepretEntity>) entityManager.createQuery("select o from OeuvrepretEntity o order by o.titreOeuvrepret").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return OeuvrePretList;
    }

    public OeuvrepretEntity getOeuvrePretByIdOeuvre(int id){
        OeuvrepretEntity oeuvre = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            oeuvre = entityManager.find(OeuvrepretEntity.class, id);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return oeuvre;
    }

}
