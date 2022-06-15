import {Component, OnInit} from '@angular/core';
import {Material} from "./model/Material";
import {MaterialService} from "./material.service";
import {CreateMaterialRequest} from "./model/CreateMaterialRequest";
import {HttpErrorResponse} from "@angular/common/http";
import {throwError} from "rxjs";

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.less']
})
export class MaterialComponent implements OnInit {


  materials: Material[] = [];

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
    this.materialService.saveMaterial(request).subscribe( //TODO subscribe deprecated
      () => {
        this.loadMaterials();
      },
      (error) => {
        console.error(error);
        this.handleError(error);
        this.loadMaterials();
      })
  }


  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occurred:', error.error);
    } else {
      if (error.status >= 200 && error.status <= 299) {
        alert("Material created successfully.")
        return;
      }
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
      alert('Error! Code: ' + error.status + ' -> ' + error.error)
    }
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
