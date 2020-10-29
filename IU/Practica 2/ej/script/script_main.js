$(document).ready(function () {
  popups('#NOVEDADES', '#popup_novedades');
  popups('#cierre_sesion', '#popup_sesion');
  popups('#NOTICIAS', '#popup_noticias');
  start();
});

function popups(nombre, seccion) {
  $(nombre).on('click', function () {
    $(seccion).fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function () {
    $(seccion).fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
}

$(function () {
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

$(function () {
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
  document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
  document.getElementById("CENTRAL_TEMA1").style.display = "none"

}

document.getElementById("boton_registro").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_REGISTRO").style.display = "block";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("RIGHT").style.display = "none";
    document.getElementById("LINKS").style.display = "none";
    document.getElementById("OPTIONS").style.display = "none";
    document.getElementById("user_zone").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"

  });

document.getElementById("linkforo_h").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_FORO").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"

  });

document.getElementById("linkforo").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_FORO").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"


  });

document.getElementById("linkcalificaciones").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"


  });

document.getElementById("linkcalificaciones_h").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"


  });

document.getElementById("linkestudiantes").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_LISTA").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_TEMA1").style.display = "none"

  });

document.getElementById("linkestudiantes_h").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_LISTA").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_TEMA1").style.display = "none"

  });

document.getElementById("linkasignaturas").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "block";
    document.getElementById("CENTRAL_TEMA1").style.display = "none"

  });



document.getElementById("linkmain").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"


  });

document.getElementById("linkmain_h").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "none"


  });

document.getElementById("TEMA1_FORO").addEventListener("click",
  function () {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_REGISTRO").style.display = "none";
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("CENTRAL_ASIGNATURAS").style.display = "none"
    document.getElementById("CENTRAL_TEMA1").style.display = "block"

  });

var user_name_logged;

function inicioSesion() {
  var x = document.forms["Formulario_Inicio_Sesion"]["nombre_inicio"].value;
  var y = document.forms["Formulario_Inicio_Sesion"]["email_inicio"].value;

  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
  if (y == "") {
    alert("Email must be filled out");
    return false;
  }

  if (getCookie("email_inicio_" + x) == y) {
    $(document).ready(document.getElementById("welcome").innerHTML = "Hola, " + getCookie("nombre_" + x) + " " +
      getCookie("apellidos_" + x));
    user_name_logged = x;
    web_estudiante(x);
    document.getElementById("CENTRAL_INICIO").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("user_zone").style.display = "block";
    document.getElementById("OPTIONS").style.display = "block";
    document.getElementById("RIGHT").style.display = "block";
    document.getElementById("LINKS").style.display = "block";
  } else {
    alert("Se debe registrar, cuenta no creada");
  }



}

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

function guardar() {
  document.cookie = "nombre_inicio_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["nombre_inicio"].value;
  document.cookie = "NIA_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["NIA"].value;
  document.cookie = "contraseña_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["contraseña"].value;
  document.cookie = "nombre_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["nombre"].value;
  document.cookie = "apellidos_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["apellidos"].value;
  document.cookie = "email_inicio_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["email_inicio"].value;
  document.cookie = "fecha_nacimiento_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["fecha_nacimiento"].value;
  document.cookie = "DNI_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["DNI"].value;
  document.cookie = "rol_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["rol"].value;
  document.cookie = "grado_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["grado"].value;
  document.cookie = "universidad_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["universidad"].value;
  document.cookie = "idioma_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" +
    document.forms["Formulario_Registro"]["idioma"].value;
}

function web_estudiante(x) {
  if (getCookie("rol_" + x) == "Estudiante") {
    alert("eres estudiante");
    crear_notas();
    document.getElementById("linkasignaturas").style.display = "block";
    document.getElementById("linkestudiantes").style.display = "none";
    document.getElementById("TABLA_ESTUDIANTE").style.display = "table";
    document.getElementById("TABLA_PROFESOR").style.display = "none";

    return false;
  } else {
    alert("Profesor o Administrador");
    document.getElementById("linkasignaturas").style.display = "none";
    document.getElementById("linkestudiantes").style.display = "block";
    document.getElementById("TABLA_ESTUDIANTE").style.display = "none";
    document.getElementById("TABLA_PROFESOR").style.display = "table";
    return false;
  }
}

function crear_notas() {
  var a1 = document.getElementById("act1").innerHTML = Math.floor(Math.random() * 1000) / 100;
  var a2 = document.getElementById("act2").innerHTML = Math.floor(Math.random() * 1000) / 100;
  var a3 = document.getElementById("act3").innerHTML = Math.floor(Math.random() * 1000) / 100;
  var m = document.getElementById("media").innerHTML = Math.floor((a1 + a2 + a3) * 100 / 3) / 100;
}

function enviar_mensaje() {
  var node = document.createElement("LI");
  var m = document.getElementById("mensaje_tema1").value;

  date_ob = new Date();
  date = date_ob.getDate();
  month = date_ob.getMonth() + 1;
  year = date_ob.getFullYear();

  hours = date_ob.getHours();
  minutes = date_ob.getMinutes();

  today = date + "/" + month + "/" + year + " " + hours + ":" + minutes;
  node.innerHTML =
    "<img class=\"AVATAR\" class=\"col - 3\" src=\"./images\/user\-default.png\" alt=\"UC3M Logo\" \/\>" +
    getCookie("nombre_" + user_name_logged) + " " + getCookie("apellidos_" + user_name_logged) + " " + today + "<p>" +
    m + "</p>";
  document.getElementById("tema1foro").appendChild(node);
}