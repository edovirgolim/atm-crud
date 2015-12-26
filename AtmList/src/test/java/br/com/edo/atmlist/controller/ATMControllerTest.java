/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edo.atmlist.controller;

import br.com.edo.atmlist.config.Config;
import br.com.edo.atmlist.config.SpringMvcInitializer;
import br.com.edo.atmlist.model.ATM;
import br.com.edo.atmlist.model.ATMRequest;
import br.com.edo.atmlist.model.Address;
import br.com.edo.atmlist.model.GeoLocation;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 *
 * @author Edo Virgolim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, SpringMvcInitializer.class})
@WebAppConfiguration
public class ATMControllerTest {

    @Autowired
    public ATMController atmController;
    
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;

    public ATMControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getATMListFromServer method, of class ATMController.
     */
    @Test
    public void testGetATMListFromServer() {
        System.out.println("getATMListFromServer");
        ModelMap model = new ModelMap();
        ATMController instance = new ATMController();
        Object result = instance.getATMListFromServer(model);
        assertNotNull(result);
    }

    /**
     * Test of getATMList method, of class ATMController.
     */
    @Test
    public void testGetATMList() {
        System.out.println("getATMList");
        ModelMap model = new ModelMap();
        ATMController instance = new ATMController();
        Object result = instance.getATMList(model);
        assertNotNull(result);
    }
    
    @Test
    public void callATMList() throws Exception {
        System.out.println("callATMList");
        this.mockMvc
            .perform(get("/atmList")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    /**
     * Test of saveATM method, of class ATMController.
     */
    @Test
    public void testSaveATM() {
        System.out.println("saveATM");
        ATM atm = new ATM();
        Address address = new Address();
        
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setLat("111");
        geoLocation.setLng("222");
        
        address.setGeoLocation(geoLocation);
        address.setCity("333");
        address.setHousenumber("444");
        address.setPostalcode("555");
        address.setStreet("6666");
                
        atm.setAddress(address);
        atm.setDistance(111);
        atm.setType("AAAA");
        
        ATMRequest request = new ATMRequest(atm);
        ATMController instance = new ATMController();
        Object expResult = null;
        Object result = instance.saveATM(request);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of login method, of class ATMController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        ModelMap model = new ModelMap();
        ATMController instance = new ATMController();
        String expResult = "home";
        String result = instance.login(model);
        assertEquals(expResult, result);

    }

    /**
     * Test of home method, of class ATMController.
     */
    @Test
    public void testHome() {
        System.out.println("home");
        ModelMap model = new ModelMap();
        ATMController instance = new ATMController();
        String expResult = "home";
        String result = instance.home(model);
        assertEquals(expResult, result);

    }

    /**
     * Test of logout method, of class ATMController.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        ModelMap model = new ModelMap();
        HttpSession session = new MockHttpSession();
        ATMController instance = new ATMController();
        String expResult = "redirect:login";
        String result = instance.logout(model, session);
        assertEquals(expResult, result);

    }

    /**
     * Test of addATM method, of class ATMController.
     */
    @Test
    public void testAddATM() {
        System.out.println("addATM");
        ModelMap model = new ModelMap();
        ATMController instance = new ATMController();
        String expResult = "atm";
        String result = instance.addATM(model);
        assertEquals(expResult, result);

    }

    /**
     * Test of listAtm method, of class ATMController.
     */
    @Test
    public void testListAtm() {
        System.out.println("listAtm");
        ModelMap model = new ModelMap();
        ATMController instance = new ATMController();
        String result = instance.listAtm(model);
        assertNotNull(result);
    }
}
