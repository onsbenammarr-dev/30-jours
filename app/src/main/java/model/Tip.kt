/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.trentejours.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.trentejours.R

/**
 * A data class to represent the information presented in the flower card
 */
data class Tip(
    val day: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int
)

val tips = listOf(
    Tip(1, R.drawable.rose, R.string.tip1_title, R.string.tip1_desc),
    Tip(2, R.drawable.tulipe, R.string.tip2_title, R.string.tip2_desc),
    Tip(3, R.drawable.tournesol, R.string.tip3_title, R.string.tip3_desc),
    Tip(4, R.drawable.lavande, R.string.tip4_title, R.string.tip4_desc),
    Tip(5, R.drawable.marguerite, R.string.tip5_title, R.string.tip5_desc),
    Tip(6, R.drawable.orchidee, R.string.tip6_title, R.string.tip6_desc),
    Tip(7, R.drawable.pivoine, R.string.tip7_title, R.string.tip7_desc),
    Tip(8, R.drawable.lys, R.string.tip8_title, R.string.tip8_desc),
    Tip(9, R.drawable.jasmin, R.string.tip9_title, R.string.tip9_desc),
    Tip(10, R.drawable.hibiscus, R.string.tip10_title, R.string.tip10_desc),
    Tip(11, R.drawable.coquelicot, R.string.tip11_title, R.string.tip11_desc),
    Tip(12, R.drawable.iris, R.string.tip12_title, R.string.tip12_desc),
    Tip(13, R.drawable.narcisse, R.string.tip13_title, R.string.tip13_desc),
    Tip(14, R.drawable.jacinthe, R.string.tip14_title, R.string.tip14_desc),
    Tip(15, R.drawable.magnolia, R.string.tip15_title, R.string.tip15_desc),
    Tip(16, R.drawable.dahlia, R.string.tip16_title, R.string.tip16_desc),
    Tip(17, R.drawable.camelia, R.string.tip17_title, R.string.tip17_desc),
    Tip(18, R.drawable.lotus, R.string.tip18_title, R.string.tip18_desc),
    Tip(19, R.drawable.violette, R.string.tip19_title, R.string.tip19_desc),
    Tip(20, R.drawable.bleuet, R.string.tip20_title, R.string.tip20_desc),
    Tip(21, R.drawable.muguet, R.string.tip21_title, R.string.tip21_desc),
    Tip(22, R.drawable.pensee, R.string.tip22_title, R.string.tip22_desc),
    Tip(23, R.drawable.glycine, R.string.tip23_title, R.string.tip23_desc),
    Tip(24, R.drawable.cerisier, R.string.tip24_title, R.string.tip24_desc),
    Tip(25, R.drawable.oeillet, R.string.tip25_title, R.string.tip25_desc),
    Tip(26, R.drawable.gerbera, R.string.tip26_title, R.string.tip26_desc),
    Tip(27, R.drawable.freesia, R.string.tip27_title, R.string.tip27_desc),
    Tip(28, R.drawable.anemone, R.string.tip28_title, R.string.tip28_desc),
    Tip(29, R.drawable.hortensia, R.string.tip29_title, R.string.tip29_desc),
    Tip(30, R.drawable.mimosa, R.string.tip30_title, R.string.tip30_desc)
)