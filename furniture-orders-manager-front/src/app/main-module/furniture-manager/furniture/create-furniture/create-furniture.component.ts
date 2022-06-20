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
  createFurnitureRequest: CreateFurnitureRequest = {name: '', description: ''};

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

  createFurniture() {
    this.furnitureService.postCreateFurniture(this.createFurnitureRequest)
      .subscribe(() => {
          this.loadFurnitureDtos();
          alert("Added!")
        },
        (err) => {
          this.commonService.handleError(err)
          this.loadFurnitureDtos();
        });
    this.clearNameAndDescriptionInput()
  }

  removeFurniture(i: number) {
    let id: string = this.furnitureNameAndDescriptionDtos[i].id
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
    this.clearNameAndDescriptionInput()
  }

  clearNameAndDescriptionInput() {
    this.createFurnitureRequest = {name: '', description: ''}
  }
}
