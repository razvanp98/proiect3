package com.razvan.papurica.proiect3.controller;

import com.razvan.papurica.proiect3.entity.Medicament;
import com.razvan.papurica.proiect3.service.MedicamentService;
import com.razvan.papurica.proiect3.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/medicament")
public class MedicamentController {

    @Autowired
    @Qualifier("medicamentService")
    private MedicamentService medicamentService;

    @Autowired
    @Qualifier("pacientService")
    private PacientService pacientService;

    // Mappings

    @RequestMapping
    public ModelAndView showMedicamente(ModelAndView model) {
        Set<Medicament> medicamente = medicamentService.getMedicamente();

        model.addObject("medicamente", medicamente);
        model.setViewName("medicament/medicament-home");

        return model;
    }

    @GetMapping("ShowMedicamentAdd")
    public ModelAndView showMedicamentAdd(ModelAndView model) {
        Medicament medicament = (Medicament) medicamentService.addMedicamentGet();
        model.addObject("addMedicament", medicament);
        model.setViewName("medicament/medicament-create");

        return model;
    }

    @PostMapping("ProcessMedicamentAdd")
    public String processMedicamentAdd(@ModelAttribute("addMedicament") Medicament medicament) {
        medicamentService.addMedicamentDo(medicament);
        return "redirect:/medicament";
    }

    // Update mappings

    @GetMapping("ShowMedicamentUpdate")
    public ModelAndView updateMedicament(@RequestParam("medicamentId") int medicamentId, ModelAndView model) {

        model.addObject("updateMedicament", medicamentService.getMedicamentUpdate(medicamentId));
        model.setViewName("medicament/medicament-update");

        return model;
    }

    @PostMapping("ProcessMedicamentUpdate")
    public String processUpdateMedicament(@ModelAttribute("updateMedicament") Medicament medicament) {
        medicamentService.processMedicamentUpdate(medicament);

        return "redirect:/medicament";
    }

    // Delete mappings

    @GetMapping("DeleteMedicament")
    public String deleteMedicament(@RequestParam("medicamentId") int medicamentId) {
        medicamentService.deleteMedicament(medicamentId);
        return "redirect:/medicament";
    }
}
