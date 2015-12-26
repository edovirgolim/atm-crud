/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edo.atmlist.controller;

import br.com.edo.atmlist.model.ATM;
import br.com.edo.atmlist.model.ATMRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.annotation.Secured;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Edo Virgolim
 */
@Controller
public class ATMController {

    List<ATM> atmList = new ArrayList<ATM>();
    List<ATM> atmServerList = new ArrayList<ATM>();

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("greeting", "ING ATM");
        return "home";
    }
    
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("greeting", "ING ATM");
        return "home";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map, HttpSession session) {
        session.invalidate();
	return "redirect:login";
    }

    @RequestMapping(value = "/atm", method = RequestMethod.GET)
    public String addATM(ModelMap map) {
        map.put("greeting", "ING ATM Add");
        return "atm";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public String listAtm(ModelMap map) {
        return "list";
    }

    @Secured("authenticated")
    @RequestMapping(value = "/atmList", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Object getATMListFromServer(ModelMap map) {
        map.put("greeting", "ING ATM List");
        
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext();
            System.out.println("----");
            Resource resource = appContext.getResource("url:https://www.ing.nl/api/locator/atms/");

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            // Skip first line
            inputStr = streamReader.readLine();
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            ObjectMapper mapper = new ObjectMapper();
            atmServerList = mapper.readValue(responseStrBuilder.toString(), List.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atmServerList;
    }

    @Secured("authenticated")
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Object getATMList(ModelMap map) {
        map.put("greeting", "ING ATM List");
        return atmList;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object saveATM(@RequestBody ATMRequest request) {
        atmList.add(request.getAtmObj());
        Map msgMap = new HashMap();
        msgMap.put("msg", "ATM Stored successfully");
        return msgMap;
    }
}
