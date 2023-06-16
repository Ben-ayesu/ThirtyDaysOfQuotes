package com.example.thirtydaysofquotes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Card(
    @StringRes val descriptionRes: Int,
    @StringRes val title: Int,
    @DrawableRes val imageRes: Int
)