var cuentaActiva = null;
var rolActivo = null;

$(document).ready(function () {
  //Al cargar la página se genera el calendario que aparecerá en la barra lateral derecha
  $("#calendario").simpleCalendar({
    months: [
      "Enero",
      "Febrero",
      "Marzo",
      "Abril",
      "Mayo",
      "Junio",
      "Julio",
      "Agosto",
      "Septiembre",
      "Octubre",
      "November",
      "Diciembre",
    ],
    days: [
      "Domingo",
      "Lunes",
      "Martes",
      "Miércoles",
      "Jueves",
      "Viernes",
      "Sábado",
    ],
    displayYear: true, // Display year in header
    fixedStartDay: true, // Week begin always by monday or by day set by number 0 = sunday, 7 = saturday, false = month always begin by first day of the month
    displayEvent: true, // Display existing event
    disableEventDetails: false, // disable showing event details
    disableEmptyDetails: true, // disable showing empty date details
    events: [
      {
        startDate: new Date("2020-12-22 23:55"),
        endDate: new Date("2020-12-22 23:55"),
        summary: "ENTREGA PRÁCTICA 2. JAVASCRIPT Y JQUERY",
      },
      {
        startDate: new Date("2020-12-05 23:55"),
        endDate: new Date("2020-12-05 23:55"),
        summary: "ENTREGA PRÁCTICA 1. HTML Y CSS",
      },
    ],
  });

  //Al cargar la página también se crearán los popups de las diferentes acciones que pueden realizar los estudiantes, profesores y administradores
  popups("#addAsignatura", "#popup_add_asignatura");
  popups("#addcontent", "#popup_contenido");
  popups("#addCalificaciones", "#popup_calificaciones");
  popups("#gestAlumno", "#popup_gestion_est");
  popups("#addHilo", "#popup_hilo");
  popups("#addActividad", "#popup_actividad");
  popups("#verChartP", "#popup_chartP");
  popups("#verChartE", "#popup_chartE");
  popups("#addEntrega", "#popup_entregar");
});

function popups(nombre, seccion) {
  $(nombre).on("click", function () {
    $(seccion).fadeIn("slow");
    $(".popup-overlay").fadeIn("slow");
    $(".popup-overlay").height($(window).height());
    return false;
  });
  $(".cerrar").on("click", function () {
    $(seccion).fadeOut("slow");
    $(".popup-overlay").fadeOut("slow");
    return false;
  });
}

function start() {
  document.getElementById("iniciosesion").style.paddingTop = "2%";
  document.getElementById("iniciosesion").style.width = "100%";
  document.getElementById("formularios").style.marginLeft = "38%";
  document.getElementById("formularios").style.marginRight = "35%";
  document.getElementById("formularios").style.width = "25%";
}

//Función que al registrarse permite guardar una cookie
function guardarCookie() {
  var contraseña = document.getElementById("formcontraseña").value;
  var nombre = document.getElementById("formnombre").value;
  var apellidos = document.getElementById("formapellidos").value;
  var email = document.getElementById("formemail").value;
  if (validarCookie(email)) {
    alert("Ya existe una cuenta vinculada a este correo");
    return;
  }
  var roles = document.getElementById("formrol").selectedOptions[0].value;
  var NIA = document.getElementById("formNIA").value;
  var sep = "#";
  var cookieCompleta =email +"=" + contraseña + sep + nombre + sep + apellidos + sep + roles + sep + NIA;
  document.cookie = cookieCompleta;

  $("#vertical-line").fadeOut("slow");
  $("#registro").fadeOut("slow");
  start();
}

//Función que despliega el registro (inicialmente oculto) al darle click a registrarse
function desplegarRegistro() {
  document.getElementById("vertical-line").style.display = "absolute";
  document.getElementById("registro").style.display = "block";
  window.addEventListener("resize", responsivelogin);
  responsivelogin();
}

//Función que despliega el contenido de la página inicial (las asignaturas de los diferentes campus)
function desplegar_contenido(x) {
  var contenido = document.getElementById(x);
  $(contenido).slideToggle();
}

//Función que muestra el contenido inicial de una asignatura seleccionada
function desplegar_asignatura(x) {
  var asignatura = document.getElementById(x);
  asignatura.style.display = "block";
  $(".barralateralderecha").show();

  if (rolActivo === "Estudiante") {
    estudiante();
  } else if (rolActivo === "Profesor") {
    profesor();
  } else {
    administrador();
  }

  if (window.matchMedia("(max-width: 600px)").matches) {
    $(".barralateralderecha").hide();
  }

  var home = document.getElementById("contenido_principal");
  home.style.display = "none";
}

