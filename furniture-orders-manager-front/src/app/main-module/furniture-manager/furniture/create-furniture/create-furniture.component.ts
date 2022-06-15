import {Component, OnInit} from '@angular/core';
import {FurnitureService} from "../furniture.service";
import {CreateFurnitureRequest} from "../model/dto/CreateFurnitureRequest";
import {FurnitureIdNameDescriptionDto} from "../model/dto/FurnitureIdNameDescriptionDto";
import {FurnitureCommonService} from "../../furniture-common.service";

@Component({
  selector: 'app-create-furniture',
  templateUrl: './create-furniture.component.html',
  styleUrls: ['./create-furniture.component.less']
})
export class CreateFurnitureComponent implements OnInit {

  furnitureNameAndDescriptionDtos!: FurnitureIdNameDescriptionDto[];

  constructor(private furnitureService: FurnitureService,
              private commonService: FurnitureCommonService) {
  }

  ngOnInit(): void {
    this.loadFurnitureDtos();
    console.info("FurnitureDtos loaded")
  }

  loadFurnitureDtos(): void {
    this.furnitureService.getAllFurnitureNameAndDescription().subscribe(furnitureDto =>
      this.furnitureNameAndDescriptionDtos = furnitureDto);
  }

  createFurniture(name: string, description: string) {
    let createFurnitureRequest: CreateFurnitureRequest = {
      name,
      description
    };
    this.furnitureService.postCreateFurniture(createFurnitureRequest)
      .subscribe(() => {
          this.loadFurnitureDtos();
          alert("Added!")
        },
        (err) => {
          this.commonService.handleError(err)
          this.loadFurnitureDtos();
        });
  }

  removeFurniture(id: string) {
    this.furnitureService.removeFurnitureById(id).subscribe(
      () => {
        alert("Removed!")
        this.loadFurnitureDtos();
      },
      (error => {
        this.commonService.handleError(error)
        this.loadFurnitureDtos();
      })
    );
  }
}
