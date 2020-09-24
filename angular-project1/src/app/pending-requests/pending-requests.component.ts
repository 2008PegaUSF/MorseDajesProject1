import { Component, OnInit } from '@angular/core';
import { Request } from "../request";
import { REQUESTS } from "../mock-requests";
import { RequestService } from "../request.service";

@Component({
  selector: 'app-pending-requests',
  templateUrl: './pending-requests.component.html',
  styleUrls: ['./pending-requests.component.css']
})
export class PendingRequestsComponent implements OnInit {

  status: string = "pending";

  performFilter(userid: number): Request[]{
  
    return this.requests.filter(

      (request: Request) => request.status == this.status
    );
  }

  requests: Request[];
  filteredRequests: Request[];

  constructor(private requestService: RequestService) {
    this.requests = REQUESTS;
    this.filteredRequests = this.performFilter(2)
  }

  ngOnInit(): void {
  }

}
