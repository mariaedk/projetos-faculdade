function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

function onFormSubmit() {
  var formData = readFormData();
  insertNewRecord(formData);
  resetForm();
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
                  <a>Deletar</a>`;
}

// cruDl -> limpar
function resetForm()
{
  document.getElementById("nome").value = "";
  document.getElementById("codigo").value = "";
  document.getElementById("idade").value = "";
}

// paramametro -> pega o proprio objeto para editar
function onEdit(td)
{
  selectRow = td.parentElement.parentElement;
  document.getElementById("nome").value = selectedRow.cells[0].innerHTML;
  document.getElementById("codigo").value = selectedRow.cells[1].innerHTML;
  document.getElementById("idade").value = selectedRow.cells[2].innerHTML;
}