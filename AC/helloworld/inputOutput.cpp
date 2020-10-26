//
// Created by Jorge Rodríguez Fraile on 18/09/2020.
//

#include <iostream>

int main() {
  using namespace std;

  cout << "Introduzca su nombre y dos apellidos: \n";
  string nombre, apellido1, apellido2;
  cin >> nombre >> apellido1 >> apellido2;

  cout << "Introduzca su edad: \n";
  int edad;
  cin >> edad;

  cout << "Hola, " << nombre << " " << apellido1 << " " << apellido2 << " de " << edad << " años \n";
  return 0;
}