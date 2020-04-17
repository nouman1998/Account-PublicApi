import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppServiceService } from './app-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  name = 'Angular';
  countriesArray
  dataFromDb
  flag: Boolean = false;

  ngOnInit() {
    this.service.getApiResult().subscribe(d => {
      this.countriesArray = d
    })
  }


  constructor(private http: HttpClient, private service: AppServiceService) { }



  saveAll() {
    debugger
    this.countriesArray.map(d => {
      let obj = {
        "name": d.name,
        "alphaCode": d.alpha2Code,
        "capital": d.capital,
        "population": d.population,
        "subRegion": d.subregion,
        "region": d.region
      };



      this.service.saveAll(obj).subscribe(

      );;
    })

  }

  getAll() {
    this.flag = true;
    this.service.getAll().subscribe(d => {
      this.dataFromDb = d;
      console.log(this.dataFromDb)
    })
  }

  deleteAll() {
    this.flag=false;
    this.service.deleteAll().subscribe();
  }

}
