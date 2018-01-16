/**
 *  Clase que permite leer los datos de un archivo json.
 * 
 *  En este ejercicio se consulta la lista de paises de un archivo paises.json
 *  
 *  @author lopera
 */
package com.pais.util;

import com.pais.model.Pais;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONRead {	

	public List<Pais> getDataPaises() {

		JSONParser parser = new JSONParser();
		try {
			List<Pais> paises = new ArrayList<Pais>();
			InputStream is = JSONRead.class.getResourceAsStream("/paises.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			Object obj = parser.parse(sb.toString());

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray tags = (JSONArray) jsonObject.get("paises");
			Pais pais;
			for (int i = 0; i < tags.size(); i++) {
				JSONObject jsonObj = (JSONObject) tags.get(i);
				pais = new Pais();
				pais.setId(jsonObj.get("id").toString());
				pais.setNombre(jsonObj.get("nombre").toString());
				pais.setCapital(jsonObj.get("capital").toString());
				pais.setMoneda(jsonObj.get("moneda").toString());
				pais.setIdioma(jsonObj.get("idioma").toString());
				paises.add(pais);
			}
			return paises;
		} catch (Exception e) {
			System.out.println("getDataPaises - error: " + e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {

		JSONRead jsonRead = new JSONRead();

		List<Pais> paises = jsonRead.getDataPaises();
		for (Pais pais : paises) {
			System.out.println(pais);
		}
	}
}
