import { Component } from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule],   // ← Must have RouterModule
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'RealEstate LK';
}
