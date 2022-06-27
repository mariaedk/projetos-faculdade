export class Aluno
{
  codigo?: number;
  nome?: string;
  idade?: number;
  genero?: string;
  escolaridade?: string;

  constructor(obj: Partial<Aluno>)
  {
    Object.assign(this, obj);
  }
}
