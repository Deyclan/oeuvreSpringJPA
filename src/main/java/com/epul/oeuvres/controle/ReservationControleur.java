package com.epul.oeuvres.controle;

import com.epul.oeuvres.dao.ServiceAdherent;
import com.epul.oeuvres.dao.ServiceOeuvreVente;
import com.epul.oeuvres.dao.ServiceReservation;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ReservationEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
public class ReservationControleur {

    @RequestMapping(value = "ajouterReservation")
    public ModelAndView ajouterReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceOeuvreVente servO = new ServiceOeuvreVente();
            OeuvreventeEntity uneO = servO.getOeuvreVenteByIdOeuvre(Integer.parseInt(request.getParameter("reserv")));
            request.setAttribute("oeuvreAReserver", uneO);
            ServiceAdherent servA = new ServiceAdherent();
            request.setAttribute("adherents", servA.getListAdherent());
            destinationPage = "ajouterReservation";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererReservation")
    public ModelAndView insererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ReservationEntity uneR = new ReservationEntity();
            uneR.setIdOeuvrevente(Integer.parseInt(request.getParameter("txtIDOeuvre")));
            uneR.setIdAdherent(Integer.parseInt(request.getParameter("txtadherent")));
            uneR.setDateReservation(Date.valueOf(request.getParameter("txtdate")));
            uneR.setStatut("attente");
            ServiceReservation serR = new ServiceReservation();
            serR.insertReservation(uneR);
            // Change l'état de l'oeuvre
            ServiceOeuvreVente serO = new ServiceOeuvreVente();
            OeuvreventeEntity uneO = serO.getOeuvreVenteByIdOeuvre(uneR.getIdOeuvrevente());
            uneO.setEtatOeuvrevente("R");
            serO.updateOeuvre(uneO);
            destinationPage = "accueil";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "gererReservations")
    public ModelAndView gererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceReservation serR = new ServiceReservation();
            request.setAttribute("mesReservations", serR.getListReservation());
            destinationPage = "listerReservation";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "confirmerReservation")
    public ModelAndView confirmerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // Changer statut réservation à confirmee
            ServiceReservation unS = new ServiceReservation();
            ReservationEntity uneR = unS.getReservationById(Integer.parseInt(request.getParameter("confirmer")));
            uneR.setStatut("confirmee");
            unS.updateReservation(uneR);
            destinationPage = "accueil";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "annulerReservation")
    public ModelAndView annulerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // Supprime la réservation
            ServiceReservation serR = new ServiceReservation();
            ReservationEntity uneR = serR.getReservationById(Integer.parseInt(request.getParameter("annuler")));
            serR.deleteReservation(uneR);
            // Change l'état de l'oeuvre
            ServiceOeuvreVente serO = new ServiceOeuvreVente();
            OeuvreventeEntity uneO = serO.getOeuvreVenteByIdOeuvre(uneR.getIdOeuvrevente());
            uneO.setEtatOeuvrevente("L");
            serO.updateOeuvre(uneO);
            destinationPage = "accueil";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

}
