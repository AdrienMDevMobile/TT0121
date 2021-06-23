package com.michelAdrien.AMTT0121.viewModel

import androidx.lifecycle.ViewModel
import com.michelAdrien.AMTT0121.viewModel.tool.data.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(val IRepository : IRepository) : ViewModel() {
}