package cz.upce.fe.cv02.controller;

import cz.upce.fe.cv02.dto.AppUserResponseDtoV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AppUserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findById_shouldReturnUser_whenUserExists() {
        Long existingUserId = 1L;
        ResponseEntity<AppUserResponseDtoV1> response = restTemplate.getForEntity("http://localhost:" + port + "/app-user/{id}", AppUserResponseDtoV1.class, existingUserId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void findById_shouldReturnNotFound_whenUserDoesNotExist() {
        Long nonExistingUserId = 2L;
        ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:" + port + "/app-user/{id}", Object.class, nonExistingUserId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
