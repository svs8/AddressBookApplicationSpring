package com.bridgelabz.addressbookapp.controller;


import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AddressBookService")
public class AddressBookController {

    @GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        AddressBookData addressBookData = new AddressBookData(1,new AddressBookDTO("Surakshith",
                "VS","7559805228", "surakshithvs415@gmail.com","Ashwini",
                "Mangalore","Karnataka",671324));
        ResponseDTO responseDTO = new ResponseDTO("Get call is Successful",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{personId}"})
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable int personId) {
        AddressBookData addressBookData = new AddressBookData(personId,new AddressBookDTO("Surakshith",
                "VS","7559805228", "surakshithvs415@gmail.com","Ashwini",
                "Mangalore","Karnataka",671324));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(2,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data got added Successfully!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/edit/{personId}"})
    public ResponseEntity<ResponseDTO> editAddressBookData(@PathVariable int personId,
                                                           @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data updated Successfully!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/remove/{personId}"})
    public ResponseEntity<ResponseDTO> removeAddressBookData(@PathVariable int personId) {
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully!!!",
                "ID number: "+personId + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}