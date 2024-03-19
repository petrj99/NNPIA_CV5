package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.domain.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import(AppUserService.class)
public class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setup() {
        entityManager.getEntityManager().createQuery("DELETE FROM AppUser").executeUpdate();
    }

    //Pokud bychom používali JUnit 4 dalo by se použít @Test(expected = SomeException.class)
    @Test
    public void findById_shouldReturnUser_whenUserExists() throws ResourceNotFoundException {
        AppUser expectedUser = new AppUser(
                100L,
                "username",
                "password",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        entityManager.persist(expectedUser);
        entityManager.flush();

        AppUser result = appUserService.findById(100L);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(expectedUser.getId());
        assertThat(result.getUsername()).isEqualTo(expectedUser.getUsername());
    }

    @Test
    public void findById_shouldThrowResourceNotFoundException_whenUserNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            appUserService.findById(100L);
        });
    }
}