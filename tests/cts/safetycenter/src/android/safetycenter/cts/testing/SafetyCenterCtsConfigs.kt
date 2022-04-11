/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.safetycenter.cts.testing

import android.content.Intent.ACTION_SAFETY_CENTER
import android.safetycenter.config.SafetyCenterConfig
import android.safetycenter.config.SafetySource
import android.safetycenter.config.SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC
import android.safetycenter.config.SafetySourcesGroup

/**
 * A class that provides [SafetyCenterConfig] objects and associated constants to facilitate
 * setting up safety sources for testing.
 */
object SafetyCenterCtsConfigs {
    private const val CTS_PACKAGE_NAME = "android.safetycenter.cts"

    /** ID of the only source provided in [CTS_SINGLE_SOURCE_CONFIG]. */
    const val CTS_SINGLE_SOURCE_CONFIG_SOURCE_ID = "cts_single_source_id"

    /** ID of a source provided in [CTS_MULTIPLE_SOURCES_CONFIG]. */
    const val CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_ID_1 = "cts_multiple_sources_config_source_id_1"

    /** ID of a source provided in [CTS_MULTIPLE_SOURCES_CONFIG]. */
    const val CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_ID_2 = "cts_multiple_sources_config_source_id_2"

    /** ID of the only [SafetySourcesGroup] provided by [CTS_SINGLE_SOURCE_CONFIG]. */
    const val CTS_SINGLE_SOURCE_GROUP_ID = "cts_single_source_group_id"

    /** ID of the only [SafetySourcesGroup] provided by [CTS_MULTIPLE_SOURCES_CONFIG]. */
    const val CTS_MULTIPLE_SOURCES_GROUP_ID = "cts_multiple_sources_group_id"

    private val CTS_SINGLE_SOURCE_CONFIG_SOURCE =
        SafetySource.Builder(SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(CTS_SINGLE_SOURCE_CONFIG_SOURCE_ID)
            .setPackageName(CTS_PACKAGE_NAME)
            .setTitleResId(android.R.string.ok)
            .setSummaryResId(android.R.string.ok)
            .setIntentAction(ACTION_SAFETY_CENTER)
            .setProfile(SafetySource.PROFILE_PRIMARY)
            .build()

    private val CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_1 =
        SafetySource.Builder(SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_ID_1)
            .setPackageName(CTS_PACKAGE_NAME)
            .setTitleResId(android.R.string.ok)
            .setSummaryResId(android.R.string.ok)
            .setIntentAction(ACTION_SAFETY_CENTER)
            .setProfile(SafetySource.PROFILE_PRIMARY)
            .build()

    private val CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_2 =
        SafetySource.Builder(SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_ID_2)
            .setPackageName(CTS_PACKAGE_NAME)
            .setTitleResId(android.R.string.ok)
            .setSummaryResId(android.R.string.ok)
            .setIntentAction(ACTION_SAFETY_CENTER)
            .setProfile(SafetySource.PROFILE_PRIMARY)
            .build()

    private val CTS_SINGLE_SOURCE_GROUP =
        SafetySourcesGroup.Builder()
            .setId(CTS_SINGLE_SOURCE_GROUP_ID)
            .setTitleResId(android.R.string.ok)
            .setSummaryResId(android.R.string.ok)
            .addSafetySource(CTS_SINGLE_SOURCE_CONFIG_SOURCE)
            .build()

    private val CTS_MULTIPLE_SOURCES_GROUP =
        SafetySourcesGroup.Builder()
            .setId(CTS_MULTIPLE_SOURCES_GROUP_ID)
            .setTitleResId(android.R.string.ok)
            .setSummaryResId(android.R.string.ok)
            .addSafetySource(CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_1)
            .addSafetySource(CTS_MULTIPLE_SOURCES_CONFIG_SOURCE_2)
            .build()

    /**
     * A simple [SafetyCenterConfig] for CTS tests with a single source of id
     * [CTS_SINGLE_SOURCE_CONFIG_SOURCE_ID].
     */
    val CTS_SINGLE_SOURCE_CONFIG = SafetyCenterConfig.Builder()
            .addSafetySourcesGroup(CTS_SINGLE_SOURCE_GROUP)
            .build()

    /** A simple [SafetyCenterConfig] for CTS tests with multiple sources. */
    val CTS_MULTIPLE_SOURCES_CONFIG = SafetyCenterConfig.Builder()
            .addSafetySourcesGroup(CTS_MULTIPLE_SOURCES_GROUP)
            .build()
}