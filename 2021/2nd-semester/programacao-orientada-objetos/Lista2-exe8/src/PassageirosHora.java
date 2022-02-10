public class PassageirosHora {
	// atributos
	private int[][][] passageiros = new int[12][30][24]; // 12 meses, 30 dias, 24 horas

	// métodos
	// item a
	public void adiciona(int dia, int mes, int hora) {
		this.passageiros[mes - 1][dia - 1][hora]++;
	}

	// item b
	public int quantosPassageiros(int dia, int mes) {
		int total = 0;
		// ajustar o valor natural ao valor do índice
		mes--;
		dia--;

		for (int i = 0; i < 24; i++) {
			total += passageiros[mes][dia][i];
		}
		return total;
	}

	// item c
	// Pedro
	public int mesMenorFluxo() {
		int menorFluxo = Integer.MAX_VALUE;
		int mes = 0;

		for (int m = 1; m <= 12; m++) {
			int quantidade = quantosPassageiros(m);
			if (quantidade < menorFluxo) {
				menorFluxo = quantidade;
				mes = m;
			}
		}
		return mes;
	}

	public int quantosPassageiros(int mes) {
		int quantidade = 0;
		for (int dia = 1; dia <= 30; dia++) {
			quantidade += quantosPassageiros(dia, mes);
		}
		return quantidade;
	}

	// Marcos Vinicius
	public int mesMenorFluxo1() {
		int mesMenorFluxo = Integer.MAX_VALUE;
		int mesMenor = -1;

		for (int mes = 0; mes < 12; mes++) {
			int mesAtual = 0;
			for (int dia = 0; dia < 30; dia++) {
				for (int hora = 0; hora < 24; hora++) {
					mesAtual += this.passageiros[mes][dia][hora];
				}
			}
			if (mesAtual < mesMenorFluxo) {
				mesMenorFluxo = mesAtual;
				mesMenor = mes + 1;
			}
		}
		return mesMenor;
	}

	// item d

	public int[] picoTransporte() {
		int quantidade = 0;
		int maior = Integer.MIN_VALUE;
		int[] retorno = new int[3];

		for (int m = 0; m < 12; m++) {
			for (int d = 0; d < 30; d++) {
				for (int h = 0; h < 24; h++) {
					quantidade = passageiros[m][d][h];

					if (quantidade > maior) {
						maior = quantidade;
						retorno[0] = d+1; // para ajustar ao valor natural
						retorno[1] = m+1; 
						retorno[2] = h;
					}
				}
			}
		}
		return retorno;
	}

}