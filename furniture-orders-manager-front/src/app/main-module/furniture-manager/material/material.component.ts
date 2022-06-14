import {Component, OnInit} from '@angular/core';
import {Material} from "./model/Material";
import {MaterialService} from "./material.service";
import {CreateMaterialRequest} from "./model/CreateMaterialRequest";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.less']
})
export class MaterialComponent implements OnInit {


  materials: Material[] = [];
  materialNameFormCtrl = new FormControl('');

  constructor(private materialService: MaterialService) {
  }

  ngOnInit(): void {
    this.materials = [];
    this.loadMaterials();
  }

  loadMaterials(): void {
    this.materialService.getAllMaterials().subscribe(materials => this.materials = materials);
  }

  removeMaterial(id: string) {
    this.materialService.removeMaterialById(id)
      .subscribe(() => this.loadMaterials());
  }

  saveMaterial(name: string) {
    let request: CreateMaterialRequest = {
      name: name
    };
    this.materialService.saveMaterial(request).subscribe(mat => {
      this.materials.push(mat);
      this.loadMaterials();
    });
  }
}
