import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';
import { Restaurant } from '../restaurant';
import { RestaurantService } from '../restaurant.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {

  menus : Menu[];
  result : any;
  res : string;
  insert(placeOrder : NgForm) {
    //alert("Hi");
    //alert(this.orders.quantityOrdered);
    //alert(this.orders.menuId);
    this.orders.customerId = this.cid;
    //alert(this.orders.customerId);
    //alert(this.orders.vendorId);
    //alert(this.orders.walletId); 
    //alert(this.orders.orderComments);
    
   this.result = this._orderService.placeOrder1(this.orders)
   this.res = JSON.stringify(this.result);
   //alert(this.res);
  //  this._orderService.placeOrder1(this.orders).subscribe(x =>{
  //     this.result=x;
  //  //   alert(x);
  //  })
   alert(this.result);
  } 
  cid : number;
  restaurants : Restaurant[];
  vendors : Vendor[];
  rid : number;
  wallets : Wallet[];
  orders : Orders;
  menu : Menu;
  price : number;
  showm() {
    alert(this.orders.menuId);
    this._menuService.searchByMenuId(this.orders.menuId).subscribe(x => {
      this.price = x.price;
    })
  }
  show() {
    alert(this.rid);
    this._menuService.showMenu(this.rid).subscribe(x => {
      this.menus = x;
    });
  }
  showv() {
    alert(this.orders.vendorId);
  }
  showW() {
    alert(this.orders.walletId);
  }
  constructor(private _restaurantSerivce : RestaurantService,
              private _menuService : MenuService, 
              private _vendorService : VendorService,
              private _walletService : WalletService,
              private _orderService : OrdersService
        ) {
    this.orders = new Orders();
    this.cid = parseInt(localStorage.getItem("custId"));
    this._walletService.showCustomerWallet(this.cid).subscribe(x => {
      this.wallets = x;
    });
    this._restaurantSerivce.showRestaurant().subscribe(x => {
      this.restaurants=x;
    });
    this._vendorService.showVendors().subscribe(x => {
      this.vendors = x;
    })
   }

  ngOnInit(): void {
  }

}
