import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/common/navbar/navbar.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { CadastroComponent } from './components/usuario/cadastro/cadastro.component';
import { LoginComponent } from './components/usuario/login/login.component';
import { SuporteComponent } from './components/suporte/suporte.component';
import { CadastroAlunoComponent } from './components/aluno/cadastro-aluno/cadastro-aluno.component';
import { HistoriaComponent } from './components/historia/historia.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatAutocompleteModule,
} from '@angular/material/autocomplete';
import {
  MatButtonModule,
} from '@angular/material/button';
import {
  MatCardModule,
} from '@angular/material/card';
import {
  MatCheckboxModule,
} from '@angular/material/checkbox';
import {
  MatChipsModule,
} from '@angular/material/chips';
import {
  MatDatepickerModule,
} from '@angular/material/datepicker';
import {
  MatDialogModule,
} from '@angular/material/dialog';
import {
  MatExpansionModule,
} from '@angular/material/expansion';
import {
  MatGridListModule,
} from '@angular/material/grid-list';
import {
  MatIconModule,
} from '@angular/material/icon';
import {
  MatInputModule,
} from '@angular/material/input';
import {
  MatListModule,
} from '@angular/material/list';
import {
  MatMenuModule,
} from '@angular/material/menu';
import {
  MatNativeDateModule,
} from '@angular/material/core';
import {
  MatPaginatorModule,
} from '@angular/material/paginator';
import {
  MatProgressBarModule,
} from '@angular/material/progress-bar';
import {
  MatProgressSpinnerModule,
} from '@angular/material/progress-spinner';
import {
  MatRadioModule,
} from '@angular/material/radio';
import {
  MatRippleModule,
} from '@angular/material/core';
import {
  MatSelectModule,
} from '@angular/material/select';
import {
  MatSlideToggleModule,
} from '@angular/material/slide-toggle';
import {
  MatSnackBarModule,
} from '@angular/material/snack-bar';
import {
  MatSortModule,
} from '@angular/material/sort';
import {
  MatTabsModule,
} from '@angular/material/tabs';
import {
  MatTableDataSource, MatTableModule,
} from '@angular/material/table';
import {
  MatToolbarModule,
} from '@angular/material/toolbar';
import {
  MatTooltipModule,
} from '@angular/material/tooltip';
import {
  MatStepperModule,
} from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { getPortuguesePaginatorIntl } from './components/aluno/cadastro-aluno/paginacao-portugues-intl';
import { MatPaginatorIntl } from '@angular/material/paginator';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    CadastroComponent,
    LoginComponent,
    SuporteComponent,
    CadastroAlunoComponent,
    HistoriaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule
  ],
  providers: [{provide: MatPaginatorIntl, useValue: getPortuguesePaginatorIntl()}],
  bootstrap: [AppComponent]
})
export class AppModule { }
