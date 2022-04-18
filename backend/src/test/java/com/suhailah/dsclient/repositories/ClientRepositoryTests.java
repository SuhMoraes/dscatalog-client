package com.suhailah.dsclient.repositories;

import com.suhailah.dsclient.entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ClientRepositoryTests {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        long existindId = 1L;

        clientRepository.deleteById(existindId);

        Optional<Client> result = clientRepository.findById(existindId);

        Assertions.assertFalse(result.isPresent());

    }
}
