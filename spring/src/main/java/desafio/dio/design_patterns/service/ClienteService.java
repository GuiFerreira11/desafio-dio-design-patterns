package desafio.dio.design_patterns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.dio.design_patterns.model.Cliente;
import desafio.dio.design_patterns.model.Endereco;
import desafio.dio.design_patterns.repository.ClienteRepository;
import desafio.dio.design_patterns.repository.EnderecoRepository;

@Service
public class ClienteService implements IClienteService {

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  EnderecoRepository enderecoRepository;

  @Autowired
  ViaCepService viaCepService;


	@Override
	public Iterable<Cliente> buscarTodos() {
    return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
    Optional<Cliente> cliente = clienteRepository.findById(id);
    return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
    salvarClienteECep(cliente);
	}


	@Override
	public void atualizar(Long id, Cliente cliente) {
    Optional<Cliente> clienteDb = clienteRepository.findById(id);
    if(clienteDb.isPresent()){
      salvarClienteECep(cliente);
    }
	}

	@Override
	public void deletar(Long id) {
    clienteRepository.deleteById(id);
	}
  
  private void salvarClienteECep(Cliente cliente){
    String cep = cliente.getEndereco().getCep();
    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
      Endereco novoEndereco = viaCepService.consultarCep(cep);
      enderecoRepository.save(novoEndereco);
      return novoEndereco;
    });
    cliente.setEndereco(endereco);
    clienteRepository.save(cliente);
  }
}
