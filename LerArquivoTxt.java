package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream entradaArquivo = 
				new FileInputStream(new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo.csv"));
		
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");/*passando entrada e a codificação que eu quero utf-8 no caso. (entradaArquivo, "UTF-8")*/
		
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (lerArquivo.hasNext()) { //Enquanto meu lerArquivo tiver dados vamos pegar String que vai ser uma linha = lerarquivo.nextline daí vou ter minha linha e imprimindo no console (linha)
			//e colocando um try catch imprimirá os arquivos e leu a linha
			
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) {//ignorando linha em branco, daí sim vai imprimir a linha retirando uma linha em branco se houver
				
				String[] dados = linha.split("\\;");//além das linhas temos um padrão de delimitador estruturado (;) normalmente este arquivo será importado para BD, ou enviar por email etc...
				/*Na linha acima estamos fazendo um array de string chamado dados e fazemos um divisor (split) e quando a linha for válida inciamos um novo obj de pessoa
				 * conforme abaixo
				 * */
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);/*setando nome posicao 0*/
				pessoa.setEmail(dados[1]);/*setando email*/
				pessoa.setIdade(Integer.parseInt(dados[2])); /* setando idade e fazendo conversão pois recebe um inteiro*/
				
				/*E agora fora do while criamos uma lista de pessoas na linha 19*/
				
				pessoas.add(pessoa); /*aqui estamos adicionando na lista*/
			}
		}
		
		/*System.out.println(pessoas); Aqui poderiamos imprimir porém fomos no pessoa e implementamos um toString para facilitar com todas as fields
		 * e agora imprime os dados da pessoa porém vamos fazer um Forecah abaixo
		 * */
		
		for (Pessoa pessoa : pessoas) { /*Poderia gravar no banco de dados, enviar email, gerar boleto, fazer coisas*/
			System.out.println(pessoa);
		}

	}
}
/*MUdadmos o demilitador de ; para PIPE | que tb é muito usdo em diversos códigos por aí*/


