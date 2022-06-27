import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CookieService } from 'ngx-cookie-service';
import { Aluno } from '../../../models/aluno/aluno';

@Component({
  selector: 'app-cadastro-aluno',
  templateUrl: './cadastro-aluno.component.html',
  styleUrls: ['./cadastro-aluno.component.scss'],
})
export class CadastroAlunoComponent implements OnInit {

  displayedColumns = ['codigo', 'nome', 'idade', 'genero', 'escolaridade', 'Ações'];
  dataSource!: MatTableDataSource<Aluno>;
  filtragem: string = ''
  listaAlunos$: Aluno[] = [];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  isCadastroValid: boolean = false;
  formNome!: any;
  formIdade!: any;
  formCodigo!: any;
  formEscolaridade!: any;
  formGenero!: any;

  nomeModel!: any;
  idadeModel!: any;
  codigoModel!: any;
  escolaridadeModel!: any;
  generoModel!: any;

  cadastrando: boolean = false;
  editando: boolean = false;
  editSucedido: boolean = false;
  alunoEditando!: Aluno;

  deletando: boolean = false;
  alunoDeletando!: Aluno;
  sucessoDelete: boolean = false;

  constructor(private cookie: CookieService) {
    this.dataSource = new MatTableDataSource(this.listaAlunos$);
  }

  ngOnInit(): void {
    this.createForm();
    this.getListAlunos();
    this.dataSource = new MatTableDataSource(this.listaAlunos$);
  }

  resetButton() {
    this.nomeModel = ''
    this.idadeModel = ''
    this.codigoModel = ''
    this.escolaridadeModel = ''
    this.generoModel = ''
    this.editando = false;
    this.deletando = false;
    this.formCodigo.controls['codigo'].enable();
  }

  createForm() {
    this.formNome = new FormGroup({
      nomeCadastroAluno: new FormControl('', Validators.compose([Validators.required, Validators.pattern(/^[\D]{2,50}$/)]))
    });
    this.formIdade = new FormGroup({
      idade: new FormControl('', Validators.compose([Validators.required, Validators.pattern(/^([1-9]{1}|[0-9]{2})$/)]))
    });
    this.formCodigo = new FormGroup({
      codigo: new FormControl('', Validators.compose([Validators.required, Validators.pattern(/[0-9]{6}/)]))
    });
    this.formEscolaridade = new FormGroup({
      escolaridade: new FormControl('', Validators.required)
    });
    this.formGenero = new FormGroup({
      genero: new FormControl('', Validators.required)
    })
  }

  checkCodeInLocalStorage(): boolean {
    let code = this.formCodigo.get('codigo').value;
    for (let aluno of this.listaAlunos$) {
      if (code === aluno.codigo && this.cadastrando == false && this.editando == false) {
        return true;
      }
    }
    return false;
  }

  saveInLocalStorage() {

    if (this.validate()) {

      localStorage.setItem('nomeCadastroAluno', JSON.stringify(this.formNome.value));
      localStorage.setItem('idade', JSON.stringify(this.formIdade.value));
      localStorage.setItem('codigo', JSON.stringify(this.formCodigo.value));
      localStorage.setItem('genero', JSON.stringify(this.formGenero.value));
      localStorage.setItem('escolaridade', JSON.stringify(this.formEscolaridade.value));
      this.cadastrando = true;
      setTimeout(() => {
        this.createAluno();
      }, 1000);

      this.isCadastroValid = true;
      setTimeout(() => {
        this.isCadastroValid = false;
      }, 3000);

      setTimeout(() => {
        location.reload();
      }, 2000);
      setTimeout(() => {
        this.cadastrando = false;
      }, 3000);
    } else {
      alert('ERRO CADASTRO ALUNO');
    }
  }

  validateName(): boolean {
    return (this.formNome.get('nomeCadastroAluno')?.errors?.['required'] || this.formNome.get('nome')?.errors?.['pattern']) ? false : true;
  }

  validateAge(): boolean {
    return (this.formIdade.get('idade')?.errors?.['required'] ||
      this.formIdade.get('idade')?.errors?.['pattern']) ? false : true;
  }

  validateCode(): boolean {
    return (this.checkCodeInLocalStorage() || this.formCodigo.get('codigo')?.errors?.['required'] || this.formCodigo.get('codigo')?.errors?.['pattern']) ? false : true;
  }

