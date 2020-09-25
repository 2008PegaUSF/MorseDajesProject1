import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { REQUESTS } from '../mock-requests';
import { Request } from '../request';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-submit-my-request',
  templateUrl: './submit-my-request.component.html',
  styleUrls: ['./submit-my-request.component.css']
})
export class SubmitMyRequestComponent implements OnInit {

  submitRequestForm: FormGroup = this.formBuilder.group({
    eventDate: new FormControl(''),
    eventTime: new FormControl(''),
    location: new FormControl(''),
    description: new FormControl(''),
    cost: new FormControl(''),
    gradingFormat: new FormControl(''),
    eventType: new FormControl(''),
    justification: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
  });

  constructor(private formBuilder: FormBuilder, private requestService: RequestService) { }

  ngOnInit(): void {
  }

  submitRequest() {
    let eventDate: string = this.submitRequestForm.get('eventDate').value;
    let eventTime: string = this.submitRequestForm.get('eventTime').value;
    let location: string = this.submitRequestForm.get('location').value;
    let description: string = this.submitRequestForm.get('description').value;
    let cost: number = this.submitRequestForm.get('cost').value;
    let gradingFormat: string = this.submitRequestForm.get('gradingFormat').value;
    let eventType: string = this.submitRequestForm.get('eventType').value;
    let justification: string = this.submitRequestForm.get('justification').value;
    let firstName: string = this.submitRequestForm.get('firstName').value;
    let lastName: string = this.submitRequestForm.get('lastName').value;

    let userid: number = 0;//this.sessionService.getCurrentUserId();
    let awardedAmount: number = null;
    let status: string = 'new';
    
    let lastRequest: Request = REQUESTS[REQUESTS.length - 1];
    let id: number = lastRequest.id + 1;
    let projectedAmount: number;

    switch (eventType) {
			
			case "University course": projectedAmount= cost * 0.8;
				break;
				
			case "Seminar": projectedAmount= cost * 0.6;
				break;
				
			case "Certification prep": projectedAmount= cost * 0.75;
				break;
				
			case "Certification": projectedAmount= cost;
				break;
			
			case "Technical training": projectedAmount= cost * 0.9;
				break;
			
			case "Other": projectedAmount= cost * 0.3;
				break;
				
			default: console.log("Event type error.");
    }
    
    let newRequest: Request = {id: id,
      eventDate: eventDate,
      eventTime: eventTime,
      location: location,
      description: description,
      cost: cost,
      gradingFormat: gradingFormat,
      eventType: eventType,
      justification: justification,
      firstName: firstName,
      lastName: lastName,
      projectedAmount: projectedAmount,
      awardedAmount: awardedAmount,
      status: status,
      userid: userid
    }

    this.requestService.add(newRequest);

  }


}
