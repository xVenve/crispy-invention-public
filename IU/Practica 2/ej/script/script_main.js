//Funciones para manejar los popups
$(document).ready(function() {
  popups('#NOVEDADES', '#popup_novedades');
  popups('#cierre_sesion', '#popup_sesion');
  popups('#NOTICIAS', '#popup_noticias');
  popups('#NOVEDADES_h', '#popup_novedades');
  popups('#NOTICIAS_h', '#popup_noticias');
  popups('#NOVEDADES_t', '#popup_novedades');
  popups('#NOTICIAS_t', '#popup_noticias');
  popups('#cierre_sesion_h', '#popup_sesion');
  start();
});

function popups(nombre, seccion) {
  $(nombre).on('click', function() {
    $(seccion).fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function() {
    $(seccion).fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
}

//Funciones que hacen funcionar el addon del calendario.
$(function() {
  $("#calendar_novedades").simpleCalendar();
});

$("#calendar_novedades").simpleCalendar({
  // displays events
  displayEvent: true,

  // event dates
  events: [{
      startDate: new Date("2020-10-1"),
      endDate: new Date("2020-10-1"),
      summary: 'Nuevo video subido: La historia de la web'
    },
    {
      startDate: new Date("2020-09-29"),
      endDate: new Date("2020-09-29"),
      summary: 'Nuevo articulo subido: Introduccion a HTML'
    },
    {
      startDate: new Date("2020-9-18"),
      endDate: new Date("2020-9-18"),
      summary: 'Foro de la asignatura habilitado'
    },
    {
      startDate: new Date("2020-9-14"),
      endDate: new Date("2020-9-14"),
      summary: 'Bienvenida a la asignatura'
    }
  ],

  // disable showing event details
  disableEventDetails: false,

  // disable showing empty date details
  disableEmptyDetails: true
});

$(function() {
  $("#calendar_noticias").simpleCalendar();
});


$("#calendar_noticias").simpleCalendar({
  // displays events
  displayEvent: true,

  // event dates
  events: [{
      startDate: new Date("2020-10-5"),
      endDate: new Date("2020-10-5"),
      summary: 'Entrega practica en dos días'
    },
    {
      startDate: new Date("2020-10-1"),
      endDate: new Date("2020-10-1"),
      summary: 'Clase online magistral para el dia 3 de octubre'
    },
    {
      startDate: new Date("2020-9-28"),
      endDate: new Date("2020-9-28"),
      summary: 'Tutoria colectiva en tres días'
    }
  ],
  // disable showing event details
  disableEventDetails: false,

  // disable showing empty date details
  disableEmptyDetails: true
});

//Conjunto de funciones que especifican la disposición de la página al pinchar sobre diferentes elementos.
function start() {
  document.getElementById("CENTRAL_REGISTRO").style.display = "none";
  document.getElementById("CENTRAL_INICIO").style.display = "block";
  document.getElementById("RIGHT").style.display = "none";
  document.getElementById("LINKS").style.display = "none";
  document.getElementById("OPTIONS").style.display = "none";
  document.getElementById("user_zone").style.display = "none";
  document.getElementById("CENTRAL_FORO").style.display = "none";
  document.getElementById("CENTRAL_MAIN").style.display = "none";
  document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
  document.getElementById("CENTRAL_LISTA").style.display = "none";
  document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
  document.getElementById("CENTRAL_TEMA1").style.display = "none";
  document.getElementById("CENTRAL_TEMA2").style.display = "none";
  document.getElementById("HAMBURGUER").style.display = "none";


}

document.getElementById("boton_registro").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_REGISTRO").style.display = "block";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
  });

document.getElementById("linkforo_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_FORO").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });

document.getElementById("linkforo").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_FORO").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });

document.getElementById("linkcalificaciones").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";
  });

document.getElementById("linkcalificaciones_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });

document.getElementById("linkestudiantes").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });

document.getElementById("linkestudiantes_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });

document.getElementById("linkasignaturas").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "block";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });



document.getElementById("linkmain").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";


  });

document.getElementById("linkmain_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "none";

  });

document.getElementById("TEMA1_FORO").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_TEMA1").style.display = "block";

  });

document.getElementById("TEMA2_FORO").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_TEMA2").style.display = "block";

  });

var user_name_logged;

//función que lleva a cabo el proceso de inicio de sesión.
function inicioSesion() {
  var x = document.forms["Formulario_Inicio_Sesion"]["contraseña"].value;
  var y = document.forms["Formulario_Inicio_Sesion"]["email_inicio"].value;

  if (x == "") {
    alert("Debe rellenar la contraseña");
    return false;
  }
  if (y == "") {
    alert("Debe rellenar el email");
    return false;
  }

  if (getCookie("email_inicio_" + x) == y) {

    $(document).ready(document.getElementById("welcome").innerHTML = "Hola, " + getCookie("nombre_inicio_" + y));
    $(document).ready(document.getElementById("welcome_m").innerHTML = "Hola, " + getCookie("nombre_inicio_" + y));
    user_name_logged = getCookie("nombre_inicio_" + y);
    web_estudiante(y);
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("user_zone").style.display = "block";



    if ($(window).width() < 600) {
      document.getElementById("user_zone").style.display = "none";
      document.getElementById("HAMBURGUER").style.display = "block";

    } else if ($(window).width() > 768) {
      document.getElementById("LINKS").style.display = "block";
      document.getElementById("OPTIONS").style.display = "block";
      document.getElementById("RIGHT").style.display = "block";
    } else {
      document.getElementById("LINKS").style.display = "block";
    }
  } else {
    alert("Se debe registrar, cuenta no creada");
  }



}
//Funcion para obtener cookies.
function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
//Función usada para saber si un correo está duplicado.
function getCookieInverse(cname) {
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(cname) != -1) {
      return "Repetido";
    }
  }
  return "No Repetido";
}

