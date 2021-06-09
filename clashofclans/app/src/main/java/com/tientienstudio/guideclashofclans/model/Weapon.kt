package com.tientienstudio.guideclashofclans.model


import java.io.Serializable

class Weapon (
    val id: Int?,
    val name: String?,
    val image: String?,
    val dan: Int?,
    val property1: Float?,
    val property2: Float?,
    val property3: Float?,
    val property4: Float?,
    val property5: Float?,
    val property6: Float?,
    val property7: Float?,
    val property8: Float?,
    val attachable: List<Boolean>?,
    val desc: String?,
    val attribute: List<String>?,
    val type: String
) : Serializable