function miprimerafuncion() {
  alert("hola mundo");
  console.log("hola mundo");
  document.getElementById("titulo").style.backgroundColor = "purple";
}

document.getElementById("titulo2").addEventListener("click",
  function() {
    console.log("hola mundo 2");
    if (document.getElementById("titulo2").style.backgroundColor == "orange")
      document.getElementById("titulo2").style.backgroundColor = "yellow";
    else
      document.getElementById("titulo2").style.backgroundColor = "orange";

  }
);

function misegundafuncion(){
	alert("Bienvenid@ "+document.getElementById("fname").value);
  alert("Bienvenid@ "+document.forms["miform"]["fname"].value);

}
