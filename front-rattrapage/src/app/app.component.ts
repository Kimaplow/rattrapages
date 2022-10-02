import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent {
  title = 'front-rattrapage';
}

export const baseUrl = "http://localhost:8080/v1/";
export const baseUrlPhotos = "http://localhost:8080/photos/";
export const baseUrlPdf = "http://localhost:8080/pdf/";