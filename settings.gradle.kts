pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()

        maven {
            setUrl("https://archiva.jessebrault.com/repository/internal/")
            credentials {
                username = System.getenv("JBARCHIVA_USERNAME")
                password = System.getenv("JBARCHIVA_PASSWORD")
            }
        }
    }
}

rootProject.name = "wvc-intellij-plugin"
