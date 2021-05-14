var server_address = "http://34.107.49.43:5000/" // IP Microservicios

var device = '';

var get_current_sensor_data = function() {
	$.getJSON( server_address+"dso/measurements/", function( data ) {
		$(".sensor_measures").empty();
		$("<tr><th>Fecha</th><th>Temperatura °C</th><th>Humedad %</th></tr>").appendTo(".sensor_measures");
		for (var i = 0; i<data.length; i++){
			var measure = data[i];
			if (measure.device==device)
				$("<tr class='item'><td>"+measure.date+"</td><td>"+measure.temperature+"</td><td>"+measure.humidity+"</td></tr>").appendTo(".sensor_measures");
		}
	});
}

var get_device_list = function(){
	$.getJSON( server_address+"dso/devices/", function( data ) {
		$(".device_list").empty();
		$("<tr><th>Nombre del dispositivo</th><th>Estado</th><th>Ubicación</th><th>Fecha</th><th>Medidas</th></tr>").appendTo(".device_list");
		for (var i = 0; i<data.length; i++){
			var device = data[i];
			$("<tr class='item'><td>"+device.device+"</td><td>"+device.status+"</td><td>"+device.location+"</td><td>"+device.date+"</td><td><button class='boton' onclick='mostrar_medidas("+device.device+")'>Medidas</button></td></tr>").appendTo(".device_list");
		}
	});
}

function mostrar_medidas(nombre) {
	document.getElementById("medidas").style.display = "block";
	document.getElementById("dispositivos").style.display = "none";
	device = nombre;
	document.getElementById('titulo_medidas').innerHTML = 'Mediciones del dispositivo ' + nombre;
}

function mostrar_dispositivos() {
	document.getElementById("medidas").style.display = "none";
	document.getElementById("dispositivos").style.display = "block";
}

get_device_list()
setInterval(get_current_sensor_data,2000)
