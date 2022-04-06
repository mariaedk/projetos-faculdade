// precisa ser uma variavel global para que o onFormSubmit() possa perceber quando houve alguma edição em algum item
var selectedRow = null;
// informações para colocar no LocalStorage
var students = [];

let isEditing = false;

updateAfterPageRefresh();

function myFunctionIndex() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

function myFunctionContatos() {
  var x = document.getElementById("topnav-contatos");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

function onFormSubmit() {
  if (validateName() && validateAge()) {
    var formData = readFormData();
    if (selectedRow == null) {
      if (students.length == 0)
      {
        insertNewRecord(formData);
      }
      else if (validateCode())
      {
        insertNewRecord(formData);
        cleanErrorMessages();
        resetForm();
      }
    } else {
      if (validateCode())
      {
        updateRecord(formData);
        cleanErrorMessages();
        selectedRow = null;
        resetForm();
      }
    }

  }
}

// vai pegar os dados do formulário e armazenar em um "json"
function readFormData() {
  var formData = {};
  formData["nome"] = document.getElementById("nome").value;
  formData["codigo"] = document.getElementById("codigo").value;
  formData["idade"] = document.getElementById("idade").value;

  return formData;
}

// Crudl -> insert (Create)
// data -> objeto formData 
function insertNewRecord(data) {
  var table = document.getElementById("alunoList").getElementsByTagName('tbody')[0];
  // inserir uma nova linha na tabela
  // a cada nova inserção aumenta o tamanho da tabela em 1
  var newRow = table.insertRow(table.length);
  // inserindo em uma nova linha, uma célula
  // em toda criação de linha, as células criadas vao ficar uma do lado da outra
  cell1 = newRow.insertCell(0);
  cell1.innerHTML = data.nome;
  cell2 = newRow.insertCell(1);
  cell2.innerHTML = data.codigo;
  cell3 = newRow.insertCell(2);
  cell3.innerHTML = data.idade;
  cell4 = newRow.insertCell(3);
  // criando botões de editar e deletar em uma nova célula do lado dos dados
  cell4.innerHTML = `<a onClick="onEdit(this)">Editar</a>
                     <a onClick="onDelete(this)">Deletar</a>`;
  // armazena no local storage
  students.push(data);
  localStorage.setItem("students", JSON.stringify(students));
}

// cruDl -> limpar
function resetForm() {
  document.getElementById("nome").value = "";
  document.getElementById("codigo").value = "";
  document.getElementById("idade").value = "";
}

// paramametro -> pega o proprio objeto para editar
function onEdit(td) {
  selectedRow = td.parentElement.parentElement;
  document.getElementById("nome").value = selectedRow.cells[0].innerHTML;
  document.getElementById("codigo").value = selectedRow.cells[1].innerHTML;
  document.getElementById("idade").value = selectedRow.cells[2].innerHTML;
}

// Atualiza os dados após uma edição
function updateRecord(formData) {
  selectedRow.cells[0].innerHTML = formData.nome;
  selectedRow.cells[1].innerHTML = formData.codigo;
  selectedRow.cells[2].innerHTML = formData.idade;
  students.splice(selectedRow.rowIndex - 1, 1, { nome: formData.nome, codigo: formData.codigo, idade: formData.idade });
  localStorage.setItem("students", JSON.stringify(students));
}

function cleanErrorMessages()
{
  document.getElementById("nameValidationError").classList.add("hide");
  document.getElementById("ageValidationError").classList.add("hide");
  document.getElementById("codeValidationError").classList.add("hide");
}

// DELETA :) e tira do LocalStore
function onDelete(td) {
  if (confirm('Você tem certeza que deseja deletar esta informação?')) {
    var row = td.parentElement.parentElement;
    // o indice no localStorage começa em 0, já no rowIndex o inicio é 1
    students.splice(row.rowIndex - 1, 1);
    localStorage.setItem("students", JSON.stringify(students));
    document.getElementById("alunoList").deleteRow(row.rowIndex);
    resetForm(); // não resetar antes de tirar do localStorage -> exclui um item diferente do selecionado
  }
}

// verifica se o nome está vazio (Só verifica se está vazio, n verifica se são números ou letra)
function validateName() {
  isValid = true;
  if (document.getElementById("nome").value == "") {
    isValid = false;
    document.getElementById("nameValidationError").classList.remove("hide");
  } else {
    isValid = true;
    if (!document.getElementById("nameValidationError").classList.contains("hide")) {
      document.getElementById("nameValidationError").classList.add("hide");
    }
  }
  return isValid;
}

// verifica se a idade está preenchida (Só verifica se está vazio, n verifica se são números ou letra)
function validateAge() {
  isValid = true;
  if (document.getElementById("idade").value == "" || document.getElementById("idade").value < 0 || document.getElementById("idade").value > 130) {
    isValid = false;
    document.getElementById("ageValidationError").classList.remove("hide");
  } else {
    isValid = true;
    if (!document.getElementById("ageValidationError").classList.contains("hide")) {
      document.getElementById("ageValidationError").classList.add("hide");
    }
  }
  return isValid;
}

function validateCode() {
  isValid = true;
  students = JSON.parse(localStorage.getItem("students"));

  let codigo;
  for (let index = 0; index < students.length; index++) 
  {
    codigo = students[index].codigo;
    if(document.getElementById("codigo").value == codigo)
    {
      isValid = false;
      document.getElementById("codeValidationError").classList.remove("hide");
    }
  }

  if (isValid)
  {
    if (!document.getElementById("codeValidationError").classList.contains("hide")) {
      document.getElementById("codeValidationError").classList.add("hide");
    }
  }
  return isValid;
}
// Sempre que atualiza a página o vetor students é resetado
// Pega dados do LocalStorage toda vez que recarregar a página
function updateAfterPageRefresh() {
  if (localStorage.getItem("students") == null) {
    console.log("LocalStorage is empty!");
  } else {
    students = JSON.parse(localStorage.getItem("students"));
    for (let index = 0; index < students.length; index++) {
      let nome = students[index].nome;
      let codigo = students[index].codigo;
      let idade = students[index].idade;
      document.getElementById("alunoList").getElementsByTagName('tbody')[0].innerHTML +=
        `<tr>
        <td>${nome}</td>
        <td>${codigo}</td>
        <td>${idade}</td>
        <td><a onClick="onEdit(this)">Editar</a>
        <a onClick="onDelete(this)">Deletar</a></td>
      </tr>
      `
    }
  }
}