package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.OeuvreventeEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceOeuvreVente extends EntityService {

    public void insertOeuvreVente(OeuvreventeEntity oeuvrepret) {
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

    public void updateOeuvre(OeuvreventeEntity uneOeuvre) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.merge(uneOeuvre);
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOeuvre(OeuvreventeEntity uneOeuvre){
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.remove(entityManager.contains(uneOeuvre) ? uneOeuvre : entityManager.merge(uneOeuvre));
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OeuvreventeEntity> getListOeuvreVente(){
        List<OeuvreventeEntity> OeuvreVenteList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            OeuvreVenteList = (List<OeuvreventeEntity>) entityManager.createQuery("select o from OeuvreventeEntity o order by o.titreOeuvrevente").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return OeuvreVenteList;
    }

    public OeuvreventeEntity getOeuvreVenteByIdOeuvre(int id){
        OeuvreventeEntity oeuvre = null;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            oeuvre = entityManager.find(OeuvreventeEntity.class, id);
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return oeuvre;
    }

    public void changeEtatOeuvreVente(OeuvreventeEntity uneOeuvre) {
        try {
            String etat = uneOeuvre.getEtatOeuvrevente().equals("L") ? "R" : "L";
            uneOeuvre.setEtatOeuvrevente(etat);
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.merge(uneOeuvre);
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}