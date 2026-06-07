import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {PropertyListComponent} from './property-list/property-list.component';
import {InquiryComponent} from './inquiry/inquiry.component';
import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {TransactionComponent} from './transaction/transaction.component';
import {ReportsComponent} from './reports/reports.component';

export const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'properties', component: PropertyListComponent },
  {path: 'inquiries', component: InquiryComponent },
  {path: 'login', component: LoginComponent },
  {path: 'admin', component: AdminComponent },
  {path: 'transactions', component: TransactionComponent },
  {path: 'reports', component: ReportsComponent },
  {path: '**', redirectTo: '' }
];
