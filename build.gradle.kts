import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "me.lpawlak"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("agh.cs.oop.World")
}