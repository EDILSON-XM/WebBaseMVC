<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!--    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="../estilo.css" rel="stylesheet">
<title>Listado de empleados</title>
</head>
<body>
	<main>-->  
	<c:import url="/plantilla/cabecera.jsp"></c:import>

		<h1>Listado de los empleados</h1>
		
		
		<table class="fl-table">
		<thead>
			<tr>
				<th>DNI</th>
				<th>nombre</th>
				<th> sexo </th>
				<th>fecha de nacimiento</th>
				<th>fecha de incorporacion</th>
				<th>salario Empleado</th>
				<th>comision Empleado</th>
				<th>cargo Empleado</th>
				<th>jefe departamento</th>
				<th>codigo de departamento</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${listaEmpleados==null or listaEmpleados.size()==0}">
			<h2>No se han encontrado datos de los empleados</h2>
		</c:if>
	
		<c:forEach var="emp" items="${listaEmpleados}">
	    	<tr>
	    		<td>${emp.nDIEmp}</td>
	    		<td>${emp.nomEmp}</td>
	    		<td>${emp.sexEmp}</td>
	    		<td>${emp.fecNac}</td>
	    		<td>${emp.fecIncorporacion}</td>
	    		<td>${emp.salEmp}</td>
	    		<td>${emp.comisionE}</td>
	    		<td>${emp.cargoE}</td>
	    		<td>${emp.jefeID}</td>
	    		<td>${emp.codDepto}</td>
	    		
	    		<td><a href="eliminar?codDepto=${emp.nDIEmp}">
	    		         <ion-icon name="close-circle-outline" class="grande"></ion-icon> 
	    		    </a>
	    		</td>
	    		<td><a href="modificar?nDIEmp=${emp.nDIEmp}">
	    		         <ion-icon name="pencil-outline" class="grande"></ion-icon> 
	    		    </a>
	    		</td>
	    	</tr> 
		</c:forEach>
		</tbody>
		</table>
		<c:import url="/plantilla/pie.jsp"></c:import>
		<!--  
		</main>
</body>
</html>-->