import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pending-requests',
  templateUrl: './pending-requests.component.html',
  styleUrls: ['./pending-requests.component.css']
})
export class PendingRequestsComponent implements OnInit {

  requests = REQUESTS;

  filteredRequests = this.requests.filter(
    function (d){
      return d.status == "pending";
    }
  );

  constructor(private requestService: RequestService) {
  }

  ngOnInit(): void {
  }

}
