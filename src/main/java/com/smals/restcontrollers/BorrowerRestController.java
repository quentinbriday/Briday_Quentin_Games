package com.smals.restcontrollers;

import com.smals.domain.Borrower;
import com.smals.dto.BorrowerDto;
import com.smals.services.BorrowerServiceImpl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/borrowers")
public class BorrowerRestController {

    private BorrowerServiceImpl borrowerService;

    public BorrowerRestController(BorrowerServiceImpl borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping(path = "")
    public List<Borrower> findAll(){
        return borrowerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Borrower findById(@PathVariable("id") int id) throws NotFoundException{
        return borrowerService.findById(id);
    }

    @GetMapping(path = "/name/{name}")
    public List<Borrower> findAllByName(@PathVariable("name") String borrowerName){
        return borrowerService.findAllByName(borrowerName);
    }

    @PostMapping(path = "")
    public Borrower save(@RequestBody BorrowerDto borrowerDto){
        Borrower borrower = new ModelMapper().map(borrowerDto, Borrower.class);
        borrowerService.save(borrower);
        return borrower;
    }

    @PutMapping(path = "")
    public int update(@RequestBody BorrowerDto borrowerDto){
        Borrower borrower = new ModelMapper().map(borrowerDto, Borrower.class);
        borrowerService.save(borrower);
        return borrower.getId();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") int id) throws NotFoundException{
        borrowerService.deleteById(id);
    }
}
