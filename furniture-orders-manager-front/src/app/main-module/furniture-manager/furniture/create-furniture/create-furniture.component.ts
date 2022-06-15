import {Component, OnInit} from '@angular/core';
import {Furniture} from "../model/Furniture";
import {FurnitureService} from "../furniture.service";
import {CreateFurnitureRequest} from "../model/CreateFurnitureRequest";

@Component({
  selector: 'app-create-furniture',
  templateUrl: './create-furniture.component.html',
  styleUrls: ['./create-furniture.component.less']
})
export class CreateFurnitureComponent implements OnInit {

  furniture!: Furniture;

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
