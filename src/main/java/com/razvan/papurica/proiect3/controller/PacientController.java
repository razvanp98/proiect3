package com.razvan.papurica.proiect3.controller;

import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Medicament;
import com.razvan.papurica.proiect3.entity.Pacient;
import com.razvan.papurica.proiect3.service.MedicService;
import com.razvan.papurica.proiect3.service.MedicamentService;
import com.razvan.papurica.proiect3.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    @Qualifier("medicService")
    private MedicService medicService;

    @Autowired
    @Qualifier("pacientService")
    private PacientService pacientService;

    @Autowired
    @Qualifier("medicamentService")
    private MedicamentService medicamentService;


    // View mappings

    @RequestMapping
    public ModelAndView showHome(ModelAndView model) {

        Set<Pacient> pacienti = pacientService.getPacienti();

        model.addObject("pacienti", pacienti);
        model.setViewName("pacient/pacient-home");

        return model;
    }

    @GetMapping("ViewMediciFromPacient")
    public ModelAndView showMediciFromPacient(@RequestParam("pacientId") int pacientId, ModelAndView model) {

        Pacient targetPacient = pacientService.getPacienti().stream()
                .filter(pacient -> pacientId == pacient.getId())
                .findAny()
                .orElse(null);

        model.addObject("mediciFromPacient", targetPacient.getMedici());
        model.addObject("targetPacient", targetPacient);
        model.setViewName("pacient/pacient-medic-view");

        return model;
    }

    // Add mappings

    @GetMapping("ShowPacientAdd")
    public ModelAndView showMedicAdd(ModelAndView model) {

        Pacient pacient = (Pacient) pacientService.addPacientGet();
        model.addObject("addPacient", pacient);
        model.setViewName("pacient/pacient-create");

        return model;
    }

    @PostMapping("ProcessPacientAdd")
    public String processPacientAdd(@ModelAttribute("addPacient") Pacient pacient) {

        pacientService.addPacientDo(pacient);
        return "redirect:PacientLinkMedic?pacientId=" + pacient.getId();
    }

    // Link Medic to Pacient mappings

    @GetMapping("PacientLinkMedic")
    public ModelAndView linkMedicToPacient(@RequestParam("pacientId") int pacientId, ModelAndView model) {

        Set<Medic> medici = medicService.getMedics();
        Pacient targetPacient = (Pacient) pacientService.getPacientUpdate(pacientId);

        model.addObject("medici", medici);
        model.addObject("targetPacient", targetPacient);
        model.setViewName("pacient/pacient-link-medic");

        return model;
    }

    @GetMapping("ProcessMedicLinkPacient")
    public String processLinkMedicToPacient(@RequestParam("medicId") int medicId,
                                            @RequestParam("pacientId") int pacientId) {

        Pacient targetPacient = (Pacient) pacientService.getPacientUpdate(pacientId);
        Medic medic = (Medic) medicService.getMedicUpdate(medicId);

        pacientService.linkMedic(medic, targetPacient);

        return "redirect:PacientLinkMedic?pacientId=" + pacientId;
    }

    // Unlinks the Medic from Pacient

    @GetMapping("UnlinkMedic")
    public String unlinkPacientFromMedic(@RequestParam("medicId") int medicId,
                                         @RequestParam("pacientId") int pacientId) {

        Medic medic = (Medic) medicService.getMedicUpdate(medicId);
        Pacient pacient = (Pacient) pacientService.getPacientUpdate(pacientId);

        pacientService.unlinkMedic(medic, pacient);

        return "redirect:ViewMediciFromPacient?pacientId=" + pacientId;
    }

    // Get view for Medicament available

    @GetMapping("ViewMedicamenteFromPacient")
    public ModelAndView linkMedicamentToPacient(@RequestParam("pacientId") int pacientId, ModelAndView model) {
        Pacient targetPacient = (Pacient) pacientService.getPacientUpdate(pacientId);
        Set<Medicament> medicamente = medicamentService.getMedicamente();

        model.addObject("targetPacient", targetPacient);
        model.addObject("medicamente", medicamente);
        model.setViewName("pacient/pacient-link-medicament");

        return model;
    }

    // Captures POST request to link Medicament to Pacient

    @GetMapping("ProcessMedicamentLinkPacient")
    public String processMedicamentLinkPacient(@RequestParam("pacientId") int pacientId,
                                               @RequestParam("medicamentId") int medicamentId) {

        Pacient pacient = (Pacient) pacientService.getPacientUpdate(pacientId);
        Medicament medicament = (Medicament) medicamentService.getMedicamentUpdate(medicamentId);

        pacientService.linkMedicament(medicament, pacient);

        return "redirect:ViewMedicamenteFromPacient?pacientId=" + pacientId;
    }

    // Remove Medicament link from Pacient

    @GetMapping("UnlinkMedicament")
    public String unlinkMedicamentFromPacient(@RequestParam("pacientId") int pacientId,
                                              @RequestParam("medicamentId") int medicamentId) {

        Pacient pacient = (Pacient) pacientService.getPacientUpdate(pacientId);
        Medicament medicament = (Medicament) medicamentService.getMedicamentUpdate(medicamentId);

        pacientService.unlinkMedicament(medicament, pacient);

        return "redirect:ViewMedicamenteFromPacient?pacientId=" + pacientId;
    }

    // Update mappings


    // Shows update page and sends entity.Pacient

    @GetMapping("ShowPacientUpdate")
    public ModelAndView updateMedic(@RequestParam("pacientId") int pacientId, ModelAndView model) {

        model.addObject("updatePacient", pacientService.getPacientUpdate(pacientId));
        model.setViewName("pacient/pacient-update");

        return model;
    }

    // Captures POST request and updates the database

    @PostMapping("ProcessPacientUpdate")
    public String processUpdatePacient(@ModelAttribute("updatePacient") Pacient pacient) {

        pacientService.processPacientUpdate(pacient);
        return "redirect:/pacient";
    }

    // Delete mapping

    @GetMapping("DeletePacient")
    public String deletePacient(@RequestParam("pacientId") int pacientId) {
        pacientService.deletePacient(pacientId);
        return "redirect:/pacient";
    }
}
