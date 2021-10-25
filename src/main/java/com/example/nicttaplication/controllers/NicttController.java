package com.example.nicttaplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class NicttController {

    @GetMapping()
    public String nicttPage(Model model) throws SQLException {

        return "index";

    }
}
