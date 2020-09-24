import { Component, OnInit } from '@angular/core';
import { Request } from "../request";
import { REQUESTS } from "../mock-requests";
import { RequestService } from "../request.service";

@Component({
  selector: 'app-view-my-requests',
  templateUrl: './view-my-requests.component.html',
  styleUrls: ['./view-my-requests.component.css']
})
export class ViewMyRequestsComponent implements OnInit {

  userid: number = 1;

  

  performFilter(userid: number): Request[]{
  
    return this.requests.filter(

      (request: Request) => request.userid == this.userid
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
