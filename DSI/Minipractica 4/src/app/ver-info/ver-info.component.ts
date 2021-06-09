import { Component, OnInit } from '@angular/core';
import { Router, RouterModule,ActivatedRoute,NavigationStart } from '@angular/router';
import { GlobalService } from '../global.service';
import { Contact,ViewContact } from '../contact';
import { DatePipe } from "@angular/common";

@Component({
  selector: "app-ver-info",
  templateUrl: "./ver-info.component.html",
  styleUrls: ["./ver-info.component.scss"],
})
export class VerInfoComponent implements OnInit {
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private global: GlobalService,
    private datePipe: DatePipe
  ) {}

  public contact: Contact;

  public id;

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      //console.log(params['params']);
      this.id = params["params"]["id"];
      if (this.id >= 0) this.contact = this.global.readContact(this.id);
      else this.contact = new Contact();
    });
  }

  public back() {
    this.router.navigate(["list/"]);
  }

  public getBirthday(o: Contact) {
    return this.datePipe.transform(ViewContact.getBirthday(o), "dd-MM-yyyy");
  }

  public getType(o: Contact) {
    return ViewContact.getType(o);
  }

  public getSpecialty(o: Contact) {
    return ViewContact.getSpecialties(o);
  }
}
