dependencies {

    // implement project
    implementation(project(":entry-core"))
    implementation(project(":entry-persistence"))
    implementation(project(":entry-presentation"))

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // security, jwts
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("io.jsonwebtoken:jjwt:0.9.1")

    // oauth
    implementation ("org.springframework.boot:spring-boot-starter-oauth2-client")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // crawling
    implementation ("org.jsoup:jsoup:1.14.2")

    // kafka
    implementation ("org.springframework.kafka:spring-kafka")

}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}