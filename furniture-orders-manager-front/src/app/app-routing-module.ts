import {NgModule} from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import {FurnitureComponent} from "./main-module/furniture-manager/furniture/furniture.component";
import {ElementComponent} from "./main-module/furniture-manager/element/element.component";

const APP_ROUTES: Route[] = [
  {path: '', pathMatch: 'full', redirectTo: 'furniture'},
  {path: 'furniture', component: FurnitureComponent},
  {path: 'elements', component: ElementComponent}
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