//Función que muestra los contenidos determinados de las opciones disponibles en la barra lateral derecha (calificaciones, foro, actividades, etc.)
function desplegar_contenido_barra(x) {
  $("#contenido_principal").hide();
  $("#IU").hide();
  $("#foroasignatura").hide();
  $("#estudiantes").hide();
  $("#actividades_estudiante").hide();
  $("#actividades_profesor").hide();
  $("#calificaciones_profesor").hide();
  $("#calificaciones_estudiante").hide();
  var contenido = document.getElementById(x);
  contenido.style.display = "block";
}

//Función que valida si una cookie existe
function validarCookie(email) {
  var emailigual = email + "=";
  var restoCookie = document.cookie.split(emailigual)[1];
  if (restoCookie) {
    return true;
  }
  return false;
}

//Función que obtiene el valor de la cookie pasada por parámetro
function obtenerCookie(email) {
  var emailigual = email + "=";
  var restoCookie = document.cookie.split(emailigual)[1];
  if (!restoCookie) {
    alert("Este correo no tiene una cuenta vinculada");
    location.reload();
  }
  var valoresCookie = restoCookie.split("#");
  return valoresCookie;
}

//Función que hace responsive el login
function responsivelogin() {
  if (window.matchMedia("(max-width: 600px)").matches) {
    document.getElementById("formularios").style.display = "inline-block";
    document.getElementById("formularios").style.marginLeft = "0%";
    document.getElementById("formularios").style.marginRight = "0%";
    document.getElementById("formularios").style.width = "100%";
    document.getElementById("iniciosesion").style.width = "100%";
  } else if (window.matchMedia("(max-width: 768px)").matches) {
    $("#vertical-line").fadeIn("slow");
    $("#registro").fadeIn("slow");
    document.getElementById("formularios").style.width = "60%";
    document.getElementById("formularios").style.marginLeft = "20%";
    document.getElementById("formularios").style.display = "flex";
  } else {
    $("#vertical-line").fadeIn("slow");
    $("#registro").fadeIn("slow");
    document.getElementById("iniciosesion").style.paddingTop = "10%";
    document.getElementById("formularios").style.marginLeft = "20%";
    document.getElementById("formularios").style.marginRight = "20%";
    document.getElementById("formularios").style.width = "58.33%";
    document.getElementById("iniciosesion").style.width = "40%";
  }
}

//Función que hace responsive el resto de la página
function responsive() {
  if (window.matchMedia("(max-width: 600px)").matches) {
    document.getElementById("principal").style.display = "inline";
    document.getElementById("menuhamburguesa").style.display = "block";
    $(".barralateralderecha").hide();
  } else if (window.matchMedia("(max-width: 768px)").matches) {
    document.getElementById("principal").style.display = "inline";
    $(".barralateralderecha").show();
    if (rolActivo === "Estudiante") {
      estudiante();
    } else if (rolActivo === "Profesor") {
      profesor();
    } else {
      administrador();
    }
  } else {
    document.getElementById("principal").style.display = "flex";
    document.getElementById("lateral").style.display = "block";
  }
}

//Función que realiza el inicio de sesión (comprobar si existe una cuenta con los datos introducidos y si es así,
// ocultar el inicio de sesión/registro y mostrar la página principal)
function inicioSesion() {
  var emailInicio = document.getElementById("inicioemail").value;
  var contraseñaInicio = document.getElementById("iniciocontraseña").value;
  var elementosCookie = obtenerCookie(emailInicio);
  var contraseñaCookie = elementosCookie[0];
  var rolCookie = elementosCookie[3];
  var usernameCookie = elementosCookie[1] + " " + elementosCookie[2];
  if (contraseñaInicio === contraseñaCookie) {
    cuentaActiva = emailInicio;
    window.removeEventListener("resize", responsivelogin);
    window.addEventListener("resize", responsive);
    document.getElementById("formularios").style.display = "none";
    document.getElementById("cabecera2").style.display = "block";
    document.getElementById("principal").style.display = "flex";
    document.getElementById("perfil").style.display = "inline";
    document.getElementById("abajo").style.display = "block";
    document.getElementById("lateral").style.display = "block";

    if (rolCookie === "Estudiante") {
      rolActivo = "Estudiante";
      estudiante();

    } else if (rolCookie === "Profesor") {
      rolActivo = "Profesor";
      profesor();

    } else {
      rolActivo = "Administrador";
      administrador();
    }

    $(".barralateralderecha").hide();
    document.getElementById("nombreusuario").innerHTML = usernameCookie;
    responsive();
    Inicio();
  }
}

