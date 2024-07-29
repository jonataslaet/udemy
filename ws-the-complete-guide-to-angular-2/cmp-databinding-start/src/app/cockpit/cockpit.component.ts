import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {

  // newServerName = '';
  // newServerContent = '';
  @ViewChild('inputContent', {static: true}) serverInputContent: ElementRef;

  @Output() serverCreated = new EventEmitter<{name: string, content: string}>;
  @Output() blueprintCreated = new EventEmitter<{name: string, content: string}>;

  constructor() { }

  ngOnInit(): void {
  }

  onAddServer(inputName: HTMLInputElement) {
    this.serverCreated.emit({
      name: inputName.value,
      content: this.serverInputContent.nativeElement.value
    });
  }

  onAddBlueprint(inputName: HTMLInputElement) {
    this.blueprintCreated.emit({
      name: inputName.value,
      content: this.serverInputContent.nativeElement.value
    });
  }
}
