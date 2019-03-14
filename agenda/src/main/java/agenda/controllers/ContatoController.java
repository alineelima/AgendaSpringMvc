package agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import agenda.dao.ContatoDAO;
import agenda.models.Contato;


@Controller
//@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired //injeta o contatoDao, através do spring
	private ContatoDAO contatoDao;
	
	@RequestMapping("/cadastroContato")
	public ModelAndView form() {
		System.out.println("entrou no form (Contatos Controller)");
		ModelAndView modelAndView = new ModelAndView("/contatos/cadastroContato");
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Contato contato) {
		System.out.println(contato);
		contatoDao.gravar(contato);
		ModelAndView modelAndView = new ModelAndView("redirect:/contatos");
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Contato> contatos = contatoDao.listar();
		ModelAndView modelAndView = new ModelAndView("/contatos/lista");
		modelAndView.addObject("contatos", contatos);
		System.out.println(contatos);
		
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/contatos");
		contatoDao.deletar(id);
		return modelAndView;
	}
	
	/*@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id){
	    ModelAndView modelAndView = new ModelAndView("/detalhe");
	    Contato contato = contatoDao.find(id);
	    modelAndView.addObject("contato", contato);
	    return modelAndView;
	}*/

}
