import { NgModule } from '@angular/core';
import { Routes, Router,RouterModule } from '@angular/router';
import { VerDetalleComponent } from './ver-detalle/ver-detalle.component';
import { ListadoComponent } from './listado/listado.component';
import { PrincipalComponent } from './principal/principal.component';
import { VerInfoComponent } from "./ver-info/ver-info.component";


const routes: Routes = [
  { path: "list", component: ListadoComponent },
  { path: "principal", component: PrincipalComponent },
  { path: "", redirectTo: "/principal", pathMatch: "full" },
  { path: "edit/:id", component: VerDetalleComponent },
  { path: "details/:id", component: VerInfoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
