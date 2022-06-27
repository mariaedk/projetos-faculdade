package calculadora;

import java.util.Scanner;

import interfacesPilha.Pilha;
import pilhaLista.PilhaLista;
import pilhaVetor.PilhaVetor;


public class Calculadora
{
	private Pilha<Integer> pilha;
	private String respostaUsuario;
	private Scanner teclado = new Scanner(System.in);
	private String expressao;
	
	public String getExpressao()
	{
		return expressao;
	}
	public void setExpressao(String expressao) 
	{
		this.expressao = expressao;
	}	
	public String getRespostaUsuario() 
	{
		return respostaUsuario;
	}
	public void setRespostaUsuario(String respostaUsuario) 
	{
		this.respostaUsuario = respostaUsuario;
	}
	public Pilha<Integer> getPilha() 
	{
		return pilha;
	}
	public void setPilha(Pilha<Integer> pilhaVetor) 
	{
		this.pilha = pilhaVetor;
	}
	
	public void getExpressaoUsuario()
	{
		boolean isValid = false;

		while (!isValid)
		{
			System.out.println("Digite a expressão: ");
			String expressaoUsuario = teclado.nextLine();
			
			if (this.validaExpressao(expressaoUsuario))
			{
				isValid = true;
				this.setExpressao(expressaoUsuario);
			}
			else
			{
				System.out.println("Expressão inválida.");
			}
		}
	}
	
	public void getTipoPilha()
	{
		String resp = "";
		this.imprimeMenuCalculadora();
		while (true)
		{
			System.out.println("Escolha o tipo de pilha que deseja implementar: ");
			resp = teclado.nextLine();
			if (resp.toUpperCase().equals("V") || resp.toUpperCase().equals("D"))
			{
				this.setRespostaUsuario(resp);
				break;
			}
		}
	}
	
	public boolean validaExpressao(String exp)
	{
		int qtdNumeros = 0;
		int qtdOperadores = 0;
		
		char c = ' ';
		char anterior;
		
		for (int i = 0; i < exp.length(); i++)
		{
			anterior = c;
			c = exp.charAt(i);
			if (Character.isLetter(c))
			{
				return false;
			}
			
			else if (Character.isDigit(c))
			{
				if (Character.isDigit(anterior))
				{
					continue;
				}
				else
				{
					qtdNumeros++;
					continue;
				}
			}
			
			else
			{
				if (c == '/' || c == '*' || c == '+' || c == '-')
				{
					if (anterior == '/' || anterior == '*' || anterior == '+' || anterior == '-')
					{
						return false;
					}
					else
					{
						qtdOperadores++;
						continue;
					}
				}
				
				if (c == ' ')
				{
					if (anterior == ' ')
					{
						return false;
					}
					else
					{
						continue;		
					}
				}
				else
				{
					return false;
				}
			}
		}
		if (qtdOperadores + 1 != qtdNumeros)
		{
			return false;
		}
		
		return true;
	}

	public int comparaElementosExpressao()
	{
		String[] arrayExpressao = new String[this.getExpressao().length()];
		arrayExpressao = this.getExpressao().split(" ");
		int resultado = 0;
		int i = 0;
		while (i < arrayExpressao.length)
		{
			String elemento = arrayExpressao[i];
			i++;
			try
			{
				if (elemento.equals("+") || elemento.equals("/")|| elemento.equals("-") || elemento.equals("*"))
				{
					int valorDaDireita = pilha.pop();
					int valorDaEsquerda = pilha.pop();
					resultado = calculo(valorDaEsquerda,valorDaDireita, elemento);
					pilha.push(resultado);
				}
				else
				{
					int numero = Integer.parseInt(elemento);
					this.pilha.push(numero);
				}
			}
			catch (Exception e)
			{
				i = 0;
				System.out.println("Não foi possível realizar a operação. Por favor verifique a expressão e tente novamente.");
				getExpressaoUsuario();
				arrayExpressao = new String[this.getExpressao().length()];
				arrayExpressao = this.getExpressao().split(" ");
				resultado = 0;
			}			
		}
		return resultado;
	}
	
	public void imprimeMenuCalculadora()
	{
		System.out.println("========= CALCULADORA =========");
		System.out.println();
		System.out.println("Para utilizar uma pilha baseada em vetor, digite 'V'.");
		System.out.println("Para utilizar uma pilha baseada em lista dinâmica, digite 'D'.");
		System.out.println();
	}
	
	public void criaTipoPilha()
	{
		switch (respostaUsuario.toUpperCase())
		{
		case "V":
			this.setPilha(new PilhaVetor<Integer>(expressao.length()));
			break;
		case "D":
			this.setPilha(new PilhaLista<Integer>());
			break;
		default:
			System.out.println("Não foi possível criar o objeto.");
		}		
	}

	public int calculo(int resultado1, int resultado2, String operador)
	{
		if (operador.equals("/")) 
		{
			return resultado1 / resultado2;
		} 
		else if (operador.equals("*")) 
		{
			return resultado1 * resultado2;
		} 
		else if (operador.equals("-"))
		{
			return resultado1 - resultado2;
		} 
		else if (operador.equals("+")) 
		{
			return resultado1 + resultado2;
		} 
		else 
		{
			return 0;
		}
	}
}