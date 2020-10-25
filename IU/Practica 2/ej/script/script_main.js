$(document).ready(function() {
  $('#NOVEDADES').on('click', function() {
    $('#popup').fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function() {
    $('#popup').fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
});

$(document).ready(function() {
  $('#NOTICIAS').on('click', function() {
    $('#popup2').fadeIn('slow');
    $('.popup-overlay').fadeIn('slow');
    $('.popup-overlay').height($(window).height());
    return false;
  });
  $('.cerrar').on('click', function() {
    $('#popup2').fadeOut('slow');
    $('.popup-overlay').fadeOut('slow');
    return false;
  });
});


$(document).ready(document.getElementById("welcome").innerHTML = "Hola, " + "Don Carlos");


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

document.addEventListener("DOMContentLoaded", start());

function start() {
  document.getElementById("CENTRAL_FORO").style.display = "none";
  document.getElementById("CENTRAL_MAIN").style.display = "block";
  document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
  document.getElementById("CENTRAL_LISTA").style.display = "none";
}

document.getElementById("linkforo_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_FORO").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
  });

document.getElementById("linkforo").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_FORO").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
  });

document.getElementById("linkcalificaciones").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
  });

document.getElementById("linkcalificaciones_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_LISTA").style.display = "none";
  });

document.getElementById("linkestudiantes").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
  });

document.getElementById("linkestudiantes_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "block";
    document.getElementById("CENTRAL_MAIN").style.display = "none";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
  });

document.getElementById("linkmain").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
  });

document.getElementById("linkmain_h").addEventListener("click",
  function() {
    document.getElementById("CENTRAL_LISTA").style.display = "none";
    document.getElementById("CENTRAL_MAIN").style.display = "block";
    document.getElementById("CENTRAL_FORO").style.display = "none";
    document.getElementById("CENTRAL_CALIFICACIONES").style.display = "none";
  });







function inicioSesion() {
  var x = document.forms["Formulario_Inicio_Sesion"]["nombre_inicio"].value;
  var y = document.forms["Formulario_Inicio_Sesion"]["email_inicio"].value;

  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
  if (y==""){
    alert("Email must be filled out");
    return false;
  }
  
  alert(document.cookie);
  if(getCookie("email_inicio_"+x) == y){
    alert("se mueve a pagina principal con nombre puesto");
  }else{
    alert("se debe registrar, cuenta no creada");
  }



}

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
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
