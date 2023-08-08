dependencies {

    // impl module
    implementation(project(":entry-core"))
    implementation(project(":entry-common"))

    // database
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly ("com.mysql:mysql-connector-j")

    // oauth
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

    // kotlin
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation ("org.jetbrains.kotlin:kotlin-reflect")

}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}