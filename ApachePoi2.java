package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	public static void main(String[] args) throws Exception{
	
		FileInputStream entrada = new FileInputStream( /*Lendo um arquivo do excel*/
				new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo_excel.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo excel para ler*/
		
		HSSFSheet planilha =  hssfWorkbook.getSheetAt(0);/*pega a primeira planilha do nosso arquivo excel*/
		
		Iterator<Row> linhaIterator = planilha.iterator(); /*daqui pra baixo estamos populando todos os dados dele em uma lista de pessoas*/
		
		
		List<Pessoa>  pessoas = new ArrayList<Pessoa>();/*Instanciando uma lista de pessoas*/
		
		while (linhaIterator.hasNext()) { /*Enquanto tiver linha no arquivo excel ele vai entrar e pegar a linha*/
			
			Row linha = linhaIterator.next(); /*Dados de pessoa na linha*/
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celulas.hasNext()) { /*Percorrer as celulas*/
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}
			}/*Fim das celulas da linha*/
			
			pessoas.add(pessoa); /*adiconando na lista de pessoas*/
		}
		
		entrada.close();/*Terminou de ler o arquivo excel*/
		
		for (Pessoa pessoa : pessoas) {/*Para cada pessoa imprima suas respectivas linhas e celulas*/
			System.out.println(pessoa);
		}/*E com esa lista em mãos você poderia gravas no bd, mandar email etc.. */
	}	
}
