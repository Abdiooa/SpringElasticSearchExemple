package com.aoo.withelasticsearch.controllers;

import com.aoo.withelasticsearch.models.Invoice;
import com.aoo.withelasticsearch.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class InvoiceUiController {
    private final InvoiceRepository repository;
    @GetMapping("/")
    public String viewHomePage(Model model){
        return "home";
    }
    @GetMapping("/listInvoice")
    public String viewListInvoicePage(Model model) throws IOException {
        model.addAttribute("listInvoiceDocuments",repository.getAllInvoices());
        return "listInvoice";
    }
    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) throws IOException{
        repository.createOrUpdateInvoice(invoice);
        return "redirect:/listInvoice";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) throws IOException {
        Invoice invoice = repository.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "updateInvoice";
    }
    @GetMapping("/showNewInvoiceForm")
    public String showNewInvoiceForm(Model model) {
        // creating model attribute to bind form data
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "addInvoice";
    }
    
}
