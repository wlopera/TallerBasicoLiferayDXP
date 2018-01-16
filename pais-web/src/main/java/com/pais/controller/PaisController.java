package com.pais.controller;

import com.pais.api.PaisApi;
import com.pais.model.Pais;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jodd.json.JsonSerializer;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/pais")
public class PaisController extends Application {

    /*
     * Private attributes
     */
    private PaisApi paisApi; 

	private String paisesData = "{\"paises\":["
			+ "{\"nombre\":\"Argentina\",\"capital\":\"Buenos Aires\",\"moneda\":\"Peso\",\"idioma\":\"Espa\u00f1ol\"},"
			+ "{\"nombre\":\"Brasil\",\"capital\":\"Brasilia\",\"moneda\":\"Cruzeiro Real\",\"idioma\":\"Portugues\"},"
			+ "{\"nombre\":\"Colombia\",\"capital\":\"Bogota\",\"moneda\":\"Peso\",\"idioma\":\"Espa\u00f1ol\"},"
			+ "{\"nombre\":\"Panam\u00e1\",\"capital\":\"Panam\u00e1\",\"moneda\":\"Balb\u00f3a\",\"idioma\":\"Espa\u00f1ol\"},"
			+ "{\"nombre\":\"Canad\u00e1\",\"capital\":\"Otawa\",\"moneda\":\"D\u00f3lar\",\"idioma\":\"Ingles\"},"
			+ "{\"nombre\":\"Italia\",\"capital\":\"Roma\",\"moneda\":\"Lira\",\"idioma\":\"Italiano\"},"
			+ "{\"nombre\":\"Jap\u00f3n\",\"capital\":\"Tokio\",\"moneda\":\"Yen\",\"idioma\":\"Japon\u00e9s\"},"
			+ "{\"nombre\":\"Venezuela\",\"capital\":\"Caracas\",\"moneda\":\"Bol\u00edvar\",\"idioma\":\"Espa\u00f1ol\"}"
			+ "]}";
	

    // ------------------------´
    // Public Methods
    // ------------------------

	/**
	 * Permite consultar la lista de paises actuales
	 * @return Lista de paises 
	 */
    @GET
    @Path("getPaises/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaises() {
        return new JsonSerializer().serialize(paisApi.obtenerlistaPaises());
    }
    
    /**
	 * Permite consultar la lista de paises originales
	 * @return Lista de paises 
	 */
    @GET
    @Path("reiniciarPaises/")
    @Produces(MediaType.APPLICATION_JSON)
    public String reiniciarPaises() {
    	return new JsonSerializer().serialize(paisApi.obtenerListaPaisesOriginales());
    }

    /**
	 * Permite agregar un pais a la lista de paises actuales
	 * @return Lista de paises 
	 */
    @POST
    @Path("agregarPais/")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
    public String agregarPais(Pais pais) {
    	return new JsonSerializer().serialize(paisApi.agregarPais(pais));
    }
    
    /**
	 * Permite modificar un pais de la lista de paises actuales
	 * @return Lista de paises 
	 */
    @POST
    @Path("modificarPais/")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
    public String modificarPais(Pais pais) {
    	return new JsonSerializer().serialize(paisApi.modificarPais(pais));
    }

    /**
	 * Permite eliminar un pais de la lista de paises actuales
	 * @return Lista de paises 
	 */
    @POST
    @Path("borrarPais/")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
    public String borrarPais(Pais pais) {    	
    	return new JsonSerializer().serialize(paisApi.borrarPais(pais));
    }
  
    /**
	 * SERVICION DUMMY para consultar la lista de paises
	 * @return Lista de paises 
	 */
    @GET
    @Path("getPaisesDUMMY/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaisesDummy() {
    	return new JsonSerializer().serialize(paisesData);
    }
    
    // ------------------------
    // OSGI References
    // ------------------------

    @Reference
    public void setPaisApi(PaisApi paisApi) {
        this.paisApi = paisApi;
    }
    
    // ------------------------
    // Rest Application Config
    // ------------------------

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }
}
