import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isDisplaying: boolean = true;
  title: string = 'task-03';
  clicks: number[] = [];
  n: number = 0;

  toggleContent() {
    this.isDisplaying = !this.isDisplaying;
    this.n++;
    this.clicks.push(this.n);
  }

  getBackgroundColor(n: number) {
    return n > 4 ? 'blue' : 'transparent';
  }

  //5: Starting at the 5th log item, give all future log items a blue background (via ngStyle) and white color (via ngClass)
}
