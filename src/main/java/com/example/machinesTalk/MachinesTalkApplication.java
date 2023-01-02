package com.example.machinesTalk;

import com.example.machinesTalk.service.UserMachinestalkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MachinesTalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachinesTalkApplication.class, args);
	}

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource urlBaseCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
    corsConfiguration.setAllowedHeaders(Arrays.asList("origin", "Access-Control-Allow-Origin", "Content-Type", "Accept",
      "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Requested-Method", "Access-Control-Resquest-Headers"));
    corsConfiguration.setExposedHeaders(Arrays.asList("origin", "Content-Type", "Accept",
      "Jwt-Token", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "File-Name"));
    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
    urlBaseCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(urlBaseCorsConfigurationSource);
  }

	@Bean
	CommandLineRunner commandLineRunner(UserMachinestalkService userMachinestalkService) throws JsonProcessingException {
		return args -> {
			for (int i = 0; i <= userMachinestalkService.getNbreTotalPagesFromUrl("", "", 0); i++)
			{
				userMachinestalkService.findAllUsersFromUrlAndSaveThem("", "", i, 10);
			}
		};
	}

}