//Función que gestiona el rol estudiante
function estudiante() {
  $(".admin").hide();
  $(".profesor").hide();
  $(".estudiante").show();
  crear_notas();
}

//Función que gestiona el rol profesor
function profesor() {
  $(".admin").hide();
  $(".estudiante").hide();
  $(".profesor").show();
}

//Función que gestiona el rol administrador
function administrador() {
  $(".profesor").hide();
  $(".estudiante").hide();
  $(".admin").show();
}

//Función que realiza el cierre de sesión (ocultar la página principal y volver a mostrar el inicio de sesión/registro)
function cerrarSesion() {
  var confirmacion = confirm("¿Quieres cerrar sesión?");
  if (confirmacion) {
    $("#principal").hide();
    $("#formularios").show();
    $("#iniciosesion").show();
    $("#perfil").hide();
    $("#cabecera2").hide();
    $("#abajo").hide();
    $("#contenido_principal").hide();
    $("#IU").hide();
    $("#actividades_estudiante").hide();
    $("#actividades_profesor").hide();
    $("#calificaciones").hide();
    $(".barralateralderecha").hide();
    $("#foroasignatura").hide();
    $("#calificaciones_estudiante").hide();
    $("#calificaciones_profesor").hide();
    $("#estudiantes").hide();
    window.removeEventListener("resize", responsive);
  }
}

function Inicio() {
  $("#contenido_principal").show();
  $("#IU").hide();
  $("#actividades_estudiante").hide();
  $("#actividades_profesor").hide();
  $("#calificaciones").hide();
  $(".barralateralderecha").hide();
  $("#foroasignatura").hide();
  $("#calificaciones_estudiante").hide();
  $("#calificaciones_profesor").hide();
  $("#estudiantes").hide();
}

//Función que abre y cierra un hilo del foro
function alternarForo(x) {
  var mensajesForo = document.getElementById("hilo" + x);
  $(mensajesForo).slideToggle();
}

//Función que permite enviar un mensaje por el foro
function enviarMensajeForo(i) {
  var mensaje = document.getElementById("usermensaje" + i).value;
  var cookieActual = obtenerCookie(cuentaActiva);
  var nombre = cookieActual[1] + " " + cookieActual[2];
  var hoy = new Date();
  var fecha =
    hoy.getHours() + ":" + hoy.getMinutes() + " " + hoy.getDate() + "/" + (hoy.getMonth() + 1) + "/" + hoy.getFullYear();
  $("#mensajesforo" + i).append(
    '<div class="mensajeusuarioenvio"> <div class="informacionusuario"> <div class="fechamensajeenvio">' +
      "<p>" +
      fecha +
      "</p></div>" +
      '<div class="nombreestudianteenvio"><p>' +
      nombre +
      "</p> </div>" +
      '<div class="estudianteconversacion">' +
      '<img src="./images/usericon.png" id="usericon" alt="usericon"></div>' +
      '</div><div class="mensajeforo"><p>' +
      mensaje +
      "</p></div></div>"
  );
  var numReplicas = Number(document.getElementById("replicas" + i).textContent);
  document.getElementById("replicas" + i).innerHTML = numReplicas + 1;
  document.getElementById("ultimomensaje" + i).innerHTML = fecha;
  document.getElementById("usermensaje" + i).value = "";
}

//Métodos para descargar la tabla de calificaciones en formato excel.
$(".export_e").click(function () {
  $("#TABLA_ESTUDIANTE").table2excel({
    // exclude CSS class
    exclude: ".noExl",
    name: "Data",
    filename: "mis_calificaciones.xlsx", 
  });
});

$(".export_p").click(function () {
  $("#TABLA_PROFESOR").table2excel({
    // exclude CSS class
    exclude: ".noExl",
    name: "Data",
    filename: "calificaciones_estudiantes.xlsx",
  });
});

//Función que permite ver las gráficas de calificaciones
function verGrafica(x) {
  if (x == "Estudiante") {
    $("#TABLA_ESTUDIANTE").highchartTable();
  } else if (x == "Profesor") {
    $("#TABLA_PROFESOR").highchartTable();
  }
}

//Método para generar aleatoriamente las notas de calificaciones.
function crear_notas() {
  var a1 = (document.getElementById("act1").innerHTML =
    Math.floor(Math.random() * 1000) / 100);
  var a2 = (document.getElementById("act2").innerHTML =
    Math.floor(Math.random() * 1000) / 100);
  var a3 = (document.getElementById("act3").innerHTML =
    Math.floor(Math.random() * 1000) / 100);
  var m = (document.getElementById("media").innerHTML =
    Math.floor(((a1 + a2 + a3) * 100) / 3) / 100);
}
