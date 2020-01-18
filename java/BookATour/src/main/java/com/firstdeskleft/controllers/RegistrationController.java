
package com.firstdeskleft.controllers;




import com.firstdeskleft.entities.Certificate;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.service.CertificateService;
import com.firstdeskleft.service.CustomerService;
import com.firstdeskleft.service.GuideService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    @Autowired
    CustomerService customerService;
    @Autowired
    GuideService guideService;
    

    
    @GetMapping("/customer")
    public String showCustomerRegistrationForm(Model m){
        
        m.addAttribute("customer", new Customer());
       
        return "CustomerRegister";
    }
    
    @GetMapping("/guide")
    public String ShowGuideRegistrationForm(Model m){
        m.addAttribute("guide",new Guide());
        return "GuideRegister";
    }
    
  
    
    @PostMapping("/customer")
    public String processCustomerRegistration(@Valid @ModelAttribute("customer") Customer customer,
          
            BindingResult result,Model m){
        
        System.out.println("------------------------POST REGISTRATION CUSTOMER"+customer);
        
        if(result.hasErrors()){
            
            return "CustomerRegister";
        }
        Customer existing = customerService.findByUsername(customer.getUsername());
        if(existing !=null){
            m.addAttribute("customer",new Customer());
            m.addAttribute("customerExistsError","Username already exists");
            return "CustomerRegister";
        }
        customerService.save(customer);
        
        return "Login";
    }
    @PostMapping("/guide")
    public String processGuideRegistration(@Valid @ModelAttribute("guide") Guide guide,
            BindingResult result,Model m){
        
        if(result.hasErrors()){
            
            return "GuideRegister";
        }
        Guide existing = guideService.findByUsername(guide.getUsername());
        if(existing !=null){
            m.addAttribute("guide",new Guide());
            m.addAttribute("guideExistsError","Username already exists");
            return "GuideRegister";
        }
        
        guideService.save(guide);
        
        return "Login";
    }
    

    
    
}
