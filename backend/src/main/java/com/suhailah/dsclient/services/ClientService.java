package com.suhailah.dsclient.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public ClientDTO findById(long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable){
		Page<Client> list = repository.findAll(pageable);
		return list.map(x -> new ClientDTO(x));
		
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
	
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);			
		}
		catch (EmptyResultDataAccessException e) {
			 throw new ResourceNotFoundExceptions("Id Not Found " + id);
		}
	}


	
}
