import {NgModule} from "@angular/core";
import {Route, RouterModule} from "@angular/router";

const FURNITURE_MANAGER_ROUTES: Route[] = []

@NgModule({
  imports: [
    RouterModule.forChild(FURNITURE_MANAGER_ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class FurnitureManagerRoutingModule {
}
