import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {

  // newServerName = '';
  newServerContent = '';

  @Output() serverCreated = new EventEmitter<{name: string, content: string}>;
  @Output() blueprintCreated = new EventEmitter<{name: string, content: string}>;

  constructor() { }

  ngOnInit(): void {
  }

  onAddServer(inputName: HTMLInputElement) {
    this.serverCreated.emit({
      name: inputName.value,
      content: this.newServerContent
    });
  }

  onAddBlueprint(inputName: HTMLInputElement) {
    this.blueprintCreated.emit({
      name: inputName.value,
      content: this.newServerContent
    });
  }
}
