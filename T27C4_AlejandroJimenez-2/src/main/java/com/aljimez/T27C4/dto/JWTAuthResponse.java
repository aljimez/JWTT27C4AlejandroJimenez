package com.aljimez.T27C4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
	
public class JWTAuthResponse {

	
		@Id
		private long id;
		private String tokenDeAcceso;
		private String tipoDeToken = "Bearer";

		public JWTAuthResponse(String tokenDeAcceso) {
			this.tokenDeAcceso = tokenDeAcceso;
		}

		
		public JWTAuthResponse(String tokenDeAcceso, String tipoDeToken) {
			this.tokenDeAcceso = tokenDeAcceso;
			this.tipoDeToken = tipoDeToken;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTokenDeAcceso() {
			return tokenDeAcceso;
		}


		public void setTokenDeAcceso(String tokenDeAcceso) {
			this.tokenDeAcceso = tokenDeAcceso;
		}


		public String getTipoDeToken() {
			return tipoDeToken;
		}


		public void setTipoDeToken(String tipoDeToken) {
			this.tipoDeToken = tipoDeToken;
		}
	
		
		
}
