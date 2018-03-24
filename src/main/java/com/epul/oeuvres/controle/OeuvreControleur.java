package com.epul.oeuvres.controle;

import com.epul.oeuvres.dao.ServiceAdherent;
import com.epul.oeuvres.dao.ServiceOeuvrePret;
import com.epul.oeuvres.metier.AdherentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OeuvreControleur {

    @RequestMapping( value = "gererOeuvre")
    public ModelAndView gererOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "gererOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "ajouterOeuvre")
    public ModelAndView ajouterOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "ajouterOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "listerOeuvre")
    public ModelAndView listerOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "listerOeuvre";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( value = "gererReservations")
    public ModelAndView gererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "gererReservation";
        return new ModelAndView(destinationPage);
    }

}
