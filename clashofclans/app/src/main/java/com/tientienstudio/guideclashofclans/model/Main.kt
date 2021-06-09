package com.tientienstudio.guideclashofclans.model


import java.io.Serializable

class Main (
    val fan: LGMin,
    val ane: LGMin,
    val unt: LGMin,
    val mop: LGMin,
    val ads_type: String,
    val percent_show_ins: Int,
    val characters: List<Character>?,
    val weapons: List<Weapon>?,
    val maps: List<Map>?,
    val guides: List<Guide>?,
    val vehicles: List<Vehicle>?,
    val aln: String?,
    val is_force_aln: Boolean
): Serializable