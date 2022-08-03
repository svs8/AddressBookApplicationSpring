package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    List<AddressBookData> getContactsByCity(String city);

    List<AddressBookData> getContactsByState(String state);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int personId);

}
