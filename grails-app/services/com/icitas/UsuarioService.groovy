package com.icitas

class UsuarioService {

    static transactional = true

    def serviceMethod() {

    }
	
	Usuario crearUsuario(Usuario usuarioACrear){
		println "aca1"
		println "segundo servicio ${usuarioACrear.nombre}"
		def usuario = new Usuario(usuarioACrear.properties).save()
		println "${usuario.properties}"
		println "${usuario.errors}"
		println "${usuario.class}"
		return usuario
	}
}
