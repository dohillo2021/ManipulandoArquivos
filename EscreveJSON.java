package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("5495889898");
		usuario1.setLogin("Joao");
		usuario1.setSenha("5655655");
		usuario1.setNome("William Machado");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("878979797");
		usuario2.setLogin("Enrico");
		usuario2.setSenha("565asdadasd5a6asd");
		usuario2.setNome("Enrico Fernandes");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\filejson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		
		/*---------------************************Lendo o arquivo Json ******************---------------*/
		
		
		FileReader fileReader = new FileReader("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\filejson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listaUsuarios.add(usuario);
		}
		System.out.println("Leitura do arquivo JSON: " + listaUsuarios);
	}

}
