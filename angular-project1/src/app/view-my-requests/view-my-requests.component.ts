import { Component, OnInit } from '@angular/core';
import { REQUESTS } from "../mock-requests";
import { RequestService } from "../request.service";

@Component({
  selector: 'app-view-my-requests',
  templateUrl: './view-my-requests.component.html',
  styleUrls: ['./view-my-requests.component.css']
})
export class ViewMyRequestsComponent implements OnInit {

  requests = REQUESTS;

  constructor(private requestService: RequestService) {
  }

  ngOnInit(): void {
  }

}
