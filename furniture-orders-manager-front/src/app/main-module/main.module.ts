import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FurnitureComponent} from './furniture-manager/furniture/furniture.component';
import {LeftSideNavComponent} from './left-side-nav/left-side-nav.component';
import {RouterModule} from "@angular/router";
import {CreateFurnitureComponent} from './furniture-manager/furniture/create-furniture/create-furniture.component';
import {ElementComponent} from './furniture-manager/element/element.component';
import {FormsModule} from "@angular/forms";
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    FurnitureComponent,
    LeftSideNavComponent,
    CreateFurnitureComponent,
    ElementComponent
  ],
  exports: [
    LeftSideNavComponent,
    FurnitureComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MatSelectModule,
  ]
})
export class MainModule {
}
