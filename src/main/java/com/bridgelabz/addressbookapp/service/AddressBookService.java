package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<AddressBookData> addressBookList=new ArrayList<>();


    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookList.stream()
                .filter(addressbookData -> addressbookData.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("contact not found In the List"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData= null;
        addressBookData = new AddressBookData(addressBookList.size()+1, addressBookDTO);
        addressBookList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=this.getAddressBookDataById(personId);
        addressBookData.setFirstName(addressBookDTO.firstName);
        addressBookData.setLastName(addressBookDTO.lastName);
        addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
        addressBookData.setEmail(addressBookDTO.email);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookData.setCity(addressBookDTO.city);
        addressBookData.setState(addressBookDTO.state);
        addressBookData.setZip(addressBookDTO.zip);
        addressBookList.set(personId-1,addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressBookList.remove(personId-1);
    }
}
