import {
  Component,
  OnInit,
  Input,
  QueryList,
  ContentChildren,
  Output,
  EventEmitter,
} from '@angular/core';

import { ProvinciaComponent } from '../provincia/provincia.component';
import { ComunidadComponent } from '../comunidad/comunidad.component';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.scss'],
})
export class SelectComponent implements OnInit {
  @Input() label1: string;
  @Input() label2: string;

  comu: string = '';
  prov: string = '';

  @ContentChildren(ProvinciaComponent)
  public provincias!: QueryList<ProvinciaComponent>;

  @ContentChildren(ComunidadComponent)
  public comunidades!: QueryList<ComunidadComponent>;

  constructor() {
    this.label1 = '';
    this.label2 = '';
  }

  @Output() sendUpdate = new EventEmitter<{ com: string; pro: string }>();

  updateCustomElements() {
    this.sendUpdate.emit({ com: this.comu, pro: this.prov });
  }

  ngOnInit(): void {}
}
