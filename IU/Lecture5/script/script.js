function miprimerafuncion() {
  if (document.forms["miform"]["fname"].value == "")
    alert("Rellene el formulario");
  return false;
  else {
    alert("Bienvenid@ " + document.getElementById("fname").value);
    alert("Bienvenid@ " + document.forms["miform"]["fname"].value);
  }
}