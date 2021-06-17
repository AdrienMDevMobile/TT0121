package com.michelAdrien.AMTT0121.ViewModel

import androidx.lifecycle.ViewModel
import com.michelAdrien.AMTT0121.Tool.Data.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(val IRepository : IRepository) : ViewModel() {
}