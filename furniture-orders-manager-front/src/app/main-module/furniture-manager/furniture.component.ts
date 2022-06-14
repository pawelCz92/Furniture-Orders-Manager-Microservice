import {Component, OnInit} from '@angular/core';
import {FurnitureService} from "./furniture.service";
import {Furniture} from "./furniture/Furniture";
import {CreateFurnitureRequest} from "./furniture/CreateFurnitureRequest";
import {Material} from "./material/model/Material";

@Component({
  selector: 'app-furniture-manager',
  templateUrl: './furniture.component.html',
  styleUrls: ['./furniture.component.less']
})
export class FurnitureComponent implements OnInit {

  furniture!: Furniture;
  elements!: Element[];
  materials!: Material[]

  constructor(private furnitureService: FurnitureService) {
  }

  ngOnInit(): void {
  }

  createFurniture(name: string, description: string) {
    let createFurnitureRequest: CreateFurnitureRequest = {
      name, description
    };
    createFurnitureRequest.name = name;
    createFurnitureRequest.description = description;
    this.furnitureService.postCreateFurniture(createFurnitureRequest)
      .subscribe(furniture => this.furniture = furniture);

  }
}
