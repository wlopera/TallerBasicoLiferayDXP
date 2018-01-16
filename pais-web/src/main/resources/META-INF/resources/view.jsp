<%@ include file="/init.jsp"%>

<div class='row' ng-controller='PaisController as ctrl'>

	<div class="col-sm-6">
		<p style="padding-left: 1cm">
			<button type="button" class="btn btn-success btn-small"
				ng-click="ctrl.getPaises()">
				<span class="glyphicon glyphicon-search"></span> Países
			</button>
			<a id="reiniciar" href ng-click="ctrl.reiniciarPaises()">Reiniciar</a>
		</p>
		
			<hr>
			<div class="table table-fixed tabla">
				<table class="table table-striped">
					<thead>
						<tr>
							<th align="center">NOMBRE</th>
							<th align="center">CAPITAL</th>
							<th align="center">MONEDA</th>
							<th align="center">IDIOMA</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="pais in ctrl.paises" ng-click="ctrl.seleccionarPais(pais);">
							<td>{{pais.nombre}}</td>
							<td>{{pais.capital}}</td>
							<td>{{pais.moneda}}</td>
							<td>{{pais.idioma}}</td>
						</tr>
					</tbody>
				</table>
			</div>

	</div>
	<div class="col-sm-6">
		<h2>Modificar o agregar país</h2>
		<hr>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pwd">País:</label>
			<div class="col-sm-9">
				<input type="input" class="form-control" placeholder="Pais"
					name="pais" ng-model="ctrl.pais.nombre">				
			</div>
			<br><br>
			
			<label class="control-label col-sm-3" for="pwd">Capital:</label>
			<div class="col-sm-9">
				<input type="input" class="form-control" placeholder="Capital"
					name="capital" ng-model="ctrl.pais.capital">
			</div>
			<br><br>
			
			<label class="control-label col-sm-3" for="pwd">Moneda:</label>
			<div class="col-sm-9">
				<input type="input" class="form-control" placeholder="Moneda" 
				  name="modeda" ng-model="ctrl.pais.moneda">
			</div>
		  <br><br>
			<label class="control-label col-sm-3" for="pwd">Idioma:</label>
			<div class="col-sm-9">
				<input type="input" class="form-control" placeholder="Idioma" 
				  name="idioma" ng-model="ctrl.pais.idioma">
			</div>
			 <br><br>
		</div>
		<button type="button" class="btn btn-success btn-small"
			ng-click="ctrl.agregarPais();">
			<span class="glyphicon glyphicon-plus"></span> Agregar
		</button>
		
		<button type="button" class="btn btn-success btn-small"
			ng-click="ctrl.modificarPais();">
			<span class="glyphicon glyphicon-pencil"></span> Modificar
		</button>
		
		<button type="button" class="btn btn-success btn-small"
			ng-click="ctrl.borrarPais();">
			<span class="glyphicon glyphicon-minus"></span> Borrar
		</button>
		
		<button type="button" class="btn btn-success btn-small"
			ng-click="ctrl.limpiarCampos();">
			<span class="glyphicon glyphicon-trash"></span> Limpiar
		</button>	
	</div>
</div>