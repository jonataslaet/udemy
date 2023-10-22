import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {
  
  @Output() firedNumber = new EventEmitter<number>();

  interval: any;
  currentNumber: number = 1;

  constructor() { }

  ngOnInit(): void {
  }

  onStartGame() {
    this.interval = setInterval(() => {
      this.firedNumber.emit(this.currentNumber);
      this.currentNumber += 1;
    }, 1000);
  }

  onStopGame() {
    clearInterval(this.interval);
  }
}
