/**
 * Convx Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.convx.music.utils.preset

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.convx.music.constants.DarkModeKey
import com.convx.music.constants.DynamicThemeKey
import com.convx.music.constants.PureBlackKey
import com.convx.music.constants.SelectedThemeColorKey
import com.convx.music.utils.dataStore

/**
 * A preset shipped with the app rather than stored in the user's preset directory.
 *
 * Built-ins intentionally only touch the colour-related preferences they advertise. They do not
 * overwrite player, layout, font, or background settings when selected.
 */
data class BuiltInPreset(
    val id: String,
    val name: String,
    val description: String,
    private val themeColor: Int,
    private val darkMode: String,
    private val pureBlack: Boolean,
) {
    suspend fun apply(context: Context) {
        context.dataStore.edit { preferences ->
            preferences[DynamicThemeKey] = false
            preferences[SelectedThemeColorKey] = themeColor
            preferences[DarkModeKey] = darkMode
            preferences[PureBlackKey] = pureBlack
        }
    }
}

/**
 * Curated starting points for users who do not want to build a look from scratch.
 *
 * Keep this list data-only so it is safe to use directly from Compose's lazy grid.
 */
val builtInPresets: List<BuiltInPreset> = listOf(
    BuiltInPreset(
        id = "calm",
        name = "Calm",
        description = "A soft rose accent with automatic light and dark mode.",
        themeColor = 0xFFE85D75.toInt(),
        darkMode = "AUTO",
        pureBlack = false,
    ),
    BuiltInPreset(
        id = "midnight",
        name = "Midnight",
        description = "A violet accent with a deep black dark theme.",
        themeColor = 0xFF7C4DFF.toInt(),
        darkMode = "ON",
        pureBlack = true,
    ),
    BuiltInPreset(
        id = "sunset",
        name = "Sunset",
        description = "A warm orange accent for a bright, energetic theme.",
        themeColor = 0xFFFF6D00.toInt(),
        darkMode = "OFF",
        pureBlack = false,
    ),
)