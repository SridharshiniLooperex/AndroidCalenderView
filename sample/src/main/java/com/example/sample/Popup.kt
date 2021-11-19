package com.example.sample

import com.looperex.calenderview.calendardayview.data.IPopup
import java.util.*


class Popup : IPopup {
    override lateinit var startTime: Calendar
    override lateinit var endTime: Calendar
    override lateinit var title: String
    override lateinit var description: String
    override val isAutohide: Boolean
        get() = false
}