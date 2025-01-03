//package br.com.pazimportss;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//		
//	 @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/api/**")  // Padrão de URL para o qual o CORS será aplicado
//	                .allowedOrigins("http://localhost:4200")  // Requisições do frontend (Angular)
//	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos HTTP 
//	                .allowedHeaders("*")  // Headers permitidos
//	                .allowCredentials(true);  // Permite credenciais (cookies, autenticação)
//	    }
//}
