package org.student.travelnoteapp.data.room.repository

import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.dao.AddressDao
import org.student.travelnoteapp.data.room.model.Address
import javax.inject.Inject

class AddressRepository @Inject constructor(
    private val addressDao: AddressDao
) {

    val getAllAddresses: LiveData<List<Address>> = addressDao.getAllAddresses()

    fun getAddressById(id: Int): LiveData<Address>{
        return addressDao.getAddressById(id = id)
    }

    fun getLastAddress(): LiveData<Address> {
        return addressDao.getLastAddress()
    }

    suspend fun addNewAddress(address: Address){
        addressDao.addNewAddress(address = address)
    }

    suspend fun updateAddress(address: Address){
        addressDao.updateAddress(address = address)
    }

    suspend fun deleteAddress(address: Address){
        addressDao.deleteAddress(address = address)
    }

    suspend fun deleteAddressById(id: Long){
        addressDao.deleteAddressById(id = id)
    }

    suspend fun deleteAllAddresses(){
        addressDao.deleteAllAddresses()
    }

}