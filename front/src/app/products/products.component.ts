import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{
products! : Array<any>;
  ngOnInit(): void {
    this.products=[
      {id:1,name:"Computer",price:6500},
      {id:2,name:"printer",price:4500},
      {id:3,name:"smarte fone",price:2700}
    ]
  }

  handleDeletProduct(p: any) {
    let index =this.products.indexOf(p);
    this.products.splice(index,1);

  }
}