//Funcion que diferencia las opciones de registro dependiendo del rol.
function rolEstudiante() {
  var x = document.getElementById("rol").value;
  if (x == "Estudiante") {
    document.getElementById("grado").style.display = "initial";
    document.getElementById("titulo_grado").style.display = "initial";
  } else {
    document.getElementById("grado").style.display = "none";
    document.getElementById("titulo_grado").style.display = "none";
  }

}
//Función que guarda los datos de un registro como cookie.
function guardar() {
  if (getCookieInverse(document.forms["Formulario_Registro"]["email_inicio"].value) == "Repetido") {
    alert("Ya existe una cuenta con este email");
    return false;
  }

  document.cookie = "nombre_inicio_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["nombre_inicio"].value;
  document.cookie = "NIA_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["NIA"].value;
  document.cookie = "contraseña_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["contraseña"].value;
  document.cookie = "nombre_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["nombre"].value;
  document.cookie = "apellidos_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["apellidos"].value;
  document.cookie = "email_inicio_" + document.forms["Formulario_Registro"]["contraseña"].value + "=" +
    document.forms["Formulario_Registro"]["email_inicio"].value;
  document.cookie = "fecha_nacimiento_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["fecha_nacimiento"].value;
  document.cookie = "DNI_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["DNI"].value;
  document.cookie = "rol_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["rol"].value;
  document.cookie = "grado_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["grado"].value;
  document.cookie = "universidad_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["universidad"].value;
  document.cookie = "idioma_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["idioma"].value;
}

//Función que diferencia la disposición de la página dependiendo del rol.
function web_estudiante(x) {
  if (getCookie("rol_" + x) == "Estudiante") {
    crear_notas();
    document.getElementById("linkasignaturas").style.display = "block";
    document.getElementById("linkestudiantes").style.display = "none";
    document.getElementById("TABLA_ESTUDIANTE").style.display = "table";
    document.getElementById("TABLA_PROFESOR").style.display = "none";
    document.getElementById("export_e").style.display = "block";
    document.getElementById("export_p").style.display = "none";


    return false;
  } else {
    document.getElementById("linkasignaturas").style.display = "none";
    document.getElementById("linkestudiantes").style.display = "block";
    document.getElementById("TABLA_ESTUDIANTE").style.display = "none";
    document.getElementById("TABLA_PROFESOR").style.display = "table";
    document.getElementById("export_e").style.display = "none";
    document.getElementById("export_p").style.display = "block";
    return false;
  }
}
//Método para generar aleatoriamente las notas de calificaciones.
function crear_notas() {
  var a1 = document.getElementById("act1").innerHTML = Math.floor(Math.random() * 1000) / 100;
  var a2 = document.getElementById("act2").innerHTML = Math.floor(Math.random() * 1000) / 100;
  var a3 = document.getElementById("act3").innerHTML = Math.floor(Math.random() * 1000) / 100;
  var m = document.getElementById("media").innerHTML = Math.floor((a1 + a2 + a3) * 100 / 3) / 100;
}

//Método para enviar un mensaje en el foro
function enviar_mensaje(ntema) {
  var node = document.createElement("LI");
  var m = document.getElementById("mensaje_tema" + ntema).value;

  date_ob = new Date();
  date = ("0" + date_ob.getDate()).slice(-2);
  month = ("0" + (date_ob.getMonth() + 1)).slice(-2);
  year = date_ob.getFullYear();

  hours = ("0" + date_ob.getHours()).slice(-2);
  minutes = ("0" + date_ob.getMinutes()).slice(-2);

  today = date + "/" + month + "/" + year + " " + hours + ":" + minutes;
  node.innerHTML =
    "<img class=\"AVATAR\" class=\"col - 3\" src=\"./images\/user\-default.png\" alt=\"UC3M Logo\" \/\>" +
    getCookie("nombre_" + user_name_logged) + " " + getCookie("apellidos_" + user_name_logged) + " " + today +
    "<p class = \"DESCRIPTION\">" + m + "</p>";
  document.getElementById("tema" + ntema + "foro").appendChild(node);
}

//Métodos para descargar la tabla de calificaciones en formato excel.
$("#export_e").click(function() {
  $("#TABLA_ESTUDIANTE").table2excel({
    // exclude CSS class
    exclude: ".noExl",
    name: "Data",
    filename: "calificaciones" //do not include extension
  });
});

$("#export_p").click(function() {
  $("#TABLA_PROFESOR").table2excel({
    // exclude CSS class
    exclude: ".noExl",
    name: "Data",
    filename: "calificaciones" //do not include extension
  });
});
