package br.com.mv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.model.Prato;
import br.com.mv.repository.PratoRepository;




@RestController
public class Controller {
	
	@Autowired//injeção de depedencias
	private PratoRepository pr;

	@GetMapping(value = "listaTodos")
	@ResponseBody() //RETONAR OS DADOS PARA O CORPO DA RESPOSTAS 
	public ResponseEntity<List<Prato>> listaPratos(){
		
		List<Prato> pratos =  pr.listaPratos(); //EXECUT A CONSULTA NO BANCO DE DADOS
		
		return new ResponseEntity<List<Prato>>(pratos, HttpStatus.OK); // RETORNA A LISTA EM JSON
		
	}
	
	@PostMapping(value = "salvar")//mapeia a url
	@ResponseBody//descrição da resposta
	public ResponseEntity<Prato> salvar(@RequestBody Prato prato){//recebe os dados para salvar
		
	Prato prat = pr.save(prato);
	
	return new ResponseEntity<Prato>(prat, HttpStatus.CREATED);
		
	}
	
	
	
	@PutMapping(value = "atualizar")//mapeia a url
	@ResponseBody//descrição da resposta
	public ResponseEntity<?> atualizar(@RequestBody Prato prato){//recebe os dados para salvar
		
		if(prato.getId() == null) {
			return new ResponseEntity<String>("ID não informado para a atualização", HttpStatus.OK);
		}
		
		
	Prato prat = pr.saveAndFlush(prato);
	
	return new ResponseEntity<Prato>(prat, HttpStatus.OK);
		
	}
	
	
	
	
	@DeleteMapping(value = "delete")//mapeia a url
	@ResponseBody//descrição da resposta
	public ResponseEntity<String> delete(@RequestParam (name = "iduser") Long iduser){//recebe id para deletar
		
	 pr.deleteById(iduser);
	
	return new ResponseEntity<String>("Prato deletado com sucesso!", HttpStatus.OK);
		
	}
	
	@GetMapping(value = "buscarId")//mapeia a url
	@ResponseBody//descrição da resposta
	public ResponseEntity<Prato> buscarpratoid(@RequestParam(name = "iduser") Long iduser){//recebe id para consultar
		
	Prato prato = pr.findById(iduser).get();
	
	return new ResponseEntity<Prato>(prato, HttpStatus.OK);
		
	}
	
	
}
