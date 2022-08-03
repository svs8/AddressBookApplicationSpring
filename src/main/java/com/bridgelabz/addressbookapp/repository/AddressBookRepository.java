package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
    @Query(value="select * from address_book where city=:city", nativeQuery=true)
    List<AddressBookData> findContactByCity(String city);
    @Query(value="select * from address_book where state=:state", nativeQuery=true)
    List<AddressBookData> findContactByState(String state);

    @Query(value = "select *from address_book order by city", nativeQuery = true)
    List<AddressBookData> orderContactsByCity();

    @Query (value = "select *from address_book order by state", nativeQuery = true)
    List<AddressBookData> orderContactsByState();
}
