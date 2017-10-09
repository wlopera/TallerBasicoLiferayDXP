package com.pais.api;

import com.pais.model.Pais;

import java.util.List;

public interface PaisApi {
	
	/**
	 * Permite obtener la lista de paises actuales
	 * 
	 * @author wlopera
	 * @return Lista de paises
	 */
    public List<Pais> obtenerlistaPaises();
    
    /**
	 * Permite obtener la lista de paises originales
	 * 
	 * @author wlopera
	 * @return Lista de paises
	 */
    public List<Pais> obtenerListaPaisesOriginales();
    
    /**
	 * Permite agregar un pais a la lista de paises actuales
	 * 
	 * @author wlopera
	 * 
	 * @param  pais Pais a agregar
	 * @return Lista de paises actualizada
	 */
    public List<Pais> agregarPais(Pais pais);
    
    /**
	 * Permite modificar un pais de la lista de paises actuales
	 * 
	 * @author wlopera
	 * 
	 * @param  pais Pais a modificar
	 * @return Lista de paises actualizada
	 */
    public List<Pais> modificarPais(Pais pais);
    
    /**
	 * Permite borrar un pais de la lista de paises actuales
	 * 
	 * @author wlopera
	 * 
	 * @param  pais Pais a borrar
	 * @return Lista de paises actualizada
	 */
    public List<Pais> borrarPais(Pais pais);
    
}