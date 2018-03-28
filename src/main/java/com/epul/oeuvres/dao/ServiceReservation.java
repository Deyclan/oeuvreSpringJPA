package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.ReservationEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceReservation extends EntityService {

    public void insertReservation(ReservationEntity reservation) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ReservationEntity> getListReservation(){
        List<ReservationEntity> reservationList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservationList = (List<ReservationEntity>) entityManager.createQuery("select r from ReservationEntity r order by r.dateReservation").getResultList();
            entityManager.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reservationList;
    }

    public ReservationEntity getReservationById(int id){
        ReservationEntity reservation = null;
        List<ReservationEntity> reservationEntityList;
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservationEntityList = entityManager.createQuery("select r from ReservationEntity r where idOeuvrevente ="+id).getResultList();
            if (reservationEntityList.size()>0){
                reservation = reservationEntityList.get(0);
            }
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return reservation;
    }

    public void confirmerReservation(ReservationEntity uneReservation) {
        try {
            uneReservation.setStatut("reserve");
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.merge(uneReservation);
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(ReservationEntity reservation) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.remove(entityManager.contains(reservation) ? reservation : entityManager.merge(reservation));
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
