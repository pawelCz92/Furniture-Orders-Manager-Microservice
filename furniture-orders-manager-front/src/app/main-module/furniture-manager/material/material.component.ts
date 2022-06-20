import {Component, OnInit} from '@angular/core';
import {Material} from "./model/Material";
import {MaterialService} from "./material.service";
import {CreateMaterialRequest} from "./model/CreateMaterialRequest";
import {FurnitureCommonService} from "../furniture-common.service";

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.less']
})
export class MaterialComponent implements OnInit {


  materials: Material[] = [];
  createMaterialRequest:   CreateMaterialRequest = {name: '', description: ''}


  constructor(private materialService: MaterialService,
              private commonService: FurnitureCommonService) {
  }

  ngOnInit(): void {
    this.materials = [];
    this.loadMaterials();
  }

  loadMaterials(): void {
    this.materialService.getAllMaterials().subscribe(materials => this.materials = materials);
  }

  removeMaterial(i: number) {
    let id = this.materials[i].id;
    this.materialService.removeMaterialById(id)
      .subscribe(() => this.loadMaterials());
  }

  saveMaterial() {
    this.materialService.saveMaterial(this.createMaterialRequest).subscribe( //TODO subscribe deprecated
      () => {
        this.loadMaterials();
      },
      (error) => {
        console.error(error);
        this.commonService.handleError(error);
        this.loadMaterials();
        this.createMaterialRequest = {name: '', description: ''}
      })
  }

}
