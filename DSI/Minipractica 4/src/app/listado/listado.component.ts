import { Component, OnInit,ViewChild } from '@angular/core';
import { Router, RouterModule,ActivatedRoute } from '@angular/router';
import { GlobalService } from '../global.service';
import { Contact,ViewContact } from '../contact';
import {MatTable} from '@angular/material/table';
import {MatSnackBar} from '@angular/material/snack-bar';
import { DatePipe } from "@angular/common";

@Component({
  selector: "app-listado",
  templateUrl: "./listado.component.html",
  styleUrls: ["./listado.component.scss"],
})
export class ListadoComponent implements OnInit {
  @ViewChild(MatTable, { static: true }) tabladatos: MatTable<any>;

  constructor(
    public router: Router,
    public route: ActivatedRoute,
    private global: GlobalService,
    private _snackBar: MatSnackBar,
    private datePipe: DatePipe
  ) {}

  ngOnInit() {}

  public displayedColumns: string[] = [
    "name",
    "birthday",
    "address",
    "phone",
    "email",
    "type",
    "regular",
    "action2",
  ];
  //public dataSource:Contact[]= this.global.data;

  public search_text: string = "";
  public search_type: number = 0;

  public getData() {
    if (this.search_type > 0)
      if (this.search_text != "")
        return this.global.data.filter(
          (c) =>
            c.type == this.search_type &&
            c.name.toLowerCase().startsWith(this.search_text.toLowerCase())
        );
      else return this.global.data.filter((c) => c.type == this.search_type);
    else {
      if (this.search_text != "")
        return this.global.data.filter((c) =>
          c.name.toLowerCase().startsWith(this.search_text.toLowerCase())
        );
      else return this.global.data;
    }
  }

  public edit(id) {
    this.router.navigate(["/edit/", id]);
  }

  public details(id) {
    this.router.navigate(["/details/", id]);
  }

  public delete(id) {
    let snackBarRef = this._snackBar.open("Contact deleted!", "", {
      duration: 2000,
    });
    this.global.delete(id);
    // Lanzar explicitamente el render solo es necesario con datasource estaticos...
    // si los datos son un Observable la tabla se repinta sola!.
    this.tabladatos.renderRows();
  }

  public getTypes() {
    return ViewContact.getTypes();
  }

  public getRegular(o: Contact) {
    return ViewContact.getRegular(o);
  }

  public getType(o: Contact) {
    return ViewContact.getType(o);
  }

  public getSpecialties(o: Contact) {
    return ViewContact.getSpecialties(o);
  }

  public getBirthday(o: Contact) {
    return this.datePipe.transform(ViewContact.getBirthday(o), "dd-MM-yyyy");
  }

  public getNContacts() {
    return this.global.getNContacts();
  }
}
