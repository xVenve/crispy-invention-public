import { Component  } from '@angular/core';
import { ComunidadComponent } from './comunidad/comunidad.component';
import { ProvinciaComponent } from './provincia/provincia.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'DSI Practice 3';
  comuLocal: string = '';
  provLocal: string = '';

  comuC: string = '';
  provC: string = '';

  selectChanged(data: { com: string; pro: string }) {
    this.comuC = data.com;
    this.provC = data.pro;
  }

  updateCustomElements() {
    this.comuLocal = this.comuC;
    this.provLocal = this.provC;
  }
}
