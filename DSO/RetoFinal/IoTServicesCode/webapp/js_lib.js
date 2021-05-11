var server_address = "http://34.89.209.120:5000/" // IP Microservicios

var temp_tabla = 0;
var hum_tabla = 0;

var get_current_sensor_data = function() {
	$.getJSON( server_address+"dso/measurements/", function( data ) {
		temp = data.temperature;
		hum = data.humidity;
		$( ".sensor_measures" ).html( "Temperature: " + temp + " C \nHumidity " + hum + " %" );
	});
}

var get_device_list = function(){
	$.getJSON( server_address+"dso/devices/", function( data ) {
		$( ".device_list" ).html( "Device Id: " + data.device_id);
	});
}

function insert_table() {
	var rowCount = $('table tr').length;
	if(rowCount > 10) $("table tr:eq(1)").remove();
	$("table tbody").append("<tr><td>" + temp + " C </td><td>" + hum + " %</td></tr>");
}
function mostrar_medidas(nombre){
	document.getElementById("medidas").style.display = "block";
	document.getElementById("dispositivos").style.display = "none";
}

function mostrar_dispositivos(){
	document.getElementById("medidas").style.display = "none";
	document.getElementById("dispositivos").style.display = "block";

}

get_device_list()
setInterval(get_current_sensor_data,2000)
setInterval(insert_table,3000)
