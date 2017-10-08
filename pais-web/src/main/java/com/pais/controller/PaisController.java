package com.pais.controller;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;

import jodd.json.JsonSerializer;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/pais")
public class PaisController extends Application {
	private String paises = "{\"paises\":["
			+ "{\"nombre\":\"Argentina\",\"capital\":\"Buenos Aires\",\"moneda\":\"Peso\",\"idioma\":\"Espa\u00f1ol\"},"
			+ "{\"nombre\":\"Brasil\",\"capital\":\"Brasilia\",\"moneda\":\"Cruzeiro Real\",\"idioma\":\"Portugues\"},"
			+ "{\"nombre\":\"Colombia\",\"capital\":\"Bogota\",\"moneda\":\"Peso\",\"idioma\":\"Espa\u00f1ol\"},"
			+ "{\"nombre\":\"Panam\u00e1\",\"capital\":\"Panam\u00e1\",\"moneda\":\"Balb\u00f3a\",\"idioma\":\"Espa\u00f1ol\"},"
			+ "{\"nombre\":\"Canad\u00e1\",\"capital\":\"Otawa\",\"moneda\":\"D\u00f3lar\",\"idioma\":\"Ingles\"},"
			+ "{\"nombre\":\"Italia\",\"capital\":\"Roma\",\"moneda\":\"Lira\",\"idioma\":\"Italiano\"},"
			+ "{\"nombre\":\"Jap\u00f3n\",\"capital\":\"Tokio\",\"moneda\":\"Yen\",\"idioma\":\"Japon\u00e9s\"},"
			+ "{\"nombre\":\"Venezuela\",\"capital\":\"Caracas\",\"moneda\":\"Bol\u00edvar\",\"idioma\":\"Espa\u00f1ol\"}"
			+ "]}";
  
    @GET
    @Path("getPaises/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaises() {
    	return new JsonSerializer().serialize(paises);
    }
    
    // ------------------------
    // Rest Application Config
    // ------------------------

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }
}
