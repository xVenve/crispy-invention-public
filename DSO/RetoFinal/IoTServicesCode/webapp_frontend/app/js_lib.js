var server_address = "http://34.107.49.43:5000/" // IP Microservicios

var device = '';
var list_of_devices;

var get_current_sensor_data = function() {
	$.getJSON( server_address+"dso/measurements/", function( data ) {
		$(".sensor_measures").empty();
		for (var i = 0; i<data.length; i++){
			var measure = data[i];
			if (measure.device==device)
				$("<tr class='item'><td>"+measure.date+"</td><td>"+measure.temperature+"</td><td>"+measure.humidity+"</td></tr>").appendTo("#mes");
		}
	});
}

var get_device_list = function(){
	$.getJSON( server_address+"dso/devices/", function( data ) {
		$(".device_list").empty();
		list_of_devices = data;
		for (var i = 0; i<data.length; i++){
			var device = data[i];
			$("<tr class='item'><td>"+device.device_id+"</td><td>"+device.status+"</td><td>"+device.location+"</td><td>"+device.date+"</td><td><button class='boton' onclick='mostrar_medidas("+i+")'>Medidas</button></td></tr>").appendTo("#dev");
		}
	});
}

function mostrar_medidas(id) {
	document.getElementById("medidas").style.display = "block";
	document.getElementById("dispositivos").style.display = "none";
	device = list_of_devices[id].device_id;
	document.getElementById('titulo_medidas').innerHTML = 'Mediciones del dispositivo ' + device;
}

function mostrar_dispositivos() {
	document.getElementById("medidas").style.display = "none";
	document.getElementById("dispositivos").style.display = "block";
}

get_device_list()
setInterval(get_current_sensor_data,2000)

