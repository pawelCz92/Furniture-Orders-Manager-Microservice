import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {MainModule} from "./main-module/main.module";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing-module";
import {FurnitureManagerRoutingModule} from "./main-module/furniture-manager/furniture-manager-routing-module";
import {FormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MainModule,
    HttpClientModule,
    AppRoutingModule,
    FurnitureManagerRoutingModule,
    MatInputModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
