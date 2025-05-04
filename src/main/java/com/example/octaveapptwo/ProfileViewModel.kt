package com.example.octaveapptwo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val PROFILE_NAME_KEY= "PROFILE_NAME"

class ProfileViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {
    var profileName : String
        get()= stateHandle.get("PROFILE_NAME") ?: ""
        set(value)= stateHandle.set("PROFILE_NAME", value)
}