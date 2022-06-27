import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-furniture-manager',
  templateUrl: './furniture.component.html',
  styleUrls: ['./furniture.component.less']
})
export class FurnitureComponent implements OnInit {


  elements!: Element[];

  constructor() {
  }

  ngOnInit(): void {
  }


}
