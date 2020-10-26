$(document).ready(function () {
  $('#NOVEDADES').on('click', function () {
    $('#popup_novedades').fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function () {
    $('#popup_novedades').fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
});


$(document).ready(function () {
  $('#cierre_sesion').on('click', function () {
    $('#popup_sesion').fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function () {
    $('#popup_sesion').fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
});

$(document).ready(function () {
  $('#NOTICIAS').on('click', function () {
    $('#popup_noticias').fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function () {
    $('#popup_noticias').fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
});

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

$(document).ready(start());

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

  });


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
    $(document).ready(document.getElementById("welcome").innerHTML = "Hola, " + x);
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
  document.cookie = "nombre_inicio_" + document.forms["Formulario_Registro"]["email_inicio"].value + "=" + document.forms["Formulario_Registro"]["nombre_inicio"].value;
  document.cookie = "NIA=" + document.forms["Formulario_Registro"]["NIA"].value;
  document.cookie = "contraseña=" + document.forms["Formulario_Registro"]["contraseña"].value;
  document.cookie = "nombre=" + document.forms["Formulario_Registro"]["nombre"].value;
  document.cookie = "apellidos=" + document.forms["Formulario_Registro"]["apellidos"].value;
  document.cookie = "email_inicio_" + document.forms["Formulario_Registro"]["nombre_inicio"].value + "=" + document.forms["Formulario_Registro"]["email_inicio"].value;
  document.cookie = "fecha_nacimiento=" + document.forms["Formulario_Registro"]["fecha_nacimiento"].value;
  document.cookie = "DNI=" + document.forms["Formulario_Registro"]["DNI"].value;
  document.cookie = "rol=" + document.forms["Formulario_Registro"]["rol"].value;
  document.cookie = "grado=" + document.forms["Formulario_Registro"]["grado"].value;
  document.cookie = "universidad=" + document.forms["Formulario_Registro"]["universidad"].value;
  document.cookie = "idioma=" + document.forms["Formulario_Registro"]["idioma"].value;
}
