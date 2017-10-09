(function(win) {
  "use strict";

  var WS_PATH = "/o/api/pais";

  var paisService = function($log, serviceInvoker) {

    $log.info("Consumiendo servicio paisService");

    // Consultar de Paises
    function getPaises() {
      return serviceInvoker.invoke("GET", WS_PATH + "/getPaises");
    }

    // Reiniciar Paises
    function reiniciarPaises() {
      return serviceInvoker.invoke("GET", WS_PATH + "/reiniciarPaises");
    }
    
    // Agregar Pais
    function agregarPais(pais) {
        return serviceInvoker.invoke("POST", WS_PATH + "/agregarPais", pais);
    }

    // Modificar Pais
    function modificarPais(pais) {
        return serviceInvoker.invoke("POST", WS_PATH + "/modificarPais", pais);
    }

    // Borrar Pais
    function borrarPais(pais) {
        return serviceInvoker.invoke("POST", WS_PATH + "/borrarPais", pais);
    }
    return {
    	getPaises: getPaises,
    	reiniciarPaises: reiniciarPaises,
    	agregarPais: agregarPais,
    	modificarPais: modificarPais,
    	borrarPais: borrarPais
    };

  };

  paisService.$inject = ["$log", "serviceInvoker"];

  win.MainApp.Services.service("paisService", paisService);

}(window));