package pl.project.promanage.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.project.promanage.team.Team;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }

    @GetMapping("/companies/{id}/teams")
    public List<Team> getTeams(@PathVariable Long id){
        return companyService.getTeams(id);
    }

    @PutMapping("/companies/{id}")
    public void updateCompany(@RequestBody Company company, @PathVariable Long id){
        companyService.updateCompany(company);
    }

    @PostMapping("/companies")
    public void createCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }


}
