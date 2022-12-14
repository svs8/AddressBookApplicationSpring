package com.bridgelabz.addressbookapp.controller;


import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/AddressBookService")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call is Successful",addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{personId}"})
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable int personId) {
        AddressBookData addressBookData= addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data got added Successfully!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/edit/{personId}"})
    public ResponseEntity<ResponseDTO> editAddressBookData(@PathVariable int personId,
                                                           @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=addressBookService.updateAddressBookData(personId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data updated Successfully!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/remove/{personId}"})
    public ResponseEntity<ResponseDTO> removeAddressBookData(@PathVariable int personId) {
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully!!!",
                "ID number: "+personId + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getContactsByCity(@PathVariable("city") String city){
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.getContactsByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Department Successful",addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDTO> getContactsByState(@PathVariable("state") String state){
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.getContactsByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Department Successful",addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping(value = {"/city"})
    public ResponseEntity<ResponseDTO> orderContactsByCity() {
        List<AddressBookData> addressBookList = addressBookService.orderContactsByCity();
        ResponseDTO responseDTO = new ResponseDTO("Contact details sorted by City!!!", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/state"})
    public ResponseEntity<ResponseDTO> orderContactsByState() {
        List<AddressBookData> addressBookList = addressBookService.orderContactsByState();
        ResponseDTO responseDTO = new ResponseDTO("Contact details sorted by State!!!", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}