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





$(function(){
  $("#calendar_novedades").simpleCalendar();
});


$("#calendar_novedades").simpleCalendar({

  // displays events
  displayEvent: true,

  // event dates
  events: [
    {
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

$(function(){
  $("#calendar_noticias").simpleCalendar();
});


$("#calendar_noticias").simpleCalendar({

  // displays events
  displayEvent: true,

  // event dates
  events: [
    {
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
