package com.eshopper.commongateway.controller;

import com.eshopper.commongateway.dto.UserDTO;
import com.eshopper.commongateway.exception.CustomerServiceException;
import com.eshopper.commongateway.repository.CommonGatewayRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(CommonGatewayController.class)
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class})
public class CommonGatewayControllerTests {
    @MockBean
    CommonGatewayRepository commonGatewayRepository;

    @InjectMocks
    CommonGatewayControllerTests commonGatewayControllerTests;

    @Autowired
    MockMvc mockMvc;

    public UserDTO getUserDTOTestData1()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();

        UserDTO user1 = new UserDTO();
        user1.setId(1);
        user1.setActive(true);
        user1.setAddress1("AA");
        user1.setAddress2("BB");
        user1.setBirthdate(new Date());
        user1.setCountry("AA");
        user1.setEmail("AA@gmail.com");
        user1.setLastName("AA");
        user1.setMiddleName("AA");
        user1.setPassword("AA");
        user1.setPhone1(12);
        user1.setCity("AA");
        user1.setPhone2(23);
        user1.setFirstName("AA");
        user1.setPostalCode(1234);
        user1.setRegistrationDate(new Date());
        user1.setRoleId(1);
        user1.setState("AA");
        user1.setRoleId(1);
        return user1;

    }

    public UserDTO getUserDTOTestData2()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();

        UserDTO user2 = new UserDTO();
        user2.setId(2);
        user2.setActive(true);
        user2.setAddress1("BB");
        user2.setAddress2("BB");
        user2.setBirthdate(new Date());
        user2.setCity("BB");
        user2.setCountry("BB");
        user2.setEmail("BB@gmail.com");
        user2.setFirstName("BB");
        user2.setLastName("BB");
        user2.setMiddleName("BB");
        user2.setPassword("AA");
        user2.setPhone1(12);
        user2.setPhone2(23);
        user2.setPostalCode(1234);
        user2.setRegistrationDate(new Date());
        user2.setRoleId(1);
        user2.setState("BB");
        user2.setRoleId(1);

        return user2;

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldRegisterCustomer() throws Exception {
        UserDTO user = getUserDTOTestData1();

        when(commonGatewayRepository.registerCustomer(user)).thenReturn(user);

        System.out.println("size ==>"+user.toString());
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/gateway/customer/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void shouldGetCustomerDetails() throws Exception {
        UserDTO user = getUserDTOTestData1();

        Optional<UserDTO> tempUser = Optional.empty();
        given(commonGatewayRepository.getCustomerDetails(100)).willReturn(tempUser);
        mockMvc.perform(get("/customer/{customerId}/personalDetails", user.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName").value("AA"))
                .andExpect(jsonPath("id").value(1))
                .andDo(MockMvcResultHandlers.print());
        verify(commonGatewayRepository, times(1)).getCustomerDetails(100);
        verifyNoMoreInteractions(commonGatewayRepository);

    }
}
