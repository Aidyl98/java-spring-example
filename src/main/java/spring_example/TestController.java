/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example;

import spring_example.Domains.NewArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aidyl
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private AreaRepo areaRepo;

    @GetMapping("/hi")
    public String hi() {
        return "HI";
    }

    @PostMapping("/create")
    public String create(@RequestBody NewArea area) {
        Area areaFinal = new Area(area.name(), area.desc());
        areaRepo.save(areaFinal);
        System.out.println(area.name());
        return area.name();
    }

    @GetMapping("/find_all")
    public Iterable<Area> findAll() {
        return areaRepo.findAll();
    }
}
