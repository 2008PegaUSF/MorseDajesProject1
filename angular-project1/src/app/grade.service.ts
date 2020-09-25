import { Injectable } from '@angular/core';
import {Grade} from './grade-interface';
import {GRADES} from './GRADES';
import { REQUESTS } from './mock-requests';

@Injectable({
  providedIn: 'root'
})

export class GradeService {

  constructor() { 
  }
 
  get(): Grade[]{
    return GRADES;
  }

  getById(id: number): Grade {
    for(let i: number = 0; i < GRADES.length; i++){
      if (GRADES[i]["requestid"] == id){
        return GRADES[i];
      }
    }
    return null;
 } 

  add(grades: Grade[]) {
    for (let grade of grades) {
        GRADES.push(grade);
    }
  }

  remove(grades: Grade[]){
    for (let gradeToRemove of grades) {
      let index = GRADES.indexOf(gradeToRemove, 0);
      if (index > -1) {
        GRADES.splice(index, 1)
      }
      //Alternative if top method doesn't work
      // GRADES.forEach( (grade, index) => {
      //   if(grade === gradeToRemove) GRADES.splice(index,1);
      // });
    }
  }

  approve(grades: Grade[]){
    for (let gradeToApprove of grades){
      for (let request of REQUESTS) {
        if(request.id === gradeToApprove.requestid){
          request.status = 'approved';
          request.awardedAmount = request.projectedAmount;
        }
      }
    }
  }


}
