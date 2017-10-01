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
	    "javax.portlet.security-role-ref=power-user,user" 
	}, service = Portlet.class)
public class PaisPortlet extends MVCPortlet { 
}
