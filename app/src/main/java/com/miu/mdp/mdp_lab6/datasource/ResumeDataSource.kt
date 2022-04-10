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
            "Mostly self motivated, I am an experienced software engineer with 5 years experience in back end development for enterprise and data intensive applications using java and SQL programming languages, the Spring Framework , REST and Service Oriented Architecture. I have a passion for Fintech driven by my working experience with financial institutions." +
                    " I aim for growth and value addition leaving a positive mark everywhere i work.",
            mapOf(
                "Languages" to "Java, Spring",
                "Databases" to "SQL, Oracle, Room, SQLite, RealmSwift, RealmAndroid, RealmJava, CoreData",
                "Design patterns" to "MVVM, MVC, MVP, VIPER, Observer, Builder Pattern, Singleton, Factory, Abstract Factory",
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
        val aptechCert = School(
            "Aptech Kampala",
            "Oracle certification",
            "2010-2014",
            "https://pbs.twimg.com/profile_images/491914437872197632/Qamuz0G7_400x400.png"
        )
        val kibuli = School(
            "Gayaza high school",
            "Advanced level certification, Majors (Physics, Chemistry, Mathematics, Economics)",
            "2010-2014",
            "https://pbs.twimg.com/profile_images/769626315569836032/BqsOszf4_400x400.jpg"
        )
        val budo = School(
            "King's college budo",
            "Ordinary level certification, Majors (German, Pure Mathematics, Poetry, Advanced Aeronautics Physics and more)",
            "2010-2014",
            "https://media-exp1.licdn.com/dms/image/C4E0BAQEWaz0Z9HydZw/company-logo_200_200/0/1608137333355?e=2147483647&v=beta&t=Qx_yZSh9xl5rpDRlfaYxWnS9XfgiBNc7ek5_89-L7Sk"
        )
        return Education(
            listOf(miu, muk, aptechCert, kibuli, budo)
        )
    }

    override fun getExperience(): WorkExperience {
        val chaseExperience = Experience(
            "JP Morgan Chase",
            "https://logos-world.net/wp-content/uploads/2021/02/JP-Morgan-Chase-Symbol.png",
            "Software Engineer",
            "2021 - Present",
            "Chicago, IL",
            "Played key role in development and integration of internal and" +
                    " customer-facing enterprise applications with the core banking system."
        )
        val dfcuExp = Experience(
            "DFCU Bank",
            "https://www.dfcugroup.com/wp-content/uploads/2021/01/dfcu_bank_logo.png",
            "Applications Engineer",
            "2018 - 2020",
            "Kampala, UG",
            "Conducted development, testing, and maintenance of microfinance " +
                    "applications and databases(Oracle and MS SQL Server)"
        )
        val prideMDI = Experience(
            "Pride Microfinance Limited",
            "https://mbararanews.co.ug/wp-content/uploads/2020/11/FB_IMG_1606405758742.jpg",
            "Application & Database Developer",
            "2015 - 2018",
            "Kampala, Uganda",
            "Conducted development, testing, and maintenance of" +
                    " microfinance applications and databases(Oracle and MS SQL Server)"
        )

        return WorkExperience(listOf(chaseExperience, dfcuExp, prideMDI))
    }

    override fun getContactDetails(): List<Contact> {
        val email = Contact(ContactType.EMAIL, "tjabz@gmail.com")
        val phone = Contact(ContactType.PHONE, "6411112222")
        val linkedIn = Contact(ContactType.LINK, "https://www.linkedin.com/in/mary-galimaka-talemwa/")
        return listOf(email, phone, linkedIn)
    }

    private fun <T : Serializable> changeToString(data: T): String {
        return Gson().toJson(data)
    }

    private inline fun <reified T> fromString(string: String): T {
        return Gson().fromJson(string, T::class.java)
    }

}
