import { Component, OnInit } from '@angular/core';
import { REQUESTS } from "../mock-requests";
import { RequestService } from "../request.service";

@Component({
  selector: 'app-pending-requests',
  templateUrl: './pending-requests.component.html',
  styleUrls: ['./pending-requests.component.css']
})
export class PendingRequestsComponent implements OnInit {

  requests = REQUESTS;

  constructor(private requestService: RequestService) {
  }

  ngOnInit(): void {
  }

}
