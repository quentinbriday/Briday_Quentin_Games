package com.smals.restcontrollers;

import com.smals.domain.Borrow;
import com.smals.services.BorrowServiceImpl;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/borrows")
public class BorrowRestController {

    private BorrowServiceImpl borrowService;

    public BorrowRestController(BorrowServiceImpl borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping(path = "")
    public List<Borrow> findAll(){
        return borrowService.findAll();
    }

    @GetMapping(path = "/borrower/{borrowerName}")
    public List<Borrow> findAllByBorrowerName(@PathVariable("borrowerName") String borrowerName){
        return borrowService.findAllByBorrowerName(borrowerName);
    }

    @GetMapping(path = "/{id}")
    public Borrow findById(@PathVariable("id") int id) throws NotFoundException{
        return borrowService.findById(id);
    }

    @PostMapping(path = "")
    public Borrow save(@RequestBody Borrow borrow){
        borrowService.save(borrow);
        return borrow;
    }

    @PutMapping(path = "")
    public int update(@RequestBody Borrow borrow){
        borrowService.save(borrow);
        return borrow.getId();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") int id) throws NotFoundException{
        borrowService.deleteById(id);
    }
}
