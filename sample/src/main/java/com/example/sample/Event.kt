package com.example.sample


import com.looperex.calenderview.calendardayview.data.IEvent
import java.util.*


class Event(
    private var mStartTime: Calendar?,
    private var mEndTime: Calendar?,
) : IEvent {

    override val startTime: Calendar
        get() = mStartTime!!
    override val endTime: Calendar
        get() = mEndTime!!

}