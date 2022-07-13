package com.app.baseproject.utils.core

import androidx.annotation.UiThread
import androidx.annotation.VisibleForTesting

/**
 * Event class for passing through LiveData. Events will only be handled once, unless the handler
 * explicitly calls [markUnhandled].
 *
 * For background see this blog post:
 * https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150
 */
class SingleEvent<T>(private val data: T) {
    private var consumed = false

    /**
     * Process this event, will only be called once
     */
    @UiThread
    fun handle(block: SingleEvent<T>.(T) -> Unit) {
        val wasConsumed = consumed
        consumed = true
        if (!wasConsumed) {
            this.block(data)
        }
    }

    /**
     * Inside a handle lambda, you may call this if you discover that you cannot handle
     * the event right now. It will mark the event as available to be handled by another handler.
     */
    @UiThread
    fun SingleEvent<T>.markUnhandled() {
        consumed = false
    }

    @VisibleForTesting
    fun getData() = data
}