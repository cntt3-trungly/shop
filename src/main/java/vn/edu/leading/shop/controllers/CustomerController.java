package vn.edu.leading.shop.controllers;

import antlr.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.services.CustomerService;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customers")
    public String list(Model model){
        model.addAllAttributes("customers",customerService.fineAll());
        return "customers/list";
    }
    @GetMapping("customers/search")
    public String search(@RequestParam("term") String term,Model model){
        if(StringUtils.isEmpty(term)){
            return "redirect:/customers";

        }
        model.addAllAttributes("customers",customerService.search(term));
        return "customer/list";
    }

    @GetMapping("/customers/add")
        public String add(Model model){
        model.addAllAttributes("customerModel",new CustomerModel());
        return "customer/form";
        }

    @GetMapping("/customers/{id}/edit")
    public String edit(@PathVariable("id") Long id,Model model){
        model.addAllAttributes("customerModel",customerService.findById(id));
        return "customer/form";
    }

    @GetMapping("/customer/save")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        if(customerService.delete(id)){
            redirect.addFlashAttribute("successMessage","Deleted cuntomer seccessfully!");
            return "redirect:/customers";
        } else{
            redirect.addFlashAttribute("successMessage","Not found!!");
            return "redirect:/customers"
        }

    }
}
