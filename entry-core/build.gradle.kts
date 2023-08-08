dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-tx")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}