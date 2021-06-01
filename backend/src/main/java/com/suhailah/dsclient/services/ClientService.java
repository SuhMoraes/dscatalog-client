package com.suhailah.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suhailah.dsclient.dto.ClientDTO;
import com.suhailah.dsclient.entities.Client;
import com.suhailah.dsclient.repositories.ClientRepository;
import com.suhailah.dsclient.services.exceptions.ResourceNotFoundExceptions;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ClientDTO(entity);
		
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {  //Método para atualizar um recurso
		Client entity = new Client(); // Atualiza os dados
		entity.setName(dto.getName()); // setName = Definir o nome // getName = Obter o nome
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity = repository.save(entity);
		return new ClientDTO(entity);		 
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			entity.setName(dto.getName()); // setName = Definir o nome // getName = Obter o nome
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity = repository.save(entity);
			return new ClientDTO(entity);		
		} 
	   catch(EntityNotFoundException e) {
		 throw new ResourceNotFoundExceptions("Id Not Found " + id);
	   }
	}
}
