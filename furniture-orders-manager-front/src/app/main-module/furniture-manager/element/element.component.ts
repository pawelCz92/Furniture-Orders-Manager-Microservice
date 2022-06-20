import {Component, OnInit} from '@angular/core';
import {FurnitureIdNameDescriptionDto} from "../furniture/model/dto/FurnitureIdNameDescriptionDto";
import {Furniture} from "../furniture/model/Furniture";
import {FurnitureService} from "../furniture/furniture.service";
import {FurnitureCommonService} from "../furniture-common.service";
import {MaterialService} from "../material/material.service";

@Component({
  selector: 'app-element',
  templateUrl: './element.component.html',
  styleUrls: ['./element.component.less']
})
export class ElementComponent implements OnInit {


  furnitureDtos: FurnitureIdNameDescriptionDto[] = [];
  selectedFurnitureId: string = '';
  elements: Element[] = []
  furniture!: Furniture;

  constructor(
    private furnitureService: FurnitureService,
    private furnitureCommonService: FurnitureCommonService,
    private materialService: MaterialService) {
  }

  ngOnInit(): void {
    this.loadFurnitureIdNameDescriptionDtos();
  }

  loadFurnitureIdNameDescriptionDtos(): void {
    this.furnitureService.getAllFurnitureNameAndDescription().subscribe(
      (dtos) => {
        this.furnitureDtos = dtos;
      },
      (err) => {
        this.furnitureCommonService.handleError(err);
      });
  }


  selectionChange(i: number): void {
    console.info(this.furnitureDtos[i].name);
    this.selectedFurnitureId = this.furnitureDtos[i].id;
    this.loadFurnitureById(this.selectedFurnitureId);
  }

  loadFurnitureById(id: string): void {
    this.furnitureService.getFurnitureById(id).subscribe(
      (fur) => {
        this.furniture = fur;
      },
      (err) => {
        this.furnitureCommonService.handleError(err);
      }
    )
  }
}
