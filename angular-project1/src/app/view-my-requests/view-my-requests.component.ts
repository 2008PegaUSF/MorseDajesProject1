import { Component, OnInit } from '@angular/core';
import { REQUESTS } from "../mock-requests";

@Component({
  selector: 'app-view-my-requests',
  templateUrl: './view-my-requests.component.html',
  styleUrls: ['./view-my-requests.component.css']
})
export class ViewMyRequestsComponent implements OnInit {

  requests = REQUESTS;

  constructor() { }

  ngOnInit(): void {
  }

}
