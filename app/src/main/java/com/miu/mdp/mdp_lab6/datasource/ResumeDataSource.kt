package com.miu.mdp.mdp_lab6.datasource

import android.content.Context
import com.google.gson.Gson
import com.miu.mdp.mdp_lab6.logic.authUser
import com.miu.mdp.mdp_lab6.model.*
import java.io.Serializable

class ResumeDataSource(context: Context?) : ResumeRepository {
    private val sharedPreferences = context?.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    override fun saveUser(fullName: String, email: String, password: String) {
        val sUser = SessionUser(
            "https://media-exp1.licdn.com/dms/image/C4D03AQHiF71HlZEOIg/profile-displayphoto-shrink_800_800/0/1612634117678?e=1654732800&v=beta&t=sPkUVAhaRARqfnmY369EnQ3m3Kkk00762JHCkJ8acC0",
            fullName,
            "Mobile Applications Developer",
            "Completed on-campus studies and currently taking distance education courses to complete a Master's Degree in Computer Science (Available for full-time, W-2 employment).",
            "Accomplished  iOS  and  Android  developer  with  6+  years  of  advanced  expertise  designing,  implementing,  and refining mobile apps across numerous industries. Expertise in continuous integration using Jenkins and CircleCi to ensure streamlined delivery. Talent for leading, mentoring, and training elite technical teams",
            mapOf(
                "Languages" to "Swift, Kotlin, Java, ObjC",
                "Frameworks" to " Reactive Extensions (RxJava, RxSwift), Alamofire, Swinject, Dagger2, Koin, Picasso, Retrofit, Coroutines, Socket.io, Mockito, Roboelectric",
                "Databases" to "SQL, Oracle, Room, SQLite, RealmSwift, RealmAndroid, RealmJava, CoreData",
                "Design patterns" to "MVVM, MVC, MVP, VIPER, Observer, Builder Pattern, Singleton, Factory, Abstract Factory",
                "SDLC" to "Rapid Application Development, Feature Driven Development, Agile, Scrum, Kanban, XP, Pair, KanBan  Tools:  Instabug, MixPanel, Firebase Analytics, Crashlytics, Firestore, Firebase Messaging, Chuck, IntelliJ, Xcode, VS Code, iTerm, IntelliJ IDEA, Eclipse, NetBeans, Xcode, Android Studio",
                "Platforms" to "MacOS, Windows"
            )
        )
        val aUser = AuthUser(
            email, password
        )
        sharedPreferences?.edit().apply {
            this?.putString("a$email", changeToString(aUser))
            this?.apply()
        }
        sharedPreferences?.edit().apply {
            this?.putString("s$email", changeToString(sUser))
            this?.apply()
        }

        authUser = aUser
    }

    override fun getUser(email: String): AuthUser? {
        return sharedPreferences?.getString("a$email", null)?.let { fromString(it) }
    }

    override fun getSessionUser(email: String): SessionUser? {
        return sharedPreferences?.getString("s$email", null)?.let { fromString(it) }
    }

    override fun getEducation(): Education {
        val miu = School(
            "Maharishi International University",
            "Masters of science in Computer science",
            "2020 - Present",
            "https://upload.wikimedia.org/wikipedia/en/1/14/Maharishi_International_University_logo_1.png"
        )
        val muk = School(
            "Makerere University Kampala",
            "Bachelors of science in Software Engineering",
            "2010-2014",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUtCJONpYqc9cvla5eK4uI5pPH7sVCX-_Aow&usqp=CAU"
        )
        return Education(
            listOf(miu, muk)
        )
    }

    override fun getExperience(): WorkExperience {
        val hpExp = Experience(
            "HP Inc",
            "https://i0.wp.com/logotaglines.com/wp-content/uploads/2016/08/hp-logo.jpg?fit=512%2C512&ssl=1",
            "Senior Software Engineer",
            "2021 - Present",
            "Fort collins, CO",
            "• Designing and building an engaging customer experience around HP’s Omen line of gaming PCs using mobile technologies such as Kotlin, Java, Android Studio, API’s, Git & GitHub, and Gradle \n" +
                    "• Evaluate and research latest technology, coding patterns and frameworks within the space \n" +
                    "• Provide technical estimates for development efforts and provide solutions to requirements presented by Product team "
        )
        val fenixExp = Experience(
            "Fenix International",
            "data:image/png;base64,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",
            "Software Engineer",
            "2018 - 2020",
            "Kampala, UG",
            "- Focused on designing and implementing a scalable and maintainable architecture for the field mobile application that aimed at supporting our field team that works in remote areas with poor network connections."
        )
        val safebodaExp = Experience(
            "SafeBoda Inc",
            "https://play-lh.googleusercontent.com/NptyNjT2skhzb1eEicjn-ChHPpSUeGCsp4dPwie9Iu2Y0wlRnOKF_vIloGi8lKCJ1_0",
            "iOS Engineer",
            "2015 - 2018",
            "Kampala, Uganda",
            "- Designed and wrote the automation of the build and release process for the iOS application using circleci, fastlane, fastlane match and github.\n" +
                    "- Redesigned the iOS application to MVVM architecture to make testing, debugging and adding new features easier.\n" +
                    "- Design and implement new features for the iOS app.\n" +
                    "- Lead the design and implementation of new features into the SafeBoda iOS application.\n" +
                    "- Brainstorm ideas and create new ways for making the SafeBoda app more user friendly with the help of my teammates as well as the other teams in the company."
        )

        return WorkExperience(listOf(hpExp, fenixExp, safebodaExp))
    }

    override fun getContactDetails(): List<Contact> {
        val email = Contact(ContactType.EMAIL, "aziwa@gmail.com")
        val phone = Contact(ContactType.PHONE, "8007878884")
        val linkedIn = Contact(ContactType.LINK, "https://www.linkedin.com/in/ali-ziwa/")
        return listOf(email, phone, linkedIn)
    }

    private fun <T : Serializable> changeToString(data: T): String {
        return Gson().toJson(data)
    }

    private inline fun <reified T> fromString(string: String): T {
        return Gson().fromJson(string, T::class.java)
    }

}
