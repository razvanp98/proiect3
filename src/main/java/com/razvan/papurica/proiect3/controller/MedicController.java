package com.razvan.papurica.proiect3.controller;

import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Pacient;
import com.razvan.papurica.proiect3.service.MedicService;
import com.razvan.papurica.proiect3.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class MedicController {

    @Autowired
    @Qualifier("medicService")
    private MedicService medicService;

    @Autowired
    @Qualifier("pacientService")
    private PacientService pacientService;


    // View mappings

    @GetMapping("/medic")
    public ModelAndView showHome(ModelAndView model) {

        Set<Medic> medici = medicService.getMedics();

        model.addObject("medici", medici);
        model.setViewName("medic/medic-home");

        return model;
    }

    @GetMapping("/ViewPacientiFromMedic")
    public ModelAndView showPacientiFromMedic(@RequestParam("medicId") int medicId, ModelAndView model) {

        Medic targetMedic = medicService.getMedics().stream()
                .filter(medic -> medicId == medic.getId())
                .findAny()
                .orElse(null);

        model.addObject("pacientiFromMedic", targetMedic.getPacienti());
        model.addObject("targetMedic", targetMedic);
        model.setViewName("medic/medic-pacient-view");

        return model;
    }

    // Add mappings

    @GetMapping("/ShowMedicAdd")
    public ModelAndView showMedicAdd(ModelAndView model) {

        Medic medic = (Medic) medicService.addMedicGet();
        model.addObject("addMedic", medic);
        model.setViewName("medic/medic-create");

        return model;
    }

    @PostMapping("/ProcessMedicAdd")
    public String processMedicAdd(@Validated @ModelAttribute("addMedic") Medic medic) {

        medicService.addMedicDo(medic);
        return "redirect:/MedicLinkPacient?medicId=" + medic.getId();
    }

    // Link Pacient to Medic mappings

    @GetMapping("/MedicLinkPacient")
    public ModelAndView linkPacientToMedic(@RequestParam("medicId") int medicId, ModelAndView model) {

        Set<Pacient> pacienti = pacientService.getPacienti();
        Medic targetMedic = (Medic) medicService.getMedicUpdate(medicId);

        model.addObject("pacienti", pacienti);
        model.addObject("targetMedic", targetMedic);
        model.setViewName("medic/medic-link-pacient");

        return model;
    }

    @GetMapping("/ProcessMedicLinkPacient")
    public String processLinkPacientToMedic(@RequestParam("medicId") int medicId,
                                            @RequestParam("pacientId") int pacientId) {

        Medic targetMedic = (Medic) medicService.getMedicUpdate(medicId);
        Pacient pacient = (Pacient) pacientService.getPacientUpdate(pacientId);

        medicService.linkPacient(targetMedic, pacient);

        return "redirect:/MedicLinkPacient?medicId=" + medicId;
    }

    @GetMapping("/UnlinkPacient")
    public String unlinkPacientFromMedic(@RequestParam("medicId") int medicId,
                                         @RequestParam("pacientId") int pacientId) {

        Medic medic = (Medic) medicService.getMedicUpdate(medicId);
        Pacient pacient = (Pacient) pacientService.getPacientUpdate(pacientId);

        medicService.unlinkPacient(medic, pacient);

        return "redirect:/ViewPacientiFromMedic?medicId=" + medicId;
    }

    // Update mappings

    @GetMapping("/ShowMedicUpdate")
    public ModelAndView updateMedic(@RequestParam("medicId") int medicId, ModelAndView model) {

        model.addObject("updateMedic", medicService.getMedicUpdate(medicId));
        model.setViewName("medic/medic-update");

        return model;
    }

    @PostMapping("/ProcessMedicUpdate")
    public String processUpdateMedic(@Validated @ModelAttribute("updateMedic") Medic medic) {

        medicService.processMedicUpdate(medic);
        return "redirect:/";
    }

    // Delete mapping

    @GetMapping("/DeleteMedic")
    public String deleteMedic(@RequestParam("medicId") int medicId) {
        medicService.deleteMedic(medicId);
        return "redirect:/";
    }
}
