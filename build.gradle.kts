// Read more:
// https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
// https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html#setting-up-intellij-platform

plugins {
    id("java")
    id("com.jessebrault.jbarchiva") version "0.2.2"
    id("org.jetbrains.kotlin.jvm") version "1.9.24"
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "groowt.intellij"
version = "0.1.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    implementation("groowt:web-view-components-compiler:0.1.0")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
    intellijPlatform {
        bundledPlugin("com.intellij.java")
        bundledPlugin("org.intellij.groovy")
        intellijIdeaCommunity("2024.2.4")
        instrumentationTools()
    }
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "21"
    }

    patchPluginXml {
        sinceBuild.set("242.1")
        untilBuild.set("242.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
