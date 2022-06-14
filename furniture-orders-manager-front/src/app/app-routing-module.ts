import {NgModule} from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import {MaterialComponent} from "./main-module/furniture-manager/material/material.component";
import {FurnitureComponent} from "./main-module/furniture-manager/furniture.component";

const APP_ROUTES: Route[] = [
  {path: '', pathMatch: 'full', redirectTo: 'furniture'},
  {path: 'materials', component: MaterialComponent},
  {path: 'furniture', component: FurnitureComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(APP_ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
