import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FurnitureComponent} from './furniture-manager/furniture.component';
import {LeftSideNavComponent} from './left-side-nav/left-side-nav.component';
import {MaterialComponent} from './furniture-manager/material/material.component';
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    FurnitureComponent,
    LeftSideNavComponent,
    MaterialComponent
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
