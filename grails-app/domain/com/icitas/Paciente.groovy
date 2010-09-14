package com.icitas

class Paciente extends Usuario{

	Registro registro = new Registro()
	
    static constraints = {
    }
	
	static hasMany = [citas:Cita]
}
