# Introduction to Sprint Boot

- https://spring.io/guides/gs/spring-boot/

### Maven repository

- https://mvnrepository.com/

### Dependencies

- Mysql
- Hibernate
- Sprint boot stater web

### Settings CORS

- Add code into App.java
  <code>
  @Bean
  public WebMvcConfigurer corsConfigurer() {
  return new WebMvcConfigurer() {

              @Override
              public void addCorsMappings(CorsRegistry registry) {
                  registry.addMapping("/mascotas").allowedOrigins("*");
              }
          };
      }

  </code>
