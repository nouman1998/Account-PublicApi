import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AppServiceService {

    constructor(private http: HttpClient) { }

    public getApiResult(): Observable<any> {


        const headers = { 'x-rapidapi-host': 'restcountries-v1.p.rapidapi.com', 'x-rapidapi-key': 'b0d36ff3e0msh9da9fb4dd97cd36p1d3417jsn9f90c4e2faae' }

        return this.http.get("https://restcountries-v1.p.rapidapi.com/all", { headers });



    }



    public saveAll(obj): Observable<any> {
        return this.http.post("http://localhost:8080/api/country/", obj);
    }

    public getAll(): Observable<any> {
        return this.http.get("http://localhost:8080/api/country/");
    }

    public deleteAll(): Observable<any> {
        return this.http.delete("http://localhost:8080/api/country/");
    }
}