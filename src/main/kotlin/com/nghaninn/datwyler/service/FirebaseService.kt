package com.nghaninn.datwyler.service

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.IOException
import javax.annotation.PostConstruct


@Service
class FirebaseService {
    @PostConstruct
    fun onStart() {
//        logger.info("Initializing Firebase App...")
        try {
            initializeFirebaseApp()
        } catch (e: IOException) {
//            logger.error("Initializing Firebase App {}", e)
        }
    }

    private fun initializeFirebaseApp() {
        if (FirebaseApp.getApps() == null || FirebaseApp.getApps().isEmpty()) {
            val serviceAccount = FirebaseService::class.java.getResourceAsStream("/serviceAccount.json")
            val credentials = GoogleCredentials.fromStream(serviceAccount)
            val options: FirebaseOptions = FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build()
            FirebaseApp.initializeApp(options)
        }
    }

//    companion object {
//        private val logger: Logger = LoggerFactory.getLogger(FirebaseService::class.java)
//    }
}