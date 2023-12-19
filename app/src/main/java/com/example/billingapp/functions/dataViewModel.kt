package com.example.billingapp.functions

import androidx.lifecycle.ViewModel
import com.example.billingapp.workspace.data.*
import com.google.firebase.database.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DataViewModel : ViewModel() {
    private val _inventoryData = MutableStateFlow<Inventory?>(null)
    val inventoryData: StateFlow<Inventory?> = _inventoryData.asStateFlow()
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()
    private val db = FirebaseDatabase.getInstance().reference.child("Inventory")

    fun fetchInventoryData() {
        _loading.value = true
        db.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.value as Map<*, *>?

                // Check if data is not null before accessing its values
                if (data != null) {
                    val phonesData = data["Phones"] as? Map<*, *>
                    val accessoriesData = data["Accessories"] as? Map<*, *>
                    val soundData = data["Sound"] as? Map<*, *>

                    // Update _inventoryData based on your data mapping logic
                    _inventoryData.value = phonesData?.get("Apple")?.let { brandEntry ->
                        (brandEntry as? Map<String, Map<String, *>>)?.mapValues { phoneEntry ->
                            val specs = phoneEntry.value["specs"] as? Map<String, String>
                            PhoneDetails(
                                units = (phoneEntry.value["units"] as? Long)?.toInt() ?: 0,
                                specs = Specs(
                                    color = specs?.get("color") ?: "",
                                    storage = specs?.get("storage") ?: ""
                                )
                            )
                        }
                    }?.let {
                        phonesData["Samsung"]?.let { brandEntry ->
                            (brandEntry as? Map<String, Map<String, *>>)?.mapValues { phoneEntry ->
                                val specs = phoneEntry.value["specs"] as? Map<String, String>
                                PhoneDetails(
                                    units = (phoneEntry.value["units"] as? Long)?.toInt() ?: 0,
                                    specs = Specs(
                                        color = specs?.get("color") ?: "",
                                        storage = specs?.get("storage") ?: ""
                                    )
                                )
                            }
                        }?.let { samsungPhones ->
                            Phones(
                                apple = it,
                                samsung = samsungPhones
                            )
                        }
                    }?.let { phones ->
                        Inventory(
                            phones = phones,
                            accessories = Accessories(
                                chargers = Chargers(
                                    apple = (accessoriesData?.get("Chargers") as? Map<String, *>)?.get("Apple")?.let { chargerEntry ->
                                        (chargerEntry as? Map<String, *>)?.mapValues { accessoryEntry ->
                                            AccessoryDetails(
                                                units = (accessoryEntry.value as? Long)?.toInt() ?: 0
                                            )
                                        }
                                    } ?: emptyMap(),
                                    samsung = (accessoriesData?.get("Chargers") as? Map<String, *>)?.get("Samsung")?.let { chargerEntry ->
                                        (chargerEntry as? Map<String, *>)?.mapValues { accessoryEntry ->
                                            AccessoryDetails(
                                                units = (accessoryEntry.value as? Long)?.toInt() ?: 0
                                            )
                                        }
                                    } ?: emptyMap()
                                ),
                                headphones = Headphones(
                                    apple = (accessoriesData?.get("Headphones") as? Map<String, *>)?.get("Apple")?.let { headphoneEntry ->
                                        (headphoneEntry as? Map<String, *>)?.mapValues { accessoryEntry ->
                                            AccessoryDetails(
                                                units = (accessoryEntry.value as? Long)?.toInt() ?: 0
                                            )
                                        }
                                    } ?: emptyMap(),
                                    samsung = (accessoriesData?.get("Headphones") as? Map<String, *>)?.get("Samsung")?.let { headphoneEntry ->
                                        (headphoneEntry as? Map<String, *>)?.mapValues { accessoryEntry ->
                                            AccessoryDetails(
                                                units = (accessoryEntry.value as? Long)?.toInt() ?: 0
                                            )
                                        }
                                    } ?: emptyMap()
                                )
                            ),
                            sound = Sound(
                                speakers = Speakers(
                                    jbl = (soundData?.get("Speakers") as? Map<String, *>)?.get("JBL")?.let { speakerEntry ->
                                        (speakerEntry as? Map<String, *>)?.mapValues { accessoryEntry ->
                                            AccessoryDetails(
                                                units = (accessoryEntry.value as? Long)?.toInt() ?: 0
                                            )
                                        }
                                    } ?: emptyMap(),
                                    sony = (soundData?.get("Speakers") as? Map<String, *>)?.get("Sony")?.let { speakerEntry ->
                                        (speakerEntry as? Map<String, *>)?.mapValues { accessoryEntry ->
                                            AccessoryDetails(
                                                units = (accessoryEntry.value as? Long)?.toInt() ?: 0
                                            )
                                        }
                                    } ?: emptyMap()
                                )
                            )
                        )
                    }
                    _loading.value = false
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}
