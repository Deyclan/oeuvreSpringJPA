package com.epul.oeuvres.controle;

import com.epul.oeuvres.dao.ServiceAdherent;
import com.epul.oeuvres.dao.ServiceOeuvrePret;
import com.epul.oeuvres.dao.ServiceOeuvreVente;
import com.epul.oeuvres.dao.ServiceProprietaire;
import com.epul.oeuvres.metier.AdherentEntity;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ProprietaireEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OeuvreControleur {

    @RequestMapping( value = "gererOeuvre")
    public ModelAndView gererOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            destinationPage = "seConnecter";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "ajouterOeuvre")
    public ModelAndView ajouterOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceProprietaire unService = new ServiceProprietaire();
            request.setAttribute("proprietaires", unService.getListProprietaire());
            destinationPage = "ajouterOeuvre";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "insererOeuvre")
    public ModelAndView insererOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            OeuvreventeEntity uneOeuvre = new OeuvreventeEntity();
            uneOeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
            uneOeuvre.setEtatOeuvrevente("L");
            uneOeuvre.setPrixOeuvrevente(Float.parseFloat(request.getParameter("txtprix")));
            ServiceProprietaire unService = new ServiceProprietaire();
            ProprietaireEntity myP = unService.getProprietaireById(Integer.parseInt(request.getParameter("txtproprietaire")));
            uneOeuvre.setProprietaire(myP);
            ServiceOeuvreVente serviceOeuvreVente = new ServiceOeuvreVente();
            serviceOeuvreVente.insertOeuvreVente(uneOeuvre);
            destinationPage = "accueil";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "listerOeuvre")
    public ModelAndView listerOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceOeuvreVente serviceOeuvreVente = new ServiceOeuvreVente();
            request.setAttribute("mesOeuvres", serviceOeuvreVente.getListOeuvreVente());
            destinationPage = "listerOeuvre";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "modifierOeuvre")
    public ModelAndView modifierOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try{
            ServiceOeuvreVente serviceOeuvreVente = new ServiceOeuvreVente();
            OeuvreventeEntity oeuvre = serviceOeuvreVente.getOeuvreVenteByIdOeuvre(Integer.parseInt(request.getParameter("modif")));
            request.setAttribute("oeuvreAModifier", oeuvre);
            ServiceProprietaire serviceProprietaire = new ServiceProprietaire();
            request.setAttribute("proprietaires", serviceProprietaire.getListProprietaire());
            destinationPage = "modifierOeuvre";
        } catch (Exception e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "sauvegarderOeuvre")
    public ModelAndView sauvegarderOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceOeuvreVente serviceOeuvre = new ServiceOeuvreVente();
            OeuvreventeEntity uneOeuvre = serviceOeuvre.getOeuvreVenteByIdOeuvre(Integer.parseInt(request.getParameter("txtIDOeuvre")));
            uneOeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
            uneOeuvre.setPrixOeuvrevente(Float.parseFloat(request.getParameter("txtprix")));
            ServiceProprietaire servP = new ServiceProprietaire();
            ProprietaireEntity myP = servP.getProprietaireById(Integer.parseInt(request.getParameter("txtproprietaire")));
            uneOeuvre.setProprietaire(myP);
            serviceOeuvre.updateOeuvre(uneOeuvre);
            destinationPage = "accueil";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }


}
