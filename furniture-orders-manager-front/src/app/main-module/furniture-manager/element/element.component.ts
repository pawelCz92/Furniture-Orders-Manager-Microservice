import {Component, OnInit} from '@angular/core';
import {FurnitureIdNameDescriptionDto} from "../furniture/model/dto/FurnitureIdNameDescriptionDto";
import {Furniture} from "../furniture/model/Furniture";
import {FurnitureService} from "../furniture/furniture.service";
import {FurnitureCommonService} from "../furniture-common.service";
import {Element} from "./model/Element";
import {Observer} from "rxjs";

@Component({
  selector: 'app-element',
  templateUrl: './element.component.html',
  styleUrls: ['./element.component.less']
})
export class ElementComponent implements OnInit {


  furnitureDtos: FurnitureIdNameDescriptionDto[] = [];
  selectedFurnitureName: string = '';
  furniture!: Furniture;
  newElement: Element = new Element();

  constructor(
    private furnitureService: FurnitureService,
    private furnitureCommonService: FurnitureCommonService) {
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
    this.selectedFurnitureName = this.furnitureDtos[i].name;
    this.loadFurnitureByName(this.selectedFurnitureName);
    this.newElement = new Element();
  }

  furnitureObserver: Observer<Furniture> = {
    next: (nextFurniture: Furniture) => this.furniture = nextFurniture,
    error: err => this.furnitureCommonService.handleError(err),
    complete: () => {
    }
  }

  loadFurnitureByName(name: string): void {
    this.furnitureService.getFurnitureByName(name).subscribe(this.furnitureObserver)
  }

  elementObserver: Observer<Element> = {
    next: () => this.loadFurnitureByName(this.selectedFurnitureName),
    error: err => this.furnitureCommonService.handleError(err),
    complete: () => {
    }
  }

  addElement() {
    const furnitureName = this.selectedFurnitureName;
    this.furnitureService.addElementToFurniture(furnitureName, this.newElement).subscribe(this.elementObserver);
    this.newElement = new Element();
  }

  removeElement(index: number) {
    const elementId = this.furniture.elements[index].uuid;
    const furnitureName = this.selectedFurnitureName;
    this.furnitureService.removeElementFromFurniture(furnitureName, elementId).subscribe(this.elementObserver);
  }
}
