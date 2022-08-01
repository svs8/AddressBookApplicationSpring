package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{


    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        AddressBookData addressBookData = new AddressBookData(1,new AddressBookDTO("Surakshith",
                "VS","7559805228", "surakshithvs415@gmail.com","Ashwini",
                "Mangalore","Karnataka",671324));
        addressBookDataList.add(addressBookData);
        return addressBookDataList;

    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return new AddressBookData(personId,new AddressBookDTO("Surakshith",
                "VS","7559805228", "surakshithvs415@gmail.com","Ashwini",
                "Mangalore","Karnataka",671324));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData= null;
        addressBookData = new AddressBookData(personId, addressBookDTO);
        return  addressBookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {

    }
}
