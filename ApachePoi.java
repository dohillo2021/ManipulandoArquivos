package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo_excel.xls");/*Criando arquivo com File File file = new file e o diret�rio e colqoue \\ duas*/
		
		if (!file.exists()) { /*se ele n�o existir? ent�o crie*/
			file.createNewFile();/*criando aqui*/
		}
		
		/*Agora eu preciso de dados para escrever na planilha ent�o  peguei no Arquivos.java a lista de pessoas criadas conforme abaixo*/
		
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("email@email.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("William Machado");
		
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("segundoemail@email.com");
		pessoa2.setIdade(25);
		pessoa2.setNome("Enrico Fernandes");
		
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("terceiroemail@email.com");
		pessoa3.setIdade(40);
		pessoa3.setNome("Ana Paula");
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("quartoemail@email.com");
		pessoa4.setIdade(75);
		pessoa4.setNome("Duquesa thedoro");
		
		
		/*Essa lista pode vir do BD ou qualquer fonte de dados, arquivos de texto etc..*/
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		/*Agora vamos precisar usar nossa biblioteca HSSWorkBook que � da Apache Poi*/
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /*Vai ser usado para escrever a planilha*/
		
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento");/*Crian a planilha*/
		
		int numeroLinha = 0; /*Tenho que ter controle por fora controlar a linha, para cada itera��o n�o pode resetar a 
		linha temos que ter esse controle por fora para ir acrescentando linhas*/
		
		for (Pessoa p : pessoas) { /*Fazendo um for Each para cada pessoa a gente vai criar uma linha para cada atributo � uma c�lula*/
			
			Row linha = linhasPessoa.createRow(numeroLinha ++); /*Criando a linha na planilha*/
			
			/*Agora criaremos a c�lula*/
			
			int celula = 0; /*Inciializando variavel de controle c�lula*/
			
			Cell celNome = linha.createCell(celula ++);/*pegamos objeto Cell do apache POI e agora ser� uma c�lula para cada atribnuto, 
			pegando a variavel linha da row(linha) e criando com createCell passando o  incremento para a  variavel de controle celula inicalizada acima*/
			
			celNome.setCellValue(p.getNome());/*Na celula de nome pegamos setCellValue e pegamos objeto pessoa  e passamos getNome e nas demais tb para email e idade*/

			Cell celEmail = linha.createCell(celula ++);/*celula 2*/
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++); /*celula 3*/ 
			celIdade.setCellValue(p.getIdade());
			
		}/*Terminou de montar a planilha*/
		
		/*Agora precisamos fazer uma sa�da FileOutPutStream*/
		
		FileOutputStream saida = new FileOutputStream(file); /*Pegando o arquivo file da linha 16*/
		
		hssfWorkbook.write(saida);/*Agora vamos pegar Workbook e fazer com que ele escreva a planilha em arquivo*/
		
		saida.flush();/*O m�todo flush() serve para garantir o envio do �ltimo lote de bytes enviado para grava��o no arquivo*/
		saida.close();/*o m�todo close() serve para fechar a stream de leitura ou grava��o e ambos servem para economizar mem�ria at� funciona sem mas ideal com eles*/
		
		
		System.out.println("Planilha foi criada");
	}
}
