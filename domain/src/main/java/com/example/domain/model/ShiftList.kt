package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShiftList(
    val data: List<Data>,
    val links: List<String>,
    val meta: Meta
) : Parcelable

@Parcelize
data class Data(
    val date: String,
    val shifts: List<ShiftX>
) : Parcelable

@Parcelize
data class ShiftX(
    val covid: Boolean,
    val end_time: String,
    val facility_type: FacilityType,
    val localized_specialty: LocalizedSpecialty,
    val normalized_end_date_time: String,
    val normalized_start_date_time: String,
    val premium_rate: Boolean,
    val shift_id: Int,
    val shift_kind: String,
    val skill: Skill,
    val start_time: String,
    val timezone: String,
    val within_distance: Int
) : Parcelable

@Parcelize
data class FacilityType(
    val color: String,
    val id: Int,
    val name: String
) : Parcelable

@Parcelize
data class LocalizedSpecialty(
    val abbreviation: String,
    val id: Int,
    val name: String,
    val specialty: Specialty,
    val specialty_id: Int,
    val state_id: Int
) : Parcelable

@Parcelize
data class Specialty(
    val abbreviation: String,
    val color: String,
    val id: Int,
    val name: String
) : Parcelable

@Parcelize
data class Skill(
    val color: String,
    val id: Int,
    val name: String
) : Parcelable

@Parcelize
data class Meta(
    val lat: Double,
    val lng: Double
) : Parcelable
