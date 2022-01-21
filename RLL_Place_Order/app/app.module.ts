import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantShowComponent } from './restaurant-show/restaurant-show.component';
import { CustomerShowComponent } from './customer-show/customer-show.component';
import { VendorShowComponent } from './vendor-show/vendor-show.component';
import { CustomerDashBoardComponent } from './customer-dash-board/customer-dash-board.component';
import { VendorDashBoardComponent } from './vendor-dash-board/vendor-dash-board.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { VendorLoginComponent } from './vendor-login/vendor-login.component';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { WalletCustomerComponent } from './wallet-customer/wallet-customer.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { OrdersComponent } from './orders/orders.component';

const appRoutes : Routes = [
   {path:'',component:HomePageComponent},
  {path:'customerLogin',component:CustomerLoginComponent},
  {path:'vendorLogin',component:VendorLoginComponent},
  {path:'customerDashBoard',component:CustomerDashBoardComponent},
  {path:'vendorDashBoard',component:VendorDashBoardComponent},
  {path:'custDashBoard',component:CustomerDashBoardComponent, 
    children : [
      {path:'showRestaurant',component:RestaurantShowComponent,outlet:'mphasis'},
      {path:'showCustomer',component:CustomerShowComponent,outlet:'mphasis'},
      {path:'showCustomerWallet',component:WalletCustomerComponent,outlet:'mphasis'},
      {path:'placeOrder',component:PlaceOrderComponent,outlet:'mphasis'}
    ]  
  }
]
@NgModule({
  declarations: [
    AppComponent,
    RestaurantShowComponent,
    CustomerShowComponent,
    VendorShowComponent,
    CustomerDashBoardComponent,
    VendorDashBoardComponent,
    CustomerLoginComponent,
    VendorLoginComponent,
    HomePageComponent,
    WalletCustomerComponent,
    PlaceOrderComponent,
    OrdersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
