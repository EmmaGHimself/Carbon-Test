package com.emmagcarbontest.restapi

class CloudConfig private constructor() {
    val baseUrl: String?
        get() = Companion.baseUrl

    companion object {
        @JvmStatic
        var instance: CloudConfig? = null
            get() {
                if (field == null) {
                    synchronized(Service::class.java) {
                        if (field == null) {
                            field = CloudConfig()
                        }
                    }
                }
                return field
            }
            private set
        private var baseUrl: String? = null
    }

    init {
        if (BuildConfig.DEBUG) {
            Companion.baseUrl = BuildConfig.DEV_API_BASE_URL
        } else {
            Companion.baseUrl = BuildConfig.PRODUCTION_API_BASE_URL
        }
    }
}