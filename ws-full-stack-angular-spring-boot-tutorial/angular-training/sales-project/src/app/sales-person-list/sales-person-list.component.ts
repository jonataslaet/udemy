import { Component, OnInit } from '@angular/core';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  salesPersonList: SalesPerson[] = [
    new SalesPerson("Jonatas", "Laet", "jonataslaet@gmail.com", 72780),
    new SalesPerson("Dérick", "Wenner", "derickwenner@gmail.com", 72781),
    new SalesPerson("Marcos", "Aurélio", "marcosaurelio@gmail.com", 72782),
    new SalesPerson("Diego", "Rozado", "diegorozado@gmail.com", 72783)
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
