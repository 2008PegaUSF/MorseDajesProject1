import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormArray, FormBuilder, ReactiveFormsModule} from '@angular/forms';
import { Grade } from '../grade-interface';
import { GradeService } from '../grade.service';
import { REQUESTS } from '../mock-requests';
import { RequestService } from '../request.service';
import { Request } from '../request';


@Component({
  selector: 'app-pending-grades',
  templateUrl: './pending-grades.component.html',
  styleUrls: ['./pending-grades.component.css']
})
export class PendingGradesComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private gradeService: GradeService, private requestService: RequestService) { }

    grades: Grade[];
    requests: Request[];
    tableEntries: Request[] = [];
    selectedGrades: Grade[] = [];

    pendingGrades: FormGroup = this.formBuilder.group({
      verdict: new FormControl(''),
      selections: this.formBuilder.array([
        this.formBuilder.control('')
      ])
    });
<<<<<<< HEAD
=======


  constructor(private gradeService: GradeService, private requestService: RequestService, /*private sessionService: SessionService*/) { }
>>>>>>> bbfc249dcc502849f4b85e5b5e09a7b5546ccdbc

  ngOnInit(): void {

    let grades = this.gradeService.get();
    let requests = this.requestService.get();

    for (var grade of grades){
        for (var request of requests) {
          if (grade.requestid === request.id){
            let tableEntry = {
              requestid: request.id,
              firstName: request.firstName,
              lastName: request.lastName,
              eventType: request.eventType,
              description: request.description,
              gradingFormat: request.gradingFormat,
              eventDate: '',
              eventTime: '',
              location: '',
              justification: '',
              status: '',
              cost: 0,
              userid: 0,
              projectedAmount: 0,
              awardedAmount: 0
            }
            this.tableEntries.push(tableEntry);
          }
        }
    } 
  }

  FieldsChange(values:any,id:number){
    if (values.currentTarget.checked) {
      this.selectedGrades.push(
        this.gradeService.getById(id)
      );
    } else {
      this.selectedGrades.splice(
        this.selectedGrades.indexOf(this.gradeService.getById(id))
      );
    }
  }

  getGradeVerdict() {
    // let formData: any = new FormData();
    // formData.append('verdict', this.pendingGrades.get('verdict').value);

    let verdict: string = this.pendingGrades.get('verdict').value;
    let selections: FormArray = this.pendingGrades.get('selections') as FormArray;

    for (let selection of selections.value) {
      for (let grade of this.grades){
        if (selection == grade.requestid) {
          this.selectedGrades.push(grade);
        }
      }
    }
  
    if (verdict == 'Approve') {
      this.gradeService.approve(this.selectedGrades);
    } else if (verdict == 'Deny') {
      this.gradeService.remove(this.selectedGrades);
    }

    for (let grade of this.selectedGrades) {
      this.tableEntries = this.tableEntries.filter(tableEntry => tableEntry.id != grade.requestid)
    }
  }


}