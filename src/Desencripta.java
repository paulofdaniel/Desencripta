import java.util.Scanner;

public class Desencripta {

	public static void main(String[] args) {

		char mensagemAscii[][] = new char[3][3];
		
		int vetorCriptografado[][] = new int[3][3],							
			contaValores = 1;
		
		float mensagemDescriptografada[][] = new float[3][3], 
			  matrizCofatores[][] = new float[3][3],
			  chaveInversa[][] = new float[3][3],
			  chave[][] = new float[3][3],
			  detChave;
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("       ##Desencriptador Master 9000##     \n");
		
		//Entrada da mensagem criptografada
		System.out.println("Entre com a sequência de valores interceptados:\n");
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print((contaValores + i + j) + " de 9: ");
				vetorCriptografado[i][j] = leia.nextInt();				
			}
			contaValores += 2;
		}
		System.out.println("\nOk, valores recebidos com sucesso!");
		
		//Entrada da mensagem criptografada		
		System.out.println("\nAgora entre com os valores da matriz chave nas posições indicadas:\n");
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print("Posição " + "[" + i + "]" + "[" + j + "]: ");
				chave[i][j] = leia.nextInt();				
			}
			
		}
		
///////////////////////CALCULOS COM ASMATRIZES///////////////////////////
		//Inverter chave
		//calculo da determinante
		detChave = (chave[0][0] * chave[1][1] * chave[2][2]) + (chave[0][1] * chave[1][2] * chave[2][0]) + (chave[0][2] * chave[1][0] * chave[2][1])
				 - (chave[0][2] * chave[1][1] * chave[2][0]) - (chave[0][0] * chave[1][2] * chave[2][1]) - (chave[0][1] * chave[1][0] * chave[2][2]);
		
		//Cria matriz de cofatores
		matrizCofatores[0][0] = ((chave[1][1]*chave[2][2])-(chave[2][1]*chave[1][2]))/detChave;
		matrizCofatores[0][1] = (((chave[1][0]*chave[2][2])-(chave[2][0]*chave[1][2]))*(-1))/detChave;
		matrizCofatores[0][2] = ((chave[1][0]*chave[2][1])-(chave[2][0]*chave[1][1]))/detChave;
		matrizCofatores[1][0] = (((chave[0][1]*chave[2][2])-(chave[2][1]*chave[0][2]))*(-1))/detChave;
		matrizCofatores[1][1] = ((chave[0][0]*chave[2][2])-(chave[2][0]*chave[0][2]))/detChave;
		matrizCofatores[1][2] = (((chave[0][0]*chave[2][1])-(chave[2][0]*chave[0][1]))*(-1))/detChave;
		matrizCofatores[2][0] = ((chave[0][1]*chave[1][2])-(chave[1][1]*chave[0][2]))/detChave;
		matrizCofatores[2][1] = (((chave[0][0]*chave[1][2])-(chave[1][0]*chave[0][2]))*(-1))/detChave;
		matrizCofatores[2][2] = ((chave[0][0]*chave[1][1])-(chave[1][0]*chave[0][1]))/detChave;
		
		//Transposição para virar chave inversa
		for(int i = 0; i < 3; i++){			
			for(int j = 0; j < 3; j++ ){
				chaveInversa[i][j] = matrizCofatores[j][i];
			}
		}
		
		//////////MULTIPLICA CHAVE INVERSA PELA MATRIZ DA MSG CODIFICADA/////////////
		for(int i = 0; i < 3; i++){			
			for(int j = 0; j < 3; j++ ){
				mensagemDescriptografada[i][j] = ((vetorCriptografado[i][0] * chaveInversa[0][j]) + (vetorCriptografado[i][1] * chaveInversa[1][j]) + (vetorCriptografado[i][2] * chaveInversa[2][j]));
			}
		}
		
	
///////////////////////////CONVERTE MATRIZ DE NUMEROS EM CHAR//////////////////////////
		//converte os números em caracteres Ascii
		for(int i = 0; i < 3; i++){			
			for(int j = 0; j < 3; j++ ){
				if(mensagemDescriptografada[i][j] != 0){
					mensagemAscii[i][j] = (char)((int)mensagemDescriptografada[i][j] + 64); 
				}else
					mensagemAscii[i][j] = '#';
			}
		}		
		
		//Exibe mensagem final
		System.out.println("\n---------------------\n   Mensagem Final\n---------------------");
		for(int i = 0; i < 3; i++){			
			for(int j = 0; j < 3; j++ ){
				System.out.print(mensagemAscii[i][j]);
			}
		}		
	}

}
