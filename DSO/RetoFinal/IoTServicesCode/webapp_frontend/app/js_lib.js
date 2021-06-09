const server_address = "http://34.107.92.88:5000/"; // IP Microservicios

let device = '';
let list_of_devices;
minDateFilter = "";
maxDateFilter = "";

let get_current_sensor_data = function () {
	$.getJSON(server_address + "dso/measurements/", function (data) {
		$(".itemm").remove();
		for (let i = 0; i < data.length; i++) {
			let measure = data[i];
			var date1 = measure.date.split(" ");
			var date2 = date1[0].split("/");
			var date = new Date(date2[2]+'-'+date2[1]+'-'+date2[0]);
			var min = false;
            var max = false;
			if (minDateFilter == ""){
                min = true;
            } else {
			  if(date.getTime() >= minDateFilter.getTime())
			    min = true;
            }
			if (maxDateFilter == ""){
                max = true;
            } else {
			  if(date.getTime() <= maxDateFilter.getTime())
			    max = true;
            }
			if (measure.device == device && min && max)
				$("<tr class='itemm it'><td>" + measure.date + "</td><td>" + measure.temperature + "</td><td>" + measure.humidity + "</td></tr>").appendTo("#mes");
		}
	});
};

let get_device_list = function () {
	$.getJSON(server_address + "dso/devices/", function (data) {
		$(".itemd").remove();
		list_of_devices = data;
		for (let i = 0; i < data.length; i++) {
			let device = data[i];
			$("<tr class='itemd  it'><td>" + device.device_id + "</td><td>" + device.status + "</td><td>" + device.location + "</td><td>" + device.date + "</td><td><button class='boton' onclick='mostrar_medidas(" + i + ")'>Medidas</button></td></tr>").appendTo("#dev");
		}
	});
};

function mostrar_medidas(id) {
  	get_current_sensor_data()
	document.getElementById("medidas").style.display = "block";
	document.getElementById("dispositivos").style.display = "none";
	device = list_of_devices[id].device_id;
	document.getElementById('titulo_medidas').innerHTML = 'Mediciones del dispositivo ' + device;
}

function mostrar_dispositivos() {
	document.getElementById("medidas").style.display = "none";
	document.getElementById("dispositivos").style.display = "block";
}

$(function() {
  var oTable = $('#datatable').DataTable({
    "oLanguage": {
      "sSearch": "Filter Data"
    },
    "iDisplayLength": -1,
    "sPaginationType": "full_numbers",

  });

  $("#datepicker_from").datepicker({
    showOn: "button",
    buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
    buttonImageOnly: false,
    "onSelect": function(date) {
      minDateFilter = new Date(date);
      get_current_sensor_data()
      oTable.fnDraw();
    }
  }).keyup(function() {
    minDateFilter = new Date(this.value);
    get_current_sensor_data()
    oTable.fnDraw();
  });

  $("#datepicker_to").datepicker({
    showOn: "button",
    buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
    buttonImageOnly: false,
    "onSelect": function(date) {
      maxDateFilter = new Date(date);
      get_current_sensor_data()
      oTable.fnDraw();
    }
  }).keyup(function() {
    maxDateFilter = new Date(this.value);
    get_current_sensor_data()
    oTable.fnDraw();
  });

});


setInterval(get_device_list,2000)
// setInterval(get_current_sensor_data,2000)