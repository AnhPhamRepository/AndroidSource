package com.tientienstudio.guideclashofclans.model


import java.io.Serializable

class Character (
    val id: Int?,
    val image: String?,
    val aimage: String?,
    val name: String?,
    val sex: String?,
    val age: Int?,
    val birthDate: String?,
    val info: String?,
    val ability: Ability?,
    val level: List<String>?,
    val levelName: List<String>?
) : Serializable


class Ability (
    val name: String?,
    val desc: String?
) : Serializable