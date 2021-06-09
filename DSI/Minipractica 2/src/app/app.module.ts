import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import '@angular/common/locales/global/es';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FiltroPipe } from './filtro.pipe';

@NgModule({
  declarations: [AppComponent, FiltroPipe],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
