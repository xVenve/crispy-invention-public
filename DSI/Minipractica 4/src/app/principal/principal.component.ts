import { Component, OnInit } from '@angular/core';
import { Router, RouterModule,ActivatedRoute,NavigationStart } from '@angular/router';



@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }


  ngOnInit() {
  }
  
  public iniciar() {
    this.router.navigate(['list/']);
  }
}

