import { Injectable } from '@angular/core';
import { IContact,Contact,ViewContact } from './contact';

@Injectable({
  providedIn: "root",
})
export class GlobalService {
  constructor() {}

  public data: Contact[] = [
    {
      id: 0,
      name: "Ricardo Martín Manso",
      phone: "609117799",
      email: "ricardma@inf.uc3m.es",
      type: 2,
      specialty: 3,
      regular: true,
      address: "Calle de la Luna",
      company: "",
      birthday: new Date("1963-08-03"),
      charge: "Director",
    },
    {
      id: 1,
      name: "Jesús Hernando Corrochano",
      phone: "609117788",
      email: "jhcorroc@inf.uc3m.es",
      type: 1,
      regular: true,
      address: "",
      company: "",
      birthday: new Date("1995-09-13"),
      charge: "",
    },
    {
      id: 2,
      name: "Manolo el del Bombo",
      phone: "609667429",
      email: "manolo@inf.uc3m.es",
      type: 1,
      regular: false,
      address: "Calle Duero, nº 13, 2ºA",
      company: "",
      birthday: new Date("1978-04-15"),
      charge: "",
    },
    {
      id: 3,
      name: "María Lopez",
      phone: "609776699",
      email: "marialopez@inf.uc3m.es",
      type: 2,
      specialty: 1,
      regular: true,
      address: "Calle Salinas",
      company: "UC3m",
      birthday: new Date("2000-11-12"),
      charge: "Profesora",
      info: "Llamar en caso de emergencia.",
    },
    {
      id: 4,
      name: "Clara de Juan Pastor",
      phone: "650117799",
      email: "claradejuanpastor@inf.uc3m.es",
      type: 1,
      regular: false,
      address: "",
      company: "",
      birthday: new Date("1984-05-02"),
      charge: "Secretaria",
    },
  ];

  public readContact(id: number): Contact {
    return new Contact(this.data[id]);
  }

  public delete(id) {
    console.log("Eliminating:" + id);
    this.data.splice(id, 1);
    let i = 0;
    for (let dato of this.data) {
      dato.id = i;
      i++;
    }
  }

  public updateContact(id: number, contact: Contact) {
    this.data[id] = contact;
  }

  public newContact(contact: Contact) {
    contact.id = this.data.length;
    this.data.push(contact);
  }

  public getNContacts() {
    return this.data.length;
  }
}
