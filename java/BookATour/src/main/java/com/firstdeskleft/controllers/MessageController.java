package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Message;
import com.firstdeskleft.entities.User;
import com.firstdeskleft.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/message")
@SessionAttributes(names = {"user", "message"})
public class MessageController {

    @Autowired
    MessageService service;

    @GetMapping("/send")
    public String showMessageForm(Model model, @RequestParam("gid") Integer targetId, @ModelAttribute("user") User user) {

        System.out.println("1. Inside MessageController.showMessageForm");
        
        Integer sourceId = user.getId();

        System.out.println("2. sourceId: " + sourceId);

        Message message = new Message(sourceId, targetId);

        System.out.println("3. Message is: " + message);

        model.addAttribute("message", message);

        System.out.println("4. Model.getAttribute('message'): " + model.getAttribute("message"));

        return "messageForm";
    }

    @PostMapping("/send")
    public String showPostMessageForm(@ModelAttribute("message") Message message, Model model) {

        System.out.println("5. Inside MessageController.showPostMessageForm, message: " + message);

        service.addMessage(message);

        System.out.println("10. Inside MessageController.showPostMessageForm. After addMessage");

        User user = (User) model.getAttribute("user");

        System.out.println("11. Printing ModelAttribute('user'): " + user);

        if (user instanceof Customer) {

            System.out.println("12. Returning to Customer Home Page");
            return "HomeCustomer";

        } else if (user instanceof Guide) {

            System.out.println("12. Returning to Guide Home Page");
            return "HomeGuide";

        } else if (user instanceof User) {

            System.out.println("12. Returning to Admin Home Page");
            return "HomeAdmin";

        } else {

            System.out.println("12. Error in modelAtribute('user'). Returning to Access denied page");
            return "access-denied";

        }
    }

    @GetMapping("/inbox")
    public String showMessage(Model model, @ModelAttribute("user") User user) {
        
        List<Message> list = service.findByTargetId(user.getId());
        
        model.addAttribute("listOfMessages",list);        
        
        return "inbox";
    }

}