  validateGender(): boolean {
    return (this.formGenero.value['genero'] !== 'masculino' &&
      this.formGenero.value['genero'] !== 'feminino' &&
      this.formGenero.value['genero'] !== 'outros') ? false : true;
  }

  validateSchooling() {
    return !this.formEscolaridade.get('escolaridade').errors;
  }

  validate(): boolean {
    return (this.validateName() && this.validateAge() && this.validateCode() && this.validateGender() && this.validateSchooling());
  }

  // INICIO METODOS TABELA

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  // CREATE
  addAlunoLista(aluno: any) {
    this.listaAlunos$.push(aluno);
  }

  setListaAlunosLocalStorage(alunos: any) {
    localStorage.setItem("alunos", JSON.stringify(alunos))
  }

  createAluno() {
    var codigoAluno = JSON.parse(localStorage.getItem("codigo")!).codigo;
    var nomeCadastroAluno = JSON.parse(localStorage.getItem("nomeCadastroAluno")!).nomeCadastroAluno;
    var idadeAluno = JSON.parse(localStorage.getItem("idade")!).idade;
    var generoAluno = JSON.parse(localStorage.getItem("genero")!).genero;
    var escolaridadeAluno = JSON.parse(localStorage.getItem("escolaridade")!).escolaridade;

    var aluno = {
      "codigo": codigoAluno,
      "nome": nomeCadastroAluno,
      "idade": idadeAluno,
      "genero": generoAluno,
      "escolaridade": escolaridadeAluno
    };

    this.addAlunoLista(aluno);
    this.setListaAlunosLocalStorage(this.listaAlunos$);
  }

  // READ
  getListAlunos() {
    var alunos = JSON.parse(localStorage.getItem("alunos") || "[]");
    this.listaAlunos$ = alunos;
  }

  // UPDATE
  editAluno() {
    var posicaoAluno = this.procurarAlunoNaLista(this.alunoEditando);
    // se o aluno existe na lista
    if (posicaoAluno != -1) {
      var novoAluno = {
        "codigo": this.codigoModel,
        "nome": this.nomeModel,
        "idade": this.idadeModel,
        "genero": this.generoModel,
        "escolaridade": this.escolaridadeModel
      }
      // atualiza, na lista de alunos, o objeto que está naquela posicao
      this.listaAlunos$[posicaoAluno] = novoAluno;
      // atualiza o local storage
      this.setListaAlunosLocalStorage(this.listaAlunos$);
      this.editSucedido = true;
      setTimeout(() => {
        this.editando = false;
        this.blockCode();
        location.reload();
      }, 3000);
    }
  }

  procurarAlunoNaLista(aluno: Aluno) {
    for (let index = 0; index < this.listaAlunos$.length; index++) {
      if (this.listaAlunos$[index].codigo == aluno.codigo) {
        return index;
      }
    }
    return -1;
  }

  blockCode() {
    if (this.editando === true) {
      this.formCodigo.controls['codigo'].disable({ onlySelf: true });
    } else {
      this.formCodigo.controls['codigo'].disable({ onlySelf: false });
    }
  }

  showAlunoInInputs(aluno: Aluno) {
    this.editando = true;
    this.blockCode();
    this.nomeModel = aluno["nome"];
    this.idadeModel = aluno["idade"];
    this.codigoModel = aluno["codigo"];
    this.generoModel = aluno["genero"];
    this.escolaridadeModel = aluno["escolaridade"];
    this.alunoEditando = aluno;
  }

  // DELETE
  confirmIfDeleteAluno(aluno: Aluno) {
    this.deletando = true;
    this.alunoDeletando = aluno;
  }

  deletarAluno() {
    var posicaoAlunoDeletar = this.procurarAlunoNaLista(this.alunoDeletando);
    if (posicaoAlunoDeletar != -1) {
      this.listaAlunos$.splice(posicaoAlunoDeletar, 1);
      // atualiza o local storage
      this.setListaAlunosLocalStorage(this.listaAlunos$);

      this.sucessoDelete = true;

      setTimeout(() => {
        this.sucessoDelete = false;
        location.reload();
      }, 2000)
    }

  }


  // SEARCH
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
}



