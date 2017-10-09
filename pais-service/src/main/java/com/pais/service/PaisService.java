/**
 * Clase que permite a modo de ejercicio:
 * 	- Consultar lista de paises originales
 *  - Agregar un pais a la lista de paises 
 *  - Modificar un pais a la lista de paises
 *  - Borrar un pais d ela lista de la lista de paises.
 *  - Reiniciar el listado de paises 
 *          
 *  Nota: la lista de paises se simula a traves de una clase que permite
 *        consultar un json con la lista de paises originales.
 *        
 *  @author wlopera 
 */

package com.pais.service;

import com.pais.api.PaisApi;
import com.pais.model.Pais;
import com.pais.util.JSONRead;

import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = PaisApi.class)
public class PaisService implements PaisApi {
	private List<Pais> paises;

	/**
	 * Permite obtener la lista de paises actuales
	 * 
	 * @author wlopera
	 * @return Lista de paises con o sin cambios
	 */
	@Override
	public List<Pais> obtenerlistaPaises() {
		if (paises == null || paises.size() == 0) {
			paises = obtenerListaPaisesOriginales();
		}
		return paises;
	}

	/**
	 * Permite obtener la lista de paises originales
	 * 
	 * @author wlopera
	 * @return Lista de paises sin cambios
	 */
	@Override
	public List<Pais> obtenerListaPaisesOriginales() {
		paises = new JSONRead().getDataPaises();
		return paises;
	}

	/**
	 * Permite agregar un pais a la lista de paises actuales
	 * 
	 * @author wlopera
	 * 
	 * @param pais Pais a agregar
	 * @return Lista de paises actualizada
	 */
	@Override
	public List<Pais> agregarPais(Pais pais) {
		pais.setId(String.valueOf(paises.size() + 1));
		paises.add(pais);
		return paises;
	}

	/**
	 * Permite modificar un pais de la lista de paises actuales
	 * 
	 * @author wlopera
	 * 
	 * @param pais Pais a modificar
	 * @return Lista de paises actualizada
	 */
	@Override
	public List<Pais> modificarPais(Pais pais) {
		for (Pais paisTemp : paises) {
			if (pais.getId().equals(paisTemp.getId())) {
				paisTemp.setNombre(pais.getNombre());
				paisTemp.setCapital(pais.getCapital());
				paisTemp.setMoneda(pais.getMoneda());
				paisTemp.setIdioma(pais.getIdioma());
				break;
			}
		}
		return paises;
	}

	/**
	 * Permite borrar un pais de la lista de paises actuales
	 * 
	 * @author wlopera
	 * 
	 * @param pais Pais a borrar
	 * @return Lista de paises actualizada
	 */
	@Override
	public List<Pais> borrarPais(Pais pais) {
		Iterator<Pais> iterator = paises.iterator();
		while (iterator.hasNext()) {
			Pais itPais = iterator.next();
			if (itPais.getId().equals(pais.getId())) {
				iterator.remove();
				break;
			}
		}
		return paises;
	}
}
