package cz.upce.fe.cv02.controller;

import cz.upce.fe.cv02.domain.AppUser;
import cz.upce.fe.cv02.dto.AppUserResponseDtoV1;
import cz.upce.fe.cv02.service.AppUserService;
import cz.upce.fe.cv02.service.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AppUserController.class)
public class AppUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    @Test
    public void findById_shouldReturnUser_whenUserExists() throws Exception {
        Long existingUserId = 1L;
        AppUserResponseDtoV1 responseDto = new AppUserResponseDtoV1();

        given(appUserService.findById(existingUserId)).willReturn(new AppUser()); // Nastavte AppUser podle vaší implementace
        given(new AppUser().toDto()).willReturn(responseDto);

        mockMvc.perform(get("/app-user/{id}", existingUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        ;
    }

    @Test
    public void findById_shouldReturnNotFound_whenUserDoesNotExist() throws Exception {
        Long nonExistingUserId = 2L;
        given(appUserService.findById(nonExistingUserId)).willThrow(new ResourceNotFoundException());

        mockMvc.perform(get("/app-user/{id}", nonExistingUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
