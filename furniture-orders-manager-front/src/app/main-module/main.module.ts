import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FurnitureComponent} from './furniture-manager/furniture/furniture.component';
import {LeftSideNavComponent} from './left-side-nav/left-side-nav.component';
import {MaterialComponent} from './furniture-manager/material/material.component';
import {RouterModule} from "@angular/router";
import {CreateFurnitureComponent} from './furniture-manager/furniture/create-furniture/create-furniture.component';
import {CreateElementComponent} from './furniture-manager/element/create-element/create-element.component';
import {ElementComponent} from './furniture-manager/element/element.component';


@NgModule({
  declarations: [
    FurnitureComponent,
    LeftSideNavComponent,
    MaterialComponent,
    CreateFurnitureComponent,
    CreateElementComponent,
    ElementComponent
  ],
  exports: [
    LeftSideNavComponent,
    FurnitureComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class MainModule {
}
