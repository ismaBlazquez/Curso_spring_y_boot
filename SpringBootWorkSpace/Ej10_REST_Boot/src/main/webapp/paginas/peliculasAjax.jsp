<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script>

xmlHttp = new XMLHttpRequest();

function buscarPelicula(id){
	xmlHttp.open("GET","peliculas/"+id,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			//alert(this.responseText);
			rellenarFormulario(JSON.parse(this.responseText));
		}		
	};
	xmlHttp.send(null);
}

function rellenarFormulario(pelicula){
	with(document.formulario){
		document.getElementById('id').value = pelicula.id;
		titulo.value   = pelicula.titulo;
		director.value = pelicula.director;
		genero.value   = pelicula.genero;
		year.value     = pelicula.year;		
	}
}

function listarPeliculas(){
	xmlHttp.open("GET","peliculas",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			//alert(this.responseText);
			rellenarTabla(JSON.parse(this.responseText));
		}		
	};
	xmlHttp.send(null);
}

function rellenarTabla(peliculas){
	
	tabla = document.getElementById("tablaPeliculas");
	tabla.innerHTML = "";
	
	for(var a=0; a<peliculas.length; a++){
		
		p = peliculas[a];
		
		tr = document.createElement("tr");
		td1 = document.createElement("td");
		td2 = document.createElement("td");
		td3 = document.createElement("td");
		td4 = document.createElement("td");
		txt1 = document.createTextNode(p.titulo);
		txt2 = document.createTextNode(p.director);
		txt3 = document.createTextNode(p.genero);
		txt4 = document.createTextNode(p.year);
		td1.appendChild(txt1);
		td2.appendChild(txt2);
		td3.appendChild(txt3);
		td4.appendChild(txt4);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		
		//Para la selección:
		atr = document.createAttribute("id");
		atr.value = p.id;
		tr.setAttributeNode(atr);
		
		tr.onclick = function(){
			buscarPelicula(this.id);
		}
		
		tabla.appendChild(tr);		
	}
}

function insertar(){

	with(document.formulario){
		pelicula = { "id"       : id.value,
				     "titulo"   : titulo.value,
		             "director" : director.value,
			         "genero"   : genero.value,
			         "year"     : year.value };
	}
	
	xmlHttp.open("POST","peliculas",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarPeliculas();
			vaciar();
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send(JSON.stringify(pelicula));	
}

function modificar(){

	alert(document.getElementById('id').value);
	with(document.formulario){
		pelicula = { "id"       : document.getElementById('id').value,
				     "titulo"   : titulo.value,
		             "director" : director.value,
			         "genero"   : genero.value,
			         "year"     : year.value };
	}
	
	xmlHttp.open("PUT","peliculas",true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarPeliculas();
			vaciar();
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send(JSON.stringify(pelicula));	
}

function borrar(){
	alert(document.getElementById('id').value);

	xmlHttp.open("DELETE","peliculas/"+document.getElementById('id').value,true);
	xmlHttp.onreadystatechange = function(){
		if( this.readyState == 4 ){
			listarPeliculas();
			vaciar()
		}		
	};
	xmlHttp.setRequestHeader("Content-Type", 
			                 "application/json;charset=UTF-8")
	xmlHttp.send();	
}

function vaciar(){
	document.formulario.reset();
}

</script>

<body onload="listarPeliculas()">

	<h1 align="center">
		Películas
	</h1>
	
	<form name="formulario">
	
		<p align="center">
			<input type="button" value="Insertar"  onclick="insertar()"/>
			<input type="button" value="Modificar" onclick="modificar()"/>
			<input type="button" value="Borrar"    onclick="borrar()"/>
			<input type="button" value="Vaciar"    onclick="vaciar()"/>
		</p>

		<input type="hidden" id="id" name="id"/>
	
		<table align="center">
			<tr>
				<td>Título</td>
				<td>
					<input type="text" id="titulo"/>
				</td>
			</tr>
			<tr>
				<td>Director</td>
				<td>
					<input type="text" id="director"/>
				</td>
			</tr>
			<tr>
				<td>Género</td>
				<td>
					<input type="text" id="genero"/>
				</td>
			</tr>
			<tr>
				<td>Año</td>
				<td>
					<input type="text" id="year"/>
				</td>
			</tr>
		</table>

		<table align="center" width="500px" border="1">
			<tr>
				<th>Título</th>
				<th>Director</th>
				<th>Género</th>
				<th>Año</th>
			</tr>
			<tbody id="tablaPeliculas"></tbody>
		</table>
	
	</form>


</body>
</html>




