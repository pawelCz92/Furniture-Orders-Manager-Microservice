import {Component, OnInit} from '@angular/core';
import {Material} from "../material/model/Material";

@Component({
  selector: 'app-furniture-manager',
  templateUrl: './furniture.component.html',
  styleUrls: ['./furniture.component.less']
})
export class FurnitureComponent implements OnInit {


  elements!: Element[];
  materials!: Material[]

  constructor() {
  }

  ngOnInit(): void {
  }


}
