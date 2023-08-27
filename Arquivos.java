package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {
		
		
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
		
		
		/*Essa lista pode vir do BD ou qualquer fonte de dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		File arquivo = new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}
}
