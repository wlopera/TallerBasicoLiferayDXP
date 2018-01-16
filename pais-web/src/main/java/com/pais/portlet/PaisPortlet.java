package com.pais.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
   
@Component(immediate = true, property = {
		"com.liferay.portlet.display-category=categoria.pais",
	    "com.liferay.portlet.instanceable=true",
	    "javax.portlet.display-name=Modulo OSGI. Pais-WEB Portlet",
	    "javax.portlet.init-param.template-path=/", 
	    "javax.portlet.init-param.view-template=/view.jsp",
	    "javax.portlet.resource-bundle=content.Language",
	    "javax.portlet.security-role-ref=power-user,user", 
	    "com.liferay.portlet.footer-portlet-javascript=/js/pais-service.js",
	    "com.liferay.portlet.footer-portlet-javascript=/js/pais-controller.js",
	    "com.liferay.portlet.header-portlet-css=https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css",
	    "com.liferay.portlet.footer-portlet-javascript=https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js",
	    "com.liferay.portlet.header-portlet-css=/css/estilo.css"
	}, service = Portlet.class)
public class PaisPortlet extends MVCPortlet { 
}
