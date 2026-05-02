import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PropertyListComponent } from './property-list/property-list.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'properties', component: PropertyListComponent },
  { path: '**', redirectTo: '' }
];
