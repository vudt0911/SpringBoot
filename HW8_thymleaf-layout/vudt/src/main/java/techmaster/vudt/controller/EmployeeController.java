package techmaster.vudt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import techmaster.vudt.model.Employee;
import techmaster.vudt.repository.EmployeeDao;
import techmaster.vudt.request.DeleteRequest;
import techmaster.vudt.request.SearchRequest;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value = {"/", ""})
    public String listAll(Model model){
        model.addAttribute("employees", employeeDao.getAll());
        return "allEmployee";
    }

    @GetMapping(value = {"/{id}"})
    public String getById(@PathVariable("id") int id, Model model){
        Optional<Employee> employee = employeeDao.get(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        }
        return "employee";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/save") // Hứng POST request gọi đến /book/save
    public String save(Employee employee, BindingResult result){
        if (result.hasErrors()) {
            return "form";
        }
        if (employee.getId() > 0) { //Nếu có trường id có nghĩa là đây là edit form
            employeeDao.update(employee);
          } else { //Nếu id ==0 có nghĩa employee lần đầu được add new
            employeeDao.add(employee);
          }
             
        return "redirect:/employee"; // Chuyển về đường dẫn /employee
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeById(@PathVariable("id") int id, Model model){
        Optional<Employee> employee = employeeDao.get(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        }
        return "form";
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable("id") int id){
    //    employeeDao.deleteById(id);
    //     return "redirect:/employee";
    // }

    @PostMapping("/delete")
    public String deleteById(@ModelAttribute DeleteRequest request, BindingResult result ){
       if (!result.hasErrors()) {
            employeeDao.deleteById(request.getId());
       }
       return "redirect:/employee";
    }

    //! tại sao không làm theo cách này, liệu không cần tạo thư mục mới request/DeleteRequest thì có sao không?
    // @PostMapping("/delete")
    // public String delete(Employee employee, BindingResult result){
    //     if (!result.hasErrors()) {
    //         employeeDao.deleteById(employee.getId());
    //     }
    //     return "redirect:/employee";
    // }

    @GetMapping("/search")
    public String searchForm(Model model){
        model.addAttribute("searchrequest", new SearchRequest());
        return "search";
    }

    @PostMapping("/search")
    public String searchByKeyword(@ModelAttribute SearchRequest request, BindingResult result, Model model){
        if (!result.hasErrors()) {
            model.addAttribute("employees", employeeDao.searchByKeyword(request.getKeyWord()));
        }
        return "allEmployee";
    }
}
