import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// USADOS PARA ROUTING:
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { DatePipe } from "@angular/common";

// GENERICOS DE MATERIAL:
import {MatIconModule} from '@angular/material/icon';
import {FlexLayoutModule} from '@angular/flex-layout';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';

// ELEMENTOS UI ESPECÍFICOS:
import {MatBadgeModule} from '@angular/material/badge';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTooltipModule} from '@angular/material/tooltip';



import { VerDetalleComponent } from './ver-detalle/ver-detalle.component';
import { ListadoComponent } from './listado/listado.component';
import { GlobalService } from './global.service';
import { PrincipalComponent } from './principal/principal.component';
import { VerInfoComponent } from './ver-info/ver-info.component';


@NgModule({
  declarations: [
    AppComponent,
    VerDetalleComponent,
    ListadoComponent,
    PrincipalComponent,
    VerInfoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    FormsModule,
    MatFormFieldModule,
    MatIconModule,

    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    MatCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatBadgeModule,
    MatExpansionModule,
    MatSnackBarModule,
    MatTooltipModule,
    MatToolbarModule,
    MatInputModule,
    MatCheckboxModule,
    MatProgressSpinnerModule,
    MatMenuModule,
  ],
  providers: [GlobalService, DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
