package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Message;
import com.firstdeskleft.entities.User;
import com.firstdeskleft.service.MessageService;
import com.firstdeskleft.service.UserService;
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
    @Autowired
    UserService uservice;

    @GetMapping("/send")
    public String showMessageForm(Model model, @RequestParam("gid") Integer targetId, @ModelAttribute("user") User user) {

        Integer sourceId = user.getId();

        Message message = new Message(sourceId, targetId);

        model.addAttribute("message", message);

        return "messageForm";
    }

    @PostMapping("/send")
    public String showPostMessageForm(@ModelAttribute("message") Message message, Model model) {
//        String SourceUsername=  uservice.   message.getSourceId()
        service.addMessage(message);

        User user = (User) model.getAttribute("user");

        if (user instanceof Customer) {

            return "HomeCustomer";

        } else if (user instanceof Guide) {

            return "HomeGuide";

        } else if (user instanceof User) {

            return "HomeAdmin";

        } else {

            return "access-denied";

        }
    }

    @GetMapping("/inbox")
    public String showMessage(Model model, @ModelAttribute("user") User user) {

        List<Message> list = service.findByTargetId(user.getId());

        model.addAttribute("listOfMessages", list);

        return "inbox";
    }

}
