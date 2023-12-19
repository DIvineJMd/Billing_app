package com.example.billingapp.workspace.data
data class Inventory(
    val phones: Phones,
    val accessories: Accessories,
    val sound: Sound
)

data class Phones(
    val apple: Map<String, PhoneDetails>,
    val samsung: Map<String, PhoneDetails>
)

data class PhoneDetails(
    val units: Int,
    val specs: Specs
)

data class Specs(
    val color: String,
    val storage: String
)

data class Accessories(
    val chargers: Chargers,
    val headphones: Headphones
)

data class Chargers(
    val apple: Map<String, AccessoryDetails>,
    val samsung: Map<String, AccessoryDetails>
)

data class Headphones(
    val apple: Map<String, AccessoryDetails>,
    val samsung: Map<String, AccessoryDetails>
)

data class AccessoryDetails(
    val units: Int
)

data class Sound(
    val speakers: Speakers
)

data class Speakers(
    val jbl: Map<String, AccessoryDetails>,
    val sony: Map<String, AccessoryDetails>
)
