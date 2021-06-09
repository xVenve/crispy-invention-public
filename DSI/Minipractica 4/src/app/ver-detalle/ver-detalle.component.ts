import { Component, OnInit } from '@angular/core';
import { Router, RouterModule,ActivatedRoute,NavigationStart } from '@angular/router';
import { GlobalService } from '../global.service';
import { Contact,ViewContact } from '../contact';

@Component({
  selector: "app-ver-detalle",
  templateUrl: "./ver-detalle.component.html",
  styleUrls: ["./ver-detalle.component.scss"],
})
export class VerDetalleComponent implements OnInit {
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private global: GlobalService
  ) {}
  public id;

  public contact: Contact;

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      //console.log(params['params']);
      this.id = params["params"]["id"];
      if (this.id >= 0) this.contact = this.global.readContact(this.id);
      else this.contact = new Contact();
    });
  }

  public getTypes() {
    return ViewContact.getTypes();
  }

  public getSpecialty() {
    return ViewContact.getSpecialty();
  }

  public accept() {
    if (this.id > 0) this.global.updateContact(this.contact.id, this.contact);
    else this.global.newContact(this.contact);

    this.router.navigate(["list/"]);
  }

  public cancel() {
    this.router.navigate(["list/"]);
  }
}
