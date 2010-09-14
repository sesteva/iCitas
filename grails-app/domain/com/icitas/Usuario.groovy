package com.icitas

class Usuario {
	
	String usuario
	String password
	String tipoDeUsuario
	
	String nombre
	String apellido
	String nombreCompleto
	
	String edad
	
	String telefono
	String extension
	String email
	
	
    static constraints = {
		nombre(blank:false)
		apellido(blank:false)
		usuario(nullable:true)
		password(nullable:true)
		tipoDeUsuario(nullable:true)
		nombreCompleto(nullable:true)
		email(email:true)
		telefono(blank:false)
		extension(blank:true)
    }
}
