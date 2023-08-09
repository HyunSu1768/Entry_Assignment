dependencies {

    // implement project
    implementation(project(":entry-common"))
    implementation(project(":entry-core"))
    implementation(project(":entry-infrastructure"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}
