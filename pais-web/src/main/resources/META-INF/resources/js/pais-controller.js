(function(win) {
  "use strict";

  var PaisController = function($log, $window, paisService) {

    $log.info("Consumir Controller PaisController");

    /*
     ==============
     VALUES
     ==============
   */

    // VM
    var vm = this;

    vm.paises = {};
    vm.pais = '';

    /*
     ==============
     METHODS
     ==============
    */

    // Consultar lista de paises
    vm.getPaises = function() {

     var xhr = paisService.getPaises();

      xhr.then(function(response) {        
        console.log(response);
        vm.paises = response.data;
      });

      xhr.catch(function(exception) {
        $log.error('error getPaises: '+exception);
      });

      xhr.finally(function() {
        $log.log("Fin getPaises");
      });

    };
        
    // Reiniciar lista de paises originales 
    vm.reiniciarPaises = function() {
    	console.log("##=> Reiniciar Paises: ");
    	var xhr = paisService.reiniciarPaises();
    	 
         xhr.then(function(response) {  
           vm.paises = response.data;
           vm.pais= "";
           console.log(response);
         });

         xhr.catch(function(exception) {
           $log.error('error reiniciando paises: '+exception);
         });        
    }
    
    // Agregar pais a la lista
    vm.agregarPais = function() {
    	console.log("##=> Agregar Pais: ", vm.pais);
    	 var xhr = paisService.agregarPais(vm.pais);
    	 
         xhr.then(function(response) {
           vm.paises = response.data;
           vm.pais= "";
           console.log(response);
         });

         xhr.catch(function(exception) {
           $log.error('error agregar pais: '+exception);
         });
    }
    // Modificar pais seleccionado 
    vm.modificarPais = function() {
    	console.log("##=> Modificar Pais: ", vm.pais);    	
    	var xhr = paisService.modificarPais(vm.pais);    	 
         xhr.then(function(response) { 
           vm.paises = response.data;           
           vm.pais= "";
           console.log(response);
         });

         xhr.catch(function(exception) {
           $log.error('error modificar pais: '+exception);
         });
    }
   
    // Borrar pais seleccionado 
    vm.borrarPais = function() {
    	console.log("##=> Borrar Pais: ", vm.pais);
    	var xhr = paisService.borrarPais(vm.pais);
    	 
         xhr.then(function(response) {  
           vm.paises = response.data;
           vm.pais= "";
           console.log(response);
         });

         xhr.catch(function(exception) {
           $log.error('error borrar pais: '+exception);
         });        
    }    
    
    // limpiar los campos de pais selecionado 
    vm.limpiarCampos = function() {
    	console.log("##=> Limpiar campos Pais");
    	vm.pais= "";
    }
    
    // Llena los campos de pais seleccionado 
    vm.seleccionarPais = function(item) {
    	vm.pais = {
			"id":item.id,
			"nombre":item.nombre,
			"capital":item.capital,
			"moneda":item.moneda,
			"idioma":item.idioma	
    	};
    }
    
    /*
     ==============
     SETUP
     ==============
    */
    vm.setup = function() {
    	vm.reiniciarPaises();
    };

    vm.setup();
  };

  /*
   ==============
   CONFIGURATION
   ==============
  */
  PaisController.$inject = [
    "$log",
    "$window",
    "paisService"
  ];

  win.MainApp.Controllers
    .controller("PaisController",
      PaisController);

}(window));
