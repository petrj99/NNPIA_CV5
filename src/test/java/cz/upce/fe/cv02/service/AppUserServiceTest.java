package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.domain.AppUser;
import cz.upce.fe.cv02.repository.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private AppUserService appUserService;

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

        when(appUserRepository.findById(100L)).thenReturn(Optional.of(expectedUser));

        AppUser result = appUserService.findById(100L);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(expectedUser.getId());
        assertThat(result.getUsername()).isEqualTo(expectedUser.getUsername());
    }

    @Test
    public void findById_shouldThrowResourceNotFoundException_whenUserNotFound() {
        when(appUserRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appUserService.findById(100L);
        });
    }
}