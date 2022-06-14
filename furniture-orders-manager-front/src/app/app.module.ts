import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {MainModule} from "./main-module/main.module";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing-module";
import {FurnitureManagerRoutingModule} from "./main-module/furniture-manager/furniture-manager-routing-module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MainModule,
    HttpClientModule,
    AppRoutingModule,
    FurnitureManagerRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
