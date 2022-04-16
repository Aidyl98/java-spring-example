/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example;

import spring_example.repo.AreaRepo;
import spring_example.entitys.Area;
import spring_example.entitys.Domains.NewArea;
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
@RestController  // Allows the class to access the http petitions.
@RequestMapping(value = "/test")  // The url before all the methods defined in this class.
public class TestController {

    @Autowired // Injects the dependencies.
    private AreaRepo areaRepo;

    @GetMapping("/hi") // Return HI when the url is test(as in the init of the class)/hi.
    public String hi() {
        return "HI";
    }

    @PostMapping("/create") // Creates an Area when url test/create
    public String create(@RequestBody NewArea area) {
        // Convert the data  enter by the user the NewArea in this case to the Area Entity form the DB.
        Area areaFinal = new Area(area.name(), area.desc());
        // The Area is savedd in the DB.
        areaRepo.save(areaFinal);
        return area.name();
    }

    @GetMapping("/find_all")  // Finds all the Areas when url test/find_all
    public Iterable<Area> findAll() {
        // The interface AreaRepo have internally all the crud methods.
        return areaRepo.findAll();
    }
}
