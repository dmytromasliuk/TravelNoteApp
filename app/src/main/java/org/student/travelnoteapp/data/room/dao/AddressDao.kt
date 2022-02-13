package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Address
import org.student.travelnoteapp.data.room.model.Place

@Dao
interface AddressDao {

    @Transaction
    @Query("SELECT * FROM address_table ORDER BY id ASC")
    fun getAllAddresses(): LiveData<List<Address>>

    @Transaction
    @Query("SELECT * FROM address_table WHERE id=:id")
    fun getAddressById(id: Int): LiveData<Address>

    @Transaction
    @Query("SELECT * FROM address_table ORDER BY id DESC LIMIT 1")
    fun getLastAddress(): LiveData<Address>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewAddress(address: Address)

    @Update
    suspend fun updateAddress(address: Address)

    @Delete
    suspend fun deleteAddress(address: Address)

    @Query("DELETE FROM address_table WHERE id=:id")
    suspend fun deleteAddressById(id: Long)

    @Query("DELETE FROM address_table")
    suspend fun deleteAllAddresses()

}